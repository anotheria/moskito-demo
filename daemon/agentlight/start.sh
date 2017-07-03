export PATH_TO_JAVAAGENT=../../../msk-downloads/moskito/moskito-javaagent-lite/moskito-javaagent-lite-2.8.2.jar
echo starting javaagent light example with agent $PATH_TO_JAVAAGENT and port $1
java -javaagent:$PATH_TO_JAVAAGENT -DmoskitoAgentPort=$1 -cp target/moskito-demo-daemon-agentlight-1.0.0-SNAPSHOT-jar-with-dependencies.jar org.moskito.demo.daemon.agentlight.Daemon