#! /usr/bin/env groovy

pipeline {

  agent any
  tools { 
        maven 'maven 3.8.6' 
        jdk 'JDK 11' 
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
		app = docker.build("backend_service")   
          // Add steps here

        }
      }
    }
    stage('Push image') {
        steps {
        	echo 'Push image to docker hub..'
        	docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
            	app.push("${env.BUILD_NUMBER}")
            	app.push("latest")
        	}
        }
    }
    
  }
}
