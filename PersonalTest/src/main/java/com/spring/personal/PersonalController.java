package com.spring.personal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.personal.model.BoardVO;
import com.spring.personal.service.InterPersonalService;

@Controller
public class PersonalController {
	
	@Autowired
	private InterPersonalService service;
	
	@RequestMapping(value="/test.action", method={RequestMethod.GET})
	public String test(HttpServletRequest req){
		
		List<BoardVO> boardList = service.getMemo();
		
		req.setAttribute("boardList", boardList);
		
		return "test";
	}
	
	@RequestMapping(value="/testEnd.action", method={RequestMethod.GET})
	public String testEnd(){
		
		return "testEnd";
	}
}