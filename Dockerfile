FROM tomcat:8.0-alpine

ADD '/var/jenkins_home/workspace/Create Jobs Pipeline/target/PageHitCounter2.war' '/usr/local/tomcat/webapps/'

EXPOSE 8080

CMD ["catalina.sh", "run"]
