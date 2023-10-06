package com.heabom.course.model.vo;

public class Course {
	private String courseNo;
	private String courseWriter;
	private String place1;
	private String place2;
	private String place3;
	private String place4;
	private String place5;
	private int courseTime;
	private int courseMoney;
	private String titleImg; 
	private String locationName;
	private String hashtagName;
	
	public Course() {}

	public Course(String courseNo, String courseWriter, String place1, String place2, String place3, String place4,
			String place5, int courseTime, int courseMoney) {
		super();
		this.courseNo = courseNo;
		this.courseWriter = courseWriter;
		this.place1 = place1;
		this.place2 = place2;
		this.place3 = place3;
		this.place4 = place4;
		this.place5 = place5;
		this.courseTime = courseTime;
		this.courseMoney = courseMoney;
	}
	
	

	public Course(String place1, String titleImg, String locationName) {
		super();
		this.place1 = place1;
		this.titleImg = titleImg;
		this.locationName = locationName;
	}	
	
	public Course(String place1, String courseNo, String titleImg, String locationName) {
		super();
		this.place1 = place1;
		this.courseNo = courseNo;
		this.titleImg = titleImg;
		this.locationName = locationName;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getHashtagName() {
		return hashtagName;
	}

	public void setHashtagName(String hashtagName) {
		this.hashtagName = hashtagName;
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseWriter() {
		return courseWriter;
	}

	public void setCourseWriter(String courseWriter) {
		this.courseWriter = courseWriter;
	}

	public String getPlace1() {
		return place1;
	}

	public void setPlace1(String place1) {
		this.place1 = place1;
	}

	public String getPlace2() {
		return place2;
	}

	public void setPlace2(String place2) {
		this.place2 = place2;
	}

	public String getPlace3() {
		return place3;
	}

	public void setPlace3(String place3) {
		this.place3 = place3;
	}

	public String getPlace4() {
		return place4;
	}

	public void setPlace4(String place4) {
		this.place4 = place4;
	}

	public String getPlace5() {
		return place5;
	}

	public void setPlace5(String place5) {
		this.place5 = place5;
	}

	public int getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(int courseTime) {
		this.courseTime = courseTime;
	}

	public int getCourseMoney() {
		return courseMoney;
	}

	public void setCourseMoney(int courseMoney) {
		this.courseMoney = courseMoney;
	}

	@Override
	public String toString() {
		return "Course [courseNo=" + courseNo + ", courseWriter=" + courseWriter + ", place1=" + place1 + ", place2="
				+ place2 + ", place3=" + place3 + ", place4=" + place4 + ", place5=" + place5 + ", courseTime="
				+ courseTime + ", courseMoney=" + courseMoney + "]";
	}
	

}
