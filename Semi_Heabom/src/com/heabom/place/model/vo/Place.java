package com.heabom.place.model.vo;

import java.sql.Date;

public class Place {
	private String placeNo;
	private String placeTitle;
	private int categoryNo;
	private String writer;
	private int locationNo;
	private Date makeDate;
	private String status;
	private String phone;
	private String address;
	private String placeContent;
	private int startTime;
	private int endTime;
	private int starPoint;
	private String placeUrl;
	private int viewCount;
	private int useTime;
	private int usePrice;
	private String bestStatus;
	private String hashtagName;
	private int likeCount ;
	private String imgpath;
	private String locationName;
	private String strMakeDate;
	public String getStrMakeDate() {
		return strMakeDate;
	}



	public void setStrMakeDate(String strMakeDate) {
		this.strMakeDate = strMakeDate;
	}



	public String getLocationName() {
		return locationName;
	}



	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}



	private String userImgPath;
	
	public String getUserImgPath() {
		return userImgPath;
	}


	

	public Place(String placeNo,String writer,String placeTitle ,int locationNo, String strMakeDate, String status, String phone, String address,
			String placeContent, int startTime, int endTime, int starPoint, String placeUrl, int useTime, int usePrice,
			String bestStatus, int likeCount, String titleImg, String locationName) {
		super();
		this.placeNo = placeNo;
		this.writer = writer;
		this.placeTitle = placeTitle;
		this.locationNo = locationNo;
		this.strMakeDate = strMakeDate;
		this.status = status;
		this.phone = phone;
		this.address = address;
		this.placeContent = placeContent;
		this.startTime = startTime;
		this.endTime = endTime;
		this.starPoint = starPoint;
		this.placeUrl = placeUrl;
		this.useTime = useTime;
		this.usePrice = usePrice;
		this.bestStatus = bestStatus;
		this.likeCount = likeCount;
		this.titleImg = titleImg;
		this.locationName = locationName;
	}



	public void setUserImgPath(String userImgPath) {
		this.userImgPath = userImgPath;
	}



	private String titleImg ;
	
	
	public String getTitleImg() {
		return titleImg;
	}



	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	
	public String getImgpath() {
		return imgpath;
	}



	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}



	public Place() {}

	
	
	public Place(String placeNo, String placeTitle, Date makeDate ,String placeContent, int starPoint, int viewCount,
			String hashtagName, String imgpath) {
		super();
	
		this.placeNo = placeNo;
		this.placeTitle = placeTitle;
		this.makeDate = makeDate ;
		this.placeContent = placeContent;
		this.starPoint = starPoint;
		this.viewCount = viewCount;
		this.hashtagName = hashtagName;
		this.imgpath = imgpath;
	}

	

	public Place(String placeNo, String placeTitle, int categoryNo, String writer, int locationNo, Date makeDate,
			String status, String phone, String address, String placeContent, int startTime, int endTime, int starPoint,
			String placeUrl, int viewCount, int useTime, int usePrice, String bestStatus, String hashtagName) {
		super();
		this.placeNo = placeNo;
		this.placeTitle = placeTitle;
		this.categoryNo = categoryNo;
		this.writer = writer;
		this.locationNo = locationNo;
		this.makeDate = makeDate;
		this.status = status;
		this.phone = phone;
		this.address = address;
		this.placeContent = placeContent;
		this.startTime = startTime;
		this.endTime = endTime;
		this.starPoint = starPoint;
		this.placeUrl = placeUrl;
		this.viewCount = viewCount;
		this.useTime = useTime;
		this.usePrice = usePrice;
		this.bestStatus = bestStatus;
		this.hashtagName = hashtagName;
	}

	public String getPlaceNo() {
		return placeNo;
	}

	public void setPlaceNo(String placeNo) {
		this.placeNo = placeNo;
	}

	public String getPlaceTitle() {
		return placeTitle;
	}

	public void setPlaceTitle(String placeTitle) {
		this.placeTitle = placeTitle;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getLocationNo() {
		return locationNo;
	}

	public void setLocationNo(int locationNo) {
		this.locationNo = locationNo;
	}

	public Date getMakeDate() {
		return makeDate;
	}

	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlaceContent() {
		return placeContent;
	}

	public void setPlaceContent(String placeContent) {
		this.placeContent = placeContent;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getStarPoint() {
		return starPoint;
	}

	public void setStarPoint(int starPoint) {
		this.starPoint = starPoint;
	}

	public String getPlaceUrl() {
		return placeUrl;
	}

	public void setPlaceUrl(String placeUrl) {
		this.placeUrl = placeUrl;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getUseTime() {
		return useTime;
	}

	public void setUseTime(int useTime) {
		this.useTime = useTime;
	}

	public int getUsePrice() {
		return usePrice;
	}

	public void setUsePrice(int usePrice) {
		this.usePrice = usePrice;
	}

	public String getBestStatus() {
		return bestStatus;
	}

	public void setBestStatus(String bestStatus) {
		this.bestStatus = bestStatus;
	}

	public String getHashtagName() {
		return hashtagName;
	}

	public void setHashtagName(String hashtagName) {
		this.hashtagName = hashtagName;
	}


	

	public int getLikeCount() {
		return likeCount;
	}



	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}



	@Override
	public String toString() {
		return "Place [placeNo=" + placeNo + ", placeTitle=" + placeTitle + ", categoryNo=" + categoryNo + ", writer="
				+ writer + ", locationNo=" + locationNo + ", makeDate=" + makeDate + ", status=" + status + ", phone="
				+ phone + ", address=" + address + ", placeContent=" + placeContent + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", starPoint=" + starPoint + ", placeUrl=" + placeUrl + ", viewCount="
				+ viewCount + ", useTime=" + useTime + ", usePrice=" + usePrice + ", bestStatus=" + bestStatus
				+ ", hashtagName=" + hashtagName + ", likeCount=" + likeCount + ", titleImg=" + titleImg + "]";
	}





	
	
	
	
}
