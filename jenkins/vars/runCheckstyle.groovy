def call() {
    runWithMaven {
        def checkstyleFilename = 'checkstyle-result.xml'

        sh "mvn checkstyle:checkstyle -DcheckstyleFileName=${checkstyleFilename}"

        recordIssues(
                aggregatingResults: true,
                publishAllIssues: false,
                qualityGates: [getQualityGate()],
                tools: [
                        java(),
                        checkStyle(pattern: "**/${checkstyleFilename}", reportEncoding: 'UTF-8')
                ]
        )
    }
}

def getQualityGate() {
    def type = isMasterBranch() ? 'TOTAL' : 'NEW_ERROR'

    return [threshold: 1, type: "${type}"]
}

def isMasterBranch() {
    gitUtils.getCurrentBranch().equals('master')
}