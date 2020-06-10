package com.odx.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;


// This class is used to do crud operations on the database
public class DBService {
	private SessionFactory factory;

	public DBService() {
		//create session factory
		 factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Demo.class)
				.buildSessionFactory();
	}
	
	public void saveDemo(Demo d) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(d);
		System.out.println("saved");
		session.getTransaction().commit();
		session.close();
	}

	public String getPalindrome() {
		Session session = factory.openSession();
		Query query = session.createQuery("from Demo");
		
	    List<Demo> list =query.getResultList();
	    StringBuilder sb = new StringBuilder();
	    for(Demo d: list) {
	    
	    	sb.append(d.getName()+", ");
	    }
	    return sb.toString();
	}
	
}
