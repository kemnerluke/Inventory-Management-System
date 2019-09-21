package com.luv2code.InventoryManagement.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.InventoryManagement.dao.ProductDAO;
import com.luv2code.InventoryManagement.entity.Customer;
import com.luv2code.InventoryManagement.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Product> getProducts() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Product> theQuery = currentSession.createQuery("from Product", Product.class);

		// execute query and get result list
		List<Product> products = theQuery.getResultList();

		// return the results
		return products;
	}

	@Override
	public void saveProduct(Product theProduct) {

		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save/upate the Product ...
		currentSession.saveOrUpdate(theProduct);

	}

	@Override
	public Product getProduct(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using the primary key
		Product theProduct = currentSession.get(Product.class, theId);

		return theProduct;

	}

	@Override
	public void deleteProduct(int theId) {
		// get the current hibernate session

		Session currentSession = entityManager.unwrap(Session.class);

//				Session currentSession = entityManager.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Product where product_id=:productId");
		theQuery.setParameter("productId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public Product getProduct(String name) {
		Session currentSession = entityManager.unwrap(Session.class);

		TypedQuery<Product> theQuery = currentSession.createQuery("select c from Product c where name=:name",
				Product.class);
		theQuery.setParameter("name", name);
		Product theProduct = theQuery.getSingleResult();

		// now retrieve/read from database using the primary key

		return theProduct;
	}

}