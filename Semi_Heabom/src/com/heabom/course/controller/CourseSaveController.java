package com.heabom.course.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heabom.course.model.service.CourseService;
import com.heabom.member.model.vo.Member;

/**
 * Servlet implementation class CourseSaveController
 */
@WebServlet("/saveCourse.pl")
public class CourseSaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseSaveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//분기를 세번해야겠다.
		String pl1 = request.getParameter("str1");
		String pl2 = request.getParameter("str2");
		String pl3 = request.getParameter("str3");
		int time = Integer.parseInt(request.getParameter("time"));
		int money = Integer.parseInt(request.getParameter("money"));
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginMember");
		String writer = m.getMemNo();
		
		
		int result = 0 ; 
		if(pl2 == null) {
			 result = new CourseService().saveCourse1(writer,pl1,time,money);
		}else if(pl3 == null ) {
			 result = new CourseService().saveCourse2(writer,pl1,pl2,time,money);
		}else {
			 result = new CourseService().saveCourse3(writer,pl1,pl2,pl3,time,money);
		}
		System.out.println("왜 안됨 ?" + result);
		if(result>0) {
			session.setAttribute("alertMsg", "저장성공");
			response.sendRedirect(request.getContextPath());
		}else {
			System.out.println("실패");
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
