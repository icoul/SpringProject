package com.test.pointcut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:main.xml");

		ICore core = context.getBean("core", ICore.class);
		
		/*core.m1();
		core.m2();
		
		
		core.insertProduct();
		core.insertMember();
		core.insertJumun();*/
		
		
		core.updateProduct();
		core.updateMember();
		core.updateJumun();
		
		
		core.noPointcutUse();
		
		//  ((GenericXmlApplicationContext)context).close();
	}

}











