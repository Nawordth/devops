FROM tomcat:9.0-alpine

ADD ["target/PageHitCounter2.war", "/usr/local/tomcat/webapps/"]

EXPOSE 8080

CMD ["catalina.sh", "run"]
