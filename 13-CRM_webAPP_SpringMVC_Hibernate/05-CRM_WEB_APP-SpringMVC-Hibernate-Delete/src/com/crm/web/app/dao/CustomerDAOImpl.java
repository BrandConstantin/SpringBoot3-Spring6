package com.crm.web.app.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.web.app.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
		//currentSession.save(theCustomer); 		// save
		//currentSession.update(theCustomer);		// update
		currentSession.saveOrUpdate(theCustomer); 	// save or update
	}

	@Override
	public Customer getCustomers(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// read from database using PK
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// get current session hibernate
		Session currentSession = sessionFactory.getCurrentSession();
		
		// read from database for pk
		Query theQuery = currentSession.createQuery("delete from Customer where id =: customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}
	
}
