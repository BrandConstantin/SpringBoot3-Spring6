# SpringBoot3-Spring6
Learn Spring Boot 3 with Spring 6 and Hibernate

## Spring Boot Initialzr
https://start.spring.io/
- select the dependencies and download the zip file
- unzip and import to IDE

## Create a REST Controller
```
@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
}
```

## Spring Framework
Core Container contains: Beans -> Core -> SpEL -> Context
Infrastructure contains: AOP -> Aspects -> Instrumentation -> Messaging
Data Access Layer contains: JDBC -> ORM -> Transactions -> OXM and JMS
Web Layer contains: Servlet -> WebSocket -> Web

## What is Maven?
- Maven is the most popular Project Management tool
- Can download the jar files needed for your project
- Structure:
![Standard Directory Structure](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/structure-directory.PNG "Standard Directory Structure")
- To find dependency: spring.io, hibernate.org, search.maven.org
- Maven Wrapper files 
    - mvnw allows you to run Maven project
    - to run on windows/linux: mvnw clean compile test / ./mvnw clean compile test
    - if you have maven installed in your pc run: 
        - ./mvnw package
        - ./mvnw spring-boot:run
![mvnw](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/mvnw.PNG "mvnw")
- Warning: Do not use the src/main/weapp directory if your application is a packaged as a JAR. Although tihis is a standard Maven directory, it works only with WAR packaging. 

## Spring Boot
- can use templates like FreeMarker, Thymeleaf or Mustache

## Spring Boot Starters
- for Spring MVC you normally need: spring-webmvc, hibernate-validator, thymeleaf
- for Spring Boot Starter-Web you need: spring-boot-starter-web (contains all the bellow, json, tomcat etc)
- include spring-boot-starter-security and spring-boot-starter-data-jpa

## Spring Boot Parents for Starter
- spring-boot-starter-parent is provided for Maven by defaults and contain default compiler lever and utf-8 encoding
- if you wanna work with a specify java, not that is incluyed by default with Maven, change it:
```
<properties>
    <java.version> 17 </java.version>
</properties>
```
![spring-boot-starter](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-boot-starter.PNG "spring-boot-starter")

## Spring Boot Dev Tools
- for automatic restart, when add new dependencies to pom file for example, use spring-boot-devtools 
- then go to Preferences > Build, Execution, Deployment > Compiler > check box Build project automatically
- additional settings > Preferences > Advanged settings > check box Allow auto-make to ...

## Spring Boot Actuator
- it use to expose to monitor and manage the endpoints of application, to check the health of application
- add the REST endpoints automatically to application
- endpoints: /health and /info
- we need to update the application.properties
![actuator-endpoints](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/actuator-endpoints.PNG "actuator-endpoints")
- add the endpoints and the artifact in pom file
```
management.endpoints.web.exposure.include=health,info
management.info.env.enabled=true
```
- when run the project we get
```
LiveReload server is running on port 35729
Exposing 2 endpoint(s) beneath base path '/actuator'
Tomcat started on port(s): 8080 (http) with context path ''
```
- go to the endpoint /actuator/health to check if is working
- with /actuator/beans we get all the beans in project
- to analyzing and profiling your application performance /actuator/threaddump

## Spring Boot Actuator - securing endpoints
- add dependency spring-boot-security
![actuator-security](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/actuato-security.PNG "actuator-security")
- override default user name and generated a password
![actuator-security-pass](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/actuator-security-pass.PNG "actuator-security-pass")
- we also can exclude endopoints
```
management.endpoints.web.exposure.exclude=health,info
```

## Spring Boot from command line
- You don't need to have a server install or a IDE
![command-line](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/command-line.PNG "command-line")
- Two options for running the app
    - java -jar
    - mvnw spring-boot:run

## Injecting custom application properties
- By default is located in src/main/resources/application.properties
- With @Value annotation we can define a custom properties
```
coach.name=Micky Mouse
```
- For injecting the properties 
```
@RestController
public class FunRestController{
    @Value("${coach.name}")
    private String coachName;
}
```

## Configure Spring Boot Server
- Spring Boot properties have more than 1000. The properties are grouped into the following categories: core, web, security, data, acutator, integration, devtools, testing
- Core properties:
![core-properties](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/core-properties.PNG "core-properties")
- Create your own log file > logging.file=my-stuff.log
- Web properties
![web-properties](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/web-properties.PNG "web-properties")
- Data properties:
![data-properties](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/data-properties.PNG "data-properties")
- Server properties:
```
server.port=7070
server.servlet.context-path=/home
```
- the result is http://127.0.0.1:7070/home/teamInfo