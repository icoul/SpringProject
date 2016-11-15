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
	@Override
	public List<BoardVO> list(){
		
		List<BoardVO> contentList = sqlsession.selectList("board.list");
		
		return contentList;
	} // end of List<BoardVO> list() -----------------------------------------------------
	
	
	//#31. 글 개만 가져오는 메서드
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
	}
	
	// #37. 글 수정 메서드
	@Override
	public int updateContent(HashMap<String,String> map){
		
		int result = sqlsession.update("board.updateContent", map);
		
		return result;
	}
}
