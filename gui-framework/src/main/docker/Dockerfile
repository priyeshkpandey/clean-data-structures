FROM maven:3.8.1-adoptopenjdk-11 as Maven

FROM browserless/chrome:latest as Chrome
ARG USER_HOME_DIR="/root"

COPY --from=Maven /usr/bin/mvn/ /usr/bin/mvn/
COPY --from=Maven /usr/share/maven/bin/mvn /usr/share/maven/bin/mvn
COPY --from=Maven /usr/share/maven/ /usr/share/maven/
COPY --from=Maven /usr/share/maven/ref/ /usr/share/maven/ref/
COPY --from=Maven /usr/local/bin/mvn-entrypoint.sh /usr/local/bin/mvn-entrypoint.sh

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

EXPOSE 3000