node{
  stage('SCM Checkout'){
    git 'https://github.com/Nawordth/devops'
  }
  stage('Compile-Package'){
    def mvnHome = tool name: 'maven3', type: 'maven'
    sh "${mvnHome}/bin/mvn -B -DskipTests clean package"
  }
   stage('Initialize'){
        def dockerHome = tool 'mDocker'
        env.PATH = "${dockerHome}/bin:${env.PATH}"
            }
      stage('Image Build'){
        imageBuild('aaa', 3)
    }
    
}
