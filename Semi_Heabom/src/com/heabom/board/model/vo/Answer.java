package com.heabom.board.model.vo;

import java.sql.Date;

public class Answer {
	private int answerNo;
	private int questionNo;
	private String answerWriter;
	private String answerOrNot;
	private String answerContent;
	private Date answerDate;
	private String status;
	private String nickname;
	
	public Answer() {}

	public Answer(int answerNo, int questionNo, String answerWriter, String answerOrNot, String answerContent,
			Date answerDate, String status) {
		super();
		this.answerNo = answerNo;
		this.questionNo = questionNo;
		this.answerWriter = answerWriter;
		this.answerOrNot = answerOrNot;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
		this.status = status;
	}
	
	

	public Answer(int questionNo, String answerWriter, String answerOrNot, String answerContent, Date answerDate, String nickname) {
		super();
		this.questionNo = questionNo;
		this.answerWriter = answerWriter;
		this.answerOrNot = answerOrNot;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getAnswerNo() {
		return answerNo;
	}

	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public String getAnswerWriter() {
		return answerWriter;
	}

	public void setAnswerWriter(String answerWriter) {
		this.answerWriter = answerWriter;
	}

	public String getAnswerOrNot() {
		return answerOrNot;
	}

	public void setAnswerOrNot(String answerOrNot) {
		this.answerOrNot = answerOrNot;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AnswerDao [answerNo=" + answerNo + ", questionNo=" + questionNo + ", answerWriter=" + answerWriter
				+ ", answerOrNot=" + answerOrNot + ", answerContent=" + answerContent + ", answerDate=" + answerDate
				+ ", status=" + status + "]";
	}
}
