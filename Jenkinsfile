node{
  stage('SCM Checkout'){
    git 'https://github.com/Nawordth/devops'
  }
  stage('Build') {
   withMaven(maven: 'Maven 3') {
     sh 'mvn clean package'
   }
  }
}
