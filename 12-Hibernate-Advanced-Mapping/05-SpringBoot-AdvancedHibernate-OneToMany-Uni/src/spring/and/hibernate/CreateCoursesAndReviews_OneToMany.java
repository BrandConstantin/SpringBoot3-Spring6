package spring.and.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.and.hibernate.entity.Course;
import spring.and.hibernate.entity.Instructor;
import spring.and.hibernate.entity.InstructorDetail;
import spring.and.hibernate.entity.Review;

public class CreateCoursesAndReviews_OneToMany {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {		
			session.beginTransaction();

			// crate the course
			Course tmpCourse = new Course("Java - from beginner to advanced");
			
			// add reviews
			tmpCourse.addReview(new Review("Great course!"));
			tmpCourse.addReview(new Review("A 5 stars course"));
			tmpCourse.addReview(new Review("I'm happy to do this course"));
			
			// save the course and laverage the cascade all
			session.save(tmpCourse);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done ...");
		} finally {
			session.close();
			factory.close();
		}
	}

}
