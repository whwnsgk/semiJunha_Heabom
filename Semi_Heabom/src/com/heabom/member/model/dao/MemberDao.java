package com.heabom.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.heabom.common.JDBCTemplate.*;

import com.heabom.admin.model.vo.Report;
import com.heabom.board.model.vo.Board;
import com.heabom.common.model.vo.PageInfo;
import com.heabom.member.model.vo.Member;
import com.heabom.member.model.vo.MemberAttachment;

public class MemberDao {
   private Properties prop = new Properties();
   
   public MemberDao() {
      String filePath = MemberDao.class.getResource("/db/sql/member-mapper.xml").getPath();
      
      try {
         prop.loadFromXML(new FileInputStream(filePath));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public int selectMemberListCount(Connection conn) {
         
         int listCount = 0;
         PreparedStatement pstmt = null;
         ResultSet rset = null;

         String sql = prop.getProperty("selectMemberListCount");
         
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
      
      
      public ArrayList<Member> selectAdminList(Connection conn, PageInfo pi) {
         
         ArrayList<Member> list = new ArrayList<Member>();
         
         PreparedStatement pstmt = null;
         ResultSet rset = null;
         
         String sql = prop.getProperty("selectAdminList");
         
         int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit() + 1;
         int endRow = startRow + pi.getBoardLimit() - 1;
         
         try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, startRow);
            pstmt.setInt(2, endRow);
            
            rset = pstmt.executeQuery();
            
            while (rset.next()) {
                list.add(new Member(
                    rset.getString("MEM_NO"),
                    rset.getString("MEM_ID"),
                    rset.getString("MEM_NAME"),
                    rset.getString("NICKNAME"),
                    rset.getString("GRADE"),
                    rset.getInt("MEM_POINT"),
                    rset.getDate("MEM_VISIT"),
                    rset.getString("EMAIL")
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
      
      public int selectMemberKeyWordCount(Connection conn, String keyWord) {
         
         int listCount = 0;
         PreparedStatement pstmt = null;
         ResultSet rset = null;
         
         String sql = prop.getProperty("selectMemberKeyWordCount");
         
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
      
      
      public ArrayList<Member> selectAdminList(Connection conn, PageInfo pi, String keyWord){
         
         System.out.println(pi.getBoardLimit());
         
         ArrayList<Member> list = new ArrayList<Member>();
         PreparedStatement pstmt = null;
         ResultSet rset = null;
         
         String sql = prop.getProperty("selectAdminKeyWord");
         
         int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit() + 1;
         int endRow = startRow + pi.getBoardLimit() - 1;
         
         try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, '%' + keyWord + '%');
            pstmt.setInt(2, startRow);
            pstmt.setInt(3, endRow);
            
            rset = pstmt.executeQuery();
            
            while (rset.next()) {
                   list.add(new Member(
                       rset.getString("MEM_NO"),
                       rset.getString("MEM_ID"),
                       rset.getString("MEM_NAME"),
                       rset.getString("NICKNAME"),
                       rset.getString("GRADE"),
                       rset.getInt("MEM_POINT"),
                       rset.getDate("MEM_VISIT"),
                       rset.getString("EMAIL")
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
      
      /*
      public int deleteReportMember(Connection conn, String userPwd) {
         
         int result = 0;
         
         PreparedStatement pstmt = null;
         
         String sql = prop.getProperty("deleteReportMember");
         
         try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, userPwd);
         
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
         return result;
      }
      */
      
      
      
      
      public int deleteReportMember(Connection conn, String userId) {
          
         int result = 0;

         
          PreparedStatement pstmt = null;
         
         try {
             // MEM_ID 및 MEM_PWD를 기반으로 회원 삭제하는 SQL 쿼리
             String sql = prop.getProperty("deleteReportMember");
             pstmt = conn.prepareStatement(sql);
             
             
             pstmt.setString(1, userId);     // MEM_ID 매개변수 설정

             result = pstmt.executeUpdate();

         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             close(pstmt);
         }

         return result;

      } 
      
      
      
   
   
   public int updateMember(Connection conn, Member m) {
      
      int result = 0;
      
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("updateMember");
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setInt(1, m.getMemPoint());
         pstmt.setString(2, m.getMemId());
         
         result = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
      
      return result;
   }
   
   
   
   
   
   
   public int insertMember(Connection conn , Member m) {
      int result =0; 
      PreparedStatement pstmt = null ; 
      String sql = prop.getProperty("insertMember");
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, m.getMemId());
         pstmt.setString(2, m.getMemPwd());
         pstmt.setString(3, m.getMemName());
         pstmt.setString(4, m.getNickname());
         pstmt.setString(5, m.getEmail());
         pstmt.setString(6, m.getMbit());
         pstmt.setString(7, m.getMemPhone());
         result = pstmt.executeUpdate();
         
      } catch (SQLException e) {
      
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
      return result ; 
      
   }
   
   public Member loginMember(Connection conn , String memId , String memPwd) {
      ResultSet rset = null ;
      PreparedStatement pstmt = null;
      Member m = null ;
      
      
      String sql = prop.getProperty("loginMember");
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, memId);
         pstmt.setString(2, memPwd);
         rset = pstmt.executeQuery();
         
         
         if(rset.next()) {
             m  = new Member(rset.getString("MEM_NO")
                    ,rset.getString("GRADE")
                    ,rset.getString("MEM_ID")
                    ,rset.getString("MEM_PWD")
                    ,rset.getString("MEM_NAME")
                    ,rset.getString("NICKNAME")
                    ,rset.getString("EMAIL")
                    ,rset.getString("MBTI")
                    ,rset.getString("MEM_PHONE")
                    ,rset.getDate("ENROLL_DATE")
                    ,rset.getString("MEM_STATUS")
                    ,rset.getDate("MEM_VISIT")
                    ,rset.getString("MEM_BIRTHDAY")
                    ,rset.getInt("MEM_POINT")
                     ,rset.getString("TITLEIMG")
                     ,rset.getInt("FILE_LEVEL"));
         }
         
      } catch (SQLException e) {
         
         e.printStackTrace();
      }finally {
         close(rset);
         close(pstmt);
      }

      return m ;
   }
   
   
   /**
    * 프사 첨부 
    * 조준하
    * @return
    */
   public int insertAttachment(Connection conn , MemberAttachment at) {
      int result = 0 ; 
      PreparedStatement pstmt = null;
      String sql = prop.getProperty("insertAttachment");
      
      try {
         pstmt= conn.prepareStatement(sql);
         pstmt.setString(1,at.getOriginName());
         pstmt.setString(2, at.getChangeName());
         pstmt.setString(3, at.getFilePath());
         result = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
      return result ; 
   }
   
   public int insertMemberDetailAttachment(Connection conn , MemberAttachment at, Member m) {
      int result = 0 ; 
      PreparedStatement pstmt = null;
      String sql = prop.getProperty("insertMemberDetailAttachment");
      
      System.out.println("여기는 DAO");
      System.out.println(at.getOriginName());
      System.out.println(at.getChangeName());
      System.out.println(at.getFilePath());
      System.out.println(m.getMemNo());
      
      try {
         pstmt= conn.prepareStatement(sql);
         pstmt.setString(1, at.getOriginName());
         pstmt.setString(2, at.getChangeName());
         pstmt.setString(3, at.getFilePath());
         pstmt.setString(4, m.getMemNo());
         result = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
      return result ; 
   }
   
   public int updatePwd(Connection conn,String userId,String userPwd,String updatePwd) {
      int result = 0;
      PreparedStatement pstmt = null;
      String sql = prop.getProperty("updatePwd");
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, updatePwd);
         pstmt.setString(2, userId);
         pstmt.setString(3, userPwd);
         
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }
   
   public Member selectMember(Connection conn, String userId) {
      Member m = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String sql = prop.getProperty("selectMember");
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, userId);
         rset = pstmt.executeQuery();
         if(rset.next()) {
             m  = new Member(rset.getString("MEM_NO")
                    ,rset.getString("GRADE")
                    ,rset.getString("MEM_ID")
                    ,rset.getString("MEM_PWD")
                    ,rset.getString("MEM_NAME")
                    ,rset.getString("NICKNAME")
                    ,rset.getString("EMAIL")
                    ,rset.getString("MBTI")
                    ,rset.getString("MEM_PHONE")
                    ,rset.getDate("ENROLL_DATE")
                    ,rset.getString("MEM_STATUS")
                    ,rset.getDate("MEM_VISIT")
                    ,rset.getString("MEM_BIRTHDAY")
                    ,rset.getInt("MEM_POINT"));
         }
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      return m;
   }
   
   public int myDetailUpdate(Connection conn,Member m) {
      System.out.println("여기는Dao");
      System.out.println(m.getNickname());
      System.out.println(m.getEmail());
      System.out.println(m.getMbit());
      System.out.println(m.getMemPhone());
      System.out.println(m.getMemBirthday());
      System.out.println(m.getMemId());
      
      int result = 0;
      PreparedStatement pstmt = null;
      String sql = prop.getProperty("myDetailUpdate");
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, m.getNickname());
         pstmt.setString(2, m.getEmail());
         pstmt.setString(3, m.getMbit());
         pstmt.setString(4, m.getMemPhone());
         pstmt.setString(5, m.getMemBirthday());
         pstmt.setString(6, m.getMemId());
         
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }
   
   public int updateAttachment(Connection conn,MemberAttachment at, Member m) {
      int result = 0;
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("updateAttachment");
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, at.getOriginName());
         pstmt.setString(2, at.getChangeName());
         pstmt.setString(3, at.getFilePath());
         pstmt.setString(4, m.getMemNo());
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }
   
   public int updateStatus(Connection conn,String userId,String userPwd) {
      System.out.println(userId);
      System.out.println(userPwd);
      int result = 0;
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("updateStatus");
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, userId);
         pstmt.setString(2, userPwd);
         
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }
   
	/**
	 * 아이디 중복검사
	 * @param conn
	 * @param idCheck
	 * @return
	 */
	public int idCheck(Connection conn , String idCheck) {
		ResultSet rset = null ;
		int result = 0 ; 
		PreparedStatement pstmt = null ;
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idCheck);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = 1 ; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result ;
		
	}
   
}









