def call() {
    node {
        sh 'env'
        if(env.BRANCH_NAME == "main"){ 
            stage('compile'){}
            stage('build') {}
        } else if(env.BRANCH_NAME ==~ "PR.*") {
          stage('test') {}
          stage('Release') {}
        } else if(env.TAG_NAME ==~ ".*") {
          stage('compile'){}
          stage('test') {}
        } else {
          stage('compile'){}
          stage('test') {}
          stage('Release') {}
        }
        }
    }

    ///
    


