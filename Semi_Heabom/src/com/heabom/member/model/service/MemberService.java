package com.heabom.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.heabom.common.JDBCTemplate.*;

import com.heabom.board.model.dao.BoardDao;
import com.heabom.board.model.vo.Board;
import com.heabom.common.model.vo.PageInfo;
import com.heabom.member.model.dao.MemberDao;
import com.heabom.member.model.vo.Member;
import com.heabom.member.model.vo.MemberAttachment;

public class MemberService {
   
   public int selectMemberListCount() {
         
         Connection conn = getConnection();
         
         int listCount = new MemberDao().selectMemberListCount(conn);
         
         close(conn);
         return listCount;
      }
   
   public int selectMemberKeyWordCount(String keyWord) {
      
      Connection conn = getConnection();
      
      int listCount = new BoardDao().selectKeyWordCount(conn, keyWord);
      close(conn);
      return listCount;
   }
      
      
      public ArrayList<Member> selectAdminList(PageInfo pi) {
      
         System.out.println(pi.getBoardLimit());
         Connection conn = /*JDBCTemplate.*/getConnection();
         
         ArrayList<Member> list = new MemberDao().selectAdminList(conn, pi);
         
         close(conn);
         return list;
         
      }
      
      public ArrayList<Member> selectAdminList(PageInfo pi, String keyWord){
         
         System.out.println(pi.getBoardLimit());
         Connection conn = getConnection();
         
         ArrayList<Member> list = new MemberDao().selectAdminList(conn, pi, keyWord);
         
         close(conn);
         return list;
      }
      
      
      
      
      
      public int deleteReportMember(String userId) {
         
         Connection conn = getConnection();
         
         int result = new MemberDao().deleteReportMember(conn, userId);
         
         if(result > 0) {
            commit(conn);
         }else {
            rollback(conn);
         }
         
         close(conn);
         
         return result;
      }
      
      
   
   public Member updateMember(Member m) {
	   
	  // System.out.println("여긴 service");
      // System.out.println("asdasd"+m.getMemId());
      // System.out.println("asss"+m.getMemPoint());
	   
      Connection conn = getConnection();
      
      int result = new MemberDao().updateMember(conn, m);
      
      Member updateMem = null;
      
      if(result > 0) {
         commit(conn);
         
         updateMem = new MemberDao().selectMember(conn, m.getMemId());
         
      }else {
         rollback(conn);
      }
      
      close(conn);
      
      return updateMem;
   }
   
   
   
   
   
   
   /**
    * 조준하
    *회원가입
    */
   public int insertMember(MemberAttachment at , Member m) {
      Connection conn = getConnection();
      int result1 = new MemberDao().insertMember(conn , m);
      
   
      int result2 = 1; 
      
      if (at != null) {
         result2 = new MemberDao().insertAttachment(conn, at);
      }
      System.out.println("여긴 service");
      System.out.println(result1 + " "  +result2 );
      
      if (result1 > 0 && result2 > 0) {
         commit(conn);
      }else {
         rollback(conn);
      }
      close(conn);
      System.out.println("controller 로 가는 리턴값 : " + (result1 * result2));
      return result1*result2 ; 
      
      
   }
   
   /**
    * 로그인 조준하
    */
   public Member loginMember(String memId , String memPwd) {
      Connection conn = getConnection();
      
      Member m = new MemberDao().loginMember(conn, memId, memPwd);
      close(conn);
      return m; 
   }
   
   public Member updatePwd(String userId,String userPwd,String updatePwd) {
      Connection conn = getConnection();
      int result = new MemberDao().updatePwd(conn, userId, userPwd, updatePwd);
      
      Member updateMem = null;
      
      if(result >0) {
         commit(conn);
         
         // 커밋으로 변경된 비밀번호를 확정해 주고 조회를 해와야 한다.
         updateMem = new MemberDao().selectMember(conn, userId);
      }else {
         rollback(conn);
      }
      
      close(conn);
      
      return updateMem;
   }
   
   public int myDetailUpdate(MemberAttachment at , Member m) {
      Connection conn = getConnection();
      int result1 = new MemberDao().myDetailUpdate(conn, m);
      int result2 = 1;
      
      if(at != null) {
         if(at.getFileNo() != 0) {
            result2 = new MemberDao().updateAttachment(conn, at, m);
         }else {
            result2 = new MemberDao().insertMemberDetailAttachment(conn, at, m);
         }
      }
      
      if(result1 > 0 && result2 >0) {
         commit(conn);
      }else {
         rollback(conn);
      }
      
      close(conn);
      
      return result1 * result2;
   }
   
   public int updateStatus(String userId, String userPwd) {
      Connection conn = getConnection();
      int result = new MemberDao().updateStatus(conn, userId, userPwd);
      
      if(result > 0) {
         commit(conn);
      }else {
         rollback(conn);
      }
      
      close(conn);
      
      return result;
      
   }
   
	   /**
	    * 아이디 중복검사
	 * @param idCheck
	 * @return
	 */
   public int idCheck(String idCheck) {
	   Connection conn = getConnection();
	   int result = new MemberDao().idCheck(conn , idCheck);
	   close(conn);
	   return result; 
   }
   
   
   
}