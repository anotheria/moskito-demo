spring-boot-moskito-demo
================

Spring boot demo project for MoSKito

Demo is based on MoSKito version 4.0.3 and Java21.

How to run spring boot demo application:
1) Via spring boot maven plugin:
    
    1.1 Open spring-boot folder in a terminal.
    
    1.2 Run the command "mvn spring-boot:run".
    
    1.3 Spring boot app will start on port 8080 and local registry will start on port 9250 (If this port is busy, another port will be selected. In order to find out which port was selected, you can look at the log of the org.distributeme.core.RMIRegistryUtil).
    
2) Via executable jar:
        
    1.1 Open spring-boot folder in a terminal.
        
    1.2 Run the command "mvn clean package spring-boot:repackage".
        
    1.3 Go to the target folder and run "java -jar moskito-demo-spring-boot-2.0.0-SNAPSHOT-spring-boot.jar".
    
    1.4 Spring boot app will start on port 8080 and local registry will start on port 9250 (If this port is busy, another port will be selected. In order to find out which port was selected, you can look at the log of the org.distributeme.core.RMIRegistryUtil).
  
    1.5 If you want to specify local registry port run "java -DlocalRmiRegistryPort=the_port_you_want_to_use -jar moskito-demo-spring-boot-2.0.0-SNAPSHOT-spring-boot.jar".

3) Run moskito-inspect application (for details see https://anotheria.net/blog/msk/the-complete-moskito-integration-guide-step-1/).
4) Enter localhost as host and your local registry post as port. Click connect.
5) Go to the link "http://localhost:8080/test/get". Go to the "Producers" tab in the moskito-inspect app . A producer with the name "SpringBootTestController" will be displayed in the "Services" section. 
6) You can also send a json with a single "string" field using the post request by the endpoint "http://localhost:8080/test/post". After that a producer with the name "SpringBootTestService" will be displayed in the "Services" section. 
