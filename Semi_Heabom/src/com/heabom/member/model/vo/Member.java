package com.heabom.member.model.vo;

import java.sql.Date;

public class Member {
   private String memNo;
   private String grade;
   private String memId;
   private String memPwd;
   private String memName; 
   private String nickname;
   private String email;
   private String mbit;
   private String memPhone;
   private Date enrollDate;
   private String memStatus;
   private Date memVisit;
   private String memBirthday;
   private int memPoint;
   
   private String titleImg;
   private int fileLevel;
   
   public Member () {}

   public Member(String memNo, String grade, String memId, String memPwd, String memName, String nickname,
         String email, String mbit, String memPhone, Date enrollDate, String memStatus, Date memVisit,
         String memBirthday, int memPoint, String titleImg, int fileLevel) {
      super();
      this.memNo = memNo;
      this.grade = grade;
      this.memId = memId;
      this.memPwd = memPwd;
      this.memName = memName;
      this.nickname = nickname;
      this.email = email;
      this.mbit = mbit;
      this.memPhone = memPhone;
      this.enrollDate = enrollDate;
      this.memStatus = memStatus;
      this.memVisit = memVisit;
      this.memBirthday = memBirthday;
      this.memPoint = memPoint;
      this.titleImg = titleImg;
      this.fileLevel = fileLevel;
   }

   public Member(String memNo, String memId, String memName, String nickname, String grade, int memPoint, Date memVisit, String email) {
      super();
      this.memNo = memNo;
      this.memId = memId;
      this.memName = memName;
      this.nickname = nickname;
      this.grade = grade;
      this.memPoint = memPoint;
      this.memVisit = memVisit;
      this.email = email;
      
   }

   
   

   public Member(String memNo, String grade, String memId, String memPwd, String memName, String nickname,
         String email, String mbit, String memPhone, Date enrollDate, String memStatus, Date memVisit,
         String memBirthday, int memPoint) {
      super();
      this.memNo = memNo;
      this.grade = grade;
      this.memId = memId;
      this.memPwd = memPwd;
      this.memName = memName;
      this.nickname = nickname;
      this.email = email;
      this.mbit = mbit;
      this.memPhone = memPhone;
      this.enrollDate = enrollDate;
      this.memStatus = memStatus;
      this.memVisit = memVisit;
      this.memBirthday = memBirthday;
      this.memPoint = memPoint;
   }

   public Member(String memId, int memPoint) {
      super();
      this.memId = memId;
      this.memPoint = memPoint;
   }
   

   public Member(String memId) {
      super();
      this.memId = memId;
   }
   
   
   
   
   

   public String getTitleImg() {
      return titleImg;
   }

   public void setTitleImg(String titleImg) {
      this.titleImg = titleImg;
   }

   public int getFileLevel() {
      return fileLevel;
   }

   public void setFileLevel(int fileLevel) {
      this.fileLevel = fileLevel;
   }

   public String getMemNo() {
      return memNo;
   }

   public void setMemNo(String memNo) {
      this.memNo = memNo;
   }

   public String getGrade() {
      return grade;
   }

   public void setGrade(String grade) {
      this.grade = grade;
   }

   public String getMemId() {
      return memId;
   }

   public void setMemId(String memId) {
      this.memId = memId;
   }

   public String getMemPwd() {
      return memPwd;
   }

   public void setMemPwd(String memPwd) {
      this.memPwd = memPwd;
   }

   public String getMemName() {
      return memName;
   }

   public void setMemName(String memName) {
      this.memName = memName;
   }

   public String getNickname() {
      return nickname;
   }

   public void setNickname(String nickname) {
      this.nickname = nickname;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getMbit() {
      return mbit;
   }

   public void setMbit(String mbit) {
      this.mbit = mbit;
   }

   public String getMemPhone() {
      return memPhone;
   }

   public void setMemPhone(String memPhone) {
      this.memPhone = memPhone;
   }

   public Date getEnrollDate() {
      return enrollDate;
   }

   public void setEnrollDate(Date enrollDate) {
      this.enrollDate = enrollDate;
   }

   public String getMemStatus() {
      return memStatus;
   }

   public void setMemStatus(String memStatus) {
      this.memStatus = memStatus;
   }

   public Date getMemVisit() {
      return memVisit;
   }

   public void setMemVisit(Date memVisit) {
      this.memVisit = memVisit;
   }

   public String getMemBirthday() {
      return memBirthday;
   }

   public void setMemBirthday(String memBirthday) {
      this.memBirthday = memBirthday;
   }

   public int getMemPoint() {
      return memPoint;
   }

   public void setMemPoint(int memPoint) {
      this.memPoint = memPoint;
   }

   @Override
   public String toString() {
      return "Member [memNo=" + memNo + ", grade=" + grade + ", memId=" + memId + ", memPwd=" + memPwd + ", memName="
            + memName + ", nickname=" + nickname + ", email=" + email + ", mbit=" + mbit + ", memPhone=" + memPhone
            + ", enrollDate=" + enrollDate + ", memStatus=" + memStatus + ", memVisit=" + memVisit
            + ", memBirthday=" + memBirthday + ", memPoint=" + memPoint + "]";
   }
}