package com.test.pointcut;

import java.util.HashMap;
import java.util.Set;

/*
- Advice가 호출될 때 Pointcut 으로부터 전달받고 전달해야 하는 데이터들이 있는 경우 
  어떻게 전달하고 어떻게 전달받는지를 알아본다.
  
- 주업무 -> (전달할 값) -> 보조업무
*/


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class Cross {

	/*@Pointcut("execution(public void com.test.pointcut.Core.m1())")
	public void pc1() { 
	}*/
	
	// 모든 Advice는 JoinPoint라는 프록시 객체를 인자로 전달받는다. 
	// - 우선 JoinPoint 객체를 통해 얻을 수 있는 여러가지 정보에 대해서 알아본다.
	/*@Before("pc1()")
	public void before(JoinPoint joinPoint) {
		
		System.out.println("보조업무");
		
		// == 주업무 객체를 반환한다. ==
		System.out.println(joinPoint.getTarget());
		// com.test.pointcut.Core@646153
		
		 - getTarget()은 주업무 객체를 반환하기 때문에 주업무의 여러가지 정보를 올 수 있다.
		 - 이를 통해 보조업무에 다양한 적용이 가능하다. 
		 
		
		// == Pointcut AspectJ 형식을 반환한다. ==
		System.out.println(joinPoint.toLongString());
		// execution(public abstract void com.test.pointcut.ICore.m1())
		
		System.out.println(joinPoint.toString());
		// execution(void com.test.pointcut.ICore.m1())
		
		System.out.println(joinPoint.toShortString());
		// execution(ICore.m1())
			
		
		
		// == Pointcut 메소드 형식을 반환한다. ==
		System.out.println(joinPoint.getSignature());
		// void com.test.pointcut.ICore.m1()
		
		
		
		// == 인자값 리스트를 반환한다. ==
		System.out.println(joinPoint.getArgs());
		// [Ljava.lang.Object;@417213
		
	}*/
	
	
	/*@Pointcut("execution(public void com.test.pointcut.Core.m2())")
	public void pc2() { 
	}*/

	/*@Before("pc2()")
	public void before2(JoinPoint joinPoint) {
		
		// 주업무 객체를 반환한다.
		Core core = (Core)joinPoint.getTarget();
		
		// 주업무 객체의 멤버를 접근한다.
		System.out.println(core.num);
		System.out.println(core.getName());
	
		// 주업무 객체의 public 멤버를 얼마든지 접근 가능하기 때문에 이를 사용해서
		// 여러가지 보조업무를 진행할 수 있다.
	}*/
	
	
	
	
	/*
	  모든 Advice는 JoinPoint라는 프록시 객체를 인자로 전달받는다. 
       우선 JoinPoint 객체를 통해 얻을 수 있는 여러가지 정보에 대해서 알아본다.
	  다음으로 getArgs()에 대해 살펴본다.
	  - getArgs()은 Pointcut의 인자값을 반환한다.
	  - 주업무 객체가 실행되기 위한 인자값에 대한 정보를 보조업무 객체가 접근 가능하다는 뜻이다. 
	 */
	//인자값 틀리지않게 조심!!
	@Pointcut("execution(public void com.test.pointcut.Core.m3(String , String))")
	public void pc3() { 
	}
	
	
	HashMap<String,String> mapColor = new HashMap<String, String>();
	HashMap<String,String> mapSubject = new HashMap<String, String>();

	@After("pc3()")
	public void after(JoinPoint joinPoint) {
		
		// Pointcut("m3())"의 인자값을 가져온다.
		// 즉, MainTest에서 m3()를 호출할 때 넣어준 색상명을 가져온다.
		// 3번의 호출에서 2번은 "red", 1번은 "blue"를 전달한 상태이다.
		String color = (String)joinPoint.getArgs()[0];
		
		if(color != null && !color.trim().isEmpty()) {
			
			if(color.equalsIgnoreCase("red")) 
				mapColor.put(color, "빨강");
			else if(color.equalsIgnoreCase("blue"))
				mapColor.put(color, "파랑");
			else if(color.equalsIgnoreCase("yellow"))
				mapColor.put(color, "노랑");
			else if(color.equalsIgnoreCase("green"))
				mapColor.put(color, "초록");
			else 
				mapColor.put(color, "기타색깔");
			
		}
		else {
			color = "none";
			mapColor.put(color, "색깔없음");
		}
		
		Set<String> keyset = mapColor.keySet();
		
		for(String key : keyset) {
			 System.out.println(key + "=" + mapColor.get(key));
		}
		
		
		///////////////////////////////////////////////////////////////
		
		String subject = (String)joinPoint.getArgs()[1];
		
		if(subject != null && !subject.trim().isEmpty()) {
			
			if(subject.equalsIgnoreCase("kor")) 
				mapSubject.put(subject, "국어");
			else if(subject.equalsIgnoreCase("eng"))
				mapSubject.put(subject, "영어");
			else if(subject.equalsIgnoreCase("math"))
				mapSubject.put(subject, "수학");
			else if(subject.equalsIgnoreCase("science"))
				mapSubject.put(subject, "과학");
			else if(subject.equalsIgnoreCase("society"))
				mapSubject.put(subject, "사회");
			else 
				mapSubject.put(subject, "기타과목");
		}
		else {
			subject = "none";
			mapSubject.put(subject, "과목없음");
		}
		
		keyset = mapSubject.keySet();
		
		for(String key : keyset) {
			 System.out.println(key + "=" + mapSubject.get(key));
		}
	
	} // end of after(JoinPoint joinPoint)----------------------------
	
 /*
  
    [요약 정리] 주업무 객체에서 보조업무 객체로 무언가를 전달하려면..
		1. 주업무 객체의 public 멤버
			-> JoinPoint.getTarget() 사용
		
		2. 주업무 객체의 Pointcut 인자값
			-> JoinPoint.getArgs() 사용
		
		3. 주업무 객체의 Pointcut 내부 지역 변수값
			-> After returning Advice 사용
   
	주업무3
	색상 : red / 과목 : kor
	red=빨강
	kor=국어
	주업무3
	색상 : blue / 과목 : eng
	red=빨강
	blue=파랑
	kor=국어
	eng=영어
	주업무3
	색상 : red / 과목 : math
	red=빨강
	blue=파랑
	math=수학
	kor=국어
	eng=영어
	주업무3
	색상 :   / 과목 : science
	red=빨강
	blue=파랑
	none=색깔없음
	science=과학
	math=수학
	kor=국어
	eng=영어
	주업무3
	색상 : yellow / 과목 : society
	red=빨강
	blue=파랑
	yellow=노랑
	none=색깔없음
	society=사회
	science=과학
	math=수학
	kor=국어
	eng=영어
	
*/
	
	
	@Pointcut("within(com.test.pointcut.Core)")
	public void pc4() { 
	}

	@Before("pc4()")
	public void before4() {
		
		System.out.println("보조업무4");
		
	}
	/*
	 == Pointcut 명시자를 within을 사용해서 선언하기 ==
		- within 명시자는 특정 타입에 속하는 메소드를 Pointcut으로 설정한다.
		- 타입 패턴만을 이용해서 Pointcut을 설정한다.
		- execution 명시자에 비해 덜 세밀하다.
		
		ex) @Pointcut("within(com.test.pointcut.Core)")
			- com.test.pointcut.Core 클래스의 모든 메소드를 Pointcut으로 선언한다.
		ex) @Pointcut("within(Core)")
			- 위의 예의 패키지 생략 표현
		ex) @Pointcut("within(com.test.pointcut.*)")
			- com.test.pointcut 패키지내의 모든 클래스의 모든 메소드를 Pointcut으로 선언한다.
		ex) @Pointcut("within(com.test...*)")
			- com.test와 그 하위 패키지내의 모든 클래스의 모든 메소드를 Pointcut으로 선언한다. 
	 */
	
	
	
	@Pointcut("bean(core)")
	public void pc5() { 
	}

	@Before("pc5()")
	public void before5() {
		
		System.out.println("보조업무5");
		
	}
	/*
	 == Pointcut 명시자를 bean을 사용해서 선언하기 ==
		- baen 명시자는 빈 이름의 패턴을 사용해서 Pointcut을 설정한다.
		- Spring에서만 사용 가능한 명시자이다. (AspectJ에는 없다.)
		
		1. MainTest.java 내용 확인하기
		2. Cross.java 내용 추가하기
		3. main.xml  내용 확인하기
		
		ex) @Pointcut("bean(core)")
			- 빈 이름이 "core"인 클래스의 모든 메소드를 Pointcut으로 선언한다.
		ex) @Pointcut("bean(c*)")
			- 빈 이름이 "c"로 시작하는 모든 클래스의 모든 메소드를 Pointcut으로 선언한다.
		ex) @Pointcut("bean(*c)")
			- 빈 이름이 "c"로 끝나는 모든 클래스의 모든 메소드를 Pointcut으로 선언한다. 
	 */
	 /*
	     동일한 클래스로 자바 빈을 여러 용도로 만들어서 사용할 때 
	    (  <bean id="my" class="com.test.Use">,
	       <bean id="he" class="com.test.Use">,
	       <bean id="she" class="com.test.Use"> )  이중 특정 빈(my)만을 
	    Pointcut 을 선언한다고 가정하면.....
	    execution 명시지와 within 명시자로는 불가능하지만 bean 명시자로는 가능하다.
	  */
	
}












