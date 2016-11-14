package com.spring.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.personal.service.InterPersonalService;

@Controller
public class PersonalController {
	
	@Autowired
	private InterPersonalService service;
	
	@RequestMapping(value="/test.action", method={RequestMethod.GET})
	public String test(){
		return "test";
	}
}
