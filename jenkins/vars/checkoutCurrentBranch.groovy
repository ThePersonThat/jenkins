def call() {
    checkout([
            $class:                 'GitSCM',
            branches:               scm.branches,
            userRemoteConfigs:      scm.userRemoteConfigs,
            extensions: [
                    localBranch(),
                    cleanAfterCheckout(),
                    [$class: "WipeWorkspace"]
            ]
    ])
}