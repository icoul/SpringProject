package com.test.fileattach.model;


public class AttachFileVO {

	private int           seqfileno;      // 파일번호
	private String        fileName;       // 웹서버에 저장될 파일명(2016082545435345464367524654634.png)
	private String        orgFilename;    // 진짜 파일명(강아지.png) // 사용자가 파일을 업로드 하거나 파일을 다운로드 할때 사용되어지는 파일명 
	private String        fileSize;       // 파일크기
	private int           fk_seqcontent;  // -- 글번호(참조키)
	
	private String        thumbnailFileName; // 웹서버에 저장될 썸네일 파일명(2016082513165790354388015717.png)
	
	
	public AttachFileVO() { }
	
	
	public AttachFileVO(int seqfileno, String fileName, String orgFilename, String fileSize, int fk_seqcontent
			          , String thumbnailFileName) {
		this.seqfileno = seqfileno;
		this.fileName = fileName;
		this.orgFilename = orgFilename;
		this.fileSize = fileSize;
		this.fk_seqcontent =fk_seqcontent;
		
		this.thumbnailFileName = thumbnailFileName;
	}

	
	public int getSeqfileno() {
		return seqfileno;
	}

	public void setSeqfileno(int seqfileno) {
		this.seqfileno = seqfileno;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOrgFilename() {
		return orgFilename;
	}

	public void setOrgFilename(String orgFilename) {
		this.orgFilename = orgFilename;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
	public int getFk_seqcontent() {
		return fk_seqcontent;
	}

	public void setFk_seqcontent(int fk_seqcontent) {
		this.fk_seqcontent = fk_seqcontent;
	}


	public String getThumbnailFileName() {
		return thumbnailFileName;
	}


	public void setThumbnailFileName(String thumbnailFileName) {
		this.thumbnailFileName = thumbnailFileName;
	}
	
	
}
