package com.spring.personal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.personal.model.BoardVO;
import com.spring.personal.model.PersonalDAO;

@Repository
public class PersonalService implements InterPersonalService {

	@Autowired
	private PersonalDAO dao;

	@Override
	public List<BoardVO> getMemo() {
		
		List<BoardVO> boardList = dao.getMemo();
		
		return boardList;
	}
	
	
}
