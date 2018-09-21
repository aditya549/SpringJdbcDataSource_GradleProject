package com.java.datasource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("resources/spring.xml");
		EmpDAOImpl emp=(EmpDAOImpl)context.getBean("empdao");
		Employee e=new Employee();
		e.setUsername("reddy");
		e.setPassword("reddy123");
		e.setEmail("reddy@gmail.com");
		e.setId("1216");
		emp.insert(e);
		
		/*Employee e=new Employee();
		e.setUsername("reddy");
		e.setEmail("reddy12345@gmail.com");
		emp.update(e);
		
	//	emp.fetch();
		
		Employee e=new Employee();
		e.setUsername("reddy");
		emp.delete(e);*/
	}
}
