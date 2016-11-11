package com.test.pointcut;

public class Core implements ICore {
// 주업무 담당 , 서비스 객체
	
	/*@Override
	public void m1() {

		System.out.println("주업무 m1()");

	}

	@Override
	public void m2() {
		
		System.out.println("주업무 m2()");
		
	}

	
	
	// N : 1 관계
	@Override
	public void insertProduct() {
		System.out.println("주업무 insertProduct()");
		
	}

	@Override
	public void insertMember() {
		System.out.println("주업무 insertMember()");
		
	}

	@Override
	public void insertJumun() {
		System.out.println("주업무 insertJumun()");
		
	}*/

	
	
	// N : N 관계
	@Override
	public void updateProduct() {
		System.out.println("주업무 updateProduct()");
		
	}

	@Override
	public void updateMember() {
		System.out.println("주업무 updateMember()");
		
	}

	@Override
	public void updateJumun() {
		System.out.println("주업무 updateJumun()");
		
	}

	
	
	@Override
	public void noPointcutUse() {
		System.out.println("주업무 noPointcutUse() -- Pointcut 선언을 별도로 하지 않고 Advice에 직접 선언이 가능하다.");
		
	}
	
	
	

}
