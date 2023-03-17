# SpringBoot3-Spring6
Learn Spring Boot 3 with Spring 6 and Hibernate

## Spring Boot Initialzr
https://start.spring.io/
* select the dependencies and download the zip file
* unzip and import to IDE

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
* Maven is the most popular Project Management tool
* Can download the jar files needed for your project
* Structure:
![Standard Directory Structure](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/structure-directory.PNG "Standard Directory Structure")
* To find dependency: spring.io, hibernate.org, search.maven.org
* Maven Wrapper files 
    * mvnw allows you to run Maven project
    * to run on windows/linux: mvnw clean compile test / ./mvnw clean compile test
    * if you have maven installed in your pc run: 
        * ./mvnw package
        * ./mvnw spring-boot:run
![mvnw](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/mvnw.PNG "mvnw")
* Warning: Do not use the src/main/weapp directory if your application is a packaged as a JAR. Although tihis is a standard Maven directory, it works only with WAR packaging. 

## Spring Boot
* can use templates like FreeMarker, Thymeleaf or Mustache

## Spring Boot Starters
* for Spring MVC you normally need: spring-webmvc, hibernate-validator, thymeleaf
* for Spring Boot Starter-Web you need: spring-boot-starter-web (contains all the bellow, json, tomcat etc)
* include spring-boot-starter-security and spring-boot-starter-data-jpa

## Spring Boot Parents for Starter
* spring-boot-starter-parent is provided for Maven by defaults and contain default compiler lever and utf-8 encoding
* if you wanna work with a specify java, not that is incluyed by default with Maven, change it:
```
<properties>
    <java.version> 17 </java.version>
</properties>
```

![Spring Boot Starter](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-boot-starter.png "Spring Boot Starter")

## Spring Boot Dev Tools
* for automatic restart, when add new dependencies to pom file for example, use spring-boot-devtools 
* then go to Preferences > Build, Execution, Deployment > Compiler > check box Build project automatically
* additional settings > Preferences > Advanged settings > check box Allow auto-make to ...

## Spring Boot Actuator
* it use to expose to monitor and manage the endpoints of application, to check the health of application
* add the REST endpoints automatically to application
* endpoints: /health and /info
* we need to update the application.properties

![Actuator endpoints](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/actuator-endpoints.png "Actuator endpoints")

* add the endpoints and the artifact in pom file
```
management.endpoints.web.exposure.include=health,info
management.info.env.enabled=true
```
* when run the project we get
```
LiveReload server is running on port 35729
Exposing 2 endpoint(s) beneath base path '/actuator'
Tomcat started on port(s): 8080 (http) with context path ''
```
* go to the endpoint /actuator/health to check if is working
* with /actuator/beans we get all the beans in project
* to analyzing and profiling your application performance /actuator/threaddump

## Spring Boot Actuator - securing endpoints
* add dependency spring-boot-security

![Actuator security](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/actuato-security.png "Actuator security")

* override default user name and generated a password

![Actuator security pass](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/actuator-security-pass.png "Actuator security pass")

* we also can exclude endopoints
```
management.endpoints.web.exposure.exclude=health,info
```

## Spring Boot from command line
* You don't need to have a server install or a IDE

![Command line](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/command-line.png "Command line")

* Two options for running the app
    * java -jar
    * mvnw spring-boot:run

## Anotaciones:
* @Override - override the method from the principal class
* @Component - mark a class like a spring bean and make the bean available for dependency injection
* @Autowired - allow injecting as a bean after a constructor, method or attribute is created
* @Qualifier - when there are one or more beans created and you want to use one of them, use this annotation together with @Autowired to specify which bean to use
* @Scope - specifies the scope of the bean
* @PostConstruct - to execute code during bean initialization
* @PreDestroy - to execute code during bean destruction
* @Configuration - define a class for bean creation
* @ComponentScan - indicate in which package to start searching for components
* @Bean - defines a bean
* @Controller - inherits from @Component
* @RequestMapping - used to map URLs to a class or method
* @RequestParam - get a parameter from the request
* @InitBinder - processes requests to the controller
* @Entity - to map a table from the database
* @Table - to specify the database table
* @Column - indicate the database column
* @Id - pk of a table
* @OneToOne
* @OneToMany
* @ManyToOne
* @ManyToMany    

