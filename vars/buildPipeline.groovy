def call() {
    pipeline {

        options {
            timeout(time: 3, unit: 'HOURS')
            buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
            timestamps()
        }
        agent none
        stages {
            stage('Build Test Analyze Package') {
                agent any
                steps {
                    def projectMetadata = readMavenPom file: "pom.xml"
                }
            }
        }
    }
}
