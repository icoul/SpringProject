package com.spring.board.model;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// #15. DAO 선언
@Repository
public class BoardDAO implements InterBoardDAO {
	
	// #16. 의존객체주입
	@Autowired //의존객체주입(DI : Dependency Injection) 
	private SqlSessionTemplate sqlsession;
	
	// #23. 글쓰기 메서드
	@Override
	public int add(BoardVO vo){
		
		int n = sqlsession.insert("board.add",vo);
		
		return n;
	} // end of add(BoardVO vo) -------------------------------------------------------
	
	// #27. 글 목록 가져오기
	/*  @Override
		public List<BoardVO> list(){
			
			List<BoardVO> contentList = sqlsession.selectList("board.list");
			
			return contentList;
		} // end of List<BoardVO> list() -----------------------------------------------------
	*/	
	
	//#64. 글목록 가져오기 (검색어가 있음)
	@Override
	public List<BoardVO> list(HashMap<String,String> map){
		
		List<BoardVO> contentList = sqlsession.selectList("board.list", map);
		
		return contentList;
	} // end of list(HashMap<String,String> map) ----------------------------------
	
	//#71. 페이징 처리에 필요한 글 갯수 구하기
	@Override
	public int getTotalCount(HashMap<String,String> map) {
		
		int totalCount = sqlsession.selectOne("board.getTotalCount", map);
		
		return totalCount;
	} // end of getTotalCount(HashMap<String,String> map) ----------------------------------
	
	//#31. 글 1개만 가져오는 메서드
	@Override
	public BoardVO getView(String seq, String readCountCheck){
		
		if ("no".equals(readCountCheck)) {
			sqlsession.update("board.updateReadCount", seq);
		}
		
		BoardVO vo = sqlsession.selectOne("board.view", seq);
		
		return vo;
	} // end of getView(String seq)--------------------------------------------------------
	
	
	//#36. 글 수정 및 삭제 시 비밀번호 체크 메서드
	@Override
	public boolean checkPW(HashMap<String,String> map){
		
		int n = sqlsession.selectOne("board.checkPW", map);
		boolean result = false;
		
		if (n > 0) {
			result = true;
		}
		
		return result;		
	}// end of checkPW(HashMap<String,String> map)--------------------------------------------------------
	
	// #37. 글 수정 메서드
	@Override
	public int updateContent(HashMap<String,String> map){
		
		int result = sqlsession.update("board.updateContent", map);
		
		return result;
	}// end of updateContent(HashMap<String,String> map)--------------------------------------------------------
	
	//#43. 글 삭제 메서드
	@Override
	public int delContent(HashMap<String, String> map) {

		int result = sqlsession.update("board.delContent", map);
		
		return result;
	}// end of delContent(HashMap<String, String> map)-------------------------------------------------------

	//#48. 댓글입력
	@Override
	public int addComment(CommentVO vo) {

		int result = sqlsession.insert("board.addComment", vo);
		
		return result;
	}// end of addComment(CommentVO vo)----------------------------------------------------
	
	//#49. 댓글 작성 시 게시글 테이블에 댓글 갯수 추가
	@Override
	public int updateCommentCount(String parentSeq) {
		
		int result = sqlsession.update("board.updateCommentCount", parentSeq);
		
		return result;
	}// end of updateCommentCount(String parentSeq)---------------------------------------------------
	
	// #54. 댓글 리스트 가져오기
	@Override
	public List<CommentVO> listComment(String seq) {

		List<CommentVO> commentList = sqlsession.selectList("board.listComment", seq);
		
		return commentList;
	} // end of List<CommentVo> listComment() -------------------------------------------------------
	
	// #59. 해당 글에 댓글이 존재하는지 확인 
	@Override
	public int isExistsComment(HashMap<String, String> map) {
		
		int result = sqlsession.selectOne("board.isExistsComment", map);
		
		return result;
	}
	
	// #59. 댓글 삭제 
	@Override
	public int delComment(HashMap<String, String> map) {
		
		int result = sqlsession.update("board.delComment", map);
		
		return result;
	}
}
