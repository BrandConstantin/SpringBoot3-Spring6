package spring.and.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.and.hibernate.entity.Instructor;
import spring.and.hibernate.entity.InstructorDetail;

public class GetInstructorAndCourses {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			Instructor tmpInstructor = new Instructor("Katie", "Perry", "musica@gmail.com");
			InstructorDetail tmpInstructorDetail = new InstructorDetail("www.youtube/com/katieperry", "Muzic");
			
			// associate the objects
			tmpInstructor.setInstructorDetail(tmpInstructorDetail);	
			
			// start a transaction
			session.beginTransaction();
			
			// save
			session.save(tmpInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done ...");
		} finally {
			factory.close();
		}
	}

}
