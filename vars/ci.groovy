def call() {
    node {
        sh 'env'
        if(env.TAG_NAME ==~ ".*") {
           env.branchName = env.TAG_NAME
        }  else {
           env.branchName = env.BRANCH_NAME     
           }
        { 
          stage('code checkout'){
                git branch: env.branchName, url: 'https://github.com/omdevops99/expense_jenkins.git'
            }
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

    ////



