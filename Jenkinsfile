pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/nwintop/rest-assured-testng-framework.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
            always {
                junit 'target/surefire-reports/*.xml'

                allure([
                    includeProperties: false,
                    results: [[path: 'allure-results']]
                ])
            }
        }
}