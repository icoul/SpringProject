package com.spring.board.model;

import java.util.HashMap;
import java.util.List;

// model단(DAO)의 인터페이스 생성
public interface InterBoardDAO {
	
	int add(BoardVO vo); // 파일 첨부가 없는 글쓰기
	List<BoardVO> list(); // 글 목록 받아오기
	BoardVO getView(String seq, String readCountCheck); // 글 1개만 받아오는 메서드
	boolean checkPW(HashMap<String,String> map); // 글 수정 및 삭제 시 암호가 일치하는지 여부확인 메서드
	int updateContent(HashMap<String,String> map); // 글 내용 수정 메서드
	
}
