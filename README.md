# SpringBoot3-Spring6
Learn Spring Boot 3 with Spring 6 and Hibernate
Course: https://www.udemy.com/course/spring-hibernate-tutorial/

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
* @Primary - to identify the principal bean, it is an alternative to @Qualifier
* @Lazy bean is only initialized if needed for dependency injection
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
* @Transactional - is an annotation to begin and the end of a transaction in in JPA code, is no need to implement because Spring do it behind the scenes
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

## Spring Container and his functions
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

## Spring Injection types
* Constructor injection
* Setter injection
* Field injection (not recommended by spring.io)

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
---------------------------------------------------------
![Spring process](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-process.png "Spring process")

## Component Scanner
* Scan the java classes for this special annotations and automatically register the beans in the spring container
* The @Component tag composed by: @EnableAutoConfiguration, @ComponentScan and @Configuration
![Spring  boot application](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/spring-boot-application.png "Spring boot application")
---------------------------------------------------------
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
---------------------------------------------------------
![Setter injection behind the scene](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/Setter-injection-behind-the-scene.PNG "Setter injection behind the scene")
---------------------------------------------------------
![Spring process setter injection](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/setter-injection-process.png "Spring process setter injection")

## Qualifiers
* When have a lot a different classes that implement a injection class and use different @Components how Spring use
![Multiple implementation](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/multiple-implementation.png "Multiple implementation")
---------------------------------------------------------
![Qualifier](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/qualifier.png "Qualifier")
```
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fService;
```
* Or can do it directly in the constructor
```
    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach theCoach){
        myCoach = theCoach;
    }
```
## @Primary
* Other alternative to @Qualifier is @Primary

## Lazy initialization
* With @Lazy bean is only initialized if needed for dependency injection
* For global configuration add lazy to application.properties '''spring.main.lazy-initialization=true'''
* Advantages: 
    * only create objects as needed
    * may help with faster startup time if you have large number of components
* Disadvantages:
    * if you have web related components like @RestController, not created until requested
    * need enough memory for all beans once created
* It is deseabled by default

## Bean scopes
* Default scop is singleton
* all dependency injection for the bean will referenece the same bean
* The scope of a bean refers to the life cycle of a bean, how long it will exist, how many instances will be created and how the bean will be shared
* By default the bean will be singleton type. Singleton type creates a single instance per bean by default, it is stored in cache memory, all requests for this bean will give us a shared reference to the same bean.
```
Coach theCoach = context.getBean("myCoach", Coach.class);
Coach alphCoach = context.getBean("myCoach", Coach.class);

// check if the beans are the same		
boolean result = false;
result = (theCoach == alphCoach);

System.out.println("Pointing to the same object: " + result);
System.out.println(theCoach + " / " + alphCoach);
```
* With scope prototype no longer point to the same bean object
```
    <bean id="myCoach" class="beanscopes.BaseballCoach" scope="prototype"></bean>
```
![Bean Scopes](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/bean-scopes.png "Bean Scopes")
* Type of scopes
![Additional Bean Scopes](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/aditional-bean-scopes.png "Additional Bean Scopes")
---------------------------------------------------------
![New injection for each object](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/new-injection-for-each-object.png "New injection for each object")

## Bean Lifecycle Methods
* Custom code can be added during bean initialization or bean destruction
* `init-method` is the method to initialize an action during bean initialization
* `destroy-method` is the method to initialize an action during bean destruction
```
<bean id="myCoach" class="beanlifecycle.TrackCoach" 
	init-method="doInitMethod" destroy-method="doDestroyMehtod">
</bean>
```
* The scope prototype does not have the destroy method so it cannot be initialized. In order to do this, the destroy() method is defined.

## Java Config Bean
* In 3 steps:
    * Create @Configuration class
![@Configuarion class](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/step1.png "@Configuarion class")    
    * Define @Bean method
![@Bean Method](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/step2.png "@Bean Method")  
    * Inject the bean
![Inject the bean](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/step3.png "Inject the bean")  

# Hibernate & JPA
* Hibernate is a framework for persisting and saving java objects in a database
* Hibernate provide the object-to-relational mapping ORM
* In Spring Boot, Hibernate is de default implementation of JPA
* EntityManager is main component for creating queries and is from Jakarta Persistence API
* https://hibernate.org
* Download and install mysql 8 : https://dev.mysql.com/downloads/windows/installer/8.0.html
* Download Hibernate and MySQL JDBC Driver and add jar file to the project
	* https://sourceforge.net/projects/hibernate/files/hibernate-orm/5.6.5.Final/hibernate-release-5.6.5.Final.zip/download
	* https://dev.mysql.com/downloads/connector/j/ >> choose the connector for a "platform independent"
* Based on entries from Maven pom file: JDBC driver (mysql-connector-j) and Spring Data (ORM) (spring-boot-starter-data-jpa)
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
---------------------------------------------------------
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
* @Column is optional but recommandly if you update BBDD column

### Primary Keys
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
### Dev process for create:
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
### Dev process for read
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
## JPQL
* JPQL is a query language for retrieving object and is similar in concept with SQL
* Is based on entity name and entity fields
![JPQL](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/JPQL.png "JPQL") 
---------------------------------------------------------
![JPQL2](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/JPQL2.png "JPQL2") 
---------------------------------------------------------
![JPQL with parameters](https://github.com/BrandConstantin/SpringBoot3-Spring6/blob/main/images/JPQL3.png "JPQL with parameters") 
### Dev process JPQL
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
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        
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
			readAllStudents(studentDAO);
		};
	}
}

private void readAllStudents(StudentDAO studentDAO) {
    // get a list of students
    List<Student> theStudents = studentDAO.findAll();

    // display the students
    for(Student tempStudent: theStudents){
        System.out.println(tempStudent);
    }
}
```
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
