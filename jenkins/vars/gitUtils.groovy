def getCurrentBranch() {
    return env.BRANCH_NAME
}

def getCurrentBranchCli() {
    return sh(
            script: 'git rev-parse --abbrev-ref HEAD',
            returnStdout: true
    )
}