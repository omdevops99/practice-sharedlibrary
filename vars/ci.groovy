def call() {
    node {
        stage('compile') {}

        stage('test') {}

        stage('build') {}

        stage('integration test') {}

        stage('Release') {}

        }
    }

