package com.heabom.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.heabom.board.model.vo.Question;
import static com.heabom.common.JDBCTemplate.*;

public class QuestionDao {
	
	private Properties prop = new Properties();
	
	public QuestionDao() {
		try {
			prop.loadFromXML(new FileInputStream(QuestionDao.class.getResource("/db/sql/board-mapper.xml").getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Question> selectQuestion(Connection conn, String memNo){
		ArrayList<Question> quArr = new ArrayList<Question>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQuestion");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				quArr.add(new Question(rset.getInt("QUESTION_NO"),
						               rset.getString("QUESTION_COMMENT"),
						               rset.getString("QUESTION_DATE"),
						               rset.getString("ANSWER_WRITER"),
						               rset.getString("ANSWER_OR_NOT"),
						               rset.getString("ANSWER_CONTENT"),
						               rset.getString("ANSWER_DATE"),
						               rset.getString("NICKNAME")
						               ));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return quArr;
	}

}
