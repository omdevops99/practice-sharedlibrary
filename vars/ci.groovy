def call() {
    node {
        
        stages {
            stage('compile') {}

            stage('test') {}

            stage('build') {}

            stage('integration test') {}

            stage('Release') {}

        }
    }
}
