# SpringBoot3-Spring6
Learn Spring Boot 3 with Spring 6 and Hibernate
Course: https://www.udemy.com/course/spring-hibernate-tutorial/

## Hibernate, Spring Data JPA, Spring Data REST, Spring Security, Thymeleaf, Spring MVC, JSP, Spring REST API
For Spring Boot 3 it needs JDK 17 version. 

# Spring Boot Start

## Spring Boot Initialzr
Spring Boot use behind Spring. Also, Spring Boot embedded HTTP server, so you don't need to install a server separately.
To start the application can use the command line: java -jar mycoolapp.jar or from IDE: Run As → java application. It can also be deployed in the traditional way, deploying a war file to an external server. 
Spring Boot include the on server so we run as java application not like a server. On web browser open with localhost:8080


https://start.spring.io/
* select the dependencies and download the zip file
* unzip and import to IDE

![spring-boot-contains](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-boot-contains.png "spring-boot-contains")
![initialzr](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/initialzr.png "initialzr")

## Spring Framework
* Core Container contains: Beans -> Core -> SpEL -> Context
* Infrastructure contains: AOP -> Aspects -> Instrumentation -> Messaging
* Data Access Layer contains: JDBC -> ORM -> Transactions -> OXM and JMS
* Web Layer contains: Servlet -> WebSocket -> Web

## What is Maven?
* Maven is the most popular Project Management tool
* Can download the jar files needed for your project
* Structure:
![Standard Directory Structure](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/standard-directory-structure.png "Standard Directory Structure")
* To find dependency: spring.io, hibernate.org, search.maven.org
* standard directory structure
![src-main-java](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/src-main-java.png "src-main-java")
![src-main-webapp](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/src-main-webapp.png "src-main-webapp")
POM structure:
![pom xml](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/pom-xml.png "pom xml")
![pom structure](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/pom-structure.png "pom structure")
![Spring Boot Starter](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-boot-starter.png "Spring Boot Starter")
To find dependency coordinates:
* pages like spring.io, hibernate.org
* https://central.sonatype.com
* Maven Wrapper files 
    * mvnw allows you to run Maven project
    * to run on windows/linux: mvnw clean compile test / ./mvnw clean compile test
    * if you have maven installed in your pc run: 
        * ./mvnw package
        * ./mvnw spring-boot:run
![mvnw](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/mvnw-cmd.png "mvnw")
* Warning: Do not use the src/main/weapp directory if your application is a packaged as a JAR. Although tihis is a standard Maven directory, it works only with WAR packaging. 

## Create a REST Controller
![REST Controller](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/rest-controller.png "REST Controller")
If a rest controller it’s not defined, we have the famous error “Whitelabel Error Page - This application has no explicit mapping for /error, so you are seeing this as a fallback”. 

## Spring modules
Spring framework have an additional module like Spring Cloud, Spring Data, Spring Batch, Spring Security, Spring Web Service, Spring LDAP etc
Use only what you need.

## Application properties
![Properties](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/properties.png "Properties")

## Static Content
![static-content](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/static-content.png "static-content")

### Templates
-FreeMarker
-Thymeleaf
-Mustache

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
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```
* then go to Settings > Build, Execution, Deployment > Compiler > check box Build project automatically
* additional Settings > Advanced settings > check box Allow auto-make to start even if developed application is currently running

## Spring Boot Actuator
* it use to expose to monitor and manage the endpoints of application, to check the health of application
* add the REST endpoints automatically to application
* endpoints: /health and /info
* we need to update the application.properties

![Actuator endpoints](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/actuator-endpoints.png "Actuator endpoints")

* change the pom file
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
* add the endpoints and the artifact in properties file
```
## use wildcard "*" to expose all endpoints
##management.endpoints.web.exposure.include=*
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
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

![Actuator security](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/actuato-security.png "Actuator security")

* override default user name and generated a password

![Actuator security pass](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/actuator-security-pass.png "Actuator security pass")

* we also can exclude endopoints
```
management.endpoints.web.exposure.exclude=health,info
```

* application.properties file 
```
## Actuator
## use wildcard "*" to expose all endpoints
##management.endpoints.web.exposure.include=*
management.endpoints.web.exposure.include=health,info
management.endpoints.web.exposure.exclude=devtools
management.info.env.enabled=true
spring.security.user.name=adminuser
spring.security.user.password=adminuser1

##http://localhost:8080/home/actuator

## actuator info
info.app.name=SpringApp
info.app.description=Learning Spring Boot
info.app.version=1.0
info.app.lesson=Actuator
```

## Spring Boot from command line
* You don't need to have a server install or a IDE

![Command line](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/command-line.png "Command line")

* Command for running the app from cmd:
    * echo %JAVA_HOME%
    * java --version
    * cd folder/myapp
    * mvnw package
    * java -jar target\myapp-0.0.1-SNAPSHOT.jar
    * mvnw spring-boot:run
    * CTRL+c to stop the server

