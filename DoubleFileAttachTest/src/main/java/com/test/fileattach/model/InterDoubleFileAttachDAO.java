package com.test.fileattach.model;

import java.util.List;

public interface InterDoubleFileAttachDAO {

	int add(BoardVO vo);    // 글쓰기(tblDoublefileContent 테이블에 insert)
	int getSeqcontent();    // 글번호(tblDoublefileContent 테이블의 seqcontent 컬럼의 값) 가져오기 
	int add_file(AttachFileVO avo);    // 글쓰기(tblDoublefileAttach 테이블에 insert)
	
	
	List<BoardVO> boardList();  // 글목록 보기(tblDoublefileContent 테이블 select)
	
	BoardVO view_tblDoublefileContent(String seqcontent); // 특정글 조회(tblDoublefileContent 테이블 select)
	List<AttachFileVO> view_tblDoublefileAttach(String seqcontent); // 특정글에 해당하는 파일(이미지파일)조회(tblDoublefileAttach 테이블 select)
	
	String getSeqfileno(String seqfileno); // 파일번호(seqfileno)에 해당하는 tblDoublefileAttach 테이블에서 fileName 컬럼의 값 가져오기 
}
