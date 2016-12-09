FROM tomcat:9.0.0.M11-alpine
MAINTAINER Bilgin Ibryam
EXPOSE 8080
COPY target/semat.war /maven/ROOT.war
RUN rm -fr /usr/local/tomcat/webapps/* && mv /maven/ROOT.war /usr/local/tomcat/webapps/
CMD catalina.sh run
