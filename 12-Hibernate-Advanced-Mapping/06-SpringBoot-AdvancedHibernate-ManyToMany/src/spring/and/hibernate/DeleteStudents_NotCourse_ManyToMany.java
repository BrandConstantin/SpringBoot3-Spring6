package spring.and.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.and.hibernate.entity.Course;
import spring.and.hibernate.entity.Instructor;
import spring.and.hibernate.entity.InstructorDetail;
import spring.and.hibernate.entity.Review;
import spring.and.hibernate.entity.Student;

public class DeleteStudents_NotCourse_ManyToMany {

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
			// start a transaction
			session.beginTransaction();
			
			// get a course
			int studentId = 1;
			Student tmpStudent = session.get(Student.class, studentId);
			// delete the students role in the course
			session.delete(tmpStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done ...");
		}catch(Exception esc) {
			esc.printStackTrace();
		}	finally {
			session.close();
			factory.close();
		}
	}

}
