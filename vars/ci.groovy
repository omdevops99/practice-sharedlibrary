def call() {
    pipeline {
        agent any 
        stages {
            stage('Build') {
                steps {
                    sh 'env'
                }
            }
        }
    }
}
