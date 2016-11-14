package com.spring.personal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.personal.model.PersonalDAO;

@Repository
public class PersonalService implements InterPersonalService {

	@Autowired
	private PersonalDAO dao;
	
	
}
