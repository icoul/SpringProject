package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
/*
 	@Controller 어노테이션을 해주면 이것이 MyMVC에서 사용하던 Command.properties 파일의 역할에다가
 	controller 역할까지 해주는 것이다.
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloController {
	
	// URL 지정 ==> URL 1개에 메서드 1개가 매핑된다.
	@RequestMapping(value="/hello.action", method={RequestMethod.GET} )
	public String hello(HttpServletRequest req, HttpServletResponse res){
		
		// DB 연결작업은 생략
		
		req.setAttribute("name", "홍길동");
		req.setAttribute("age", 25);
		req.setAttribute("addr", "서울시 강남구 역삼동");
		
		return "hello";
		//뷰페이지 호출
		//servlet-context.xml에 정의해준 접두사, 접미사에 의해
		// /WEB-INF/views/hello.jsp
	}
}
