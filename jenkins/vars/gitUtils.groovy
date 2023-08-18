def getCurrentBranch() {
    return sh(
            script: 'git rev-parse --abbrev-ref HEAD',
            returnStdout: true
    ).trim()
}

def getCurrentCommitHash() {
    return sh(
            script: 'git rev-parse HEAD',
            returnStdout: true
    ).trim()
}

def getTriggeredBranch() {
    return scm.branches[0].name
}

def isMasterBranch() {
    return getCurrentBranch().equals('master')
}