def call() {
    runWithMaven {
        def testStatus = sh(script: "mvn clean test", returnStatus: true)
        junit(testResults: '**/target/surefire-reports/*.xml', skipMarkingBuildUnstable: true)

        return testStatus
    }
}