def call() {
    node {
        sh 'env'
        if(BRANCH_NAME == "main"){

            stage('compile'){}
             stage('build') {}

        }
        else {

        stage('compile'){}

        stage('test') {}

        stage('Release') {}

        }

        }
    }


