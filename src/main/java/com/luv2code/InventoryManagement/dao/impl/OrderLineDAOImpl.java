package com.luv2code.InventoryManagement.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.InventoryManagement.dao.OrderLineDAO;
import com.luv2code.InventoryManagement.entity.OrderHeader;
import com.luv2code.InventoryManagement.entity.OrderLine;
import com.luv2code.InventoryManagement.entity.Product;
@Repository
public class OrderLineDAOImpl implements OrderLineDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<OrderLine> getOrderLines() {
		// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
						
				// create a query
				Query<OrderLine> theQuery = 
						currentSession.createQuery("from OrderLine", OrderLine.class);
				
				// execute query and get result list
				List<OrderLine> OrderLine = theQuery.getResultList();
						
				// return the results		
				return OrderLine;
	}

	@Override
	public void saveOrderLine(OrderLine theOrderLine) {

		
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save/update the OrderLine
		currentSession.saveOrUpdate(theOrderLine);
	}
	
	public List<OrderLine> getOrderLineByOrderHeaderID(int orderHeaderID) {
		Session currentSession = entityManager.unwrap(Session.class);

		TypedQuery<OrderLine> theQuery = currentSession
				.createQuery("select ol from OrderLine ol where order_header_id=:order_header_id", OrderLine.class);
		theQuery.setParameter("order_header_id", orderHeaderID);
		List<OrderLine> orderLine = theQuery.getResultList();
		
		return orderLine;

	}
	
	@Override
	public void deleteOrderLine(int theId) {
		// get the current hibernate session

		Session currentSession = entityManager.unwrap(Session.class);

//				Session currentSession = entityManager.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from OrderLine where order_line_id=:orderLineId");
		theQuery.setParameter("orderLineId", theId);

		theQuery.executeUpdate();
	}


}
