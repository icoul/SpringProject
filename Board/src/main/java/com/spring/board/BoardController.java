package com.spring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.board.service.InterBoardService;

// #13. 컨트롤러 선언
@Controller
public class BoardController {
	
	// #18. 의존객체주입(DI : Dependency Injection)
	@Autowired 
	private InterBoardService service; 
	
	// #20. 글쓰기 폼페이지 요청
	// 지금은 다른 업무가 없으므로 JSP 폼 페이지만 요청한다.
	@RequestMapping(value="/add.action", method={RequestMethod.GET})
	public String add(){
		return "add";
	}
}
