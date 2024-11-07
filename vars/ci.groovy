def call() {
    node {
        sh 'env'
        if(BRANCH_NAME == "main"){ 
            stage('compile'){}
            stage('build') {}
        } else if(BRANCH_NAME ==~ "PR.*") {
          stage('test') {}
          stage('Release') {}
        } else if(TAG_NAME ==~ ".*") {
          stage('compile'){}
          stage('test') {}
        } else {
          stage('compile'){}
          stage('test') {}
          stage('Release') {}
        }
        }
    }


