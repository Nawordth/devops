FROM tomcat:8.0-alpine

ADD $JENKINS_HOME/workspace/Create Jobs Pipeline/target/PageHitCounter2.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]
