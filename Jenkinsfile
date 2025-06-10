pipeline {
    agent any

    environment {
       PROJECT_NAME = "rolandmaulana8-dev" 
       BUILD_NAME = "springboot-api"
    }

    stages {
        stage('Trigger Build in Openshift') {
            steps {
                sh "oc start-build ${BUILD_NAME} --from-dir=. --follow -n ${PROJECT_NAME}"
            }
        }
        stage('Deploy to Openshift') {
            steps {
                sh "oc rollout restart deployment/${BUILD_NAME} -n ${PROJECT_NAME}"
            }
        }
    }

    post {
        success {
            echo 'Build and deployment successful via OpenShift BuildConfig!'
        }
        failure {
            echo 'Pipeline Failed!'
        }
    }
}