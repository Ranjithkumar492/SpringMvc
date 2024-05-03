package com.telusko.hibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.telusko.entity.Emp;


public class Connection {

	public static Session getConnection() {
		Configuration con=new Configuration().configure().addAnnotatedClass(Emp.class);
		
		SessionFactory sf=con.buildSessionFactory();
		
		Session session=sf.openSession();
		
		return session;
	}
}
