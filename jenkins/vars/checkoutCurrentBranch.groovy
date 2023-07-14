def call() {
    checkout([
            $class:                 'GitSCM',
            branches:               scm.branches,
            userRemoteConfigs:      scm.userRemoteConfigs,
            extensions: [
                    localBranch(buildBranchName())
            ]
    ])
}

def buildBranchName() {
    return gitUtils.getTriggeredBranch() + getUtils.getCurrentCommitHash()
}