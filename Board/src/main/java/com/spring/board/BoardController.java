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
import com.spring.board.model.CommentVO;
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
	//public String add(){
		
	// #76. 답변 글쓰기가 추가되었으므로 먼저 위의 메서드를 주석처리한다.
	public String add(HttpServletRequest req){
		
		String fk_seq = req.getParameter("fk_seq");
		String groupno = req.getParameter("groupno");
		String depth = req.getParameter("depth");
		
		req.setAttribute("fk_seq", fk_seq);
		req.setAttribute("groupno", groupno);
		req.setAttribute("depth", depth);
		
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
		
		// #66. 페이징 처리하기
		// 글목록 보기 페이지 요청은 URL 형태에 페이징 처리를 띄는 것으로 만들어주어야한다
		// 즉, 예를 들면 3페이지의 내용을 보고자 한다라면 /board/list.action?pageNo=3과 같이 해주어야한다
		
		String pageNo = req.getParameter("pageNo");
		
		int totalCount = 0;   // 총게시물 건수
		int sizePerPage = 10;  // 한 페이지당 보여줄 게시물 수
		int currentShowPageNo = 1; // 현재 보여주는 페이지 번호
		int totalPage = 0; // 총 페이지 수(웹브라우저 상에 보여줄 총 페이지 갯수)
		
		int start = 0;	// 시작 행 번호
		int end = 0;	// 끝 행 번호
		int startPageNo = 0; // 페이지바에서 시작될 페이지 번호입니다.
		
		int loop = 0; // startPageNo 값이 증가할 때 마다 1씩 증가한다.
		int blocksize = 5; // 페이지바에 보여줄 갯수
		
		if (pageNo == null) {
			// 게시판 초기화면에 보여지는 것은 req.getparameter("pageNo"); 값이 없으므로 pageNo는 null이 된다.
			currentShowPageNo = 1;
		}
		else {
			currentShowPageNo = Integer.parseInt(pageNo);
			// GET 방식으로 파라미터 pageNo에 넘어온 값을 현재 보여주고자 하는 페이지로 정한다.
		}
		
		// **** 가져올 게시글의 범위를 구한다. ***** ----- 
		start = ((currentShowPageNo - 1) * sizePerPage) + 1;
		end = start + sizePerPage - 1;
		
		// #33. 글 조회수 증가는 반드시 해당 글제목을 클릭했을때만 증가되고 웹브라우저에서 새로고침을 했을 경우에는
			//  증가되지 않도록 하겠다 이를 위해 session을 사용한다.
		// session에 readCountCheck 키값으로 저장된 밸류값은 "no"이고 이를 얻기 위해서는
		// 반드시 웹브라우저 주소창에 /list.action이라고 입력해야만 얻을 수 있다.
		
		//List<BoardVO> contentList = service.list();
		// #62. 검색어가 포함되었으므로 먼저 위의 부분을 주석처리한다.
		String colname = req.getParameter("colname");
		String search = req.getParameter("search");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("colname", colname);
		map.put("search", search);
		
		// #67. 페이징처리를 위해 start,end를 map에 추가하여 파라미터로 넘겨서 select되도록 한다.
		map.put("start", String.valueOf(start));
		map.put("end", String.valueOf(end));
		
		List<BoardVO> contentList = service.list(map);
		
		// #69. 페이징 작업의 계속(페이지바에 나타낼 총 페이지 갯수 구하기)
		// 검색 조건이 없을 때  --> colname과 search가 값이 null
		// 검색 조건이 있을 때  --> colname과 search가 값이 있음
		totalCount = service.getTotalCount(map);
		
		totalPage = (int)Math.ceil((double)totalCount/sizePerPage);
		
		String pagebar = "";
		pagebar += "<ul>";
		
		loop = 1;
		
		// 페이지바의 시작 페이지 번호 값 만들기
		startPageNo = ((currentShowPageNo - 1 ) / blocksize ) * blocksize + 1;
		
		if ((colname == null || search == null) && (startPageNo - blocksize) > 0) {
			pagebar += String.format("&nbsp;<a href='list.action?pageNo=%d'>[이전 %d페이지]</a>", startPageNo - blocksize, blocksize);
		}
		else if((startPageNo - blocksize) > 0){
			pagebar += String.format("&nbsp;<a href='list.action?pageNo=%d&colname=%s&search=%s'>[이전 %d페이지]</a>", startPageNo - blocksize, colname, search, blocksize);
		}
		
		while( !(loop > blocksize || startPageNo > totalPage ) ) {
			
			if (startPageNo == currentShowPageNo) {
				pagebar += String.format("&nbsp;<span style = 'color:red; font-weight:bold; text-decoration:underline;'>%d</span>", startPageNo);
			}
			else{
				if (colname == null || search == null) {
					pagebar += String.format("&nbsp;<a href='list.action?pageNo=%d'>%d</a>", startPageNo, startPageNo);
				}
				else{
					pagebar += String.format("&nbsp;<a href='list.action?pageNo=%d&colname=%s&search=%s'>%d</a>", startPageNo, colname, search, startPageNo);
				}
			}
			
			loop++;
			startPageNo++;
		}
		
		if ((colname == null || search == null) && startPageNo <= totalPage) {
			pagebar += String.format("&nbsp;<a href='list.action?pageNo=%d'>[다음 %d페이지]</a>", startPageNo, blocksize);
		}
		else if(startPageNo <= totalPage){
			pagebar += String.format("&nbsp;<a href='list.action?pageNo=%d&colname=%s&search=%s'>[다음 %d페이지]</a>", startPageNo, colname, search, blocksize);
		}
		
		pagebar += "</ul>";
		
		req.setAttribute("contentList", contentList);
		req.setAttribute("colname", colname);
		req.setAttribute("search", search);
		
		req.setAttribute("pagebar", pagebar);
		
		return "list";
	}
	
	// #29. 글 1개 자세히 보여주기
	@RequestMapping(value = "/view.action", method = {RequestMethod.GET})
	public String view(HttpServletRequest req, HttpSession session){
		
		String seq = req.getParameter("seq");
		String readCountCheck = req.getParameter("readCountCheck");
		System.out.println(seq + " // " + readCountCheck);
		BoardVO vo = null;
		
		vo = service.getView(seq, readCountCheck);
		
		/*
		 	글내용에 엔터(\r\n)가 들어가있으면 
		 	엔터를 <br/>로 대체시켜서 request 영역으로 넘긴다.
		 */
		String content = vo.getContent();
		content = content.replaceAll("\r\n", "<br/>");
		
		vo.setContent(content);
		
		req.setAttribute("vo", vo);
		
		// #52. 댓글 내용 가져오기
		List<CommentVO> commentList = service.listComment(seq);
		
		req.setAttribute("commentList", commentList);
		
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
	
	
	// #40. 글 삭제하기 전에 암호 확인하기
	@RequestMapping(value = "/del.action", method = {RequestMethod.GET})
	public String del(HttpServletRequest req){
		
		String seq = req.getParameter("seq");
		
		BoardVO vo = service.getView(seq, "yes");
		
		req.setAttribute("vo", vo);
		
		return "del";
	}
	
	// #41. 글 삭제하기
	@RequestMapping(value = "/delEnd.action", method = {RequestMethod.POST})
	public String delEnd(HttpServletRequest req, BoardVO vo) throws Throwable{
		
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("seq", vo.getSeq());
		map.put("pw", vo.getPw());
		
		int result = service.delContent(map);
		
		req.setAttribute("seq", vo.getSeq());
		req.setAttribute("result", result);
		
		return "delEnd";
	}
	
	// #46. 댓글쓰기
	@RequestMapping(value = "/addComment.action", method = {RequestMethod.POST})
	public String addComment(CommentVO vo, HttpServletRequest req) throws Throwable{
		
		int result = service.addComment(vo);
		
		if (result != 0) {
			// 댓글 쓰기와 원게시물에 댓글의 갯수 업데이트가 성공한다면
			req.setAttribute("msg", "댓글쓰기 완료!!");
		}
		if (result == 0){
			// 댓글 쓰기와 원게시물에 댓글의 갯수 업데이트가 실패한다면
			req.setAttribute("msg", "댓글쓰기 실패!!");
		}
		
		String seq = vo.getParentSeq();
		req.setAttribute("seq", seq);
		
		return "addCommentEnd";
	}
}
