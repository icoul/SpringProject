package com.spring.board.service;

import java.util.HashMap;
import java.util.List;

import com.spring.board.model.BoardVO;
import com.spring.board.model.CommentVO;
import com.spring.board.model.ListVO;

// #14. Service 선언
public interface InterBoardService {
	
	int add(BoardVO vo); // 파일 첨부가 없는 글쓰기
	
	int add_withFile(BoardVO vo); // 파일첨부 글쓰기
	
	//List<BoardVO> list(); // 글 리스트 받아오기(검색어 없음)
	List<BoardVO> list(HashMap<String,String> map); // 글 리스트 받아오기(검색어가 존재함)
	
	ListVO getListVO(HashMap<String, String> map, String pageNo); // 페이징 처리에 필요한 값 가져오기
	
	BoardVO getView(String seq, String readCountCheck); // 글 1개만 받아오는 메서드
	
	int edit(HashMap<String,String> map); // 1개 글 수정하기
	
	int delContent(HashMap<String, String> map) throws Throwable; // 글 삭제하기
	
	int addComment(CommentVO vo) throws Throwable; // 댓글 작성하기
	
	List<CommentVO> listComment(String seq); // 댓글 리스트 가져오기
	
	List<String> searchWordCompleteList(HashMap<String, String> map); // 검색어 입력시 자동 글 완성
	
}
