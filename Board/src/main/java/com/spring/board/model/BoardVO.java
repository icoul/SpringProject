package com.spring.board.model;

import org.springframework.web.multipart.MultipartFile;

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
	private String commentCount; // 댓글 갯수
	
	private String fileName;            //WAS(톰캣)에 저장될 파일명(201611211433243323421.png)
	private String orgFileName;         //원본 파일명(강아지.png) 사용자가 파일을 upload하거나, downlaod할 때 사용되어지는 파일명
	private String fileSize;            // 파일 크기, 단위는 byte이다.

	private MultipartFile attach;       // 진짜 파일 ==> WAS(톰캣)에 저장된다. tbl_board의 컬럼이 아니다.
	
	// #73. 먼저 오라클에서 기존 테이블을 모두 제거한 후 새로이 만들고 추가해야한다.
	
	private String groupno;		// 그룹번호, 답변글 아닌 원글의 경우 groupno의 값은 groupno컬럼의 최대값 +1로 한다
	private String fk_seq;		// fk_seq 컬럼은 절대로 foreign key가 아니다 fk_seq 컬럼은 자신의 글(답변글)에 있어서 원글(부모글)이 누구인지에 대한 정보값
    							// 답변글쓰기에 있어서 답변글이라면 fk_seq 컬럼의 값음 원글의 seq컬럼의 값을 가지게 되며
    							// 답변글이 아닌 원글일 경우 0을 가지도록 한다.
	private String depth;		// 답변글쓰기에 있어서 답변글이라면 원글의 depthno+1을 가지게 되며 원글이면 0
	
	public BoardVO(){}

	public BoardVO(String seq, String name, String subject, String content, String pw, String readCount, String regDate,
			String status, String commentCount, String fileName, String orgFileName, String fileSize,
			MultipartFile attach, String groupno, String fk_seq, String depth) {

		this.seq = seq;
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.pw = pw;
		this.readCount = readCount;
		this.regDate = regDate;
		this.status = status;
		this.commentCount = commentCount;
		this.fileName = fileName;
		this.orgFileName = orgFileName;
		this.fileSize = fileSize;
		this.attach = attach;
		this.groupno = groupno;
		this.fk_seq = fk_seq;
		this.depth = depth;
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

	public String getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public MultipartFile getAttach() {
		return attach;
	}

	public void setAttach(MultipartFile attach) {
		this.attach = attach;
	}

	public String getGroupno() {
		return groupno;
	}

	public void setGroupno(String groupno) {
		this.groupno = groupno;
	}

	public String getFk_seq() {
		return fk_seq;
	}

	public void setFk_seq(String fk_seq) {
		this.fk_seq = fk_seq;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}
}
