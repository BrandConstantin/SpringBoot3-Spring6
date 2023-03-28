package spring.and.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.and.hibernate.entity.Course;
import spring.and.hibernate.entity.Instructor;
import spring.and.hibernate.entity.InstructorDetail;

public class CreateInstructor {

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
			// create the objects
			Instructor tmpInstructor = new Instructor("Michel", "Dougles", "mi@doug.com");
			InstructorDetail tmpInstructorDetail = new InstructorDetail("www.youtube/com/thechannel", "Others");
			
			// associate the objects
			tmpInstructor.setInstructorDetail(tmpInstructorDetail);	
			
			session.beginTransaction();
			session.save(tmpInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done ...");
		} finally {
			session.close();
			factory.close();
		}
	}

}
