package com.telusko.dao;

import java.util.List;

import com.telusko.entity.Emp;

public interface EmpDao {
    
	public void saveEmp(Emp emp);
	
	public List<Emp> getAllEmp();
	
	public Emp getEmpById(int id);
	
	public void update(Emp emp);
	
	public void deleteEmp(int id);
}
