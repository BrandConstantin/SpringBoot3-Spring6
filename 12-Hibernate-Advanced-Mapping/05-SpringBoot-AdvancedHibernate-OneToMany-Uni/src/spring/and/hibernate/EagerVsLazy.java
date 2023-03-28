package spring.and.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.and.hibernate.entity.Course;
import spring.and.hibernate.entity.Instructor;
import spring.and.hibernate.entity.InstructorDetail;

public class EagerVsLazy {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// get courses of the instructor
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			session.close();
			
			// resolve lazy loading
			// option 1; call getter method while session is open  tempInstructor.getCourses()					
			
			System.out.println("Done ...");
		}catch(Exception esc) {
			esc.printStackTrace();
		}	finally {
			session.close();
			factory.close();
		}
	}

}
