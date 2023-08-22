def getRegistry() {
    return 'oleksiihaidabrus'
}

def getFullImageName() {
    return "${getRegistry()}/${getImageName()}:${getImageTag()}"
}

def buildImageName(def imageTag) {
    return "${dockerUtils.getRegistry()}/${dockerUtils.getImageName()}:${imageTag}"
}

def getImageNameAndTag() {
    return "${getImageName()}:${getImageTag()}"
}

def getImageName() {
    return 'application'
}

def getImageTag() {
    return "${gitUtils.getCurrentBranch()}-${gitUtils.getCurrentCommitHash()}"
}