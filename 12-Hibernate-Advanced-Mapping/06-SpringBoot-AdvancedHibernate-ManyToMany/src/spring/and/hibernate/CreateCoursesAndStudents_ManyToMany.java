package spring.and.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.and.hibernate.entity.Course;
import spring.and.hibernate.entity.Instructor;
import spring.and.hibernate.entity.InstructorDetail;
import spring.and.hibernate.entity.Review;
import spring.and.hibernate.entity.Student;

public class CreateCoursesAndStudents_ManyToMany {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {		
			session.beginTransaction();

			// crate the course
			Course tmpCourse1 = new Course("PHP for beginners");
			Course tmpCourse2 = new Course("Java advanced tricks");		
			Course tmpCourse3 = new Course("jQuery is imortal");		
			
			// save the course and laverage the cascade all
			session.save(tmpCourse1);
			session.save(tmpCourse2);
			session.save(tmpCourse3);
			
			// save students to course
			Student tempStudent1 = new Student("John", "Doe", "john@doe.com");
			Student tempStudent2 = new Student("Berto", "Vinici", "berto@vi.it");
			Student tempStudent3 = new Student("María", "Luisa", "maria@luisa.es");
			
			tmpCourse1.addStudent(tempStudent1);
			tmpCourse1.addStudent(tempStudent2);
			tmpCourse1.addStudent(tempStudent3);
			tmpCourse2.addStudent(tempStudent3);
			tmpCourse3.addStudent(tempStudent3);
			
			System.out.println("Saving students ... ");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done ...");
		} finally {
			session.close();
			factory.close();
		}
	}

}
