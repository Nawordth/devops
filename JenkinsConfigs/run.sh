#!/bin/bash
export personal_access_token=$(cat ../gitlab-docker/setup/personal-access-token.txt)
echo --------------------------------------------------------
echo -
echo -  Using GitLab personal access token:
echo -
echo -    $personal_access_token
echo -
echo --------------------------------------------------------
grep -qxF 'chmod 777 /var/run/docker.sock' /etc/rc.d/rc.local || echo 'chmod 777 /var/run/docker.sock' >> /etc/rc.d/rc.local
dockerhost=$(hostname -I | awk '{print $1}')

docker run \
 --add-host=dockerhost:$dockerhost \
 --name jenkins-sandbox \
 -v /var/run/docker.sock:/var/run/docker.sock \
 -p 8080:8080 \
 -e personal_access_token=$personal_access_token \
 docker-jenkins-sandbox
 
 
