package com.ct.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ct.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer order by firstName", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers; 
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void delete(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
	}

	@Override
	public List<Customer> searchCustomers(String searchName) {
		Session session = sessionFactory.getCurrentSession();
		if(searchName==null || searchName.trim().length()==0)
			return getCustomers();
		
		return session.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name",Customer.class)
		.setParameter("name", "%" + searchName.toLowerCase() + "%")
		.getResultList();
	}

}
