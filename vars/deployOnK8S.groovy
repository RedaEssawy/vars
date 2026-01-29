def call(String API_SERVER, String SERVICEACCOUNT_TOKEN, String IMAGE_NAME, String DEPLOYMENT_FILE) { 

     sh "sed -i 's|image: .*|image: ${IMAGE_NAME}:${BUILD_NUMBER}|' ${DEPLOYMENT_FILE}"
             
        withCredentials([
                string(credentialsId: 'APIServer', variable: 'API_SERVER'),
                string(credentialsId: 'ServiceAccount-Token', variable: 'KUBE_TOKEN')

                ]) {
                sh "kubectl --server=${API_SERVER} --token=${KUBE_TOKEN} apply -f ${DEPLOYMENT_FILE}  --insecure-skip-tls-verify=true  "
}
}