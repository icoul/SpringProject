package com.spring.board.model;

public class AttachFileVO {
	
	private int seqFileNo; // 파일번호
	private String fileName; // 서버에 저장될 파일명(2016082545435345464367524654634.png)
	private String nowFileName; // 진짜 이름 (image.png)
	private String fileSize; // 파일사이즈
	private int fk_SeqContent; // 글번호
	
	private String thumnailFileName; // 썸네일 파일명
	
	public AttachFileVO(){}

	public AttachFileVO(int seqFileNo, String fileName, String nowFileName, String fileSize, int fk_SeqContent,
			String thumnailFileName) {
		super();
		this.seqFileNo = seqFileNo;
		this.fileName = fileName;
		this.nowFileName = nowFileName;
		this.fileSize = fileSize;
		this.fk_SeqContent = fk_SeqContent;
		this.thumnailFileName = thumnailFileName;
	}

	public int getSeqFileNo() {
		return seqFileNo;
	}

	public void setSeqFileNo(int seqFileNo) {
		this.seqFileNo = seqFileNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getNowFileName() {
		return nowFileName;
	}

	public void setNowFileName(String nowFileName) {
		this.nowFileName = nowFileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public int getFk_SeqContent() {
		return fk_SeqContent;
	}

	public void setFk_SeqContent(int fk_SeqContent) {
		this.fk_SeqContent = fk_SeqContent;
	}

	public String getThumnailFileName() {
		return thumnailFileName;
	}

	public void setThumnailFileName(String thumnailFileName) {
		this.thumnailFileName = thumnailFileName;
	}
}
