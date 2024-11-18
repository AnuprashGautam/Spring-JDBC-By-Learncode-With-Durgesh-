package com.spring.orm.dao;


import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;


public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	// save student
	@Transactional
	public int insert(Student student) {
		//insert
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return i;
	}
}
