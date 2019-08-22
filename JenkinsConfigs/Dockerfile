FROM jenkins/jenkins:lts

RUN mkdir $JENKINS_HOME/casc_configs
COPY ./jenkins.yaml $JENKINS_HOME/casc_configs/jenkins.yaml
COPY ./maven.groovy $JENKINS_HOME/init.groovy.d/maven.groovy
COPY ./devops.pem $JENKINS_HOME/.ssh/devops.pem
ENV CASC_JENKINS_CONFIG=$JENKINS_HOME/casc_configs

ENV JAVA_OPTS=-Djenkins.install.runSetupWizard=false
RUN install-plugins.sh \
  configuration-as-code \
  configuration-as-code-support \
  blueocean \
  job-dsl \
  cloudbees-folder \
  workflow-aggregator \
  pipeline-utility-steps \
  generic-webhook-trigger \
  git-changelog \
  violation-comments-to-gitlab
  
USER root
RUN apt-get update && \
apt-get -y install apt-transport-https \
    ca-certificates \
    curl \
    gnupg2 \
    software-properties-common && \
curl -fsSL https://download.docker.com/linux/$(. /etc/os-release; echo "$ID")/gpg > /tmp/dkey; apt-key add /tmp/dkey && \
add-apt-repository \
    "deb [arch=amd64] https://download.docker.com/linux/$(. /etc/os-release; echo "$ID") \
    $(lsb_release -cs) \
    stable" && \
apt-get update && \
apt-get -y install docker-ce
RUN apt-get install -y docker-ce
RUN apt-get install -y ansible
RUN usermod -a -G docker jenkins
RUN chown jenkins.jenkins /var/jenkins_home/.ssh/ -R
RUN chmod 600 /var/jenkins_home/.ssh/devops.pem
USER jenkins
  
