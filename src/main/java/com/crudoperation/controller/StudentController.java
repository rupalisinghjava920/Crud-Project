package com.crudoperation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crudoperation.dao.EmployeeDao;
import com.crudoperation.dao.StudentDao;
import com.crudoperation.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDao studentDao; 
	
	@RequestMapping("/student")
	public String registerPage() {
		return "student";
	}
	
	@RequestMapping(path= "/createStudent" ,method=RequestMethod.POST)
	public String createStudent(@ModelAttribute Student student,HttpSession session) {
		
		int i =studentDao.addStudent(student);
		session.setAttribute("student", "Sucessfully student created");
		return "redirect:/student";
	}
}
