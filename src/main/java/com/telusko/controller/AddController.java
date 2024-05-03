package com.telusko.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.dao.EmpDao;
import com.telusko.dao.EmpDaoImpl;
import com.telusko.entity.Emp;
import com.telusko.helper.Message;
import com.telusko.service.AddService;

@Controller
public class AddController {
	
	@Autowired
	EmpDao empDao;

	@RequestMapping("/home")
	public String home(Model m) {
		
		List<Emp> emp=empDao.getAllEmp();
		
		m.addAttribute("empList", emp);
		
		
		return "home";
		
	}
	
	@RequestMapping("/addEmp")
	public String addemp() {
		
		return "add_emp";
	}
	
	 @RequestMapping(value = "/createEmp", method=RequestMethod.POST)
	   	public String createEmp(@ModelAttribute Emp emp,HttpSession session) {
	
		 System.out.println(emp);
		    if( emp.getAddress()=="" || emp.getDesignation()=="" || emp.getEmail()=="" || emp.getFullName()=="" || emp.getPassword()=="" ||
		    		emp.getSalary()=="") {
		    	session.setAttribute("message","Please fill the required fields!!");
		    	
		    }else {
	    	    empDao.saveEmp(emp);
	    	    session.setAttribute("message","Registered Successfully..");
	    	   
	    	    
		    }
		return "redirect:/addEmp";
	   	}
	 
	 @RequestMapping("/edit_emp/{id}")
	 public String editEmp(@PathVariable int id,Model m) {
		 
		 Emp emp=empDao.getEmpById(id);
		 
		 
		 m.addAttribute("emp", emp);
		 
		 return "edit_emp";
	 }
     
	 @RequestMapping(value = "/updateEmp", method=RequestMethod.POST)
	   	public String updateEmp(@ModelAttribute Emp emp,HttpSession session) {
		
		 System.out.println("hii");
	
	    	empDao.update(emp);
	    	session.setAttribute("msg","Update Successfully");

		return "redirect:/home";
	   	}
	 
	 @RequestMapping(value="/delete_emp/{id}")
	 public String deleteEmp(@PathVariable int id,HttpSession session) {
		 
		 empDao.deleteEmp(id);
		 
		 session.setAttribute("msg","Emp Deleted Successfully");
		 return "redirect:/home";
	 }
}
