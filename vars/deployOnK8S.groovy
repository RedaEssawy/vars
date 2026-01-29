def call(String API_SERVER, String SERVICEACCOUNT_TOKEN)  {

        withCredentials([
                string(credentialsId: 'APIServer', variable: 'API_SERVER'),
                string(credentialsId: 'ServiceAccount-Token', variable: 'KUBE_TOKEN')

                ]) 
                sh "kubectl --server=${API_SERVER} --token=${KUBE_TOKEN} apply -f deployment.yaml  --insecure-skip-tls-verify=true  "
}