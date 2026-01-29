def call(String IMAGE_NAME, String DOCKER_CREDENTIALS_ID)  {
    sh "docker build -t ${IMAGE_NAME}:${BUILD_TAG} ."
    withCredentials([usernamePassword(credentialsId: DOCKER_CREDENTIALS_ID, passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh "echo ${PASSWORD} | docker login -u ${USERNAME} --password-stdin"
        sh "docker push ${IMAGE_NAME}:${BUILD_TAG}"
    }
    sh "docker rmi ${IMAGE_NAME}:${BUILD_TAG}"
    // Add your image building logic here
}