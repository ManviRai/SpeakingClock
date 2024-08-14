The Speaking Clock is a Java-based Spring Boot application built using maven

**Project Structure**
1. pom.xml: Maven configuration file that manages dependencies and build lifecycle.
2. src: Contains the source code of the application.
3. main: Contains the main application code.
4. target: Contains the compiled classes and packaged JAR files (generated after a Maven build).


**To build the project use**
mvn clean install

**To run the application use**
mvn spring-boot:run

**The request has to be sent on localhost specifying the port number(as required)**
http://localhost:3302/api/time/convert?time=10:34
