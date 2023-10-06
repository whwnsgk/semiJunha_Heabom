package com.heabom.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heabom.admin.model.service.ReportService;
import com.heabom.admin.model.vo.Report;

/**
 * Servlet implementation class UserReportController
 */
@WebServlet("/insert2.rp")
public class BoardReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String reNo = request.getParameter("reNo");
		String reporter = request.getParameter("reporter");
		String reported = request.getParameter("reported");
		String reportType = request.getParameter("reportType");
		String reportContent = request.getParameter("reportContent");
		
		Report re = new Report();
		re.setPostNo(reNo);
		re.setReporter(reporter);
		re.setReported(reported);
		re.setReCategory(reportType);
		re.setReContent(reportContent);
		
		int result = new ReportService().boardInReport(re);
		
		if(result > 0) {
			request.setAttribute("alertMsg", "리뷰 신고에 실패하였습니다.");
			response.sendRedirect(request.getContextPath()+"/list.bo?cpage=1");
		}else {
			request.setAttribute("alertMsg", "리뷰 신고에 실패하였습니다.");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
