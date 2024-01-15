package com.crudoperation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crudoperation.dao.EmployeeDao;
import com.crudoperation.dao.UserDao;
import com.crudoperation.model.Employee;
import com.crudoperation.model.User;

@Controller
public class HomeController {
    
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(path= "/home")
	public String  home(Model m){
		
		List<Employee> list=employeeDao.getAllEmployee();
		m.addAttribute("employeelist", list);
		return "home";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@RequestMapping(path= "/addEmp")
	public String  addEmp(){
		return "add_emp";
	}
	
	@RequestMapping(path =("/loginUser"), method= RequestMethod.POST)
	public String login(@Valid @RequestParam("email") String em,@RequestParam("password") String pwd,HttpSession session) {
		User user=userDao.loginUser(em, pwd);
		if(user!= null) {
			session.setAttribute("loginuser", user);
			return "profile";
		}else {
			session.setAttribute("msg", "invalid email & password");
			return "redirect:/login";
		}
	}
	
	@RequestMapping(path= "/createEmp" ,method=RequestMethod.POST)
	public  String  createEmp(@ModelAttribute Employee employee, HttpSession session){
		System.out.println(employee);
		
		int i= employeeDao.saveEmployee(employee);
		session.setAttribute("msg", "Register Sucessfully");
		return "redirect:/addEmp";
	}
	
	@RequestMapping(path="/editEmp/{id}")
	public String editEmp(@PathVariable int id,Model m) {
		
		Employee employee=employeeDao.getEmployeeById(id);
		m.addAttribute(employee);
		return "edit_emp";
	}
	
	@RequestMapping(path="/updateEmp", method=RequestMethod.POST)
	public String updateEmp(@ModelAttribute Employee employee, HttpSession session) {
		
		employeeDao.update(employee);
		session.setAttribute("msg", "Update Sucessfully");
		return "redirect:/home";
	}
	
	@RequestMapping(path="/deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {
	    employeeDao.deleteEmployee(id);
	    session.setAttribute("msg", "Emp deleted successfully");
	    return "redirect:/home";
	}
	
	
	

	@RequestMapping(path="/createUser" ,method=RequestMethod.POST)
	public String register(@ModelAttribute User user, HttpSession session) {
		System.out.println(user);
		
		userDao.saveUser(user);
		session.setAttribute("msg", "User Register sucessfully");
		return "redirect:/register";
	}
	

	
	@RequestMapping("/myProfile")
	public String myProfile() {
		return "profile";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginuser");
		session.setAttribute("msg","Logout Sucessfully");
		return "login";
	}
	
}
