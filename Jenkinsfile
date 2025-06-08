pipeline {
    agent {
        docker {
            image 'maven:3.8.6-openjdk-17'
        }
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the build...'
            }
        }
    }
}
