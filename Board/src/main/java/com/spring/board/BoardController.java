package com.spring.board;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.board.model.BoardVO;
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
	
	// #21. 글쓰기 완료
	@RequestMapping(value="/addEnd.action", method={RequestMethod.POST})
	public String addEnd(BoardVO vo, HttpServletRequest req){
		
		int n = service.add(vo);
		
		req.setAttribute("n", n);
		
		return "addEnd";
	}
	
	// #25. 글 목록 페이지 요청
	@RequestMapping(value="/list.action", method = {RequestMethod.GET})
	public String list(HttpServletRequest req, HttpSession session){
		
		// #33. 글 조회수 증가는 반드시 해당 글제목을 클릭했을때만 증가되고 웹브라우저에서 새로고침을 했을 경우에는
			//  증가되지 않도록 하겠다 이를 위해 session을 사용한다.
		session.setAttribute("readCountCheck", "no");
		// session에 readCountCheck 키값으로 저장된 밸류값은 "no"이고 이를 얻기 위해서는
		// 반드시 웹브라우저 주소창에 /list.action이라고 입력해야만 얻을 수 있다.
		
		List<BoardVO> contentList = service.list();
		
		req.setAttribute("contentList", contentList);
		
		return "list";
	}
	
	// #29. 글 1개 자세히 보여주기
	@RequestMapping(value = "/view.action", method = {RequestMethod.GET})
	public String view(HttpServletRequest req, HttpSession session){
		
		String seq = req.getParameter("seq");
		String readCountCheck = (String)session.getAttribute("readCountCheck");
		BoardVO vo = null;
		
		vo = service.getView(seq, readCountCheck);
		
		/*
		 	글내용에 엔터(\r\n)가 들어가있으면 
		 	엔터를 <br/>로 대체시켜서 request 영역으로 넘긴다.
		 */
		String content = vo.getContent();
		content = content.replaceAll("\r\n", "<br/>");
		
		vo.setContent(content);
		
		session.setAttribute("readCountCheck", "yes");
		req.setAttribute("vo", vo);
		
		return "view";
	}
	
	
	// #34. 글 수정하기
	@RequestMapping(value = "/edit.action", method = {RequestMethod.GET})
	public String edit(HttpServletRequest req){
		
		String seq = req.getParameter("seq");
		
		BoardVO vo = service.getView(seq, "yes");
		
		req.setAttribute("vo", vo);
		
		return "edit";
	}
	
	// #36. 글 수정 완료하기
	@RequestMapping(value = "/editEnd.action", method = {RequestMethod.POST})
	public String editend(BoardVO vo, HttpServletRequest req){
		
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("seq", vo.getSeq());
		map.put("pw", vo.getPw());
		map.put("subject", vo.getSubject());
		map.put("content", vo.getContent());
		
		int result = service.edit(map); // 넘겨받은 값이 1이면 update 성공, 0이면 실패
		
		req.setAttribute("seq", vo.getSeq());
		req.setAttribute("result", result);
		
		return "editEnd";
	}
}
