node{
  stage('SCM Checkout'){
    git 'https://github.com/Nawordth/devops'
  }
  stage('Compile-Package'){
    def mvnHome = tool name: 'maven3', type: 'maven'
    sh "${mvnHome}/bin/mvn -B -DskipTests clean install"
  }
      stage('Image Build'){
        sh 'docker build -t hasarangaprasad/test:latest .'
    }
       stage('Image Test'){ 
         sh 'docker rm -v -f agent || true'
      sh 'docker run --name agent -d -p 9999:8080 hasarangaprasad/test:latest'
         sleep(time:5,unit:"SECONDS")
         
         def response = sh(script: 'curl -s -o /dev/null -w "%{http_code}" http://dockerhost:9999/PageHitCounter2/PageHitCounter', returnStdout: true)
         echo response
         if (response != '200') {
    currentBuild.result = 'ABORTED'
    error('Health check is failed during the image test..')
        } 
         sh 'docker rm -v -f agent'
       }
    stage('Image Push'){
  sh 'docker login -u hasarangaprasad -p hasa@12345'
      sh 'docker push hasarangaprasad/test:latest'
      sh 'docker image rm hasarangaprasad/test:latest'
          }
  stage("Deploy") {
                    sh "export ANSIBLE_HOST_KEY_CHECKING=False"
                    sh "chmod +x ./ec2.py"
                    sh "ansible-playbook playbook1.yml -i ./ec2.py --limit 'tag_Network_Public'"
  }
}
