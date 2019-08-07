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
    stage('Build') {
echo "Build docker image"
                script {
                    dockerImage = docker.build(2,  '-f ./Dockerfile .')
                    pipelineContext.dockerImage = dockerImage
            
   }
}
