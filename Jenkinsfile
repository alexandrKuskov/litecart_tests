Jenkinsfile (Declarative Pipeline)
pipeline {
    agent { docker 'maven:3.3.3' }
    stages {
        stage('Test') {
            steps {
                retry(3) {
                  bat 'echo Hello'
                }
            }
        }
    }
    post {
        always {
           echo 'This will always run'
        }
    }
}
