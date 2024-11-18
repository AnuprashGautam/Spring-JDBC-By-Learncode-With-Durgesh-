package com.spring.orm;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        
		StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
		
		
		Student student=new Student(785,"Anirudh Gautam","Muzaffarnagar");
		
		int r=studentDao.insert(student);
		System.out.println("Done "+r);
    }
}
