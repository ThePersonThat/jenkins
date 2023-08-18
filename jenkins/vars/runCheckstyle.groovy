def call() {
    runWithMaven {
        def checkstyleFilename = 'checkstyle-result.xml'

        sh "mvn checkstyle:checkstyle -DcheckstyleFileName=${checkstyleFilename}"

        recordIssues(
                aggregatingResults: true,
                publishAllIssues: isMasterBranch(),
                qualityGates: [getQualityGate()],
                ignoreQualityGate: false,
                failedNewAll: 1,
                tools: [
                        java(),
                        checkStyle(pattern: "**/${checkstyleFilename}", reportEncoding: 'UTF-8')
                ]
        )
    }
}

def getQualityGate() {
    def type = isMasterBranch() ? 'TOTAL' : 'TOTAL'

    return [threshold: 1, type: "${type}"]
}

def isMasterBranch() {
    gitUtils.getCurrentBranch().equals('master')
}