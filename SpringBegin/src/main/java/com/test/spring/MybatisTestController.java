package com.test.spring;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
사용자 웹브라우저 요청  ==> DispatcherServlet ==> @Controller 클래스 <==>> Service단(핵심업무로직단, business logic단) <==>> Model단(DAO, DTO) <==>> myBatis <==>> DB(오라클)           
(http://...  *.action)                                  |
          ↑                                             |
          |                                             ↓
          |                                          View단(.jsp)
          ----------------------------------------------| 

서비스 객체는 데이터베이스 작업만 전문으로 하는 객체가 아니라 
해당업무(예: 게시판)에서 필요로 하는 작업을 전부 총 관리하는 객체이다.
여기서 관리라는 것은 업무에 필요한 작업의 흐름만 기술하는 것으로(즉, 메소드 호출임)
실제 업무 프로그래밍은 Model 단에서 기술해둔다.(즉, Model 단에서 메소드를 작성한다.)
이 서비스 객체는 업무 로직단(비지니스 로직단)이라고 부르며, 
실제 코딩은 없고 @Controller 에서 요청받은 것을 Model 단으로 넘겨주는 역할을 한다. 
 */    


@Controller
public class MybatisTestController {

	// 의존객체주입(DI : Dependency Injection)
	@Autowired
	private MybatisTestService service;

	// 1. 리턴값도 없고 파라미터 값도 없는 SQL구문 실행
	@RequestMapping(value="/mybatis/mybatisTest1.action",method={RequestMethod.GET})
	public String mybatisTest1(){

		service.mbt1();

		return "mybatisTest1";
	}

	// 2. 기본형 primitive type(int, double, String)d을 파라미터값으로 넘겨서 SQL문 실행
	@RequestMapping(value="/mybatis/mybatisTest2.action",method={RequestMethod.GET})
	public String mybatisTest2(){

		String name = "이유림";
		service.mbt2(name);

		return "mybatisTest2";
	}

	// 3. 페이지간의 데이터 전송 & 받기 예제
	//    작업내용 : 글쓰기 폼 페이지 작성
	/*폼페이지 띄우기는 무조건 get방식*/
	@RequestMapping(value="/mybatis/mybatisTest3.action",method={RequestMethod.GET})
	public String mybatisTest3(){

		return "add"; // 글쓰기 폼페이지 작성
	}

	// 3. 페이지간의 데이터 전송 & 받기 예제
	//    작업내용 : 폼페이지에서 넘겨온 값을 받아서 서비스단에 넘기기
	@RequestMapping(value="/mybatis/mybatisTest3End.action",method={RequestMethod.POST})
	public String mybatisTest3End(HttpServletRequest req){

		//1. 폼페이지에서 넘겨온 값을 받기
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String addr = req.getParameter("addr");

		//2. DTO(VO)에 넣어준다.
		MybatisTestVO vo = new MybatisTestVO();

		vo.setName(name);
		vo.setEmail(email);
		vo.setTel(tel);
		vo.setAddr(addr);

		//3. service 단으로 생성된 DTO(VO)를 넘긴다.
		service.mbt3(vo);

		return "addEnd"; // 글쓰기 폼페이지 작성
	}


	// 4. 페이지간의 데이터 전송 & 받기 예제
	//    작업내용 : 글쓰기 폼 페이지 작성
	/*폼페이지 띄우기는 무조건 get방식*/
	@RequestMapping(value="/mybatis/mybatisTest4.action",method={RequestMethod.GET})
	public String mybatisTest4(){

		return "add2"; // 글쓰기 폼페이지 작성
	}

	// 4. 페이지간의 데이터 전송 & 받기 예제
	//    작업내용 : 폼페이지에서 넘겨온 값을 받아서 서비스단에 넘기기
	@RequestMapping(value="/mybatis/mybatisTest4End.action",method={RequestMethod.POST})
	public String mybatisTest4End(MybatisTestVO vo){

		//3. service 단으로 생성된 DTO(VO)를 넘긴다.
		service.mbt4(vo);

		return "addEnd"; // 글쓰기 폼페이지 작성
	}


	// 5. 해쉬맵 사용하기
	@RequestMapping(value="/mybatis/mybatisTest5.action",method={RequestMethod.GET})
	public String mybatisTest5(){

		return "add3"; // 글쓰기 폼페이지 작성
	}

	// 5. 페이지간의 데이터 전송 & 받기 예제
	//    작업내용 : 폼페이지에서 넘겨온 값을 받아서 서비스단에 넘기기
	@RequestMapping(value="/mybatis/mybatisTest5End.action",method={RequestMethod.POST})
	public String mybatisTest5End(HttpServletRequest req){

		//1. 폼페이지에서 넘겨온 값을 받기
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		String addr = req.getParameter("addr");

		//2. DTO(VO) 클래스를 생성하지 않고 그냥 HashMap을 사용하는 경우
		/*
			 	ResultSet 결과물(select되어진 결과물)이 아주 다양한 종류의 테이블을 가지고 
			 	JOIN해서 나온 결과물이라면 매번 VO클래스를 추가생성해야 하지만
			 	이러한 VO클래스를 추가생성없이 해결하려면 HashMap을 사용해서 해결
		 */
		// form에서 넘겨받은 데이터를 HashMap에 저장시켜서 저장된 HashMap객체를
		// Service단으로 넘기면 된다.
		// HashMap은 key와 values로 이루어지는데 KEY는 당연히 String이고 Value는 Object타입이어야한다.
		// 그런데 Form에서 넘어온 데이터는 모두 String 타입이므로
		// Value타입 또한 String이 된다.
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("name", name);
		map.put("email", email);
		map.put("tel", tel);
		map.put("addr", addr);

		//3. service 단으로 생성된 DTO(VO)를 넘긴다.
		service.mbt5(map);

		return "addEnd"; // 글쓰기 폼페이지 작성
	}	


	// 6. 해쉬맵 사용하기
	@RequestMapping(value="/mybatis/mybatisTest6.action",method={RequestMethod.GET})
	public String mybatisTest6(){

		return "add4"; // 글쓰기 폼페이지 작성
	}

	// 6. 페이지간의 데이터 전송 & 받기 예제
	//    작업내용 : 폼페이지에서 넘겨온 값을 받아서 서비스단에 넘기기
	@RequestMapping(value="/mybatis/mybatisTest6End.action",method={RequestMethod.POST})
	public String mybatisTest6End(MybatisTestVO vo){

		//1. 폼페이지에서 넘겨온 값 VO를 HashMap에 저장시켜서
		//   저장된 HashMap객체를 서비스단으로 넘긴다.

		HashMap<String, MybatisTestVO> map = new HashMap<String, MybatisTestVO>();

		map.put("heowon", vo);

		//3. service 단으로 생성된 DTO(VO)를 넘긴다.
		service.mbt6(map);

		return "addEnd"; // 글쓰기 폼페이지 작성
	}

	// 7. 데이터 불러오기
	// -- 작업내용 : 회원조회 폼 페이지 ==> 서브밋을 하면 검색조건에 맞는 내용을 DB에서 Select해서 웹페이지에 보여지도록 한다.	
	@RequestMapping(value="/mybatis/mybatisTest7.action",method={RequestMethod.GET})
	public String mybatisTest7(){

		return "search"; // 글쓰기 폼페이지 작성
	}

	// 7. 페이지간의 데이터 전송 & 받기 예제
	//    작업내용 : 폼페이지에서 넘겨온 값을 받아서 서비스단에 넘기기
	@RequestMapping(value="/mybatis/mybatisTest7End.action",method={RequestMethod.POST})
	public String mybatisTest7End(HttpServletRequest req){

		//1. 폼페이지에서 넘겨온 값 회원번호를 서비스단으로 넘긴다.

		String no = req.getParameter("no");

		//3. service 단으로 생성된 DTO(VO)를 넘긴다.
		String name = service.mbt7(no);

		req.setAttribute("no", no);
		req.setAttribute("name", name);
		
		return "searchEnd"; // 글쓰기 폼페이지 작성
	}	
	
	
	// 8. 데이터 불러오기
	// -- 작업내용 : 회원조회 폼 페이지 ==> 서브밋을 하면 검색조건에 맞는 내용을 DB에서 Select해서 웹페이지에 보여지도록 한다.	
	@RequestMapping(value="/mybatis/mybatisTest8.action",method={RequestMethod.GET})
	public String mybatisTest8(){

		return "search2"; // 글쓰기 폼페이지 작성
	}

	// 8. 페이지간의 데이터 전송 & 받기 예제
	//    작업내용 : 폼페이지에서 넘겨온 값을 받아서 서비스단에 넘기기
	@RequestMapping(value="/mybatis/mybatisTest8End.action",method={RequestMethod.POST})
	public String mybatisTest8End(HttpServletRequest req){

		//1. 폼페이지에서 넘겨온 값 회원번호를 서비스단으로 넘긴다.

		String no = req.getParameter("no");

		//3. service 단으로 생성된 DTO(VO)를 넘긴다.
		if (no != null && !no.trim().isEmpty()) {
			MybatisTestVO vo = service.mbt8(no);

			req.setAttribute("vo", vo);
		}

		return "searchEnd2"; // 글쓰기 폼페이지 작성
	}
	
	// 9. 데이터 불러오기
	// -- 작업내용 : 회원조회 폼 페이지 ==> 서브밋을 하면 검색조건에 맞는 내용을 DB에서 Select해서 웹페이지에 보여지도록 한다.	
	@RequestMapping(value="/mybatis/mybatisTest9.action",method={RequestMethod.GET})
	public String mybatisTest9(){

		return "search3"; // 글쓰기 폼페이지 작성
	}

	// 9. 페이지간의 데이터 전송 & 받기 예제
	//    작업내용 : 폼페이지에서 넘겨온 값을 받아서 서비스단에 넘기기
	@RequestMapping(value="/mybatis/mybatisTest9End.action",method={RequestMethod.POST})
	public String mybatisTest9End(HttpServletRequest req){

		//1. service 단으로  넘긴다.
		//   service 단에서 돌려받은 데이터타입은
		//   VO객체가 여러개가 저장된 List타입니다.
		List<MybatisTestVO> memberList = service.mbt9();
		
		// view단으로 결과물을 넘긴다.
		req.setAttribute("memberList", memberList);

		return "searchEnd3"; // 글쓰기 폼페이지 작성
	}
	
	
	// 10. 데이터 불러오기
	// -- 작업내용 : 회원조회 폼 페이지 ==> 서브밋을 하면 검색조건에 맞는 내용을 DB에서 Select해서 웹페이지에 보여지도록 한다.
	// DB테이블에 있는 컬럼명과 VO의 멤버변수명이 다를 경우 resultMap을 사용하여 해결한다.
	@RequestMapping(value="/mybatis/mybatisTest10.action",method={RequestMethod.GET})
	public String mybatisTest10(){

		return "search4"; // 글쓰기 폼페이지 작성
	}

	// 10. 페이지간의 데이터 전송 & 받기 예제
	//    작업내용 : 폼페이지에서 넘겨온 값을 받아서 서비스단에 넘기기
	@RequestMapping(value="/mybatis/mybatisTest10End.action",method={RequestMethod.POST})
	public String mybatisTest10End(HttpServletRequest req){

		//1. service 단으로  넘긴다.
		//   service 단에서 돌려받은 데이터타입은
		//   VO객체가 여러개가 저장된 List타입니다.
		List<MybatisTestVO> memberList = service.mbt10();

		// view단으로 결과물을 넘긴다.
		req.setAttribute("memberList", memberList);

		return "searchEnd4"; // 글쓰기 폼페이지 작성
	}
	
	
	// 11. 데이터 불러오기
	// -- 작업내용 : 회원조회 폼 페이지 ==> 서브밋을 하면 검색조건에 맞는 내용을 DB에서 Select해서 웹페이지에 보여지도록 한다.
	// DB테이블에 있는 컬럼명과 VO의 멤버변수명이 다를 경우 resultMap을 사용하여 해결한다.
	// xml에서 select 문을 쓸 때 컬럼명에 대한 alias명을 VO의 property명으로 사용하여 해결한다.
	@RequestMapping(value="/mybatis/mybatisTest11.action",method={RequestMethod.GET})
	public String mybatisTest11(){

		return "search5"; // 글쓰기 폼페이지 작성
	}

	// 11. 페이지간의 데이터 전송 & 받기 예제
	//    작업내용 : 폼페이지에서 넘겨온 값을 받아서 서비스단에 넘기기
	@RequestMapping(value="/mybatis/mybatisTest11End.action",method={RequestMethod.POST})
	public String mybatisTest11End(HttpServletRequest req){

		//1. service 단으로  넘긴다.
		//   service 단에서 돌려받은 데이터타입은
		//   VO객체가 여러개가 저장된 List타입니다.
		List<MybatisTestVO> memberList = service.mbt11();

		// view단으로 결과물을 넘긴다.
		req.setAttribute("memberList", memberList);

		return "searchEnd5"; // 글쓰기 폼페이지 작성
	}
	
	// 12. 데이터 불러오기
	// -- 작업내용 : 회원조회 폼 페이지 ==> 서브밋을 하면 검색조건에 맞는 내용을 DB에서 Select해서 웹페이지에 보여지도록 한다.
	//컬럼 1개짜리 다중행을 추출하도록 해본다.
	// VO를 사용해도 되지만 컬럼 1개짜리를 위해 굳이 생성하는 것보다
	// SQL문에서 || 를 이용하여 리턴타입을 String으로 사용하는 것이 편하다.
	@RequestMapping(value="/mybatis/mybatisTest12.action",method={RequestMethod.GET})
	public String mybatisTest12(){

		return "search6"; // 글쓰기 폼페이지 작성
	}

	// 12. 페이지간의 데이터 전송 & 받기 예제
	//    작업내용 : 폼페이지에서 넘겨온 값을 받아서 서비스단에 넘기기
	@RequestMapping(value="/mybatis/mybatisTest12End.action",method={RequestMethod.POST})
	public String mybatisTest12End(HttpServletRequest req){

		//1. form 페이지에서 넘어온 값을 받는다.
		String name = req.getParameter("name");
		
		//2. 서비스단으로 넘긴다.
		//   서비스단에서 돌려받는 데이터 타입은 string이 여러개 저장된 List타입이다.
		List<String> memberList = service.mbt12(name);

		// view단으로 결과물을 넘긴다.
		req.setAttribute("memberList", memberList);

		return "searchEnd6"; // 글쓰기 폼페이지 작성
	}
	
	// 13. 데이터 불러오기
	// 중요함------------------------
	// 추출된 결과물에서 검색조건에 해당하는 컬럼명을 선택하고
	// 그 컬럼명에 대한 검색어를 입력한 후 데이터를 추출하도록 한다.
	@RequestMapping(value="/mybatis/mybatisTest13.action",method={RequestMethod.GET})
	public String mybatisTest13(){

		return "search7"; // 글쓰기 폼페이지 작성
	}

	// 13. 페이지간의 데이터 전송 & 받기 예제
	//    작업내용 : 폼페이지에서 넘겨온 값을 받아서 서비스단에 넘기기
	@RequestMapping(value="/mybatis/mybatisTest13End.action",method={RequestMethod.GET})
	public String mybatisTest13End(HttpServletRequest req){
		
		//1. form에서 넘겨온 값을 받는다.
		String colName = req.getParameter("colName");
		String searchWord = req.getParameter("searchWord");
		
		if (searchWord != null) {
			searchWord = searchWord.trim();
		}
		
		//2. 서비스단으로 넘긴다.
		//   파라미터로 넘어가야 할 값들이 여러개라면 HashMap으로 넘긴다.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("colName", colName);
		map.put("searchWord", searchWord);
		
		List<MybatisTestVO> memberList = service.mbt13(map);

		// view단으로 결과물을 넘긴다.
		req.setAttribute("memberList", memberList);
		
		if (colName != null && searchWord != null) {
			req.setAttribute("colName", colName);
			req.setAttribute("searchWord", searchWord);
			
		}

		return "searchEnd7"; // 글쓰기 폼페이지 작성
	}
	//완료
}
























