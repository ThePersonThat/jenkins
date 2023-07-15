def call() {
    def checkstyleFilename = 'checkstyle-result.xml'

    sh "mvn checkstyle:checkstyle -DcheckstyleFileName=${checkstyleFilename}"

    recordIssues(
            aggregatingResults: true,
            failOnError: false,
            qualityGates: [
                    [threshold: 1, type: 'NEW_ERROR']
            ],
            tools: [
                    java(),
                    checkStyle(pattern: "**/${checkstyleFilename}", reportEncoding: 'UTF-8')
            ]
    )
}