import jenkins.model.Jenkins

def call() {
    def currentJob = getCurrentJob()

    currentJob.builds
        .findAll(this.&filterBuilds)
        .each { it.doStop() }
}

def filterBuilds(def build) {
    return build.isBuilding() && isPreviousBuild(build) && isSameBranch(build)
}

def isPreviousBuild(def build) {
    return build.number.toInteger() < env.BUILD_NUMBER.toInteger()
}

def isSameBranch(def build) {
    return env.BRANCH_NAME.equals(getBuildBranch(build))
}

def getBuildBranch(def build) {
    return build.getBuildVariables.BRANCH_NAME
}

def getCurrentJob() {
    return Jenkins.instance.getItemByFullName(env.JOB_NAME)
}