#!/usr/bin/env bash

export PATH_TO_JAVAAGENT=javaagent-1.0.0-SNAPSHOT.jar
export CLASSPATH=target/moskito-demo-daemon-javaagent-1.0.0-SNAPSHOT-jar-with-dependencies.jar

echo starting javaagent example with agent $PATH_TO_JAVAAGENT and port $1

java -javaagent:${PATH_TO_JAVAAGENT} -DmoskitoAgentPort=$1 -cp ${CLASSPATH} org.moskito.demo.daemon.javaagent.Daemon
