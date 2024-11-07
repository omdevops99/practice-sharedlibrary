def call() {
  pipeline {
    agent any 
    stages{
        stage('compile'){
            steps{
                echo 'compile'
            }
        }
    }
    stage('test'){
            steps{
                echo 'test'
            }
        }

    stage('build'){
            steps{
                echo 'build'
            }
        }    

    stage('integration test'){
            steps{
                echo 'integration tests'
            }
        }    

    stage('Release'){
            steps{
                echo 'Release'
            }
        }        
  }

}