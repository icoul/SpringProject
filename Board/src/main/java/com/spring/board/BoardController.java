package com.spring.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
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
	private FileManager fileManager;
	
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
	public String addEnd(BoardVO vo, MultipartHttpServletRequest req, HttpSession session){
		/*
		       사용자가 쓴 글에 파일이 첨부가 된것이지 
		       아니면 파일첨부가 안된것인지 구분을 지어주어야 한다.
		 */
		// **** 첨부파일이 있는지 없는지 ? ****
		if(!vo.getAttach().isEmpty()) {
			// attach가 비어있지 않다면(즉, 첨부파일이 있는 경우라면)

			/*
			   1. 사용자가 보낸 파일을 WAS(톰캣)의 특정 폴더에 저장해주어야 한다.
			   >>>> 파일이 업로드 되어질 특정 경로(폴더)지정해주기
			        우리는 WAS 의 webapp/resources/files 라는 폴더로 지정해준다.
			 */

			// WAS 의 webapp 의 절대경로를 알아와야 한다. 
			String root = session.getServletContext().getRealPath("/"); 
			String path = root + "resources"+File.separator+"files";
			// path 가 첨부파일들을 저장할 WAS(톰캣)의 폴더가 된다. 

			System.out.println(">>>> 확인용 path ==> " + path); 
			// >>>> 확인용 path ==> C:\springworkspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Board\resources\files 


			// 2. 파일첨부를 위한 변수의 설정 및 값을 초기화한 후 파일올리기
			String newFileName = "";
			// WAS(톰캣) 디스크에 저장할 파일명 

			byte[] bytes = null;
			// 첨부파일을 WAS(톰캣) 디스크에 저장할때 사용되는 용도 

			long fileSize = 0;
			// 파일크기를 읽어오기 위한 용도

			try {
				bytes = vo.getAttach().getBytes(); 
				// getBytes()는 첨부된 파일을 바이트단위로 파일을 다 읽어오는 것이다. 
				/* 2-1. 첨부된 파일을 읽어오는 것
					    첨부한 파일이 강아지.png 이라면
					    이파일을 WAS(톰캣) 디스크에 저장시키기 위해
					    byte[] 타입으로 변경해서 받아들인다.
				 */ 
				newFileName = fileManager.doFileUpload(bytes, vo.getAttach().getOriginalFilename(), path);
				/* 2-2. 첨부한 파일의 확장자명을 알려고 아래와 같이 한다.
				        vo.getAttach().getOriginalFilename() 은 첨부파일의 파일이름을 말한다.
				        예를 들어, 강아지.png 을 첨부파일로 올리면
				        vo.getAttach().getOriginalFilename() 이 String 타입으로 "강아지.png" 을 얻어오는 것이다. 
				        그리고 마지막 fileManager.doFileUpload() 메소드에서
				        마지막 . 을 기준으로 그 나머지 글자만 취해오도록 되어있다. 
				        즉, .png 라는 확장자만 얻어온다.
				 */

				System.out.println(">>>> 확인용 newFileName ==> " + newFileName); 

				// 3. BoardVO vo 에 fileName 값과 orgFilename 값과 fileSize 값을 넣어주기 
				vo.setFileName(newFileName);
				// WAS(톰캣)에 저장될 파일명(20161121324325454354353333432.png) 

				vo.setOrgFileName(vo.getAttach().getOriginalFilename());
				// 진짜 파일명(강아지.png)
				// 사용자가 파일을 업로드 하거나 파일을 다운로드 할때 사용되어지는 파일명 

				fileSize = vo.getAttach().getSize();
				// 첨부한 파일의 파일크기인데 리턴타입이 long 타입이다.

				vo.setFileSize(String.valueOf(fileSize));
				// 첨부한 파일의 크기를 String 타입으로 변경해서 저장함.

			} catch (Exception e) {

			}

		}

		//	int n = service.add(vo);

		/*	#99. 파일첨부가 없는 경우 또는 파일첨부가 있는 경우
	         Service 단으로 호출하기
	         먼저 위의 int n = service.add(vo); 부분을
	         주석처리하고서 아래처럼 한다.
		 */
		int n = 0;
		if(vo.getAttach().isEmpty()) {
			// 파일첨부가 없다면
			n = service.add(vo);
		}

		if(!vo.getAttach().isEmpty()) {
			// 파일첨부가 있다면
			n = service.add_withFile(vo);
		}
		
		req.setAttribute("n", n);
		
		return "addEnd";
	}
	
	// #90. 다운로드
	@RequestMapping(value="/download.action", method = {RequestMethod.GET})
	public void download(HttpServletRequest req, HttpServletResponse res , HttpSession session){
		
		String seq = req.getParameter("seq");
		String readCountCheck = "yes";
		
		BoardVO vo = service.getView(seq, readCountCheck);
		// 조회수 증가 없이 가져오기?
		
		String fileName = vo.getFileName();
		String orgFileName = vo.getOrgFileName();
		
		// 첨부파일이 저장되어있는 WAS의 디스크 경로명을 알아와야만 다운로드를 해줄 수 있다.
		// WAS 의 webapp 의 절대경로를 알아와야 한다. 
		String root = session.getServletContext().getRealPath("/"); 
		String path = root + "resources"+File.separator+"files";
		// path 가 첨부파일들을 저장할 WAS(톰캣)의 폴더가 된다. 
		System.out.println(path);
		
		// 다운로드 실패시 메세지를 띄워주기 위해서 boolean으로 한다.
		boolean flag = false;
		
		fileManager.doFileDownload(fileName, orgFileName, path, res);
		// 다운로드가 성공이면 true, 실패하면 false		
		
		if (!flag) {
			res.setContentType("text/html; charset=UTF-8;");
			PrintWriter writer = null;
			
			try{
				writer = res.getWriter();
			} catch(IOException e){
			}
			
			writer.println("<script type = 'text/javascript'>alert('파일 다운로드가 실패했습니다');</script> ");
		}
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
	
	// 검색 자동완성
	@RequestMapping(value = "/wordSearchShow.action", method = {RequestMethod.POST})
	public String wordSearchShow(HttpServletRequest req){
		
		String colname = req.getParameter("colname");
		String search = req.getParameter("search");
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("colname", colname);
		map.put("search", search);
		
		List<HashMap<String, String>> searchWordCompleteList = service.searchWordCompleteList(map);
		
		req.setAttribute("colname", colname);
		req.setAttribute("searchWordCompleteList", searchWordCompleteList);
		
		return "ajax/wordSearchShow";
	}
	
	// JSON을 이용하여 조회수 랭킹 보여주기
	@RequestMapping(value = "/listRankN.action", method = {RequestMethod.GET})
	public String listRankN(HttpServletRequest req){
		
		String rankN = req.getParameter("rankN");
		List<BoardVO> rankList = service.getRankN(rankN);
		// 오라클 데이터베이스에서 조회수가 1등부터 5등까지 또는 1등부터 10등까지인 데이터를 넘겨받아서
		// ajax로 요청한 곳(list.jsp)으로 넘겨줄 때는 데이터타입이 JSON 형태로 넘겨주어야한다.
		// 그래서 아래처럼 JSONObject타입의 List로 넘겨준다.
		
		List<JSONObject> jsonObjectList = new ArrayList<JSONObject>();
		for(BoardVO vo : rankList){
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("seq", vo.getSeq());
			jsonObj.put("name", vo.getName());
			jsonObj.put("subject", vo.getSubject());
			jsonObj.put("readCount", vo.getReadCount());
			jsonObj.put("regDate", vo.getRegDate());
			
			jsonObjectList.add(jsonObj);
		}
		
		/*
		 * [{"subject":"안녕하세요","name":"송중기","regDate":"2016-11-22 09:57:53","readCount":"10","seq":"93"}, 
		 * {"subject":"일단 써보겠습니다","name":"송중기","regDate":"2016-11-22 09:43:46","readCount":"10","seq":"92"}, 
		 * {"subject":"시험","name":"설현","regDate":"2016-11-21 10:14:15","readCount":"4","seq":"28"}, 
		 * {"subject":"첫 글입니다.","name":"홍길동","regDate":"2016-11-21 10:00:25","readCount":"4","seq":"21"}, 
		 * {"subject":"구길동입니다.","name":"구길동","regDate":"2016-11-21 12:27:02","readCount":"3","seq":"90"}, 
		 * {"subject":"첫 글입니다.","name":"하정훈","regDate":"2016-11-21 10:09:36","readCount":"3","seq":"26"}, 
		 * {"subject":"팔길동입니다.","name":"팔길동","regDate":"2016-11-21 12:27:02","readCount":"2","seq":"89"}, 
		 * {"subject":"퇴사각","name":"홍길동","regDate":"2016-11-22 14:55:17","readCount":"1","seq":"94"}, 
		 * {"subject":"일단 써보겠습니다","name":"김영호","regDate":"2016-11-21 20:31:42","readCount":"1","seq":"91"}, 
		 * {"subject":"삼길동입니다.","name":"삼길동","regDate":"2016-11-21 12:27:02","readCount":"1","seq":"84"}]
		 */
		
		req.setAttribute("jsonObjectList", jsonObjectList);
		
		return "ajax/listRankN";
	}
}
