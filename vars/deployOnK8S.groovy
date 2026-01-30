def call(String API_SERVER,  String IMAGE_NAME, String DEPLOYMENT_FILE) { 

     sh "sed -i 's|image: .*|image: ${IMAGE_NAME}:${BUILD_NUMBER}|' ${DEPLOYMENT_FILE}"
             
        withCredentials([string(credentialsId: ServiceAccount-Token, variable: 'SERVICEACCOUNT_TOKEN'),
                         string(credentialsId: APIServer, variable: 'API_SERVER')]) {
            sh "kubectl --server=${API_SERVER} --token=${SERVICEACCOUNT_TOKEN} get pods --insecure-skip-tls-verify=true"
        }
     

}