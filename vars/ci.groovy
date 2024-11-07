def call() {
    pipeline {
        agent any
        stages {
            stage ('compile'){
                steps {
                    echo 'compile'
                }
            }

            stage('test cases'){
                steps {
                    echo 'test cases'
                }
            }

            stage('Build'){
                steps {
                    echo 'Build'
                }
            }

            stage('Release'){
                steps {
                    echo 'Release'
                }
            }
        }


    }
}