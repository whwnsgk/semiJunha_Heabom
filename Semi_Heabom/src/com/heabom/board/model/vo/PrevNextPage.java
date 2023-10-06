package com.heabom.board.model.vo;

public class PrevNextPage {
	
	private int nextPage;
	private int prevPage;
	private int currentPage;
	
	public PrevNextPage() {}

	public PrevNextPage(int nextPage, int prevPage, int currentPage) {
		super();
		this.nextPage = nextPage;
		this.prevPage = prevPage;
		this.currentPage = currentPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "PrevNextPage [nextPage=" + nextPage + ", prevPage=" + prevPage + ", currentPage=" + currentPage + "]";
	};
	
	

}
