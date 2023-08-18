def call() {
    runWithMaven {
        sh "mvn clean test || true"
        junit(testResults: '**/target/surefire-reports/*.xml')
    }
}