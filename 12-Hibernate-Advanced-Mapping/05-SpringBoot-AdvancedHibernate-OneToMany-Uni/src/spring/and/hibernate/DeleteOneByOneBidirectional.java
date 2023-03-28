package spring.and.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.and.hibernate.entity.Instructor;
import spring.and.hibernate.entity.InstructorDetail;

public class DeleteOneByOneBidirectional {

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
			
			int theId = 4;
			InstructorDetail tmpInstructorDetail = session.get(InstructorDetail.class, theId);
			
			if(tmpInstructorDetail != null) {
				System.out.println("Id finded!");
				
				// remove the associated object reference
				// break bi-directional link
				tmpInstructorDetail.getInstructor().setInstructorDetail(null);;
				
				session.delete(tmpInstructorDetail);
			}
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done ...");
		} catch(Exception esc) {
			esc.printStackTrace();
		}	finally {
			factory.close();
		}
	}

}
