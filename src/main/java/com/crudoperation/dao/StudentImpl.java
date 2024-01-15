package com.crudoperation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crudoperation.model.Student;

@Repository
public class StudentImpl implements StudentDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int addStudent(Student student) {
		int i=(int) hibernateTemplate.save(student);
		return i;
	}

}
