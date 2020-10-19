FROM jboss/wildfly
COPY target/Lesson19-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
EXPOSE 8080