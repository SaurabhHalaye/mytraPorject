pipeline {
    agent any
    tools {
        maven 'M3'  // This refers to Maven configured in Jenkins GUI
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test -Denv=remote'
            }
        }
    }
}
