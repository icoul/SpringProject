package com.test.spring;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisTestDAO {
	
	// 의존객체주입(DI : Dependency Injection) 
	@Autowired
	private SqlSessionTemplate sqlSession;

	public void mbt1() {
		// JDBC 작업이 필요없다.
		sqlSession.insert("testdb.mbt1");
		
	}

	public void mbt2(String name) {
		sqlSession.insert("testdb.mbt2", name);
	}

	public void mbt3(MybatisTestVO vo) {
		// 서비스단으로부터 넘겨받은 DTO(VO)를 DB에 insert 해주어야 한다.
		sqlSession.insert("testdb.mbt3", vo);
		
	}

	public void mbt4(MybatisTestVO vo) {
		sqlSession.insert("testdb.mbt4", vo);
	}

	public void mbt5(HashMap<String, String> map) {
		sqlSession.insert("testdb.mbt5", map);
	}

	public void mbt6(HashMap<String, MybatisTestVO> map) {
		sqlSession.insert("testdb.mbt6", map);
	}

	public String mbt7(String no) {
		
		String name = (String)sqlSession.selectOne("testdb.mbt7", no);
		
		return name;
	}

	public MybatisTestVO mbt8(String no) {

		MybatisTestVO vo = sqlSession.selectOne("testdb.mbt8", no);
		
		return vo;
	}

	public List<MybatisTestVO> mbt9() {

		List<MybatisTestVO> memberList = sqlSession.selectList("testdb.mbt9");
		
		return memberList;
	}

	public List<MybatisTestVO> mbt10() {

		List<MybatisTestVO> memberList = sqlSession.selectList("testdb.mbt10");
		
		return memberList;
	}
}
