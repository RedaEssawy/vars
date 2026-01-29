def buildApp() {
    sh "mvn test"
    sh "mvn package"
    // Add your build logic here
}