#! /usr/bin/env groovy

pipeline {

  agent any
  tools { 
        maven 'maven 3.8.6' 
        jdk 'JDK 11' 
    }
    environment {
		DOCKERHUB_CREDENTIALS=credentials('docker-hub-credentials')
		BUILD_NAME = 'backend_service'
		
		DOCKER_REPO = 'app_services_2022'
	}
  stages {
    stage("Initialize") {
            steps {
                script {
                    echo 'Initialize...' + env.BRANCH_NAME
		    		echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                }
            }
     }
    stage('Build') {
      steps {
        echo 'Building..'
          sh 'mvn clean package'
        // Add steps here
      }
    }
    stage('Create Container Image') {
      steps {
        echo 'Create Container Image..'
        
        script {
		app = docker.build("${BUILD_NAME}")   
          // Add steps here

        }
      }
    }
    stage('Login') {
			 
			steps {
			    echo 'Docker hub login..'
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
	}

	stage('Push') {
			
			steps {
			script {			
				def docker_image = '${$DOCKERHUB_CREDENTIALS_USR}/${DOCKER_REPO}:latest'
			 	echo 'Docker image push.. ${docker_image}'
			 	sh 'docke tag ${BUILD_NAME} $docker_image'
				sh 'docker push $docker_image'
				}
			}
	}
    
  }
  post {
		always {
			sh 'docker logout'
		}
  }
}
