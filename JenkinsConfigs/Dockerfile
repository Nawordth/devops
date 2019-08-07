FROM jenkins/jenkins:lts

USER root
RUN apt-get install -qqy curl 
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
RUN add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/debian \
   $(lsb_release -cs) \
   stable"
RUN apt-get update  -qq \
    && apt-get install docker-ce=17.12.1~ce-0~debian -y
RUN usermod -aG docker jenkins
RUN systemctl start docker
USER jenkins

RUN mkdir $JENKINS_HOME/casc_configs
COPY ./jenkins.yaml $JENKINS_HOME/casc_configs/jenkins.yaml
COPY ./maven.groovy $JENKINS_HOME/init.groovy.d/maven.groovy
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
  
