#! /usr/bin/env groovy

pipeline {

  agent {
    label 'maven'
  }
  
  stages {
    stage("Initialize") {
            steps {
                script {
                    echo 'Initialize...' + env.BRANCH_NAME
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
		app = docker.build("test")   
          // Add steps here

        }
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploying....'
        script {

          // Add steps here

        }
      }
    }
  }
}