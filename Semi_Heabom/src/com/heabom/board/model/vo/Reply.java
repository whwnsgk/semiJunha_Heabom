package com.heabom.board.model.vo;

public class Reply {
	
	private String replyNo;
	private String replyWriter;
	private String boardNo;
	private String replyContent;
	private int replyLike;
	private String replyDate;
	private String replyStatus;
	private String nickname;

	public Reply() {}

	public Reply(String replyNo, String replyWriter, String boardNo, String replyContent, int replyLike,
			String replyDate, String replyStatus) {
		super();
		this.replyNo = replyNo;
		this.replyWriter = replyWriter;
		this.boardNo = boardNo;
		this.replyContent = replyContent;
		this.replyLike = replyLike;
		this.replyDate = replyDate;
		this.replyStatus = replyStatus;
	}

	public Reply(String replyNo, String replyWriter, String boardNo, String replyContent, int replyLike,
			String replyDate, String replyStatus, String nicname) {
		super();
		this.replyNo = replyNo;
		this.replyWriter = replyWriter;
		this.boardNo = boardNo;
		this.replyContent = replyContent;
		this.replyLike = replyLike;
		this.replyDate = replyDate;
		this.replyStatus = replyStatus;
		this.nickname = nicname;
	}
	

	public String getNicname() {
		return nickname;
	}

	public void setNicname(String nicname) {
		this.nickname = nicname;
	}

	public String getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyWriter() {
		return replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getReplyLike() {
		return replyLike;
	}

	public void setReplyLike(int replyLike) {
		this.replyLike = replyLike;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public String getReplyStatus() {
		return replyStatus;
	}

	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyWriter=" + replyWriter + ", boardNo=" + boardNo + ", replyContent="
				+ replyContent + ", replyLike=" + replyLike + ", replyDate=" + replyDate + ", replyStatus="
				+ replyStatus + "]";
	};
}
