package com.heabom.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heabom.member.model.service.MemberService;
import com.heabom.member.model.vo.Member;

/**
 * Servlet implementation class ReportMemberDeleteController
 */
@WebServlet("/delete.re")
public class ReportMemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportMemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userId = request.getParameter("memId");
		
		System.out.println("안녕?");
		
		
		int result = new MemberService().deleteReportMember(userId);
		System.out.println(result);
		
		
		HttpSession session = request.getSession();
		
		if (result == 0) {
		    session.setAttribute("alertMsg", "추방 실패");
		    response.sendRedirect(request.getContextPath() + "/report.ad?cpage=1");
		} else {
			session.setAttribute("alertMsg", "추방 성공");
		    Member loginMember = (Member) session.getAttribute("loginMember");
		    
		    
		    
		    // 관리자의 경우 'loginMember' 속성을 제거하지 않음.
		    response.sendRedirect(request.getContextPath() + "/report.ad?cpage=1");
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
