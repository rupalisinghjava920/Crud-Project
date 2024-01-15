package com.crudoperation.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crudoperation.model.Employee;

@Repository
public class EmployeeDaoImpl  implements EmployeeDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int saveEmployee(Employee employee) {
		int i =(Integer) hibernateTemplate.save(employee); 
		return i;
	}

	public Employee getEmployeeById(int id) {
		Employee employee=hibernateTemplate.get(Employee.class, id);
		return employee;
	}

	public List<Employee> getAllEmployee() {
		List<Employee> list=hibernateTemplate.loadAll(Employee.class);
		return list;
	}

	@Transactional
	public void update(Employee employee) {
		hibernateTemplate.update(employee);
		
	}

	@Transactional
	public void deleteEmployee(int id) {
		Employee employee=hibernateTemplate.get(Employee.class, id);
		hibernateTemplate.delete(employee);
		
	}

}
