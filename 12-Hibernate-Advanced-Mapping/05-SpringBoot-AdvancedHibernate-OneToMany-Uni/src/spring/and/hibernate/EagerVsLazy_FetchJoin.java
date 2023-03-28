package spring.and.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

import spring.and.hibernate.entity.Course;
import spring.and.hibernate.entity.Instructor;
import spring.and.hibernate.entity.InstructorDetail;

public class EagerVsLazy_FetchJoin {

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
			
			System.out.println("Done ...");
		}catch(Exception esc) {
			esc.printStackTrace();
		}	finally {
			session.close();
			factory.close();
		}
	}

}
