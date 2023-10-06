package com.heabom.board.model.vo;

import java.sql.Date;

public class Question {
	private int questionNo;
	private String questionComment;
	private String questionDate;
	private String qeustionSecret;
	private String status;
	private String questionWriter;
	private String answerWriter;
	private String answerOrNot;
	private String answerContent;
	private String answerDate;
	private String answerNickname;
	
	public Question() {}

	public Question(int questionNo, String questionComment, String questionDate, String qeustionSecret, String status,
			String questionWriter) {
		super();
		this.questionNo = questionNo;
		this.questionComment = questionComment;
		this.questionDate = questionDate;
		this.qeustionSecret = qeustionSecret;
		this.status = status;
		this.questionWriter = questionWriter;
	}

	
	
	public Question(int questionNo, String questionComment, String questionDate) {
		super();
		this.questionNo = questionNo;
		this.questionComment = questionComment;
		this.questionDate = questionDate;
	}
	
	

	public Question(int questionNo, String questionComment, String questionDate, String answerWriter, String answerOrNot,
			String answerContent, String answerDate, String answerNickname) {
		super();
		this.questionNo = questionNo;
		this.questionComment = questionComment;
		this.questionDate = questionDate;
		this.answerWriter = answerWriter;
		this.answerOrNot = answerOrNot;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
		this.answerNickname = answerNickname;
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

	public String getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}

	public String getAnswerNickname() {
		return answerNickname;
	}

	public void setAnswerNickname(String answerNickname) {
		this.answerNickname = answerNickname;
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestionComment() {
		return questionComment;
	}

	public void setQuestionComment(String questionComment) {
		this.questionComment = questionComment;
	}

	public String getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(String questionDate) {
		this.questionDate = questionDate;
	}

	public String getQeustionSecret() {
		return qeustionSecret;
	}

	public void setQeustionSecret(String qeustionSecret) {
		this.qeustionSecret = qeustionSecret;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuestionWriter() {
		return questionWriter;
	}

	public void setQuestionWriter(String questionWriter) {
		this.questionWriter = questionWriter;
	}

	@Override
	public String toString() {
		return "QuestionDao [questionNo=" + questionNo + ", questionComment=" + questionComment + ", questionDate="
				+ questionDate + ", qeustionSecret=" + qeustionSecret + ", status=" + status + ", questionWriter="
				+ questionWriter + "]";
	}
}
