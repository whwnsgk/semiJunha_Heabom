package com.heabom.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.heabom.board.model.vo.Answer;
import static com.heabom.common.JDBCTemplate.*;

public class AnswerDao {
	
	private Properties prop = new Properties();
	
	public AnswerDao() {
		try {
			prop.loadFromXML(new FileInputStream(AnswerDao.class.getResource("/db/sql/board-mapper.xml").getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Answer> selectAnswer(Connection conn, String memNo){
		// select문으로 resultset으로 받아 주어야 한다.
		ArrayList<Answer> anArr = new ArrayList<Answer>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAnswer");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				anArr.add(new Answer(rset.getInt("QUESTION_NO")
									,rset.getString("ANSWER_WRITER")
									,rset.getString("ANSWER_OR_NOT")
									,rset.getString("ANSWER_CONTENT")
									,rset.getDate("ANSWER_DATE")
									,rset.getString("NICKNAME")
									));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return anArr;
	}
}
