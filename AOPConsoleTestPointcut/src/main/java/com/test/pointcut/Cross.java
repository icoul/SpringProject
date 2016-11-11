package com.test.pointcut;

import org.aspectj.lang.annotation.After;

/*
    ===>>>  Pointcut과 Advice와의 관계 개요  <<<===

◈  1 : 1 관계
-- 특정 Pointcut 1개에 특정 Advice 1개를 연결함

   @Pointcut("execution(public void com.test.pointcut.Core.m1())")
   public void pc1() { }
	
   @Around("pc1()")
   public void arround() { 명령어 }



◈  1 : N 관계
-- 특정 Pointcut 1개에 여러 Advice를 연결함

	@Pointcut("execution(public void com.test.pointcut.Core.m1())")
	public void pc1() { }

	@Around("pc1()")
	public void arround() { 명령어 }
	
	@Before("pc1()")
	public void before() { 명령어 }
	
	@After("pc1()")
	public void after() { 명령어 }



◈  N : 1 관계
-- Pointcut 여러개에 특정 Advice 1개를 연결함. Core클래스의 모든 메소드가 Pointcut 이다.
   Pointcut 정의는 1개이지만 와일드카드(*) 때문에 실제로는 수많은 메소드가 Pointcut 이 된다.


 @Pointcut("execution(public void com.test.pointcut.Core.*())")
 public void pc1() { }

 @Around("pc1()")
 public void arround() { 명령어 }



◈ N : N 관계
-- Pointcut 여러개에 Advice 여러개를 연결함

	@Pointcut("execution(public void com.test.pointcut.Core.*())")
	public void pc1() { }
	
	
	@Around("pc1()")
	public void arround() { 명령어 }
	
	@Before("pc1()")
	public void before() { 명령어 }
	
	@After("pc1()")
	public void after() { 명령어 }



 	===>>> Pointcut 선언 시 메서드 표현 방법 살펴보기 (AspectJ 표현식) <<<===
	1. 스프링에서는 Join Point을 지정하기 위해서 Pointcut을 정의할때 AspectJ 표현식을 확장해서 사용한다.
	2. Pointcut 선언은 execution, within, bean 명시자가 있다. 아래 설명은 execution 명시자를 사용한다.
		- execution([접근자지정자패턴] 리턴타입패턴 [패키지패턴]메소드이름패턴(파라미터패턴))
		- 와일드 카드(*) 사용이 가능하다.
		- .. 은 0또는 그 이상이란 표현이다.
		- 나머지는 자바 표현과 동일하다.

		ex) @Pointcut("execution(public void com.test.pointcut.Core.m1())")
			- 해당 패키지의 Core클래스의 m1() 이라는 메서드를 Pointcut으로 지정한다.
		ex) @Pointcut("execution(void com.test.pointcut.Core.m1())")
			- public은 생략이 가능하다. (public이 아니면 Pointcut이 될수 없기 때문에..)
		ex) @Pointcut("execution(void Core.m1())")
			- 주업무 객체와 보조업무 객체가 같은 패키지면 패키지도 생략이 가능하다. 
		ex) @Pointcut("execution(void Core.*())")
			- Core클래스의 인자값이 없는 모든 메서드를 Pointcut으로 지정한다.
		ex) @Pointcut("execution(void Core.a*())")
			- Core클래스의 인자값이 없고, 이름이 a로 시작하는 모든 메서드를 Pointcut으로 지정한다.
		ex) @Pointcut("execution(void Core.*ing())")
			- Core클래스의 인자값이 없고, 이름이 ing로 끝나는 모든 메서드를 Pointcut으로 지정한다.
		ex) @Pointcut("execution(void Core.*(int))")
			- Core클래스의 인자값이 int 1개를 가지는 모든 메서드를 Pointcut으로 지정한다.
		ex) @Pointcut("execution(void Core.*(int,String))")
			- Core클래스의 인자값이 2개를(int, String) 가지는 모든 메서드를 Pointcut으로 지정한다.
		ex) @Pointcut("execution(void Core.m1(..))")
			- Core클래스의 인자값이 0개 이상이며, 이름이 m1인 모든 메서드를 Pointcut으로 지정한다.
			  (즉, 오버로딩된 모든 m1들이 Pointcut으로 설정된다.)
		ex) @Pointcut("execution(void Core.*(..))")
			- Core클래스의 인자값이 0개 이상인 모든 메서드를 Pointcut으로 지정한다.
		ex) @Pointcut("execution(int Core.*(..))")
			- Core클래스의 반환값이 int이며 인자값이 0개 이상인 모든 메서드를 Pointcut으로 지정한다.
		ex) @Pointcut("execution(* Core.*(..))")
			- Core클래스의 반환값이 어느것이든 상관없으며, 인자값이 0개 이상인 모든 메서드를 Pointcut으로 지정한다.
		ex) @Pointcut("execution(* com.test.aop..*(..))")
			- com.test.aop 패키지 이하의 모든 클래스가 가지는 메서드를 Pointcut으로 지정한다. 
 */

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Cross { // 보조 업무 담당
	
	// === 1 : 1 관계 선언하기(특정 주업무 Pointcut 에 특정 Advice 연결하기) ===	
	// >>> Pointcut 설정하기 <<<
	// - 특정한 주업무만을 지정해서 Pointcut을 생성한다.
	// - 단, Pointcut 메소드는 "target()"이라는 이름은 사용 불가능!! 예약어이다.
	@Pointcut("execution(public void com.test.pointcut.Core.m1())")
	public void pc1() {
		
	}
	
	// >>> 보조 업무 구현 <<<
	// - @Pointcut이 선언된 메소드의 이름을 참조한다.
	@Before("pc1()")
	public void before() {
		
		System.out.println("주업무 m1()이 발생하기전에 실행하는 보조업무1");
	}
	// 특정 Pointcut("m1()") 에 특정 Advice("before()")를 연결 시켰기 때문에 
	// 주업무 m2() 호출시에는 보조업무가 호출되지 않는다. 
	// 재사용이 필요없을 경우 그냥 이렇게 1 : 1 연결을 한다.
	
	
	
	// === 1 : N 관계 선언하기(특정 주업무 Pointcut 에 여러 Advice 연결하기) ===	
	// >>> Pointcut 설정하기 <<<
	// - 특정한 주업무만을 지정해서 Pointcut을 생성한다. 앞에서 생성한 Pointcut 을 사용하겠다.
	// - 단, Pointcut 메서드는 "target()"이라는 이름은 사용 불가능!! 예약어이다.
	
	// 추가 보조 업무 구현
	@After("pc1()")
	public void after() {
		System.out.println("주업무 m1()이 발생한후에 실행하는 보조업무2");
	}
	
	
	
	// === N : 1 관계 선언하기(여러 주업무 Pointcut 에 한개의 동일한 Advice만 연결하기) ===	
	// 여러개의 주업무에 동일한 보조업무를 적용한다.
	// 1. ICore.java 내용 추가하기 -- 주업무 추가하기
	// 2. Core.java 내용 추가하기  -- 주업무 추가하기
	// 3. MainTest.java 내용 추가하기
	// 4. Cross.java 내용 추가하기
	// >>> 새로운 주업무 Pointcut 설정하기 <<<
	// 단, 여러 메소드가 선택될 수 있도록 표현식을 작성한다. (N : 1)
	// insert 로 시작하는 메소드명을 모두 Pointcut으로 선언한다.
	// - 단, Pointcut 메서드는 "target()"이라는 이름은 사용 불가능!! 예약어이다.
	@Pointcut("execution(public void com.test.pointcut.Core.insert*())")
	public void pc2() {
		
	}
	
	
	//pc2() Pointcut에 1개의 보조업무를 연결한다.
	// 결국 Core.insertProduct(), Core.insertMember(), Core.insertJumun() 주업무에 대해서 
	// before2() Advice 보조업무가 매번 동일하게 호출된다.
	@Before("pc2()") 
	public void before2() {
			
		System.out.println("com.test.pointcut.Core 클래스에서 메소드의 이름이 insert 로 시작하는 주업무 메소드가 실행되기전 동일한 before 보조업무 before2()를 적용함");
			
	}
	// 여러개의 주업무에 동일하게 반복되는 보조업무가 적용되는 것을 확인할 수 있다.
	// 인증처리, 로그기록 등 자주 반복되는 패턴의 업무가 N : 1 관계에 속하는 것이다.
	
	
	
	
	// === N : N 관계 선언하기(여러 주업무 Pointcut 에 여러개의 Advice를 연결하기) ===	
	// Pointcut 여러개에 Advice 여러개를 적용한다.
	// 주업무 o1() : 보조업무(o1advice1(), o1advice2())
	// 주업무(o1(), o2(), o3()) : 보조업무(osBefore())
	// 1. ICore.java 내용 추가하기 -- 주업무 추가하기
	// 2. Core.java 내용 추가하기  -- 주업무 추가하기
	// 3. MainTest.java 내용 추가하기
	// 4. Cross.java 내용 추가하기
	// >>> 새로운 주업무 Pointcut 설정하기 <<<
	// 단, 여러 메소드가 선택될 수 있도록 표현식을 작성한다. (N : N)
	// update 로 시작하는 메소드명을 모두 Pointcut으로 선언한다.
	// - 단, Pointcut 메서드는 "target()"이라는 이름은 사용 불가능!! 예약어이다.
	/*@Pointcut("execution(public void com.test.pointcut.Core.update*())")
	public void pc3() {
		
	}*/
	
	//pc3() Pointcut에 여러개의 보조업무를 연결한다.
	// 결국 Core.updateProduct(), Core.updateMember(), Core.updateJumun() 주업무에 대해서 
	// before3() Advice 보조업무가 매번 동일하게 호출된다.
	/*@Before("pc3()") 
	public void before3() {
			
		System.out.println("com.test.pointcut.Core 클래스에서 메소드의 이름이 update 로 시작하는 주업무 메소드가 실행되기전 동일한 before 보조업무 before3()를 적용함");
			
	}*/
	
	// 또한 Core.updateProduct(), Core.updateMember(), Core.updateJumun() 주업무에 대해서 
	// before3() Advice 보조업무가 매번 동일하게 호출된다.
	/*@After("pc3()")
	public void after3() {
		
		System.out.println("com.test.pointcut.Core 클래스에서 메소드의 이름이 update 로 시작하는 주업무 메소드가 실행된 후 동일한 after 보조업무 after3()를 적용함");
		
	}*/
	
	
	
	//Pointcut 선언을 따로 하지 않고 Advice 선언과 동시에 한다.
	@Before("execution(public void com.test.pointcut.Core.noPointcutUse())")
	public void noPointcutUseBefore() {
			
		System.out.println("Pointcut 선언없이 직접 연결한 보조업무");
			
	} // Pointcut 을 재사용할 일이 없으면 이와 같이 간단하게 선언할 수 있다. 
	
}








