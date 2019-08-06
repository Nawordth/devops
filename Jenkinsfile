pipeline {
    agent any
    tools { 
        maven 'Maven 3.3.9' 
        jdk 'jdk8' 
    }
    stages {
  stage('SCM Checkout'){
    git 'https://github.com/Nawordth/devops'
  }
  stage('Build') {
   withMaven(maven: 'Maven 3') {
     sh 'mvn clean package'
   }
  }
}
}
