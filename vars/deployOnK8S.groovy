def call(String apiServer,String serviceAccountToken,  String imagaName, String deploymentFile) { 

     sh "sed -i 's|image: .*|image: ${imagaName}:${BUILD_NUMBER}|' ${deploymentFile}"
             
        withCredentials([string(credentialsId: serviceAccountToken, variable: 'SERVICEACCOUNT_TOKEN'),
                         string(credentialsId: apiServer, variable: 'API_SERVER')]) {
            sh "kubectl --server=${API_SERVER} --token=${SERVICEACCOUNT_TOKEN} get pods --insecure-skip-tls-verify=true"
        }
     

}