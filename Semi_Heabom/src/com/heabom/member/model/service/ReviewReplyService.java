package com.heabom.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.heabom.common.JDBCTemplate.*;

import com.heabom.member.model.dao.ReviewReplyDao;
import com.heabom.member.model.vo.ReviewReply;

public class ReviewReplyService {
	public ArrayList<ReviewReply> selectReviewReply(String memNo) {
		Connection conn = getConnection();
		ArrayList<ReviewReply> relist = new ReviewReplyDao().selectReviewReply(conn, memNo);
		close(conn);
		return relist;
	}

}
