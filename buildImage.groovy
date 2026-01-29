def buildImage(String IMAGE_NAME, String IMAGE_TAG) {
    sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
    // Add your image building logic here
}