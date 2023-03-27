package spring.and.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.and.hibernate.entity.Instructor;
import spring.and.hibernate.entity.InstructorDetail;

public class Delete {

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
			// start a transaction
			session.beginTransaction();
			
			// get id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// delete instructor and associate detail because CASCADE
			if(tempInstructor != null) {
				System.out.println("Id finded!");
				session.delete(tempInstructor);
			}
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done ...");
		} finally {
			factory.close();
		}
	}

}
