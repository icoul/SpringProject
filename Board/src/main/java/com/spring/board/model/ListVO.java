package com.spring.board.model;

public class ListVO {
	
	int currentShowPageNo;	// 현재 보여주는 페이지 번호
	int sizePerPage;  		// 한 페이지당 보여줄 게시물 수
	int loop; 				// startPageNo 값이 증가할 때 마다 1씩 증가한다.
	int blocksize;			// 페이지바에 보여줄 갯수
	int totalCount;   		// 총게시물 건수
	
	int totalPage; 			// 총 페이지 수(웹브라우저 상에 보여줄 총 페이지 갯수)
	int start;	     		// 시작 행 번호
	int end;	     		// 끝 행 번호
	int startPageNo; 		// 페이지바에서 시작될 페이지 번호입니다.
	
	public ListVO(){}
	
	public ListVO(int currentShowPageNo, int sizePerPage, int loop, int blocksize, int totalCount) {

		this.totalCount = totalCount;
		this.sizePerPage = sizePerPage;
		this.currentShowPageNo = currentShowPageNo;
		this.loop = loop;
		this.blocksize = blocksize;
		
		setTotalPage(totalCount, sizePerPage);
		setStart(currentShowPageNo, sizePerPage);
		setEnd(currentShowPageNo, sizePerPage);
		setStartPageNo(currentShowPageNo, blocksize);
	}
	
	public int getCurrentShowPageNo() {
		return currentShowPageNo;
	}

	public void setCurrentShowPageNo(int currentShowPageNo) {
		this.currentShowPageNo = currentShowPageNo;
	}

	public int getSizePerPage() {
		return sizePerPage;
	}

	public void setSizePerPage(int sizePerPage) {
		this.sizePerPage = sizePerPage;
	}
	
	public int getLoop() {
		return loop;
	}

	public void setLoop(int loop) {
		this.loop = loop;
	}

	public int getBlocksize() {
		return blocksize;
	}

	public void setBlocksize(int blocksize) {
		this.blocksize = blocksize;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalCount, int sizePerPage) {
		this.totalPage = (int)Math.ceil((double)totalCount/sizePerPage);
	}

	public int getStart() {
		return start;
	}

	public void setStart(int currentShowPageNo, int sizePerPage) {
		this.start = ((currentShowPageNo - 1) * sizePerPage) + 1;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int currentShowPageNo, int sizePerPage) {
		this.end = ((currentShowPageNo - 1) * sizePerPage) + sizePerPage;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int currentShowPageNo, int blocksize) {
		this.startPageNo = ((currentShowPageNo - 1 ) / blocksize ) * blocksize + 1;
	}
}