package com.heabom.admin.model.vo;

import java.sql.Date;

public class Report {

	private int reportNo;
	private String reporter;
	private String reported;
	private String reCategory;
	private String reContent;
	private Date reDate;
	private Date reComplite;
	private String reStatus;
	private String postNo;
	
	public Report() {}

	public Report(int reportNo, String reporter, String reported, String reCategory, String reContent, Date reDate,
			Date reComplite, String reStatus, String postNo) {
		super();
		this.reportNo = reportNo;
		this.reporter = reporter;
		this.reported = reported;
		this.reCategory = reCategory;
		this.reContent = reContent;
		this.reDate = reDate;
		this.reComplite = reComplite;
		this.reStatus = reStatus;
		this.postNo = postNo;
	}
	

	public Report(int reportNo, String reporter, String reported, String reCategory, Date reDate, Date reComplite,
			String reStatus) {
		super();
		this.reportNo = reportNo;
		this.reporter = reporter;
		this.reported = reported;
		this.reCategory = reCategory;
		this.reDate = reDate;
		this.reComplite = reComplite;
		this.reStatus = reStatus;
	}
	
	

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getReported() {
		return reported;
	}

	public void setReported(String reported) {
		this.reported = reported;
	}

	public String getReCategory() {
		return reCategory;
	}

	public void setReCategory(String reCategory) {
		this.reCategory = reCategory;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public Date getReDate() {
		return reDate;
	}

	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}

	public Date getReComplite() {
		return reComplite;
	}

	public void setReComplite(Date reComplite) {
		this.reComplite = reComplite;
	}

	public String getReStatus() {
		return reStatus;
	}

	public void setReStatus(String reStatus) {
		this.reStatus = reStatus;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", reporter=" + reporter + ", reported=" + reported + ", reCategory="
				+ reCategory + ", reContent=" + reContent + ", reDate=" + reDate + ", reComplite=" + reComplite
				+ ", reStatus=" + reStatus + ", postNo=" + postNo + "]";
	}
}
