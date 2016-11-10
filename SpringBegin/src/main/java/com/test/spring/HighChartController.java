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
	
	
	@RequestMapping(value="/chartTest2.action",method={RequestMethod.GET})
	public String chartTest2(HttpServletRequest req){
		
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		
		for (int i = 0; i < 5; i++) {
			
			ArrayList<Integer> subList = new ArrayList<Integer>();
			
			for (int j = 0; j < 12; j++) {
			
				Random rnd = new Random();
				int panmaesu = rnd.nextInt(200 - 10 + 1) + 10;
				subList.add(new Integer(panmaesu));
				
			}// end of for(내부, 도시 1개당 1월~12월 판매량)
			
			list.add(subList);
			
		}// end of for(외부, 도시 5개)
		
		req.setAttribute("list", list);
		
		return "chartTest2"; // 글쓰기 폼페이지 작성
	}
}
