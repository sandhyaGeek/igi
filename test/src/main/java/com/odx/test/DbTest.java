package com.odx.test;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DbTest {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		Properties p = new Properties();
		//load properties file
		try {
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("myapplication.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// build session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		// get session
		Session session = factory.openSession();
		System.out.println(session.isConnected());
		// close session
		session.close();
		System.out.println(session.isConnected());

	}

}
