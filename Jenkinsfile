node{
  stage('SCM Checkout'){
    git 'https://github.com/Nawordth/devops'
  }
  stage('Compile-Package'){
    def mvnHome = tool name: 'maven3', type: 'maven'
    sh "${mvnHome}/bin/mvn -B -DskipTests clean install"
  }
      stage('Image Build'){
        sh 'docker build -t hasarangaprasad/test:2 .'
    }
    stage('Image Push'){
  sh 'docker login -u hasarangaprasad -p hasa@12345'
      sh 'docker push hasarangaprasad/test:2'
          }
}
