package com.test.fileattach.model;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {

	private int    seqcontent;  // 글번호
	private String name;        // 글쓴이  
	private String subject;     // 글제목
	private String content;     // 글내용
	private String regDate;     // 글쓴시간
	
	private MultipartFile[] attach;   // 진짜 파일  ==> WAS 디스크에 저장됨.
	 // MultipartFile[] attach 는 오라클 데이터	베이스 tblDoublefileAttach 테이블의 컬럼이 아니다.
	
	public BoardVO() { }
	
	public BoardVO(int seqcontent,  String name, String subject, String content, String regDate) {
		
		this.seqcontent = seqcontent;
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.regDate = regDate;
	}

	public int getSeqcontent() {
		return seqcontent;
	}

	public void setSeqcontent(int seqcontent) {
		this.seqcontent = seqcontent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public MultipartFile[] getAttach() {
		return attach;
	}

	public void setAttach(MultipartFile[] attach) {
		this.attach = attach;
	}
	
}
