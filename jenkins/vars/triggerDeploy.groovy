def call() {
    def jobName = 'DeployService'

    build(
            job: jobName,
            wait: false,
            parameters: [string(name: 'imageTag', value: dockerUtils.getImageTag())]
    )
}