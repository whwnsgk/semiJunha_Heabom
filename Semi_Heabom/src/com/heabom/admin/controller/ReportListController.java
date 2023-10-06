package com.heabom.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heabom.admin.model.service.ReportService;
import com.heabom.admin.model.vo.Report;
import com.heabom.common.model.vo.PageInfo;

/**
 * Servlet implementation class ReportListController
 */
@WebServlet("/report.ad")
public class ReportListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportListController() {
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
	      
	      listCount = new ReportService().selectReportListCount();
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
	      
	      ArrayList<Report> list = new ReportService().selectReportList(pi);
	      
	      request.setAttribute("pi", pi);
	      request.setAttribute("list", list);
		
		
		request.getRequestDispatcher("views/admin/reportListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
