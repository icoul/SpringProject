/* 메인 클래스(테스트 시연용) */
package com.test.memo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		
		// IoC컨테이너(Spring컨테이너)로 사용되는 
		// ApplicationContext 객체 생성하기 
		// 이것은 XML 설정을 로드함으로써 생성할 수 있다. 
		ApplicationContext context = new GenericXmlApplicationContext("classpath:memo.xml");
       
		/* Spring에선 이 ApplicationContext를 
		   IoC(Inversion of Control)(또는 DI[의존객체주입])컨테이너라 하기도 하고, 
		   Spring컨테이너라고 부르기도 한다. 
             또는 BeanFactory라고 하기도 한다.
          
          (ApplicationContext는 Application Interface를 구현하는데 
           Application Interface는 또 BeanFactory Interface를 구현하고 있다.) 
        
          ApplicationContext는 어플리케이션에서 IoC(제어역전)를 적용해서 관리할 
           모든 오브젝트에 대한 생성과 관계설정을 담당한다.
           
          ApplicationContext의 역할은 단지 오브젝트 생성과 다른 오브젝트와의 관계 설정 뿐만아니라 
          Bean을 검색하는 다양한 방법을 제공한다.
          
          "IoC 개념이란?
             그 동안 개발자들이 담당해왔던 인스턴스에 대한 직접적인 Control을 
             컨테이너란 놈이 빼앗아 감으로서 
             인스턴스에 대한 Control을 담당하는 주체가 바뀌었다."라는 것이다.
             
          "IoC(Inversion of Control)이란 무엇인가?
			자바가 등장하고 자바 기반으로 애플리케이션을 개발하기 시작하던 최초의 시기에는 
			자바 객체를 생성하고 객체간의 의존관계를 연결시키는 등의 제어권을 개발자가 직접 가지고 있었다. 
			그러나 서블릿, EJB가 등장하면서 개발자들의 독점적으로 가지고 있던 
			제어권이 서블릿과 EJB를 관리하는 컨테이너에게 넘어가 버렸다. 
			객체에 대한 제어권이 컨테이너에게 넘어가면서 객체의 생명주기를
			관리하는 권한 또한 컨테이너들이 전담할 수 밖에 없게 되었다. 
			이처럼 객체의 생성에서부터 생명주기의 관리까지 모든 객체에 대한
			제어권이 바뀐것을 의미하는 것이 제어권의 역전, 즉 Ioc라는 개념이다.
		
		  <<참고>>	
		  "DI(Dependency Injection)이란 무엇인가?
            Dependency Injection은 Spring 프레임워크에서 지원하는 IoC의 형태이다. 
            DI는 클래스 사이의 의존관계를 빈 설정 정보를 바탕으로 컨테이너가 
            자동적으로 연결해주는 것을 말한다.
            개발자들은 빈 설정 파일(저장소 관리 파일)에 의존관계가 필요하다는 정보를 추가하면 된다.
            Spring 프레임워크는 Setter Injection, Constructor Injection, Method Injection의 세가지 유형으로 나타난다.

            Setter Injection
            - Setter Injection은 클래스 사이의 의존관계를 연결시키기 위하여 setter 메소드를 이용하는 방법이다. 

            Constructor Injection
            - Constructor Injection은 생성자를 이용하여 의존관계를 연결시킨다.

			Method Injection
			- Method Injection은 Setter Injection과 Constructor Injection이 가지고 있는 한계점을 극복하기 위하여
			  Spring 프레임워크 1.1 버전에서 새롭게 지원하고 있는 DI의 한 종류이다.
			  Singleton 인스턴스와 Non Singleton 인스턴스의 의존관계를 연결할 필요가 있을때 사용한다.
        */
		
		// 빈(bean) 객체 생성하기
		IMemo memo = context.getBean("memo", IMemo.class); 
		// memo.xml 파일에서 id 가 "memo"로 되어진 객체를 얻어옴.
		
		
		// 메모 쓰기(프록시 객체를 통한 주업무 호출)
		memo.write("스프링 공부하기");

		
		/* 이미 작성한 보조 업무가 다른 주업무에도 동일하게 적용되는지 확인하기
		  - 메모 작성할 때 뿐만 아니라 메모 수정할 때에도 시간 기록을 로그로 남기고 싶다.
		  - 주업무만 추가하고 보조업무는 건드릴 필요가 없다. */
		// 메모 수정(주업무 추가)
		memo.edit("AOP 공부하기");
		
		
		/* After Returning Advice 적용하기
		  - 메모를 삭제한 뒤 삭제한 메모 번호의 번호를 로그에 기록하는 보조 업무를 추가
		  - After Returning Advice는 주업무 실행이 예외 발생없이 성공적으로 실행된 후에 실행된다. */
		// 주업무 실행 -- 메모 삭제하기
		memo.del(59);
		
		
		
		/* After Throwing Advice 적용하기
		- 메모 읽기 중 예외가 발생하면 로그에 기록하는 보조 업무를 추가
		- 주로 예외에 관련된 기록(처리)만을 따로 관리하는 용도로 사용
		- After Throwing Advice는 주업무 실행 중 예외가 발생했을 때 실행된다. */
		try {
			memo.read(10);
			memo.read(-2);
		} catch (Exception e) {
			
		}
		
		
		//  ((GenericXmlApplicationContext)context).close();
		
	}

}





