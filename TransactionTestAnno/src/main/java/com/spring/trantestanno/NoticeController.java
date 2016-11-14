package com.spring.trantestanno;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.trantestanno.model.NoticeVO;
import com.spring.trantestanno.service.InterNoticeService;

//#13. 컨트롤러 선언
@Controller
public class NoticeController {
	
	@Autowired // 의존객체주입(DI : Dependency Injection)
	private InterNoticeService service;
	
		
	// 글쓰기 요청
	@RequestMapping(value="/add.action", method={RequestMethod.GET} ) 
	public String add() {
		return "add";
	}
	
	
	// 글쓰기 완료 요청
    @RequestMapping(value="/addEnd.action", method={RequestMethod.POST} ) 
    public String addEnd(NoticeVO ntvo, HttpServletRequest req, HttpServletResponse res) 
    		throws Throwable {
	   
	   // Service 단으로 값을 넘긴다.
   		  int result = service.add(ntvo);
    	  req.setAttribute("result", result); // 키값 result 정의
    	  return "addEnd";
    }
    
    
    /*
     @ExceptionHandler
     ==> 어떤 컨트롤러내에서 발생하는 익셉션이 있을시 익셉션 처리를 하려고 한다라면
         @ExceptionHandler 어노테이션을 적용한 메소드를 구현해주면 된다
          
            컨트롤러내에서 @ExceptionHandler 어노테이션을 적용한 메소드가 존재하면, 
            스프링은 익셉션 발생시 그 메소드가 익셉션을 처리하도록 한다.
            따라서, 컨트롤러에 발생한 익셉션을 직접 처리하고 싶다면 @ExceptionHandler 어노테이션을 적용한 메소드를 구현해주면 된다.
     */
    
    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(org.springframework.dao.DataIntegrityViolationException e, HttpServletRequest req, HttpServletResponse res) {
    	
    	String msg = "포인트가 최대치가 되어서 글쓰기가 취소되었습니다.";
		String loc = "/trantestanno/list.action";
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		
		return "msg";
    }
    
    
	
    // 글목록 보기
 	@RequestMapping(value="/list.action", method={RequestMethod.GET} ) 
 	public String list(HttpServletRequest req) {
 		
 		List<HashMap> list = service.list();
 		
 		req.setAttribute("list", list);
 		
 		return "list";
 	}
    
	
}
