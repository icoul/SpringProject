package com.spring.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.model.BoardDAO;

//#14. Service 선언
@Service
public class BoardService implements InterBoardService {
	
	@Autowired 
	private BoardDAO dao;
}
