pipeline {
    agent any
    stages {
        stage('Check') {
            steps {
                git branch: 'develop',credentialsId:'0-shingo', url:'https://github.com/Spharos-final-project-WOOYANO/Admin'
            }
        }
	stage('Secret-File Download'){
	    steps{
		withCredentials([
		    file(credentialsId: 'Wooyano-Secret-File', variable: 'secret')
		])
	        {
	            sh "cp \$secret ./src/main/resources/application-secret.yml"
	    	}
	    }
	}
        stage('Build'){
            steps{
                script {
                    sh '''
                        pwd
                        chmod +x ./gradlew
                        ./gradlew build
                    '''
                    
                }
                    
            }
        }
	stage('DockerSize'){
            steps {
	    	script {
		
                sh '''
                    docker stop admin-service || true
                    docker rm admin-service || true
                    docker rmi admin-service-img || true
                    docker build -t admin-service-img:latest .
                '''
		}

            }
        }
        stage('Deploy'){
            steps {
                sh 'docker run --network spharos-network -e EUREKA_URL="${EUREKA_URL}" -d --name admin-service admin-service-img'
            }
        }
    }
}

