package com.spring.board;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.board.model.BoardVO;
import com.spring.board.model.CommentVO;
import com.spring.board.model.ListVO;
import com.spring.board.service.InterBoardService;
import com.spring.common.FileManager;

// #13. 컨트롤러 선언
@Controller
public class BoardController {
	
	// #18. 의존객체주입(DI : Dependency Injection)
	@Autowired 
	private InterBoardService service; 
	
	// #86. FileManager 의존 객체 주입
	@Autowired
	private FileManager fManager;
	
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
	public String addEnd(BoardVO vo, MultipartHttpServletRequest req){
		int n = service.add(vo);
		
		req.setAttribute("n", n);
		
		return "addEnd";
	}
	
	// #25. 글 목록 페이지 요청
	@RequestMapping(value="/list.action", method = {RequestMethod.GET})
	public String list(HttpServletRequest req, HttpSession session){
		
		// #62. 검색어가 포함되었으므로 먼저 위의 부분을 주석처리한다.
		String colname = req.getParameter("colname");
		String search = req.getParameter("search");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("colname", colname);
		map.put("search", search);
		
		// #66. 페이징 처리하기
		// 글목록 보기 페이지 요청은 URL 형태에 페이징 처리를 띄는 것으로 만들어주어야한다
		// 즉, 예를 들면 3페이지의 내용을 보고자 한다라면 /board/list.action?pageNo=3과 같이 해주어야한다
		
		String pageNo = req.getParameter("pageNo");
		
		if (pageNo == null) {
			// 게시판 초기화면에 보여지는 것은 req.getparameter("pageNo"); 값이 없으므로 pageNo는 null이 된다.
			pageNo = "1";
		}
		
		ListVO lvo = service.getListVO(map, pageNo);
		
		int currentShowPageNo = lvo.getCurrentShowPageNo();		// 현재 보여주는 페이지 번호
		int totalPage = lvo.getTotalPage(); 					// 총 페이지 수(웹브라우저 상에 보여줄 총 페이지 갯수)
		int startPageNo = lvo.getStartPageNo(); 				// 페이지바에서 시작될 페이지 번호입니다.
		int loop = lvo.getLoop(); 								// startPageNo 값이 증가할 때 마다 1씩 증가한다.
		int blocksize = lvo.getBlocksize();						// 페이지바에 보여줄 갯수
		
		String pagebar = "";
		pagebar += "<ul>";
		
		// 이전 페이지
		if ( (startPageNo - blocksize) > 0) {
			pagebar += String.format("&nbsp;<a href='#' onClick = 'getPagebar(%d)'>[이전 %d페이지]</a>", startPageNo - blocksize, blocksize);
		}
		
		// 페이지 번호
		while( !(loop > blocksize || startPageNo > totalPage ) ) {
			
			if (startPageNo == currentShowPageNo) {
				pagebar += String.format("&nbsp;<span style = 'color:red; font-weight:bold; text-decoration:underline;'>%d</span>", startPageNo);
			}
			else{
				pagebar += String.format("&nbsp;<a href='#' onClick = 'getPagebar(%d)'>%d</a>", startPageNo, startPageNo);
			}
			
			loop++;
			startPageNo++;
		}
		
		// 다음 페이지
		if (startPageNo <= totalPage) {
			pagebar += String.format("&nbsp;<a href='#' onClick = 'getPagebar(%d)'>[다음 %d페이지]</a>", startPageNo, blocksize);
		}
		
		pagebar += "</ul>";
		
		//-------------------------------------------------------------------------
		map.put("start", String.valueOf(lvo.getStart() ) );
		map.put("end", String.valueOf(lvo.getEnd() ) );
		
		List<BoardVO> contentList = service.list(map); // 전체 목록 가져오기
		
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
