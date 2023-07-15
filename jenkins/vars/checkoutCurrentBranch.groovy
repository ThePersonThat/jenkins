def call() {
    checkout([
            $class:                 'GitSCM',
            branches:               scm.branches,
            userRemoteConfigs:      scm.userRemoteConfigs,
            extensions: [
                    localBranch(),
                    cleanAfterCheckout(),
                    gitHubStatusChecks(name: 'Build commit', skipNotifications: true),
                    [$class: "WipeWorkspace"]
            ]
    ])
}