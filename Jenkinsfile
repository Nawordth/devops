tools {
        maven 'apache-maven-3.3.9' 
}
node{
  stage('SCM Checkout'){
    git 'https://github.com/Nawordth/devops'
  }
  stage('Compile-Package'){
    sh 'mvn package'
  }
}
  
