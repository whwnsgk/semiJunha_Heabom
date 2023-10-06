package com.heabom.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.heabom.board.model.dao.QuestionDao;
import com.heabom.board.model.vo.Question;
import static com.heabom.common.JDBCTemplate.*;

public class QuestionService {
	public ArrayList<Question> selectQuestion(String memNo) {
		Connection conn = getConnection();
		ArrayList<Question> quArr = new QuestionDao().selectQuestion(conn, memNo);
		close(conn);
		return quArr;
	}
}
