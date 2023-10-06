package com.heabom.admin.model.service;

import static com.heabom.common.JDBCTemplate.close;
import static com.heabom.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.heabom.admin.model.dao.ReportDao;
import com.heabom.admin.model.vo.Report;
import com.heabom.board.model.dao.BoardDao;
import static com.heabom.common.JDBCTemplate.*;
import com.heabom.common.model.vo.PageInfo;
import com.heabom.member.model.dao.MemberDao;
import com.heabom.member.model.vo.Member;


public class ReportService {

	public int selectReportListCount() {
	      
	      Connection conn = getConnection();
	      
	      int listCount = new ReportDao().selectReportListCount(conn);
	      
	      close(conn);
	      return listCount;
	   }
	
	
	public int selectReportKeyWordCount(String keyWord) {
		
		Connection conn = getConnection();
		
		int listCount = new ReportDao().selectReportKeyWordCount(conn, keyWord);
		close(conn);
		return listCount;
	}
 
 
	public ArrayList<Report> selectReportList(PageInfo pi) {
	   
	      System.out.println(pi.getBoardLimit());
	      Connection conn = /*JDBCTemplate.*/getConnection();
	      
	      ArrayList<Report> list = new ReportDao().selectReportList(conn, pi);
	      
	      close(conn);
	      return list;
	      
	   }
	
	
	public ArrayList<Report> selectReportList(PageInfo pi, String keyWord){
		
		System.out.println(pi.getBoardLimit());
		Connection conn = getConnection();
		
		ArrayList<Report> list = new ReportDao().selectReportList(conn, pi, keyWord);
		
		close(conn);
		return list;
	}
	
	public int boardInReport(Report re) {
		Connection conn = getConnection();
		int result = new ReportDao().boardInReport(conn, re);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
}
