package com.heabom.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heabom.member.model.service.MemberService;
import com.heabom.member.model.vo.Member;

/**
 * Servlet implementation class MemberPwdUpdateController
 */
@WebServlet("/updatePwd.me")
public class MemberPwdUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPwdUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String updatePwd = request.getParameter("updatePwd");
		Member updateMem = new MemberService().updatePwd(userId, userPwd, updatePwd);
		
		HttpSession session = request.getSession();
		if(updateMem == null) {
			session.setAttribute("alertMsg", "비밀번호 변경에 실패하였습니다.");
		}else {
			session.setAttribute("loginMember", updateMem);
			session.setAttribute("alertMsg", "성공적으로 비밀번호 변경되었습니다.");
		}
		response.sendRedirect(request.getContextPath() + "/myPage.me");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
