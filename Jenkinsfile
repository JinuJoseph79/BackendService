#! /usr/bin/env groovy

pipeline {

  agent any
  tools { 
        maven 'maven 3.8.6' 
        jdk 'JDK 11' 
    }
    environment {
		DOCKERHUB_CREDENTIALS=credentials('docker-hub-credentials')
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
		app = docker.build("backend_service/myapp:latest")   
          // Add steps here

        }
      }
    }
    stage('Login') {
			 echo 'Docker hub login..'
			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
	}

	stage('Push') {
			 echo 'Docker image push..'
			steps {
				sh 'docker push backend_service/myapp:latest'
			}
	}
    
  }
  post {
		always {
			sh 'docker logout'
		}
  }
}
