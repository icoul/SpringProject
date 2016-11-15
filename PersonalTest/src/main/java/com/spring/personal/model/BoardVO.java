package com.spring.personal.model;

// #19. VO 생성하기
	// 먼저, 오라클에서 tblBoard를 생성
public class BoardVO {
	private String seq; 		// 글번호
	private String name; 		// 글쓴이
	private String subject; 	// 글제목
	private String content; 	// 글내용 -- clob
	private String pw;      	// 글비번
	private String readCount; 	// 글 조회수
	private String regDate;   	// 글쓴시간
	private String status; 	 	// 글상태
	
	public BoardVO(){}
	
	public BoardVO(String seq, String name, String subject, String content, String pw, String readCount, String regDate,
			String status) {
		this.seq = seq;
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.pw = pw;
		this.readCount = readCount;
		this.regDate = regDate;
		this.status = status;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getReadCount() {
		return readCount;
	}

	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
