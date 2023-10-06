package com.heabom.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heabom.member.model.service.MemberService;

/**
 * Servlet implementation class MemberStatusUpdateController
 */
@WebServlet("/updateStatus.me")
public class MemberStatusUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberStatusUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		int result = new MemberService().updateStatus(userId, userPwd);
		
		HttpSession session = request.getSession();
		if(result == 0) { //실패
			session.setAttribute("alertMsg", "회원탈퇴에 실패하였습니다.");
			response.sendRedirect(request.getContextPath() + "/myPage.me");
		}else { //성공
			session.setAttribute("alertMsg", "그 동안 HeaBom과 함께 해주셔서 감사합니다.");
			session.removeAttribute("loginMember");
			response.sendRedirect(request.getContextPath());
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
