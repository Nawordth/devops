node{
  stage('SCM Checkout'){
    git 'https://github.com/Nawordth/devops'
  }
  stage('Compile-Package'){
    def mvnHome = tool name: 'Apache Maven 3.6.0', type: 'maven'
    sh "${mvnHome}/bin/mvn -B -DskipTests clean package"
  }
}
