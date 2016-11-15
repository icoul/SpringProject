package com.spring.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.model.BoardDAO;
import com.spring.board.model.BoardVO;

//#14. Service 선언
@Service
public class BoardService implements InterBoardService {
	
	//#17. 의존객체주입
	@Autowired 
	private BoardDAO dao;
	
	//#22. 글쓰기 메서드
	@Override
	public int add(BoardVO vo) {

		int n = dao.add(vo);
		
		return n;
		
	} //end of add(BoardVO vo)-------------------------
	
	//#26. 글목록 가져오기
	@Override
	public List<BoardVO> list(){
		
		List<BoardVO> contentList = dao.list();
		
		return contentList;
	} // end of list ----------------------------------
	
	//#30. 글 개만 가져오는 메서드
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
	}
}
