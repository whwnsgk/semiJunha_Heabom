package com.heabom.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heabom.course.model.dao.CourseDao;
import com.heabom.course.model.service.CourseService;
import com.heabom.course.model.vo.Course;
import com.heabom.member.model.service.MemberService;
import com.heabom.member.model.vo.Member;

/**
 * Servlet implementation class JqAjaxMyCourseController
 */
@WebServlet("/myCourseDetailAjax.do")
public class JqAjaxMyCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxMyCourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memNo = request.getParameter("memNo");
		ArrayList<Course> clist = new CourseService().myCourseSelect(memNo);
		request.setAttribute("clist", clist);
		request.getRequestDispatcher("views/member/myCourse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
