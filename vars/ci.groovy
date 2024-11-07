def call()
  pipeline {
    agent any 
    stages{
        stage('example'){
            steps{
                echo 'Hello world'
            }
        }
    }
    post {
        always {
            echo 'I will always say Hello again !'
        }
    }
  }