package com.test.pointcut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:main.xml");

		ICore core = context.getBean("core", ICore.class);
		
		//core.m1();
		/*
		   === 실행결과 ===
		보조업무
		com.test.pointcut.Core@646153
		execution(public abstract void com.test.pointcut.ICore.m1())
		execution(ICore.m1())
		execution(void com.test.pointcut.ICore.m1())
		void com.test.pointcut.ICore.m1()
		[Ljava.lang.Object;@12cf7ab
		주업무    
		*/
		
		
		
		//core.m2();
		
		
		
		//core.m3("red","kor");
		//core.m3("blue","eng");
		//core.m3("red","math");
		//core.m3(" ","science");
		//core.m3("yellow","society");
		
		
		
		core.m4(); //위의 나머지 업무는 주석처리
		
		
    	//  ((GenericXmlApplicationContext)context).close();
	}

}
