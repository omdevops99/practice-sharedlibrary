def call() {
    node {
        // Print all environment variables
        

        // Determine branchName based on TAG_NAME or BRANCH_NAME
        if (env.TAG_NAME ==~ ".*") {
            env.branchName = env.TAG_NAME
        } else {
            if (env.BRANCH_NAME ==~ "PR1.*") {
             env.branchName = env.CHANGE_BRANCH
          } else {
            env.branchName = env.BRANCH_NAME
        }

        }
        // Code checkout stage
        stage('code checkout') {
            checkout scmGit(branches: [[name: "${branchName}"]], extensions: [], userRemoteConfigs: [[url: 'https://github.com/omdevops99/expense_jenkins.git']])

        
        }
        sh 'cat Jenkinsfile'

        // Conditional stages based on BRANCH_NAME and TAG_NAME
        if (env.BRANCH_NAME ==~ "PR1.*") {
            stage('test') {
                echo 'Running tests for PR branch...'
            }
            stage('Release') {
                echo 'Releasing from PR branch...'
            }
        } else if (env.TAG_NAME ==~ ".*") {
            stage('compile') {
                echo 'Compiling code for tag...'
            }
            stage('test') {
                echo 'Running tests for tag...'
            }
        } else {
            stage('compile') {
                echo 'Compiling code...'
            }
            stage('test') {
                echo 'Running tests...'
            }
            stage('Release') {
                echo 'Releasing code...'
            }
        }
    }
}
