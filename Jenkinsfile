pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                bat 'java -cp C:\Users\user\Downloads\testng-6.10.jar;C:\Users\user\Downloads\jcommander-1.48.jar;C:\Users\user\IdeaProjects\google\src\test\java org.testng.TestNG testng.xml'
            }
        }
    }
}