## Application properties file and inject properties into spring boot app
* By default is located in src/main/resources/application.properties
* With @Value annotation we can define a custom properties
```
## injecting custom properties
## http://localhost:8080/home/teamInfo
coach.name=Micky Mouse
team.name=Lider United
```
* For injecting the properties 
```
@RestController
public class FunRestController{
    // inject custom properties
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teamInfo")
    public String getTeamName(){
        return "Team info: " + coachName + " - " + teamName;
    }
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
![spring-container](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-container.png "spring-container")

## Spring Container and his functions
* create and manage objects (Inversion of control)
* inject dependencies (dependency injections)
* for spring container configuration use:
    * xml (deprecated)
    * java annotations
    * java code

## Spring Injection types
* Constructor injection, use when you have required dependencies and generally recommended by the spring.io
* Setter injection, use when you have optional dependencies and if dependency is not provided, your app can provide a one default
* Field injection (not recommended by spring.io)

For dependency injection, Spring can use @Autowired, Spring looking for a class that matches (class or interface) and inject automatically. 
For this injection Spring will scan for @Components. 

## Dependency Injection
Behind the scene:
![Spring process](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-process.png "Spring process")
1. define the dependency interface and class:
    - create a interface
    - create class with the @Component annotations for scanning
2. create the rest controller, with @RestController
3. create a constructor in you class for injections
    - call to the private class interface
    - use @Autowired for injection
4. add getMapping in the controller
    - use @GetMapping for call the rest
    - return the injection

## Constructor injection:
1. Define the interface and the dependency class
File: FortuneService.java
```
public interface FortuneService{
    public String getForune();
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
2. Create the REST Controller
```
@RestController
public class DemoController{
    // define a private field for the dependency
    private Coach myCoach;

    // create the constructor for injection
    @Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWork();
    }
}
```
## Component Scanner
Scan the java classes for this special annotations and automatically register the beans in the spring container
![Spring  boot application](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-boot-application.png "Spring boot application")
---------------------------------------------------------
![Component scanning](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/component-scanning.png "Component scanning")
---------------------------------------------------------
* By default Spring Boot will not component scan the package with demo name
* Explicit component scanning
![Explicitly list of packages](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/explicit-list-package.png "Explicitly list of packages")
Error: "Parameter 0 of constructor in com.rest.DemoController requiered a bean of type 'com.util.Coach' that could no be fount" ocurre when the bean is not part of default package. Resolve add the scan package
![list-base-packages-to-scan](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/list-base-packages-to-scan.png "list-base-packages-to-scan")

## Setter injection
Behind the scene
![Spring process setter injection](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/setter-injection-process.png "Spring process setter injection")
1. Define the interface and the dependency class
```
public interface Coach {
    String getDailyWork();
}
```

```
@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWork(){
        return "Practice from CricketCoach";
    }
}
```
2. Create the REST Controller, with the setter method for injection
```
@RestController
public class DemoController {
    // define the properties field for the dependency
    private Coach myCoach;

    // create the setter injection
    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }

    ...
}
```
## Field injection
It's not recommended to use spring.io. It makes the code harder to unit test. 
```
@RestController
public class DemoController{
    // no deed for constructor or setters, field injection directly
    @Autowired
    private Coach myCoach;

    @GetMapping("/daily")
    ...
}
```

## Qualifiers
* When have multiple classes to implement a injection, use multiple @Components, Spring don't know who need to use:
![Multiple implementation](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/multiple-implementation.png "Multiple implementation")
* To resolve this problem is used the @Qualifier annotation
![Qualifier](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/qualifier.png "Qualifier")


## @Primary
* Another alternative to @Qualifier is @Primary. Instead of specifying a coach by name using @Qualifier you specify the primary coach.
* You can use more than one single @Primary annotation. Error: "Unsatisfied dependency expressed through constructor parameter 0: more than one 'primary' bean found among candidates".  
```
@Component
@Primary
public class BaseballCoach implements Coach{
    ...
}
```

## Lazy initialization
* For global configuration add lazy to application.properties 
'''spring.main.lazy-initialization=true'''
* Advantages: 
    * only create objects as needed for dependency injection or is explicitly requested
    * may help with faster startup time if you have large number of components
* Disadvantages:
    * if you have web related components like @RestController, not created until requested
    * need enough memory for all beans once created
* It is disabled by default
```
@Component
@Lazy
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        ...
    }
   
}
```

## Bean scopes
* Default scope is singleton
* Spring Container creates only one instance of the bean, by default and it is cached in memory. All dependency injection for the bean will referenece the same bean
* The scope of a bean refers to the life cycle of a bean, how long it will exist, how many instances will be created and how the bean will be shared
![Bean Scopes](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/bean-scopes.png "Bean Scopes")
```
Coach theCoach = context.getBean("myCoach", Coach.class);
Coach alphCoach = context.getBean("myCoach", Coach.class);

// check if the beans are the same		
boolean result = false;
result = (theCoach == alphCoach);

System.out.println("Pointing to the same object: " + result);
System.out.println(theCoach + " / " + alphCoach);
```
* Type of scopes
![Additional Bean Scopes](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/aditional-bean-scopes.png "Additional Bean Scopes")
* Prototype scope example
![New injection for each object](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/new-injection-for-each-object.png "New injection for each object")
* Or we can create a global scope prototype to no longer point to the same bean object
```
    <bean id="myCoach" class="beanscopes.BaseballCoach" scope="prototype"></bean>
```

## Bean Lifecycle Methods
Container Started -> Bean Instantiated -> Dependencies Injected -> Internal Spring Processing -> you custom init method -> bean ready to use
Container Shutdown -> your custom destroy method -> stop
* Custom code can be added during bean initialization or bean destruction
* `init-method` is the method to initialize an action during bean initialization
* `destroy-method` is the method to initialize an action during bean destruction
* We can do this on globally
```
<bean id="myCoach" class="beanlifecycle.TrackCoach" 
	init-method="doInitMethod" destroy-method="doDestroyMehtod">
</bean>
```
* Or separately, by class
```
@Component
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("In constructor class " + getClass().getSimpleName());
    }

    // define the init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("Do my startup stuff");
    }

    // define the destroy method
    @PreDestroy
    public void doMyDestroyStruff(){
        System.out.println("Destroy all my staff!");
    }

    @Override
    public String getDailyWork(){ return "Spend 30 min in batting practice"; }
}
```
* The scope prototype does not have the destroy method so it cannot be initialized. In order to do this, the destroy() method is defined.

## Java Config Bean
* Configure in 3 steps:
    * Create @Configuration class
![@Configuarion class](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/step1.png "@Configuarion class")    
    * Define @Bean method
![@Bean Method](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/step2.png "@Bean Method")  
    * Inject the bean in the controller
![Inject the bean](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/step3.png "Inject the bean") 

## Annotations Part I:
* @Override - override the method from the principal class
* @Component - mark a class like a spring bean and make the bean available for dependency injection
* @Autowired - allow injecting as a bean after a constructor, method or attribute is created
* @Qualifier - when there are one or more beans created and you want to use one of them, use this annotation together with @Autowired to specify which bean to use
* @Primary - to identify the principal bean, it is an alternative to @Qualifier
* @Lazy - bean is only initialized if needed for dependency injection
* @Eager - is allwais initialized
* @Scope - specifies the scope of the bean
* @PostConstruct - to execute code during bean initialization
* @PreDestroy - to execute code during bean destruction
* @Configuration - define a class for bean creation
* @ComponentScan - indicate in which package to start searching for components
* @Bean - defines a bean

# Hibernate & JPA
* Hibernate is a framework for persisting and saving java objects in a database
* Hibernate provide the object-to-relational mapping ORM
* In Spring Boot, Hibernate is de default implementation of JPA (Jakarta Persistence API)
* EntityManager is main component for creating queries
* https://hibernate.org
* Downloads and install MySQL Database Server: https://dev.mysql.com/downloads/mysql/
* Downloads and install MySQL Workbench: https://dev.mysql.com/downloads/workbench/
* Download Hibernate and MySQL JDBC Driver and add jar file to the project
	* https://sourceforge.net/projects/hibernate/files/hibernate-orm/5.6.5.Final/hibernate-release-5.6.5.Final.zip/download
	* https://dev.mysql.com/downloads/connector/j/ >> choose the connector for a "platform independent"
* Based on entries from Maven pom file: MySQL JDBC driver (mysql-connector-j) and Spring Data JPA (ORM) (spring-boot-starter-data-jpa)
### Development Process 1
* Add hibernate configuration file, placed in the src folder
```
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
    <session-factory>
        <!-- JDBC Database connection settings -->
        <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&amp;serverTimezone=UTC</property>
        <property name="connection.username">hbstudent</property>
        <property name="connection.password">hbstudent</property>

        <!-- JDBC connection pool settings ... using built-in test pool -->
        <property name="connection.pool_size">1</property>

        <!-- Select our SQL dialect -->
        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>

        <!-- Echo the SQL to stdout -->
        <property name="show_sql">true</property>

		<!-- Set the current session context -->
		<property name="current_session_context_class">thread</property>
    </session-factory>
</hibernate-configuration>
```
### Development Process 2
* Modify the application.properties:
![Datasource](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/datasource.png "Datasource")  
* Command line
![command-line-app](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/command-line-app.png "command-line-app")  
* When run the application if the connect to BBDD es correctly we se the messages:
```
- Starting...
- Added connection com.mysql.cj.jdbc.ConnectionImpl@64b7225f
- Start completed.
```
* Tricks
```
# Turn of the spring boot banner
spring.main.banner-mode=off
# reduce logging level, set to warn
logging.level.root=warn
```

## JPA Dev Process
As mentioned, Hibernate is the default JPA implementation in Spring Boot. 
* Annotate Java Class
* Develop Java Code to perform database operations
* If you don't declare any constructors in Java, Java will privide a no-argument constructor for you


* Exist two options for mapping
	* xml config file
	* java annotations (is more modern)
* Map class and fields to table and columns
```
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email_name")
	private String email;

	..........
}
```
* @Column is optional but recommandly if you update BBDD column, it's need to be the same name as java field

### About Primary Keys
* Id generation strategies
	* GenerationType.AUTO - pick an appropiate strateg for the particular database
	* GenerationType.IDENTITY - asign primary keys using database identity columns
	* GenerationType.SEQUENCE - assing primary keys using a database secuence
	* GenerationType.TABLE - assign primary keys using an underlying database table to ensure uniqueness
* Data Access Object (DAO):
    * save()
    * findById()
    * findAll()
    * findByLastName()
    * update()
    * delete()
    * deleteAll()
![JPA Entity Manager](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/JPA-EntityManager.png "JPA Entity Manager") 

### Saving java object with JPA:
* Define DAO interface
```
public interface StudentDAO {
    void save(Student theStudent);
}
```
* Define DAO implementation and inject entity manager
```
@Repository
public class StudentDAOImpl implements StudentDAO{
    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired // Autowired is optional if you have only one constructor
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
```
* Spring provide @Transactional, that is automatically begin and end a transaction for JPA code, it's no need to explicitly add to the code
* @Respository automatically register the DAO implementation, thanks to component-scanning and provides translation for any JDBC related exceptions

* Update app
```
@Bean
public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
    return runner ->{
        //createStudent(studentDAO);
        createMultipleStudent(studentDAO);
    };
}

private void createStudent(StudentDAO studentDAO) {
    // create the object
    Student tempStudent = new Student("Paul", "Doe", "paul@doe.com");

    // save the object
    studentDAO.save(tempStudent);

    // display id of the object
    System.out.println("Student saved with id " + tempStudent.getId());
}
```

### Reading objects with JPA
* Add DAO interface
```
public interface StudentDAO {
    Student findById(Integer id);
}
```
* Add DAO implementation
```
@Repository
public class StudentDAOImpl implements StudentDAO{
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }
}
```
* Update app
```
	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		Student tempStudent = new Student("Daffy", "Duckovicy", "daffy@duck.ru");

		// save the student
		studentDAO.save(tempStudent);

		// display id of the save student
		int theId = tempStudent.getId();

		// retrive the student based in primary key
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Find the student " + myStudent);
	}
```

## JPA Query Language - JPQL
* JPQL is a query language for retrieving object and is similar in concept with SQL (where, like, order by etc)
* Is based on entity name and entity fields

![JPQL](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/JPQL.png "JPQL") 
---------------------------------------------------------
![JPQL2](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/JPQL2.png "JPQL2") 
---------------------------------------------------------
![JPQL with parameters](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/JPQL3.png "JPQL with parameters") 

### Dev process
* Add DAO interface
```
public interface StudentDAO {   
    List<Student> findAll();
}
```
* Add DAO implementation
```
@Repository
public class StudentDAOImpl implements StudentDAO{
    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);
        
        // return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student where lastName=:theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData", theLastName);

        // return query result
        return theQuery.getResultList();
    }
}
```
* Update app
```
@SpringBootApplication
public class Application {
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//readAllStudents(studentDAO);
			queryGetStudentsByLastName(studentDAO);
		};
	}

    private void readAllStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display the students
        for(Student tempStudent: theStudents){
            System.out.println(tempStudent);
        }
    }

    private void queryGetStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		// display the students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}
}
```



## Annotations Part II:
* @Controller - inherits from @Component
* @RequestMapping - used to map URLs to a class or method
* @RequestParam - get a parameter from the request
* @InitBinder - processes requests to the controller
* @Entity - to map a table from the database
* @Transactional - is an annotation to begin and end a transaction in in JPA code, is no need to implement because Spring do it behind the scenes
* @Repository - is use for the DAOs
* @RestController - is use in the REST application, is the sum of @Controller and @ResponseBody
* @ControllerAdvice - is a filter used to controller all the global exception handlings
* @Service - intermediate layer for custom business logic, can integrate multiple repositories/DAO and use Service Facade design pattern
* @Table - to specify the database table
* @Column - indicate the database column
* @Id - pk of a table
* @OneToOne
* @OneToMany
* @ManyToOne
* @ManyToMany    
* @PostMapping
* @GetMapping
* @PutMapping
* @DeleteMapping
* @Pointcuts - to create pointcuts
* @Before - use a pointcuts
* @Order - order the pointcuts
* @AfterReturning
* @AfterThrowing
* @After
* @Around




---------------------------------------------------------

### Difference between @Controller and @RestController
* @Controller is used to declare common web controllers which can return HTTP response but @RestController is used to create controllers for REST APIs which can return JSON.
* @RestController = @Controller + @RequestBody
* The @Controller is a common annotation which is used to mark a class as Spring MVC Controller while the @RestController is a special controller used in RESTFul web services


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


* Configure the dependency injection in the spring config file, defined in the first step the dependency and in the second step inject the dependency
applicationContext.xml
```
<bean id="myFortuneService" class="springdependency.HappyFortuneService"></bean>
<bean id="myCoach" class="springdependency.TrackCoach">
    <constructor-arg ref="myFortuneService"/>
</bean>
```
![Spring behind the scene](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-behind.png "Spring behind the scene")


* config the dependency for injection in the config file
```
<bean id="myCricketCoach" class="setterinjection.CricketCoach">
    <!-- set up the constructor injection -->
    <property name="fortuneServ" ref="myFortune" />
</bean>
```
![Setter injection](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/setter-injection-method.png "Setter injection")
---------------------------------------------------------
![Setter injection behind the scene](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/setter-injection-behind.png "Setter injection behind the scene")
---------------------------------------------------------


 




### Dev process JPQL update
![Update](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/update-jpql.png "Update") 
* Add DAO interface
```
public interface StudentDAO {   
    void update(Student theStudent);
}
```
* Add DAO implementation
```
@Repository
public class StudentDAOImpl implements StudentDAO{
    // define field for entity manager
    private EntityManager entityManager;

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }
}
```
* Update app
```
private void updateStudent(StudentDAO studentDAO) {
    // retrive student bases on the id
    int studentId = 1;
    Student myStudent = studentDAO.findById(studentId);
    
    // change a column
    myStudent.setFirstName("Scooby");
    
    // update the student
    studentDAO.update(myStudent);
    
    // display the updated student
    System.out.println(myStudent);
}
```
### Dev process JPQL delete
* For multiple delete 
![Multiple delete](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/delete-multiple.png "Multiple delete") 
* Add DAO interface
```
void delete(Integer id);
```
* Add DAO implementation
```
@Override
@Transactional
public void delete(Integer id) {
    // retrive the student
    Student theStudent = entityManager.find(Student.class, id);

    // delete the student
    entityManager.remove(theStudent);
}
```
* Update app
```
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		studentDAO.delete(studentId);
	}
}
```
## Create table with JPA
* provides an option to automagically create database table
* It's need to add to application.properties ```spring.jpa.hibernate.ddl-auto=create``` 
* JPA drop and then create the table, all data lose it. Don't use this in production
![ddl-auto](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/ddl-auto.png "ddl-auto") 

# Spring Boot - REST CRUD APIs
* REST is a language independent, calls can be made over HTTP
![Rest](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/Rest.png "Rest") 
---------------------------------------------------------
![CRUD operations](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/crud-operations.png "CRUD operations") 
* HTTP Response
![HTTP Response](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/http-response.png "HTTP Response") 

## Spring REST controller
```
@RestController
@RequestMapping("/test")
public class DemoRestController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}
```
## JSON Data Binding
* Data binding is the process of converting JSON to a Java POJO
* This process is also known as mapping, serialization / deserialization, mashalling / unmarshalling
* Convert JSON to Java POJO, call setter methods on POJO
![Setter methods POJO](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/setter-methods-pojo.png "Setter methods POJO")
---------------------------------------------------------
* Convert Java POJO to JSON, call getter methods on POJO
![Getter methods POJO](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/getter-methods-pojo.png "Getter methods POJO")

## Spring REST Service process
* Create java POJO class, the Entity
* Create Spring REST Service using @RestController
```
@RestController
@RequestMapping("/api")
public class StrudentController {
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Pepe", "Percival"));
        theStudents.add(new Student("María Luisa", "Nazaret"));
        theStudents.add(new Student("Jesolu", "Xaviter"));

        return theStudents;
    }
}
```
## Path Variable
* Retravie a single row
```
@GetMapping("/students/{id}")
public Student getStudent(@PathVariable int id){
    return theStudents.get(id);
}
```
## Exception Handling
### Dev process
* Create custom error response class
```
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

    public StudentErrorResponse() {    }

    public StudentErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
```
* Create custom exception
```
public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
```
* Update REST service to throw exception
```
@GetMapping("/students/{id}")
public Student getStudent(@PathVariable int id){
    // check the object exist
    if(id >= theStudents.size() || id < 0){
        throw new StudentNotFoundException("Student id not found - " + id);
    }
    // index the list
    return theStudents.get(id);
}
```
* Add exception handler method
```
@ExceptionHandler
public ResponseEntity<StudentErrorResponse> handleException(StudentErrorResponse exc){
    // create a error response
    StudentErrorResponse error = new StudentErrorResponse();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(exc.getMessage());
    error.setTimeStamp(System.currentTimeMillis());
    
    // return entity
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}
@ExceptionHandler // to cover all the exception
public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
    // create a error response
    StudentErrorResponse error = new StudentErrorResponse();

    error.setStatus(HttpStatus.BAD_REQUEST.value());
    error.setMessage(exc.getMessage());
    error.setTimeStamp(System.currentTimeMillis());

    // return entity
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}
```

## Global exception handling
* @ControllerAdvice is similar to an filter
    * pre-process requests to controllers
    * pre-process responses to handle exception
### Dev process
* Create new @ControllerAdvice
* Add exception code to @ControllerAdvice
* Refact the code
```
@ControllerAdvice
public class StudentRestExceptionHandler {
    // add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        // create a error response
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        // create a error response
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage()); // se puede cambiar con mensaje personalizado
        error.setTimeStamp(System.currentTimeMillis());

        // return entity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
```
## Spring Boot REST API Design
1. Review API requierements (example employee directory)
    * REST client should be able to get a list of employee, get a single employee, add a new employee, update or delete
2. Indentify the entitys
    * use noun
3. Use HTTP methods to assing action on resource (GET, POST, PUT, DELETE)
![Real Time Project](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/real-time-project.png "Real Time Project")
* Don't use the anti-patters, is a bad practice, for endpoints like: /api/addEmployee, /api/deleteEmployee etc

# Spring Boot REST CRUD API
* REST API with Spring Boot connect to a database
* Create the DAO and Entity

## Service annotation
* @Service, like @Repository and @RestController, is an annotation that provide Spring
* Define Service interface
```
public interface EmployeeService {
    List<Employee> findAll();
}
```
* Define Service implementation
```
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
```
### Add or update
![add-or-update](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/add-or-update.png "add-or-update")
* When use the @Service the @Transactional annotations need put in the service class

### Dev process CRUD
* Add DAO interface and DAO implementation
[DAO](https://github.com/BrandConstantin/SpringBoot3-Spring6/tree/SpringBoot-REST_CRUD_API/07-SpringBoot-REST_CRUD_API/03-SpringBoot-REST_CRUT_API/src/main/java/com/springboot/rest/crud/api/dao)
* Add Service interface and Service implementation
[SERVICE](https://github.com/BrandConstantin/SpringBoot3-Spring6/tree/SpringBoot-REST_CRUD_API/07-SpringBoot-REST_CRUD_API/03-SpringBoot-REST_CRUT_API/src/main/java/com/springboot/rest/crud/api/service)
* Update the app
```
@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    // inject object dao
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose the endpoint to return the list
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee theEmployee = employeeService.findById(id);

        if(theEmployee == null){
            throw new EmployeeNotFoundException("Employee id not found: " + id);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        // if in json don't exist an id, id == 0, is a new insert else is a update
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee dbEmployee = employeeService.findById(id);

        if(dbEmployee == null){
            throw new EmployeeNotFoundException("Employee with this id not found " + id);
        }

        employeeService.deleteById(id);
        return "Employee deleted!";
    }
}
```
## Spring Data JPA
* Previously used JPA API, from now Spring Data JPA
* If we need to create anothers DAO (customer, student, product etc) it's need to repeat the same code egain
* Repet pattern
![DAO pattern](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/dao-pattern.png "DAO pattern")
* Create a DAO, plug in the entity type and primary key, and with Spring Data we have a CRUD implementation
* Spring Data provide a JpaRepository to reduce the lines code to 70% 
### Dev process Spring Data
* Extends JpaRepository and delete de EmployeeDAO interface and implementation
* JpaRepository use @Transactional so no need to use it
```
public interface EmployeeRepository extends JpaRepository<Employee, Integer> { }
```
* Use this repository in app
```
@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    // inject object dao
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // expose the endpoint to return the list
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee theEmployee = employeeService.findById(id);

        if(theEmployee == null){
            throw new EmployeeNotFoundException("Employee id not found: " + id);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        // if in json don't exist an id, id == 0, is a new insert else is a update
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee dbEmployee = employeeService.findById(id);

        if(dbEmployee == null){
            throw new EmployeeNotFoundException("Employee with this id not found " + id);
        }

        employeeService.deleteById(id);
        return "Employee deleted!";
    }
}
``` 

## Spring Data REST
* If we need to create a REST API for another entity is necesary repet the code
* Spring Data REST leverages the existing JpaRespository and give a REST CRUD implementation
* Create automatically the endpoints for the entity
![Spring Data REST](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-data-rest.png "Spring Data REST")
* HATEOS - provide information to access REST interface
### Dev process
* Add Spring Data REST to pom file
```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-rest</artifactId>
			<scope>test</scope>
		</dependency>
```
* For this reason delete the controller and service from previously leassons
* url: http://localhost:8080/employees
### Customize base path
```
# Spring Data REST
spring.data.rest.base-path=/magic-app
```
* url: http://127.0.0.1:8080/magic-app/employees

## Spring Data REST: Configuration, Pagination and Sorting
* Configuration: specify plural name/path with an annotation
```
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
```
* url: http://localhost:8080/magic-app/members
* Pagination: Spring Data Rest return 20 elements
* To navigate to different page use query params
```
http://localhost:8080/employees?page=1
```
* Sorting: 
```
http://localhost:8080/employees?sort=lastName,desc
```

# Spring Boot - REST API Security
* Edit pom file to add spring-boot-starter-security
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
* Change user and password
```
spring.security.user.name=admin
spring.security.user.password=test123
```
## Basic Configuration
* Password are stored in a specific format ```{id}encodePassword```
* ```{noop}test123``` the password are stored as plain text
* ```{bcrypt}test123``` the password are stored as encrypted password
![Users and roles](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/users-and-roles.png "Users and roles")
---------------------------------------------------------
![Basic authentication](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/basic-auth.png "Basic authentication")
```
@Configuration
public class SecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails employee1 = User.builder()
                .username("John")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails employee2 = User.builder()
                .username("Mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails employee3 = User.builder()
                .username("Susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(employee1, employee2, employee3);
    }
}
```

## Restrict access to roles
![Restrict access](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/restrict-access.png "Restrict access")
---------------------------------------------------------
![Authorize Requests Roles](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/auth-request-role.png "Authorize Requests Roles")

## Cross-Site Request Forgery CSRF
* Protect agains attacks
* Embed additional authentication data/token into HTML forms
* Verify token before processing
* Disabled CSRF ```http.csrf().disable();```
```
@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer ->
            configurer
                    .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );

        // use http basic authentication
        httpSecurity.httpBasic();

        // disabled CSRF
        // in general is not required for post, put, delete or patch
        httpSecurity.csrf().disable();
        
        return httpSecurity.build();

    }
}
```
* From postman use Basic Auth with the specified roles to do the actions
## JDBC Authentication
### Dev process
* Add database support to pom file
```
@Bean
public UserDetailsManager userDetailsManager(DataSource dataSource){
    return new JdbcUserDetailsManager(dataSource);
}
```
* Create JDBC properties
* Update Spring Security configuration to use JDBC
![JDBC](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/JDBC.png "JDBC")
## Bcrypt
![bcrypt](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/bcrypt.png "bcrypt")
---------------------------------------------------------
![Login Process](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/login-process.png "Login Process")

## Custom tables
* Create our custom table with sql
* Update Spring Security configuration
```
@Bean
public UserDetailsManager userDetailsManager(DataSource dataSource){
    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

    // define query to retrieve a user by username
    jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id = ?");

    // define query to retrieve the roles by username
    jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id = ?");
    
    return jdbcUserDetailsManager;
}
```
# Spring Boot MVC Thymeleaf
* Thymeleaf is a Java templating engine
* Used to generate HTML views for web apps
* It is seperat progect separate to spring.io, you can create Java apps without Spring 
* Template files go to /src/main/resources/templates
* More info in www.thymeleaf.org
### Dev process
* Add Thymeleaf to pom file
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
* Develop Spring MVC Controller
```
@Controller
public class AppController {
    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDate", new java.util.Date());

        return "hello-world";
    }
}
```
* Add css and js file to the /resource/static directory
* Create Thymeleaf template
```
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<!-- in the udemy course used -->
<!--<html xmlns:th="http://www.thymeleaf.org">-->
<head>
    <meta charset="UTF-8">
    <title>Hello World</title>
    <link rel="stylesheet" th:href="@{css/style.css}">
</head>
<body>
<p th:text="'Time on the server is ' + ${theDate}" class="green-color"/>
</body>
</html>
```
* Result in the URL: http://127.0.0.1:8080/hello is "Time on the server is Wed Mar 22 22:25:29 CET 2023"

# Spring Boot MVC CRUD
* Add button to 'add'
```
<a th:href="@{/employees/showFormForAdd}" class="btn btn-primary btn-sm mb-3">Add Employee</a>
```
* Add controller
```
@PostMapping("/save")
public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
    // save
    employeeService.save(theEmployee);
    
    // use a redirect to prevent duplicate submision
    return "redirect:/employees/list";
}
```
* Create the form 
```
<form action="#" th:action="@{/employees/save}" th:object="@{employee}" method="POST">
    <input type="text" th:field="*{firstName}" class="form-control mb-4 w-25" placeholder="First name">
    <input type="text" th:field="*{lastName}" class="form-control mb-4 w-25" placeholder="Last name">
    <input type="text" th:field="*{email}" class="form-control mb-4 w-25" placeholder="Email">
    
    <button type="submit" class="btn btn-info col-2">Save</button>
</form>
```
### Dev process for update to prepopulate the form
* Add button with the id
```
<td><a th:href="@{/employees/showFormForUpdate(employeeId=${tempEmployee.id})}"
    class="btn btn-info btn-sm">Update</a></td>
```
* Populate the form
```
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
        // get employee from service
        Employee theEmployee = employeeService.findById(theId);

        // set employee in the model to populate the form
        theModel.addAttribute("employee", theEmployee);

        // send to form the data
        return "employees/employee-form";
    }
```
### Dev process for delete
* The button
```
<a th:href="@{/employees/delete(employeeId=${tempEmployee.id})}"
    class="btn btn-danger btn-sm">Update</a>
```
* The Controller
```
@GetMapping("/delete")
public String deleteEmployee(@RequestParam("employeeId") int theId){
    // delete
    employeeService.deleteById(theId);

    // redirect to list
    return "redirect:/employees/list";
}
```
# Spring MVC Form Validation
* Java has a standard Bean Validation API
* http://www.beanvalidation.org
* Spring v4 to up, support Bean Validation API 
![Validation annotations](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/validation-form.png "Validation annotations")
---------------------------------------------------------
* Hibernate have a validator very usefull http://hibernate.org/validator
* All the packages are renamed from javax.* to jakarta.* 
* Hibernate Validator 7 is based in Jakarta EE 9, but Spring 5 is still based in Java EE (javax.*), so Spring 5 and Hibernate Validator 7 are not compatible. We need to use Hibernate Validator 6.2 https://hibernate.org/validator/releases/6.2/
* When finished the comprimited file we copy the 3 files that are in the dist directory to the WEB-INF >> lib >> and from lib >> requiered subdirectory copy all the jar files
### Form Tags
* Form tags generate HTML for you:
	* form:form
	* form:input
	* form:textarea
	* form:checkbox
	* form:radiobutton
	* form:select
	* etc
* Create the controller
```
@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		// create a student object
		Student theStudent = new Student();
		
		// add student object to the model
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}
}
```
* To reference need to specify the spring namespace at beginning of JSP file
```
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
```
* You must add a model attribute, this is a bean that will hold form data for the data binding
```
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		return "student-confirmation";
	}
```
* Setting the form
```
	<form:form action="processForm" modelAttribute="student">
		Fist name <form:input path="firstName"/>
		Second name <form:input path="lastName"/>
		<br><br>
		Country:
		<form:select path="country">
			<form:options items="${countryOptions}"/>
		</form:select>
		<br><br>
		Favorite language:
		<form:radiobuttons path="language" items="${student.languageOptions}"/>
		<br><br>
		OS:
		Linux<form:checkbox path="os" value="Linux"/>
		Mac<form:checkbox path="os" value="Mac"/>
		<br><br>
		<input type="submit" value="Submit" />
	</form:form>
```
* A simple way to create a form
```
Java <form:radiobutton path="language" value="Java"/>
Python <form:radiobutton path="language" value="Python"/>
JavaScript <form:radiobutton path="language" value="JavaScript"/>
PHP <form:radiobutton path="language" value="PHP"/>

<form:select path="country">
	<form:option value="Romania">Romania</form:option>
	<form:option value="Spain">Spain</form:option>
	<form:option value="Germany">Germany</form:option>
	<form:option value="Austria">Austria</form:option>
</form:select>
```
#### Development process
* Add validation rule to class
```
public class Professor {
	@NotNull(message="Name is required")
	@Size(min=4, message="Name most have more than 4 caracters")
	private String firstName;
	@Min(value=1, message="Must be gratear than or equal to 1")
	@Max(value=10, message="Must be less than or igual to 10")
	private int cualification;
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="Only 5 chars/digits")
	private String postalCode;
}
```
* Display error messages on HTML form
```
	<form:form action="processForm" modelAttribute="professor" >
		First name(*):
		<form:input placeholder="What's your name?" path="firstName" />
		<form:errors path="firstName" cssClass="error"/>
		Last name(*):
		<form:input placeholder="What's your surname?" path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
		<br><br>
		Cualification:
		<form:input path="cualification"/>
		<form:errors path="cualification" cssClass="error"/>
		<br><br>
		Postal Code:
		<form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/>
		<br><br>
		Course Code:
		<form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"/>
		<br><br>
		<input type="submit" value="Submit"/>
	</form:form>
```
* Perform validation in controller
```
@Controller
@RequestMapping("/student")
public class StudentController {
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		// create a student object
		Student theStudent = new Student();
		
		// add student object to the model
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}
}
```
* Update confirmation page
```
@RequestMapping("/processForm")
public String processForm(@Valid @ModelAttribute("student") Student theStudent, BindingResult theBindingRes) {
    if(!theBindingRes.hasErrors()) {
        return "student-confirmation";
    }else {
        return "student-form";
    }
    
}
```
* Update confirmation page
* Add @InitBinder to eliminate white space from inputs
```
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimm = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimm);
	}
```
```
<h1>Student confirmation</h1>
<p>The student is ${student.firstName} ${student.lastName}</p>
<p>The student country is ${student.country}</p>
<p>The student like ${student.language} and operating with: </p>
<ul>
    <c:forEach var="temp" items="${student.os}">
        <li>${temp}</li>
    </c:forEach>
</ul>
```
* To eliminate white spaces in the input forms
```
@InitBinder
public void initBinder(WebDataBinder dataBinder) {
    StringTrimmerEditor stringTrimm = new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class, stringTrimm);
}
```
### Handle String input for integer fields
* Create custom error message in src >> resources >> messages.properties
```
typeMismatch.professor.cualification=Invalid number
```
* Load custom messages resource in Spring config file:
```
WebContent/WEB-INF/spring-mvc-demo-servlet.xml

	<bean id="messageSource" 
		class="org.springframework.context.support.ResourceBundleMessageSource" >
		<property name="basenames" value="resources/messages" />
	</bean>
```
### Create custom Annotation
* Create a new package with a new annotation, the custom validation rule
```
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	// define default course code
	public String value() default "BRIND";
	
	// define default error message
	public String message() default "Must start with a secret code";
	
	// defain default groups
	public Class<?>[] groups() default {};
	
	// defain default payloads
	public Class<? extends Payload>[] payload() default {};
}
```
* Create the validator
```
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode constraintAnnotation) {
		coursePrefix = constraintAnnotation.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraint) {
		boolean result = false;
		if(theCode != null) {
			theCode.startsWith(coursePrefix);
		}else {
			result = true;
		}
		return result;
	}
}
```
* Add the validation rules 
```
	@CourseCode
	private String courseCode;
```
* Display the errors in html 


# Hibernate advanced mapping
### Entity lifecycle
![Entity lifecycle](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/entity-lifecycle.png "Entity lifecycle")
---------------------------------------------------------
![Session method calls](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/session-method-calls.png "Session method calls")
---------------------------------------------------------
![Cascade-Type](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/Cascade-Type.png "Cascade-Type")

* @OneToOne - use to relation a column from a table with the foreign key from another table
```
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="instructor_detail_id")
private InstructorDetail instructorDetail;
```
* @OneToOne - bidirectional
```
@OneToOne(mappedBy="instructorDetail", cascade=CascadeType.ALL)
private Instructor instructor;
```
![OneToOne-bidirectional](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/OneToOne-bidirectional.png "OneToOne-bidirectional")
* Delete details but not the instructor
```
@OneToOne(mappedBy="instructorDetail", cascade= {CascadeType.DETACH, CascadeType.MERGE,
                                        CascadeType.PERSIST, CascadeType.REFRESH})
```
* @OneToMany - use to relation a column from a table with the many foreign key from another table
```
@OneToMany(fetch=FetchType.EAGER, mappedBy="instructor")
private List<Course> courses;

public void add(Course tempCourse) {
    if(courses == null) {
        courses = new ArrayList<>();
    }
    
    courses.add(tempCourse);
    tempCourse.setInstructor(this);
    
}
```
## Eager vs Lazy loading
* eager will retrive everything
* lazy will retrive on request
* only load data when absolutely needes, so prefer lazy loading instead of eager loading
![Eager Loading](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/eager-loading.png "Eager Loading")
* The best practice is load data when absolutely needed, prefer use lazy loading
* How resolve the Lazy loading
    * use hibernate query with HQL
```
    // start a transaction
    session.beginTransaction();
    
    // resolve lazy loading
    // option 2 hibernate query with HQL
    
    // get the instructor from db
    int theId = 1;
    Query<Instructor> query = session.createQuery("select i from Instructor i " +
            " JOIN FETCH i.courses " + 
            " where i.id=:theInstructorId",Instructor.class);
    
    query.setParameter("theInstructorId", theId);
    
    // execute query and get the instructor
    Instructor tempInstructor = query.getSingleResult();
    
    // get courses of the instructor
    System.out.println("Courses: " + tempInstructor);
    
    // commit transaction
    session.getTransaction().commit();
    
    session.close();
```
* @OneToMany
```
@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name="course_id")
private List<Review> reviews;
```
@ManyToMany
* @ManyToMany use @JoinTable and @JoinColumn
```
@ManyToMany(fetch = FetchType.LAZY,
        cascade= {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
@JoinTable(name="course_student",
        joinColumns = @JoinColumn(name="course_id"),
        inverseJoinColumns = @JoinColumn(name="student_id"))
private List<Student> students;
```
# Create a Dynamic Web Project with Eclipse
### Dev environment:
* You should have installed: apache tomcat, eclipse java EE version, and connect eclipse to tomacat
### Spring MVC configuration process:
* create new Dynamic Web Project in Eclipse
	* remove the source folder (src/main/java) and add the folder src
	* remove the content directory (src/main/webapp) and add the folder WebContent and finish
    * add JDBC driver
    * Create new Servlet to test the connection
    * uncheck and let only 'Inherited abstract methods' and 'doGet'
* To work propertily in right click to project > Properties 
    * > Targeted Runtime > select the server
    * > Java Build Path > click to Classpath > add JARs > select all the jars from lib directory
    * Check if the web.xml and spring-mvc-servlet.xml are the same package 
 ![web.xml](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/web-xml.png "web.xml")
---------------------------------------------------------
 ![servlet](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/servlet.png "servlet")
 * If project open other project lock for server.xml in server apache and modify 'Context'

# Spring MVC & Hibernate
 ![DAO implementation](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/dao-implementation.png "DAO implementation")
 ---------------------------------------------------------
* Spring provide @Transactional annotation
* @Transactional begin and end a transaction in Hibernate
* Begin > session.beginTransaction() and End > session.getTransaction().commit() is replaced with @Transactional
![Transactional](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/transactional.png "Transactional")
* Spring provide @Repository annotation
![Repository](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/repository.png "Repository")
* Is applied to DAO implementation. Spring also provide translation of any JDBC related exceptions
```
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
        ...
	}
}
```
* When use @Transactional in DAO and when in Service?
```
Here is the general guidance (of course it may vary for specific use cases / app requirements)

If you are using the single database/datasource
- If you want to manage transaction rollback across multiple DAOs, place @Transactional at Service layer

If you are using multiple databases/datasources
- Place @Transactional on DAO layer
```
* POST
![POST](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/POST.png "POST")
* UPDATE
* Define a variable
```
<c:url var="updateLink" value="/customer/showFormForUpdate">
    <c:param name="customerId" value="${tempCustomer.id}" />
</c:url>	
...
<a href="${updateLink}">Update</a>
```
![update](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/update.png "update")
```
<c:url var="deleteLink" value="/customer/delete">
    <c:param name="customerId" value="${tempCustomer.id}" />
</c:url>
...
<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
```
![delete](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/delete.png "delete")

# AOP (Aspect oriented programming)
* AOP use cases:
 * most common: logging, security, transactions
 * audit logging: who, what, when, where
 * exeption handling: log exception and notify DevOps teams via SMS/EMAIL
 * API management: how many times has a method been called user, what are peak times?, what is avafege load? etc
![AOP](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/AOP.png "AOP")
* Terminology:
![Terminology AOP](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/Terminology_AOP.png "Terminology AOP")
* Advice Type
![Advice Types](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/Advice_Types.png "Advice Types")
* Exists two AOP frameworks for Java
 * Spring AOP:
    * support of Spring
    * key component: security, transactions, caching
 * AspectJ: 
    * privide complete support for AOP
    * join points: method-level, constructor, field
    * code weaving: compile-time, post compile-time and load-time
* Comparasion:
![Comparasion AOP](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/Comparasion_AOP.png "Comparasion AOP")
 ---------------------------------------------------------
 ![Comparasion AspectJ](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/Comparasion_AspectJ.png "Comparasion AspectJ")
 * Spring AOP it's slower than AspectJ
 * Spring AOP is a light implementation of AOP, it easy to get started and when have complex requirements then move to AspectJ
 * Download AspectJ from https://mvnrepository.com/artifact/org.aspectj/aspectjweaver

## @Before
 ### Dev process
 * Create target object
 ```
 @Component
public class AccountDAO { }
 ```
 * Create Spring java config
 ```
@Configuration						// Spring pure java configuration
@EnableAspectJAutoProxy				// Spring AOP proxy support
@ComponentScan("com.spring.aop")	// Component scan for components and aspects
public class DemoConfig { }
 ```
 * Main
```
public class MainApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the business method
		theAccountDAO.addAccount();
		
		// call business method again
		System.out.println("Do it again!");
		theAccountDAO.addAccount();
		
		// close the context
		context.close();
	}		

}
```
 * Create Aspect with @Before
 ```
@Aspect
@Component
public class LogginAspect {
	// add advice for loggin
	// start with @Before advice
	
	@Before("execution(public void addAccount())")
	public void beforeAddAcountAdvice() {
		System.out.println(">>>>>> @Before advice on addAcount()");
	}
}
 ```
## Pointcut Expression
* Pointcut: a predicate expression for where advice should be applied
```
execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
```
 * Modifiers: Spring AOP only supports public
 * Return type: void, Boolean, String
 * Declaring type: the class name
 * Method name pattern
 * Params
 * Exceptions
![Pointcut Expression](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/pointcut-expression.png "Pointcut Expression")
* Match methods starting with add in any class
```
@Before("execution(public void add*())")
...
@Before("execution(public VerificationResult processCreditCard*())")
...
@Before("execution(public * processCreditCard*())")
```
* Modifier is optional
```
@Before("execution(* processCreditCard*())")
```
* For the full class name, if whe have more than one method with the same name
```
@Before("execution(public void com.spring.aop.dao.AccountDAO.addAccount())")
public void beforeAddAcountAdvice() { }
```
* Parameter pattern wildcards
    * () - matches a method with no arguments
    * (*) - matches a method with one argument of any type
    * (..) - matches a method with zero or more arguments of any types
```
@Before("execution(* addAccount(com.spring.aop.dao.Account))")
...
@Before("execution(* addAccount(..))")
...
@Before("execution(* com.spring.aop.dao.*.*(..))")
```
![Pointcut Expression 2](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/pointcut-expression2.png "Pointcut Expression 2")

## How can reuse a pointcut expression?
![Not ideal pointcut expression](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/no-ideal-pointcut-expression.png "Not ideal pointcut expression")
 ---------------------------------------------------------
* The ideal solution is create a pointcut declaration and apply it
    * Declaration
![Ideal pointcut expression](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/ideal-pointcut-expression.png "Ideal pointcut expression")
    * Apply
![Apply pointcut expression](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/Apply-pointcut-expression.png "Apply pointcut expression")
```
// pointcut declaration
@Pointcut("execution(* com.spring.aop.*.*(..))")
private void personalPointcutDeclaration() {}

@Before("personalPointcutDeclaration()")
public void beforeAddAcountAdvice() {
    System.out.println(">>>>>> @Before advice on addAcount()");
}
```
## Combining pointcuts
* You cas use operators
```
@Before("express1ionOne() && expressionTwo()")
...
@Before("express1ionOne() || expressionTwo()")
...
@Before("express1ionOne() && !expressionTwo()")
```
## Ordering Aspects
* Refactor code in separate the aspects
![Separate Aspects](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/separate-aspects.png "Separate Aspects")
* Use @Order annotations
```
@Aspect
@Component
@Order(-1)
public class LogginAspect { }
...
@Aspect
@Component
@Order(5)
public class ApiAnalyticsAspect { }
```
## Read method arguments wiht JoinPoints
* Access and display the methdo signature
```
@Aspect
@Component
@Order(-1)
public class LogginAspect {
	@Before("com.spring.aop.aspect.AspectExpression.forPointcutWithoutGettersAndSetters()")
	public void beforeAddAcountAdvice(JoinPoint theJoinPoint) {		
		// display the method signtature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method >>> " + methodSignature);		
		
		// get the arguments ant loop through
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArgObject: args) {			
			if(tempArgObject instanceof Account) {
				Account theAccount = (Account) tempArgObject;
			}
		}
	}
}
```
## @AfterReturning 
* most common: logging, security, transactions
* audit logging: who, what, when, where
* post-processing data
    * post process data before returning to caller
    * format the data or enrich the data
![Return value AOP](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/return-value-aop.png "Return value AOP")
```
@AfterReturning(
        pointcut="execution(* com.spring.aop.dao.AccountDAO.findAccounts(..))",
        returning="result")
public void afterReturningAdvice(JoinPoint theJoinPoint, List<Account> result) {
    // print the method
    String method = theJoinPoint.getSignature().toShortString();
    
    // print the result of the method calls
    System.out.println(">>>>>>>>>> result " + result);
}
```

## @AfterThrowing
* Use case:
    * Log the exceptions
    * Perform auditing on the expception
    * Notify DevOps team via email or SMS
    * Encapusate this functionality in AOP aspect for easy reuse
```
@AfterThrowing(
        pointcut="execution(* com.spring.aop.dao.AccountDAO.findAccounts(..))",
        throwing="theExc")
public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
    // print the method
    String method = theJoinPoint.getSignature().toShortString();
    
    // log the exception
    System.out.println("The exception is >> " + theExc);
}
```

## @After
* Uses case: 
    * Log the exception and/or peforming auditing
    * Code to execute the method result independently
    * Encapusate this functionality in AOP aspect for easy reuse
```
@After("execution(* com.spring.aop.dao.AccountDAO.findAccounts(..))")
public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {    
    System.out.println("After >>>>> " + theJoinPoint);
}
```

## @Around
* Uses:
    * most common: logging, auditing, security
    * pre-processing and post-processing data
    * instrumentation/profiling code: how long does it take for a section of code tu run?
    * managing exceptions: swallow/handle/stop exception
```
@Around("execution(* com.spring.aop.service.*.getTraffic(..))")
public Object aroundGetTraffic(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {    
    // get begin timestamp
    long begin = System.currentTimeMillis();
    
    // execute the method
    Object result = theProceedingJoinPoint.proceed();
    
    // end of timestamp
    long end = System.currentTimeMillis();
    
    // compute duration 
    long duration = end - begin;
    myLogger.info("Duration: " + duration / 1000.0 + " seconds");
    
    return result;
}
```
## Rethrow Exception
![Rethrow Exception](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/rethrow-exception.png "Rethrow Exception")

# Spring Security
![Spring security filter](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-security-filters.png "Spring security filter")
* Use java config (@Configuration) or xml config to configuration spring security
### Dev process
* Add maven dependencies for spring mvc web app
![Add maven dependency](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/maven-dependency.png "Add maven dependency")
* Crate spring configuration
![Spring configuration](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-configuration.png "Spring configuration")
* The old way was config the xml servlet
![Old way](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/old-way.png "Old way")
* The new way to config 
![Spring Dispatcher Servlet Initializer](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/dispatcher-serlvel-initializer.png "Spring Dispatcher Servlet Initializer")
* Develop the Spring Controller
![Spring Controlelr](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-controller.png "Spring Controlelr")
* Add spring-security-web and spring-security-config (spring framework and spring security are 2 different projects)
![Spring security](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-security.png "Spring security")
* Create spring seurity initializer, create spring security configuration (@Configuration) and add users and roles
* The login in Spirng security is a "web browser session"
## Dev process for login
* Modify spring security configuration to reference custom login form
![Spring security config](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-security-config.png "Spring security config")
* Develop a controller to custom login
![Develop a controller](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-security-controller.png "Develop a controller")
* Create custom login form (html, css, spring mvc form tag)
![Custom login](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/custom-login.png "Custom login")

## CSRF (Cross site request forgery)
* Manually add CSRF token
![Manually CSRF](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/manually_CSRF.png "Manually CSRF")
* The best practice is use <form:form> tag because add automatically the CSRF

## Configure access resources
```
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/").hasRole("EMPLOYEE")
        .antMatchers("/leaders/**").hasRole("MANAGER")
        .antMatchers("/systems/**").hasRole("ADMIN")
        .antMatchers("/resources/**").permitAll()
        .anyRequest().authenticated()
    .and()
    .formLogin()
        .loginPage("/showLoginPage")
        .loginProcessingUrl("/authTheUser")
        .permitAll()
    .and()
    .logout().permitAll()
    .and()
    .exceptionHandling().accessDeniedPage("/access-denied");
}
```
## Dev process access BBDD
* Add database support to maven pom file
```
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.9</version>
</dependency>	
<dependency>
    <groupId>com.mchange</groupId>
    <artifactId>c3p0</artifactId>
    <version>0.9.5.5</version>
</dependency>	
```
* Create JDBC properties file
```
# JDBC connection properties
#
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/spring_security_demo_plaintext?useSSL=false
jdbc.user=springstudent
jdbc.password=springstudent

#
# Connection pool properties
#
connection.pool.initialPoolSize=5
connection.pool.minPoolSize=5
connection.pool.maxPoolSize=20
connection.pool.maxIdleTime=3000
```
* Define DataSource in Spring configuration
```
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.security")
@PropertySource("classpath:persitence-mysql.properties")
public class AppConfig implements WebMvcConfigurer {
	// set up variable to hold the properties
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
    ....
}
```
* Define a bean
```
@Bean
public DataSource securityDataSource() {
    // create connection pool
    ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
    
    // set the jdbc driver class
    try {
        securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
    } catch (PropertyVetoException e) {
        throw new RuntimeException(e);
    }
    
    // log the connection props
    logger.info(">>>> jdbc.url= " + env.getProperty("jdbc.url"));
    logger.info(">>>> jdbc.user= " + env.getProperty("jdbc.user"));
    
    // set dataase connection props
    securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
    securityDataSource.setUser(env.getProperty("jdbc.user"));
    securityDataSource.setPassword(env.getProperty("jdbc.password"));
    
    // set connection pool props
    securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
    securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
    securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
    securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
    
    return securityDataSource;
}

// helper method
// read environment property and convert to int
private int getIntProperty(String propName) {
    String propVal = env.getProperty(propName);
    int intPropVal = Integer.parseInt(propVal);
    
    return intPropVal;
}
```
* Update Spring security to use JDBC
![Use JDBC](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/use-jdbc.png "Use JDBC")
* Storage password in bcrypt
![Password encrypt](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/password-encrypt.png "Password encrypt")

# Spring REST API
![Spring REST API](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/rest-api.png "Spring REST API")
* Spring use the Jackson Project behind the scenes, Jakson handles data binding between JSON and Java POJO
![Java POJO](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/java-pojo.png "Java POJO")
 ---------------------------------------------------------
![Java POJO to JSON](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/java-pojo-to-json.png "Java POJO to JSON")
```
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Driver {

	public static void main(String[] args) {
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON and convert to java pojo
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print the data
			System.out.println("First name: " + theStudent.getFirstName());
			System.out.println("Last name: " + theStudent.getLastName());
			System.out.println("Address: " + theStudent.getAddress().getCity());
			
			Address tempAddress = theStudent.getAddress();
			System.out.println("Country: " + tempAddress.getCountry());
			
			for(String tempLang: theStudent.getLanguages()) {
				System.out.print(tempLang + ",");
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
```
* To ignore the unknown properties:
```
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    ...
}
```
## HTTP overview
* Stauts code
```
100 - 199 > Informational
200 - 299 > Successful
300 - 399 > Redirection
400 - 499 > Client error
500 - 599 > Server error
```
## Handling Exception
* Create a custom error response class
```
public class StudentErrorResponse {
	private int status;
	private String message;
	private int timeStamp;
	
	public StudentErrorResponse() { }

	public StudentErrorResponse(int status, String message, int timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
    ...
}
```
* Create a custom exception class
```
public class StudentNotFoundException extends RuntimeException{
	
	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
```
* Update Rest Service 
```
@GetMapping("/students/{studentId}")
public Student getStudent(@PathVariable int studentId) {		
    if((studentId < 0) || (studentId >= theStudents.size())) {
        throw new StudentNotFoundException("Not found student with id: " + studentId);
    }
    
    return theStudents.get(studentId);		
}
```
* Add an exception handler using @ExceptionHandler
```
@ExceptionHandler
public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
    StudentErrorResponse error = new StudentErrorResponse();
    
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(exc.getMessage());
    error.setTimeStamp(System.currentTimeMillis());
    
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}
```
## API Design
* Review API requirement
    * Create REST API for CRM system (get list customers, delete customer, update customer)
* Identify main resources / entity
    * the entity with noun "customer" and the endpoints with plural "customers"
* Use HTTP methods to asign a action on resource 
    * POST, GET, PUT, DELETE
![Perfect endpoints](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/perfect-endpoints.png "Perfect endpoints")

### Arquitecture CRM Web APP REST Client + CRM REST API
![CRM](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/CRM.png "CRM")
