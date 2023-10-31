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
                script {
                    sh '''
                        pwd
                        chmod +x ./gradlew
                        ./gradlew build -x test
                    '''
                    
                }
                    
            }
        }
        stage('DockerSize'){
            steps {
                sh '''
                    docker stop admin-service || true
                    docker rm admin-service || true
                    docker rmi admin-service-img || true
                    docker build -t admin-service-img:latest .
                '''
            }
        }
        stage('Deploy'){
            steps{
                sh 'docker run --name admin-service admin-service-img'
            }
        }
    }
}


