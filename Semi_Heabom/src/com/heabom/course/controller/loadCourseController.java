package com.heabom.course.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heabom.course.model.service.CourseService;
import com.heabom.place.model.vo.Place;

/**
 * Servlet implementation class loadCourseController
 */
@WebServlet("/load.cs")
public class loadCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadCourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cNo  = request.getParameter("cNo");
		ArrayList<Place> list = new CourseService().loadCourse(cNo);
//		
//		for (int i = 0 ; i <list.size() ; i ++) {
//			System.out.println("안녕안녕!");
//			System.out.println(list.get(i));
//		}
		
		//courseview 는 list 조회기 때문에 이대로만 주면 됨
		if(list.isEmpty()) {
			System.out.println("이런시발");
		}else {
			request.setAttribute("coursePlaceList", list);
			request.getRequestDispatcher("views/course/courseView2.jsp").forward(request, response);
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
