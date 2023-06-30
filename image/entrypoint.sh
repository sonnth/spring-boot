#!/bin/bash

AGENT_PARAM=
if [ $AGENT_ENABLE = true ]; then
  AGENT_PARAM="-javaagent:/apps/dd-java-agent.jar -Ddatadog.slf4j.simpleLogger.defaultLogLevel=off"
fi

exec java $JAVA_OPTS $AGENT_PARAM \
  -Duser.timezone=$TZ \
  -Dspring.config.location=$SPRING_CONFIG_LOCATION \
  -Dspring.profiles.active=$SPRING_PROFILE \
  -Djava.security.egd=file:/dev/./urandom \
  -jar /app.jar