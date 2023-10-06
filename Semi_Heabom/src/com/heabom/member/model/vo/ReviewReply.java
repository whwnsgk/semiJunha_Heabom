package com.heabom.member.model.vo;

import java.sql.Date;

public class ReviewReply {
	private String reNo;
	private String reRefNo;
	private String reWriter;
	private String reOriginWriter;
	private String reContent;
	private int reLikeStar;
	private String reDate;
	private String reLevel;
	private String reStatus;
	private String nickname;
	private String imgPath;
	private String fileLevel;
	
	public ReviewReply () {}

	public ReviewReply(String reNo, String reRefNo, String reWriter, String reOriginWriter, String reContent,
			int reLikeStar, String reDate, String reLevel, String reStatus) {
		super();
		this.reNo = reNo;
		this.reRefNo = reRefNo;
		this.reWriter = reWriter;
		this.reOriginWriter = reOriginWriter;
		this.reContent = reContent;
		this.reLikeStar = reLikeStar;
		this.reDate = reDate;
		this.reLevel = reLevel;
		this.reStatus = reStatus;
	}
	
	

	public ReviewReply(String reNo, String reRefNo, String reWriter, String reContent, int reLikeStar, String reDate,
			String reLevel, String nickname) {
		super();
		this.reNo = reNo;
		this.reRefNo = reRefNo;
		this.reWriter = reWriter;
		this.reContent = reContent;
		this.reLikeStar = reLikeStar;
		this.reDate = reDate;
		this.reLevel = reLevel;
		this.nickname = nickname;
	}
	
	
	
	
	public ReviewReply(String reRefNo, String reNo, String reContent, String nickname, String reDate, String imgPath,
			String reLevel) {
		super();
		this.reRefNo = reRefNo;
		this.reNo = reNo;
		this.reContent = reContent;
		this.nickname = nickname;
		this.reDate = reDate;
		this.imgPath = imgPath;
		this.reLevel = reLevel;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(String fileLevel) {
		this.fileLevel = fileLevel;
	}

	public String getReNo() {
		return reNo;
	}

	public void setReNo(String reNo) {
		this.reNo = reNo;
	}

	public String getReRefNo() {
		return reRefNo;
	}

	public void setReRefNo(String reRefNo) {
		this.reRefNo = reRefNo;
	}

	public String getReWriter() {
		return reWriter;
	}

	public void setReWriter(String reWriter) {
		this.reWriter = reWriter;
	}

	public String getReOriginWriter() {
		return reOriginWriter;
	}

	public void setReOriginWriter(String reOriginWriter) {
		this.reOriginWriter = reOriginWriter;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public int getReLikeStar() {
		return reLikeStar;
	}

	public void setReLikeStar(int reLikeStar) {
		this.reLikeStar = reLikeStar;
	}

	public String getReDate() {
		return reDate;
	}

	public void setReDate(String reDate) {
		this.reDate = reDate;
	}

	public String getReLevel() {
		return reLevel;
	}

	public void setReLevel(String reLevel) {
		this.reLevel = reLevel;
	}

	public String getReStatus() {
		return reStatus;
	}

	public void setReStatus(String reStatus) {
		this.reStatus = reStatus;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "ReviewReply [reNo=" + reNo + ", reRefNo=" + reRefNo + ", reWriter=" + reWriter + ", reOriginWriter="
				+ reOriginWriter + ", reContent=" + reContent + ", reLikeStar=" + reLikeStar + ", reDate=" + reDate
				+ ", reLevel=" + reLevel + ", reStatus=" + reStatus + ", nickname=" + nickname + "]";
	}

	
	
}
