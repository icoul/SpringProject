package com.spring.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.board.model.BoardDAO;
import com.spring.board.model.BoardVO;
import com.spring.board.model.CommentVO;
import com.spring.board.model.ListVO;

//#14. Service 선언
@Service
public class BoardService implements InterBoardService {
	
	//#17. 의존객체주입
	@Autowired 
	private BoardDAO dao;
	
	//#22. 글쓰기 메서드
	@Override
	public int add(BoardVO vo) {
		/*#78. 이 글쓰기가 원글쓰기인지 아니면 답변글쓰기인지 알아낸 후 입력한다.
		 * 	     원글쓰기라면 tblBoard테이블의 groupno컬럼의 값은 max값+1 이고
		 *     답변글쓰기라면 넘겨받은 값 그대로 insert해준다.*/
		System.out.println("ddd"+vo.getFk_seq());
		// 원글인지 답글인지 구분하기
		if (vo.getFk_seq() == null || vo.getFk_seq().trim().isEmpty() ) {
			// 원글
			int groupno_int = dao.getGroupMaxno() + 1;
			String groupno = String.valueOf(groupno_int);
			vo.setGroupno(groupno);
		}
		
		int n = dao.add(vo);
		
		return n;
		
	} //end of add(BoardVO vo)-------------------------
	
	//#26. 글목록 가져오기
	/*  @Override
		public List<BoardVO> list(){
			
			List<BoardVO> contentList = dao.list();
			
			return contentList;
		} // end of list ----------------------------------
	*/
	
	// 페이징 처리에 필요한 값을 가져오는 메서드
	@Override
	public ListVO getListVO(HashMap<String, String> map, String pageNo) {
		
		ListVO lvo = dao.getListVO(map, pageNo);
		
		return lvo;
	}
	
	//#63. 글목록 가져오기 (검색어가 있음)
	@Override
	public List<BoardVO> list(HashMap<String,String> map){
		
		List<BoardVO> contentList = dao.list(map);
		
		return contentList;
	} // end of list(HashMap<String,String> map) ----------------------------------
	
	//#30. 글 1개만 가져오는 메서드
	@Override
	public BoardVO getView(String seq, String readCountCheck){
		BoardVO vo = dao.getView(seq, readCountCheck);
		
		return vo;
	}// end of getView(String seq)--------------------------------------------------------
	
	//#35. 글 수정 메서드
	@Override
	public int edit(HashMap<String,String> map){
		
		boolean checkpw = dao.checkPW(map);
		int result = 0;
		
		if (checkpw) {
			result = dao.updateContent(map);
		}
		
		return result;
	} // end of  edit(HashMap<String,String> map)-------------------------------------------------------
	
	//#42. 글 삭제 메서드
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor={Throwable.class})
	public int delContent(HashMap<String, String> map) throws Throwable {

		boolean checkpw = dao.checkPW(map);
		int count = 0;
		int result = 0;
		int result2 = 0;
		int n = 0;
		
		if (checkpw) {
			// #58. 원게시글에 딸린 댓글이 있는지 확인하기
			count = dao.isExistsComment(map);
			
			result = dao.delContent(map); // 글 1개 삭제하기
			
			if (count > 0) {
				result2 = dao.delComment(map); // 원게시글에 딸린 댓글들 삭제하기
			}
		}
		
		if ((result > 0 && count > 0 && result2 > 0) || (result > 0 && count > 0)) {
			n = 1;
		}
		
		return n;
	}

	//#47. Transaction 처리하기
	//tblComment 테이블에 insert 된 다음에 
	//tblBoard 테이블에 commentCount 컬럼이 1증가하도록 요청한다
	//2개 이상의 DML 처리를 해야하므로 Transaction처리를 한다.
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor={Throwable.class})
	public int addComment(CommentVO vo) throws Throwable {

		int result = 0;
		
		int n = dao.addComment(vo);
		
		if (n == 1) {
			result = dao.updateCommentCount(vo.getParentSeq());
		}
		
		return result;
	} // end of addComment(CommentVO vo) -------------------------------------------------
	
	// #53. 댓글 리스트 가져오기
	@Override
	public List<CommentVO> listComment(String seq) {

		List<CommentVO> commentList = dao.listComment(seq);
		
		return commentList;
	} // end of List<CommentVo> listComment() -------------------------------------------------------
}
