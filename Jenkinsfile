pipeline {
    agent any
    stages {
        stage('Check') {
            steps {
                git branch: 'develop',credentialsId:'0-shingo', url:'https://github.com/Spharos-final-project-WOOYANO/Admin'
            }
        }
	stage('Gateway-Secret-File Download'){
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
        stage('Deploy'){
            steps {
                sh '''
                    docker stop admin-service || true
                    docker rm admin-service || true
                    docker rmi admin-service-img || true
                    docker build -t admin-service-img:latest .
		    docker run --network spharos-network -d --name gateway -p 8000:8000 gateway-img
                '''
            }
        }
    }
}

