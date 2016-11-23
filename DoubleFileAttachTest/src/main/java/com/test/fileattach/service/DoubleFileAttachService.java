package com.test.fileattach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.fileattach.model.AttachFileVO;
import com.test.fileattach.model.BoardVO;
import com.test.fileattach.model.InterDoubleFileAttachDAO;


//#14. Service 선언
@Service
public class DoubleFileAttachService implements InterDoubleFileAttachService {

	@Autowired //의존객체주입(DI : Dependency Injection) 
	private InterDoubleFileAttachDAO dao;
	
	@Override
	public int add(BoardVO vo) {
		// 글쓰기(tblDoublefileContent 테이블에 insert)
		
		int result = dao.add(vo);
		
		int seqcontent = 0;
		if(result > 0) {
			seqcontent = dao.getSeqcontent(); 
			// tblDoublefileContent 테이블에 insert 되어진 행의 글번호 seqcontent 컬럼의 값을 얻어온다. 
		}
		
		return seqcontent;
	}

	@Override
	public int add_file(AttachFileVO avo) {
		// 글쓰기(tblDoublefileAttach 테이블에 insert)
		
		int result = dao.add_file(avo);
		return result;
	}
	
	@Override
	public List<BoardVO> boardList() {
		// 글목록 보기(tblDoublefileContent 테이블 select)
		List<BoardVO> boardList = dao.boardList();
		return boardList;
	}

	@Override
	public BoardVO view_tblDoublefileContent(String seqcontent) {
		// 특정글 조회(tblDoublefileContent 테이블 select)
		BoardVO vo = dao.view_tblDoublefileContent(seqcontent);
		return vo;
	}

	@Override
	public List<AttachFileVO> view_tblDoublefileAttach(String seqcontent) {
		// 특정글에 해당하는 파일(이미지파일)조회(tblDoublefileAttach 테이블 select) 
		List<AttachFileVO> avoList = dao.view_tblDoublefileAttach(seqcontent);
		return avoList;
	}

	@Override
	public String getSeqfileno(String seqfileno) {
		// 파일번호(seqfileno)에 해당하는 tblDoublefileAttach 테이블에서 fileName 컬럼의 값 가져오기 
		String result_seqfileno = dao.getSeqfileno(seqfileno);
		return result_seqfileno;
	}
	
}
