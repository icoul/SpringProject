package com.test.spring;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisTestService {
	
	// 의존객체주입(DI : Dependency Injection)
	@Autowired
	private MybatisTestDAO dao;
	
	public void mbt1(){
		//SQL 구문을 실행하려면 DAO개체의 특정메소드를 호출해야한다
		dao.mbt1();
	}

	public void mbt2(String name) {
		dao.mbt2(name);
		
	}

	public void mbt3(MybatisTestVO vo) {
		//DAO에게 DTO(VO)를 파라미터로 넘겨서 작업(insert작업)을 위임한다.
		dao.mbt3(vo);
		
	}

	public void mbt4(MybatisTestVO vo) {
		dao.mbt4(vo);
	}

	public void mbt5(HashMap<String, String> map) {
		dao.mbt5(map);
	}

	public void mbt6(HashMap<String, MybatisTestVO> map) {
		dao.mbt6(map);
	}

	public String mbt7(String no) {
		
		String name = dao.mbt7(no);
		
		return name;
	}

	public MybatisTestVO mbt8(String no) {

		MybatisTestVO vo = dao.mbt8(no);
		
		return vo;
	}

	public List<MybatisTestVO> mbt9() {

		List<MybatisTestVO> memberList = dao.mbt9();
		
		return memberList;
	}

	public List<MybatisTestVO> mbt10() {
		
		List<MybatisTestVO> memberList = dao.mbt10();
		
		return memberList;
	}

	public List<MybatisTestVO> mbt11() {
		
		List<MybatisTestVO> memberList = dao.mbt11();
		
		return memberList;
	}

	public List<String> mbt12(String name) {

		List<String> memberList = dao.mbt12(name);
		
		return memberList;
		
	}
}
