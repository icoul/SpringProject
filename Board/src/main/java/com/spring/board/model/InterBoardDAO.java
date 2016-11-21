package com.spring.board.model;

import java.util.HashMap;
import java.util.List;

// model단(DAO)의 인터페이스 생성
public interface InterBoardDAO {
	
	int add(BoardVO vo); // 파일 첨부가 없는 글쓰기
	
	int getGroupMaxno(); // groupno의 최대값을 가져오는 메서드, 답글쓰기 기능
	
	//List<BoardVO> list(); // 글 목록 받아오기
	List<BoardVO> list(HashMap<String,String> map); // 글 리스트 받아오기(검색어가 존재함)
	
	int getTotalCount(HashMap<String,String> map); // 페이징 처리에 필요한 글 갯수 구하기
	
	BoardVO getView(String seq, String readCountCheck); // 글 1개만 받아오는 메서드
	
	boolean checkPW(HashMap<String,String> map); // 글 수정 및 삭제 시 암호가 일치하는지 여부확인 메서드
	
	int updateContent(HashMap<String,String> map); // 글 내용 수정 메서드
	
	int delContent(HashMap<String, String> map); // 글 삭제 메서드
	
	int addComment(CommentVO vo); // 댓글 작성하기
	
	int updateCommentCount(String parentSeq); // 게시글 테이블에서 댓글 갯수 1 증가시키기
	
	List<CommentVO> listComment(String seq); // 댓글 리스트 가져오기
	
	int isExistsComment(HashMap<String, String> map); // 해당 글에 댓글이 존재하는지 확인
	
	int delComment(HashMap<String, String> map); // 댓글삭제
	
}
