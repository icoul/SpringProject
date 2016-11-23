package com.test.fileattach.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//#13. DAO 선언
@Repository
public class DoubleFileAttachDAO implements InterDoubleFileAttachDAO {
	
	@Autowired //의존객체주입(DI : Dependency Injection) 
	private SqlSessionTemplate sqlsession;

	@Override
	public int add(BoardVO vo) {
		// 글쓰기(tblDoublefileContent 테이블에 insert)
		int result = sqlsession.insert("doublefileattachtest.add", vo); // 아이디 add , 파라미터값 vo
		return result;
		
	}

	@Override
	public int add_file(AttachFileVO avo) {
		// 글쓰기(tblDoublefileAttach 테이블에 insert)
		int result = sqlsession.insert("doublefileattachtest.add_file", avo); // 아이디 add_file , 파라미터값 avo
		return result;
	}

	
	@Override
	public List<BoardVO> boardList() {
		// 글목록 보기(tblDoublefileContent 테이블 select)
		List<BoardVO> boardList = sqlsession.selectList("doublefileattachtest.boardList");
		return boardList;
	}
	
	
	@Override
	public int getSeqcontent() {
		// tblDoublefileContent 테이블에 insert 되어진 seqcontent 컬럼의 값을 얻어오기
		int seqcontent = sqlsession.selectOne("doublefileattachtest.getSeqcontent");
		return seqcontent;
	}

	@Override
	public BoardVO view_tblDoublefileContent(String seqcontent) {
		// 특정글 조회(tblDoublefileContent 테이블 select)
		BoardVO vo = sqlsession.selectOne("doublefileattachtest.view_tblDoublefileContent", seqcontent);
		return vo;
	}

	@Override
	public List<AttachFileVO> view_tblDoublefileAttach(String seqcontent) {
		// 특정글에 해당하는 파일(이미지파일)조회(tblDoublefileAttach 테이블 select) 
		List<AttachFileVO> avoList = sqlsession.selectList("doublefileattachtest.view_tblDoublefileAttach", seqcontent); 
		return avoList;
	}

	@Override
	public String getSeqfileno(String seqfileno) {
		// 파일번호(seqfileno)에 해당하는 tblDoublefileAttach 테이블에서 fileName 컬럼의 값 가져오기 
		String result_seqfileno = sqlsession.selectOne("doublefileattachtest.getSeqfileno", seqfileno);
		return result_seqfileno;
	}
	
}
