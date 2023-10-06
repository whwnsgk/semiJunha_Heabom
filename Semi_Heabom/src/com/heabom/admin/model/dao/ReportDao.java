package com.heabom.admin.model.dao;

import static com.heabom.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.heabom.admin.model.vo.Report;
import com.heabom.board.model.dao.BoardDao;
import com.heabom.common.model.vo.PageInfo;
import com.heabom.member.model.vo.Member;

public class ReportDao {
	
private Properties prop = new Properties();
	
	public ReportDao() {
		try {
			prop.loadFromXML(new FileInputStream(BoardDao.class.getResource("/db/sql/admin-mapper.xml").getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int selectReportListCount(Connection conn) {
	      
	      int listCount = 0;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;

	      String sql = prop.getProperty("selectReportListCount");
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	            listCount = rset.getInt("count");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      return listCount;
	   }
	   
	   
	   public ArrayList<Report> selectReportList(Connection conn, PageInfo pi) {
	      
	      ArrayList<Report> list = new ArrayList<Report>();
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectReportList");
	      
	      int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit() + 1;
	      int endRow = startRow + pi.getBoardLimit() - 1;
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, startRow);
	         pstmt.setInt(2, endRow);
	         
	         rset = pstmt.executeQuery();
	         
	         while(rset.next()) {
                 list.add(new Report(
                     rset.getInt("REPORT_NO"),
                     rset.getString("REPORTER"),
                     rset.getString("REPORTED"),
                     rset.getString("REPORT_CATEGORY"),
                     rset.getDate("REPORT_DATE"),
                     rset.getDate("REPORT_COMPLITE"),
                     rset.getString("REPORT_STATUS")
                 ));
             }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      return list;
	   }
	   
	   
	   
	   
	   
	   
	   public int selectReportKeyWordCount(Connection conn, String keyWord) {
			
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectReportKeyWordCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, '%' + keyWord + '%');
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					listCount = rset.getInt("count");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return listCount;
			
		}
	   
	   
	   public ArrayList<Report> selectReportList(Connection conn, PageInfo pi, String keyWord){
			
			System.out.println(pi.getBoardLimit());
			
			ArrayList<Report> list = new ArrayList<Report>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectReportKeyWord");
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, '%' + keyWord + '%');
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rset = pstmt.executeQuery();
				
				while (rset.next()) {
		             list.add(new Report(
		            		 rset.getInt("REPORT_NO"),
		                     rset.getString("REPORTER"),
		                     rset.getString("REPORTED"),
		                     rset.getString("REPORT_CATEGORY"),
		                     rset.getDate("REPORT_DATE"),
		                     rset.getDate("REPORT_COMPLITE"),
		                     rset.getString("REPORT_STATUS")
		             ));
		         }
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			return list;
			
		}
	   
	   public int boardInReport(Connection conn,Report re) {
		   
		   int result = 0;
		   PreparedStatement pstmt = null;
		   String sql = prop.getProperty("boardInReport");
		   try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, re.getReporter());
			pstmt.setString(2, re.getReported());
			pstmt.setString(3, re.getReCategory());
			pstmt.setString(4, re.getReContent());
			pstmt.setString(5, re.getPostNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		   return result;
	   }
	
}
