/* 인터페이스 설계 */
package com.test.memo;

public interface IMemo {

	// 주업무 - 메모 작성하기
	void write(String memo);
	
	/* 이미 작성한 보조 업무가 다른 주업무에도 동일하게 적용되는지 확인하기
	  - 메모 작성할 때 뿐만 아니라 메모 수정할 때에도 시간 기록을 로그로 남기고 싶다.
	  - 주업무만 추가하고 보조업무는 건드릴 필요가 없다. */
	// 주업무 추가 - 메모 수정하기
	void edit(String memo);
	
	
	/* After Returning Advice 적용하기
	  - 메모를 삭제한 뒤 삭제한 메모 번호의 번호를 로그에 기록하는 보조 업무를 추가
	  - After Returning Advice는 주업무 실행이 예외 발생없이 성공적으로 실행된 후에 실행된다. */
	// 주업무  추가 - 메모 삭제하기
	int del(int seq);
	
	/* After Throwing Advice 적용하기
		- 메모 읽기 중 예외가 발생하면 로그에 기록하는 보조 업무를 추가
		- 주로 예외에 관련된 기록(처리)만을 따로 관리하는 용도로 사용
		- After Throwing Advice는 주업무 실행 중 예외가 발생했을 때 실행된다. */
	// 주업무 추가 - 메모 읽기
	void read(int seq) throws Exception; // 주업무 추가
	
}





