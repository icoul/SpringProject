/* 보조업무를 구현하는 객체(로그 작성) */

package com.test.memo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

	// 보조업무
	// -- 메모를 작성하는데 걸리는 시간을 로그에 남기는 보조업무
	public void arround(ProceedingJoinPoint joinPoint)
	    throws Throwable {
		
		// 보조업무 시작
		long start = System.currentTimeMillis(); 
		System.out.println("====================================");
		System.out.println("시간 기록 시작");
		
		try {
			// 주업무 시작
			// - joinPoint.proceed(); 메소드를 실행함으로 
			//   Pointcut 에 설정된 주업무를 처리해주는 메소드가 호출되어 실행된다.
			//   지금은 public * com.test.memo.Memo.*(..) 이다. 
			joinPoint.proceed();  
			//   그리고 joinPoint.proceed() 메소드의 리턴값은 Object 이다.;
			//   이를통해 Aspect 로 연결된 Original Method(지금은 Memo 클래스의 모든 메소드임) 의 
			//   리턴값을 형변환을 통하여 받을수 있다.
			//   지금은 Original Method 의 리턴값이 void 임.
			// 주업무 끝
		} finally {
			long finish = System.currentTimeMillis();
			System.out.println("시간 기록 끝");
			System.out.println("주업무 실행시간 : " + (finish - start)+"ms");
			System.out.println("====================================");
			// 보조업무 끝
		}
		
	}// end of arround(ProceedingJoinPoint joinPoint) -----------
	
	
	/*
	Before Advice 적용하기
	- 메모 작성(수정)하기 전에 해당 시간을 로그에 기록하는 보조 업무를 추가
	- 이번엔 새로운 Advice(보조업무)를 추가할 것이기 때문에 보조업무 객체를 편집 */
	// 보조업무 추가
	// -- 메모를 작성하기 전 현재 시간을 로그에 남기는 보조업무 
	public void before() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String now = sdf.format(new Date());
		
		System.out.println("   메모 작성 날짜시간 : " + now);
		
		//System.out.printf("메모 작성 시간 : %tT\n", Calendar.getInstance());
	}// end of before()--------------------
	

	/*
	After Advice 적용하기
	- 메모 작성(수정) 후 편집 횟수를 로그에 기록하는 보조 업무를 추가
	- 새로운 Advice(보조업무)를 추가할 것이기 때문에 보조업무 객체를 편집
	- After Advice는 주업무 실행 중 예외 발생과 무관하게 항상 무조건 실행된다.(자바의 finally와 비슷한 역할임) */
	// 보조업무 추가
	// -- 메모를 작성(수정)하면 편집 횟수를 누적해서 로그에 남기는 보조 업무
	int cnt = 0;
	public void after() {
		
		cnt++;
		System.out.printf("   메모 편집 횟수 : %d회\n", cnt);
	}
	
	
	
	/* After Returning Advice 적용하기
	  - 메모를 삭제한 뒤 삭제한 메모 번호의 번호를 로그에 기록하는 보조 업무를 추가
	  - After Returning Advice는 주업무 실행이 예외 발생없이 성공적으로 실행된 후에 실행된다. */
	// 보조업무 추가
	// -- 메모를 삭제한뒤 삭제한 메모의 번호를 로그에 남기는 보조업무
	// -- 보조 객체의 파라미터명과 XML의 returning 의 파라미터명이 동일해야 한다.
	public void afterreturing(Object seq) {
		
		System.out.println(">>> 삭제된 메모 번호 : " + seq);
		
	}
	
	
	
	/* After Throwing Advice 적용하기
	- 메모 읽기 중 예외가 발생하면 로그에 기록하는 보조 업무를 추가
	- 주로 예외에 관련된 기록(처리)만을 따로 관리하는 용도로 사용
	- After Throwing Advice는 주업무 실행 중 예외가 발생했을 때 실행된다. */
	// 보조업무 추가
	// - 메모를 읽다가 예외가 발생하면 로그에 남기는 보조업무
	// - 보조 객체의 파라미터명과 XML의 throwing의 파라미터명이 동일해야 한다.
	public void afterthrowing(Exception e) {
		
		System.out.println("예외 기록 : " + e.getMessage());
	}
	
}









