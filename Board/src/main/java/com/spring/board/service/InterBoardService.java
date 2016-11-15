package com.spring.board.service;

import java.util.HashMap;
import java.util.List;

import com.spring.board.model.BoardVO;

// #14. Service 선언
public interface InterBoardService {
	
	int add(BoardVO vo); // 파일 첨부가 없는 글쓰기
	List<BoardVO> list(); // 글 리스트 받아오기(검색어 없음)
	BoardVO getView(String seq, String readCountCheck); // 글 1개만 받아오는 메서드
	int edit(HashMap<String,String> map); // 1개 글 수정하기
}
