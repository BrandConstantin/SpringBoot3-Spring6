package com.springboot.hibernate.jpa.hibernate.jpa;

import com.springboot.hibernate.jpa.hibernate.jpa.dao.StudentDAO;
import com.springboot.hibernate.jpa.hibernate.jpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//readAllStudents(studentDAO);
			queryGetStudentsByLastName(studentDAO);
		};
	}

	private void queryGetStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		// display the students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
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

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating the student ...");
		Student tempStudent = new Student("Daffy", "Duckovicy", "daffy@duck.ru");

		// save the student
		System.out.println("Saving ...");
		studentDAO.save(tempStudent);

		// display id of the save student
		int theId = tempStudent.getId();
		System.out.println("Saved student with id " + theId);

		// retrive the student based in primary key
		System.out.println("Read info from id " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Find the student " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create the objects
		System.out.println("Creating 3 objects ...");
		Student tempStudent = new Student("Maria", "Winterfall", "maria@wi.com");
		Student tempStudent2 = new Student("Lizy", "Banaroe", "lizy@ly.com");
		Student tempStudent3 = new Student("John", "Wild", "wild@john.uk");

		// save the object
		System.out.println("Saving ...");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the object
		System.out.println("Create the student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@doe.com");

		// save the object
		System.out.println("Saving ...");
		studentDAO.save(tempStudent);

		// display id of the object
		System.out.println("Student saved with id " + tempStudent.getId());
	}

}
