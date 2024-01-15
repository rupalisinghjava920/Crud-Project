package com.crudoperation.dao;

import java.util.List;

import com.crudoperation.model.Employee;

public interface EmployeeDao {

	public int saveEmployee(Employee employee);
	
	public Employee getEmployeeById(int id);
	
	public List<Employee> getAllEmployee();
	
	public void update(Employee employee);
	
	public void deleteEmployee(int id);


	
}
