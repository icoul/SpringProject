package com.spring.personal.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonalDAO implements InterPersonalDAO {
	
	@Autowired
	private SqlSessionTemplate sqlsession;

	@Override
	public List<BoardVO> getMemo() {
		
		List<BoardVO> boardList = sqlsession.selectList("personal.view");
		
		return boardList;
	}
}
