node{
  stage('SCM Checkout'){
    git 'https://github.com/Nawordth/devops'
  }
  stage('Compile-Package'){
    def mvnHome = tool name: 'maven3', type: 'maven'
    sh "${mvnHome}/bin/mvn -B -DskipTests clean package"
  }
    stage('Build') {
sh 'docker build -t shanem/spring-petclinic:latest .'
            
   }
}
