package com.telusko.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.telusko.entity.Emp;
import com.telusko.hibernateConnection.Connection;

import jakarta.transaction.Transactional;

@Repository
public class EmpDaoImpl implements EmpDao{
    
	@Transactional
	public void saveEmp(Emp employee) {
		
		Session session=Connection.getConnection();
	  session.beginTransaction();
		session.save(employee);
		
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Emp> getAllEmp() {
		System.out.println("hello");
		Session s3=Connection.getConnection();
	     s3.beginTransaction();
		Query q=s3.createQuery("from Emp");
		
		List<Emp> list=q.list();
		
	    s3.getTransaction().commit();
	    s3.close();
		return list;
	}

	@Override
	public Emp getEmpById(int id) {
		Session s4= Connection.getConnection();
		s4.beginTransaction();
		Emp emp=s4.get(Emp.class,id);
		s4.getTransaction().commit();
		s4.close();
		return emp;
	}

	@Transactional
	public void update(Emp employee) {
		Session session2=Connection.getConnection();
		
		session2.beginTransaction();
		System.out.println("welcome");
		System.out.println(employee);
		session2.update(employee);
		
		session2.getTransaction().commit();
		session2.close();
	}

	@Transactional
	public void deleteEmp(int id) {
		Session s5=Connection.getConnection();
		
		s5.beginTransaction();
		Emp emp=s5.get(Emp.class,id);
		s5.delete(emp);
		s5.getTransaction().commit();
		s5.close();
	}

}
