package com.crudoperation.dao;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crudoperation.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public int saveUser(User user) {
		int i=(Integer)hibernateTemplate.save(user);
		return i;
	}

	public User loginUser(String email, String password) {
	    String sql = "FROM User WHERE email=:em AND password=:pwd";
	    User user = (User) hibernateTemplate.execute(s -> {
	        Query query = s.createQuery(sql);
	        query.setParameter("em", email);
	        query.setParameter("pwd", password);
	        return query.uniqueResult();
	    });
	    return user;
	}


	
}