## Injecting custom application properties
* By default is located in src/main/resources/application.properties
* With @Value annotation we can define a custom properties
```
coach.name=Micky Mouse
```
* For injecting the properties 
```
@RestController
public class FunRestController{
    @Value("${coach.name}")
    private String coachName;
}
```

## Configure Spring Boot Server
* Spring Boot properties have more than 1000. The properties are grouped into the following categories: core, web, security, data, acutator, integration, devtools, testing
* Core properties:
![Core Properties](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/core-properties.png "Core Properties")
* Create your own log file > logging.file=my-stuff.log
* Web properties
![Web Properties](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/web-properties.png "Web Properties")
* Data properties:
![Data Properties](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/data-properties.png "Data Properties")
* Server properties:
```
server.port=7070
server.servlet.context-path=/home
```
* the result is http://127.0.0.1:7070/home/teamInfo

# Inversion Of Control 
* Design process and outsource, build and manage objects
* Interfaces are used and the application must be as configurable as possible

## Spring Container y sus funciones
* create and manage objects (Inversion of control)
* inject dependencies (dependency injections)
* for spring container configuration use:
    * xml (deprecated)
    * java annotations
    * java code

## Spring development process:
* Configuration of a spring bean
```
<bean id="myCoach" class="inversionOfControl.TrackCoach"></bean>
```
* Create the spring container (special implementation: ClassPathXmlApplicationContext, AnnotationConfigApplicationContext, GenericWebApplicationContext, etc)
```
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
```
* Recover the bean from container (a bean is just an object in java)
```
Coach theCoach = context.getBean("myCoach", Coach.class);
```

## Constructor injection development process:
* Define the dependency class and the interface
File: FortuneService.java
```
public interface FortuneService{
    puclic String getForune();
}
```
File: HappyFortuneService.java
```
@Component
public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortune(){ 
        return "Today is my lucky day!"
    }
}
```
* Create the REST Controller
```
@RestController
public class DemoController{}
```
* Create a constructor in your class for injections 
```
private FortuneService fortuneService;

@Autowired
public BaseballCoach(FortuneService theFortuneService){
    fortuneService = theFortuneService;
}
```
* Configure the dependency injection in the spring config file, defined in the first step the dependency and in the second step inject the dependency
applicationContext.xml
```
<bean id="myFortuneService" class="springdependency.HappyFortuneService"></bean>
<bean id="myCoach" class="springdependency.TrackCoach">
    <constructor-arg ref="myFortuneService"/>
</bean>
```
![Spring behind the scene](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/Spring-behind-the-scene.PNG "Spring behind the scene")
![Spring process](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-process.png "Spring process")

## Component Scanner
* Scan the java classes for this special annotations and automatically register the beans in the spring container
* The @Component tag composed by: @EnableAutoConfiguration, @ComponentScan and @Configuration
![Spring  boot application](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-boot-application.png "Spring boot application")
![Component scanning](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/component-scanning.png "Component scanning")
* By default Spring Boot will not component scan the package with demo name
* Explicit component scanning
![Explicitly list of packages](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/explicit-list-package.png "Explicitly list of packages")

## Setter injection
* Create the setter method for injection
```
private FortuneService fortuneService;

@Autowired
public void setFortuneService(FortuneService fortuneService){
    this.fortuneService = fortuneService;
}
```
* config the dependency for injection in the config file
```
<bean id="myCricketCoach" class="setterinjection.CricketCoach">
    <!-- set up the constructor injection -->
    <property name="fortuneServ" ref="myFortune" />
</bean>
```
![Setter injection](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/Setter-injection.PNG "Setter injection")
![Setter injection behind the scene](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/Setter-injection-behind-the-scene.PNG "Setter injection behind the scene")
![Spring process setter injection](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/setter-injection-process.png "Spring process setter injection")