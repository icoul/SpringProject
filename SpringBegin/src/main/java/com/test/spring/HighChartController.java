package com.test.spring;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HighChartController {
	
	@RequestMapping(value="/chartTest1.action",method={RequestMethod.GET})
	public String chartTest1(HttpServletRequest req){
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 12; i++) {
			Random rnd = new Random();
			int panmaesu = rnd.nextInt(200 - 10 + 1) + 10;
			list.add(new Integer(panmaesu));
			
		}
		
		req.setAttribute("list", list);
		
		return "chartTest1"; // 글쓰기 폼페이지 작성
	}
}
