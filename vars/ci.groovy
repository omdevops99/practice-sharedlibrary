def call() {
    pipeline {
        agent { 
            docker { image 'maven:3.9.3-eclipse-temurin-17' }
        }
        stages {
            stage('Build') {
                steps {
                    sh 'mvn -B clean verify'
                }
            }
        }
    }
}
