def call(String API_SERVER,  String IMAGE_NAME, String DEPLOYMENT_FILE) { 

     sh "sed -i 's|image: .*|image: ${IMAGE_NAME}:${BUILD_NUMBER}|' ${DEPLOYMENT_FILE}"
             
        withCredentials([string(credentialsId: SERVICEACCOUNT_TOKEN, variable: 'SERVICEACCOUNT_TOKEN')]) {
            sh "kubectl --server=${API_SERVER} --token=${SERVICEACCOUNT_TOKEN} get pods --insecure-skip-tls-verify=true"
        }
     

}