package com.heabom.course.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heabom.course.model.service.CourseService;
import com.heabom.place.model.service.PlaceService;
import com.heabom.place.model.vo.Place;

/**
 * Servlet implementation class SelectCourseFormController
 */
@WebServlet("/courseSelect.pl")
public class SelectCourseFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCourseFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();//전역으로 session 생성

		
		
		
		
		if(request.getParameter("pNo") != null) {//한번이상 다녀온거임
			int count = (int)session.getAttribute("count");
			
			
			ArrayList<String> courseList = (ArrayList<String>)session.getAttribute("courseList");
				
			session.setAttribute("count",count-1);//하나깎어 ㅅㅂ
			String pNo = request.getParameter("pNo");
			courseList.add(pNo);
			
			session.setAttribute("courseList", courseList);
			
			
			
			
			
			
			int lNo = (int)session.getAttribute("lNo");
			
			if(count != 1) {
				
				int checkArr [] = (int [])session.getAttribute("checkArr");
				
				
				int i = (int)session.getAttribute("i");
				
				int cNo = checkArr[i+1];
				
				session.setAttribute("i", i+1);
				session.setAttribute("checkArr", checkArr);
				
			ArrayList<Place> list = new CourseService().selectCourse(lNo,cNo); //지역과 카페인지 음식점인지 골라야함
			
			if(!(list.isEmpty())) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("views/course/selectCourse.jsp").forward(request, response);
				}else {
					session.setAttribute("alertMsg","등록된맛집이 없네용");
					response.sendRedirect(request.getContextPath());
				}
			}
			else {
				ArrayList<Place> coursePlaceList = new CourseService().selectCoursePlaceList(courseList);
				request.setAttribute("coursePlaceList", coursePlaceList);
				request.getRequestDispatcher("views/course/courseView.jsp").forward(request, response);
				
			}
			
		}else {//처음온거여
			
			ArrayList<String> courseList = new ArrayList<String>(); //코스 담을 어레이리스트
			session.setAttribute("courseList", courseList); 
			
			
			String arr [] =  request.getParameterValues("check").clone(); //뭐가 왔는지 좀 보자
			
			int checkArr [] = new int [arr.length]; //인트값 담을 체크 배열 생성
			for(int i = 0 ; i < arr.length ; i ++) {
				checkArr[i] = Integer.parseInt(arr[i]);
			}
			session.setAttribute("checkArr", checkArr);
			
			ArrayList searchKey = (ArrayList)session.getAttribute("searchKey");
			searchKey.add(checkArr); //1번인덱스에 추가 
			int lNo = (int)searchKey.get(0); //지역은 어디야?
			session.setAttribute("lNo", lNo);
			
			int count = checkArr.length ; 
			session.setAttribute("searchKey", searchKey);
			session.setAttribute("count", count);
			
			int cNo = checkArr[0]; //카페야 음식점이야?
			session.setAttribute("i",0);
			
			
			ArrayList<Place> list = new CourseService().selectCourse(lNo,cNo);
		
			
			
			if(!(list.isEmpty())) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/course/selectCourse.jsp").forward(request, response);
			}else {
				session.setAttribute("alertMsg","등록된맛집이 없네용");
				response.sendRedirect(request.getContextPath());
			}
			
			
			
			//request.getRequestDispatcher("views/course/selectCourse.jsp").forward(request, response);
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
