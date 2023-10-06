package com.heabom.common.model.vo;

public class HashTag {
	
	private String categoryNo;
	private String hashTagName;
	
	public HashTag () {}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getHashTagName() {
		return hashTagName;
	}

	public void setHashTagName(String hashTagName) {
		this.hashTagName = hashTagName;
	}

	@Override
	public String toString() {
		return "HashTag [categoryNo=" + categoryNo + ", hashTagName=" + hashTagName + "]";
	};
	
	

}
