def call() {
    checkout([
            $class:                 'GitSCM',
            branches:               scm.branches,
            userRemoteConfigs:      scm.userRemoteConfigs,
            extensions: [
                    localBranch(buildBranchName()),
                    cleanAfterCheckout(),
                    [$class: "WipeWorkspace"]
            ]
    ])
}

def buildBranchName() {
    return String.format("%s-%s", gitUtils.getTriggeredBranch(), gitUtils.getCurrentCommitHash())
}