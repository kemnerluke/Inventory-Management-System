package com.luv2code.InventoryManagement.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.InventoryManagement.dao.CustomerDAO;
import com.luv2code.InventoryManagement.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private EntityManager entityManager;
			
	@Override
	public List<Customer> getCustomers() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the current hibernate session

				
		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}
	
	@Override
	public void saveCustomer(Customer theCustomer) {

		// get current hibernate session
		
		Session currentSession = entityManager.unwrap(Session.class);

		
		// save/update the customer
		currentSession.saveOrUpdate(theCustomer);
		
	}
	
	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		
		Session currentSession = entityManager.unwrap(Session.class);

		
		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		
		Session currentSession = entityManager.unwrap(Session.class);

//		Session currentSession = entityManager.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();		
	}

	@Override
	public Customer getCustomer(String email) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		TypedQuery<Customer> theQuery = 
				currentSession.createQuery("select c from Customer c where email=:email", Customer.class);
		theQuery.setParameter("email", email);
		Customer theCustomer = theQuery.getSingleResult();
		
		// now retrieve/read from database using the primary key
		
		return theCustomer;
	}



}
