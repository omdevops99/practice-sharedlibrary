def call() {
    pipeline {
        agent 
        stages {
            stage('Build') {
                steps {
                    sh 'mvn -B clean verify'
                }
            }
        }
    }
}
