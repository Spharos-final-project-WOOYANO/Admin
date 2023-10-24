pipeline {
    agent any

    stages {
        stage('Check') {
            steps {
                git branch: 'develop',credentialsId:'0-shingo', url:'https://github.com/Spharos-final-project-WOOYANO/Admin'
            }
        }
        stage('Build'){
            steps{
                sh '''
                    cd Admin
                    chmod +x ./gradlew
                    ./gradlew build -x test
                '''
            }
        }
        stage('DockerSize'){
            steps {
                sh '''
                    cd server
                    docker stop Admin-Service || true
                    docker rm Admin-Service || true
                    docker rmi Admin-Service-Img || true
                    docker build -t Admin-Service-Img:latest .
                '''
            }
        }
        stage('Deploy'){
            steps{
                sh 'docker run -d --name Admin-Service -p 8080:8000 Admin-Service-Img'
            }
        }
    }
}
