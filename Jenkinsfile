pipeline {
    agent any

    tools {
        gradle "gradle"
    }

    stages {
        stage('Build') {
            steps {

                git branch: 'feature/feedback', url: 'https://github.com/edwincneira/prueba-tecnica-habi'

                bat "gradle clean test"

            }

            post {
                success {
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/site/serenity', reportFiles: 'index.html', reportName: 'Report Test', reportTitles: ''])
                }
            }
        }
    }
}