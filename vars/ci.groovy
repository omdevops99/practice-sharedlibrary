def call() {
    node {
        // Print all environment variables
        sh "find . | sed -e '1d' |xargs rm -rf"

        // Determine branchName based on TAG_NAME or BRANCH_NAME
        if (env.TAG_NAME ==~ ".*") {
            env.branch_name = env.TAG_NAME
        } else {
          if (env.BRANCH_NAME ==~ "PR.*") {
             env.branch_name = "${env.CHANGE_BRANCH}"
          } else {
            env.branch_name = "${env.BRANCH_NAME}"
        }

        }
        // Code checkout stage
        stage('code checkout') {
            checkout scmGit(branches: [[name: "${branch_name}"]], extensions: [], userRemoteConfigs: [[url: 'https://github.com/omdevops99/expense_jenkins.git']])

        
        }
        sh 'cat Jenkinsfile'

        // Conditional stages based on BRANCH_NAME and TAG_NAME
        if (env.BRANCH_NAME ==~ "PR.*") {
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
