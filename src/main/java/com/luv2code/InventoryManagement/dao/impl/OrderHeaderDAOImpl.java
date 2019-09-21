package com.luv2code.InventoryManagement.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.InventoryManagement.dao.OrderHeaderDAO;
import com.luv2code.InventoryManagement.entity.Customer;
import com.luv2code.InventoryManagement.entity.OrderHeader;
import com.luv2code.InventoryManagement.entity.OrderLine;

@Repository
@Transactional
public class OrderHeaderDAOImpl implements OrderHeaderDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<OrderHeader> getOrderHeader() {

		// note change to get orderHeaders^

		// get the current hibernate session

		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<OrderHeader> theQuery = currentSession.createQuery("from OrderHeader", OrderHeader.class);

		// execute query and get result list
		List<OrderHeader> orderHeader = theQuery.list();

		// return the results
		return orderHeader;
	}

	@Override
	public OrderHeader getLastOrderHeader() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<OrderHeader> query = currentSession
				.createQuery("select oh from OrderHeader oh order by oh.orderHeaderId desc", OrderHeader.class);
		query.setMaxResults(1);
		OrderHeader oh = query.uniqueResult();

//		//OrderHeader oh1 = currentSession.createQuery("select oh from OrderHeader oh where oh.orderHeaderId = 11", OrderHeader.class).uniqueResult();
//		OrderHeader oh1 = currentSession.get(OrderHeader.class, 11);
//		for (OrderLine ol : oh1.getOrderLines()) {
//			System.out.println("Order Line :: " + ol.getLineNumber() + " | " + ol.getOrderPackQuantity());
//		}
		currentSession.flush();

		return oh;
	}

	@Override
	public void saveOrderHeader(OrderHeader orderHeader) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(orderHeader);

	}

	@Override
	public OrderHeader getOrderHeaderById(Integer orderHeaderId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Integer id = ((Number) orderHeaderId).intValue();
		OrderHeader oh = currentSession.get(OrderHeader.class, id);
		return oh;
	}

	@Override
	public List<OrderHeader> getAllOrders() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query query = currentSession.createQuery("select oh from OrderHeader oh");
		List<OrderHeader> orderHeaders = query.list();
		return orderHeaders;
	}

	@Override
	public List<OrderHeader> getAllOrders(String type) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query query = currentSession.createQuery("select oh from OrderHeader oh where oh.type in :typeParam");
		query.setParameter("typeParam", type);
		List<OrderHeader> orderHeaders = query.list();
		return orderHeaders;
	}

	@Override
	public OrderHeader getOrderHeaderByNumber(String OrderHeaderNumber) {
		Session currentSession = entityManager.unwrap(Session.class);

		TypedQuery<OrderHeader> theQuery = currentSession
				.createQuery("select c from OrderHeader c where number=:number", OrderHeader.class);
		theQuery.setParameter("number", OrderHeaderNumber);
		OrderHeader orderHeader = theQuery.getSingleResult();

		// now retrieve/read from database using the primary key

		return orderHeader;
	}
}
