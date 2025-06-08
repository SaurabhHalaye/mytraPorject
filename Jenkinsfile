pipeline {
    agent any
    tools {
        maven 'M3'  // This refers to Maven configured in Jenkins GUI
        allure 'ALLURE'
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
        stage('Allure Report'){
            steps{
                allure commandline: 'ALLURE', includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }
}
