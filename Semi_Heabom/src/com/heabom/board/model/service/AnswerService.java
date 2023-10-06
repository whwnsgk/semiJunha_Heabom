package com.heabom.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.heabom.board.model.dao.AnswerDao;
import com.heabom.board.model.vo.Answer;
import static com.heabom.common.JDBCTemplate.*;

public class AnswerService {
	public ArrayList<Answer> selectAnswer(String memNo) {
		Connection conn = getConnection();
		ArrayList<Answer> anArr = new AnswerDao().selectAnswer(conn, memNo);
		close(conn);
		return anArr;
	}
}
