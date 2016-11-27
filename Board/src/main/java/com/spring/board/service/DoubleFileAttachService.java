package com.spring.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.model.DoubleFileAttachDAO;

@Repository
public class DoubleFileAttachService {

	@Autowired
	private DoubleFileAttachDAO dao;
	
	
}
