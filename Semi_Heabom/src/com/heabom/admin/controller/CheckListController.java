package com.heabom.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heabom.common.model.vo.PageInfo;
import com.heabom.member.model.service.MemberService;
import com.heabom.member.model.vo.Member;

/**
 * Servlet implementation class CheckListController
 */
@WebServlet("/check.ad")
public class CheckListController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckListController() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int listCount;
      int currentPage;
      int pageLimit;
      int boardLimit;
      
      int maxPage;
      int startPage;
      int endPage;
      
      listCount = new MemberService().selectMemberListCount();
      // currentPage = 1;
      currentPage = Integer.parseInt(request.getParameter("cpage"));
      
      boardLimit= 10;

      pageLimit = 10;
      
      maxPage = (int)Math.ceil((double)listCount / boardLimit);
      startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
      endPage = startPage + pageLimit - 1;
      
      if(endPage > maxPage) {
         endPage = maxPage;
      }
      
      PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
      
      ArrayList<Member> list = new MemberService().selectAdminList(pi);
      
      request.setAttribute("pi", pi);
      request.setAttribute("list", list);
      
      request.getRequestDispatcher("views/admin/checkListView.jsp").forward(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}