pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/nwintop/rest-assured-testng-framework.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}