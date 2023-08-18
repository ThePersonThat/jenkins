def getRegistry() {
    return 'oleksiihaidabrus'
}

def getFullImageName() {
    return "${getRegistry()}/${getImageName()}:${getImageTag()}"
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