package com.heabom.place.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heabom.member.model.vo.Member;
import com.heabom.place.model.service.PlaceService;
import com.heabom.place.model.vo.Place;

/**
 * Servlet implementation class PlaceLikeUpController
 */
@WebServlet("/likeup.pl")
public class PlaceLikeUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceLikeUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNo = request.getParameter("input");
		String writer = request.getParameter("test");
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginMember");
		String memNo = m.getMemNo();
		//System.out.println(memNo);
//		System.out.println(pNo);
//		System.out.println("?뭐여");
		
		//먼저 LIKE TB 에 있나 없나 확인을 해보자 
		int check = new PlaceService().likeCheck(memNo , pNo);
		// 0 이면 좋아요 눌릴것이고 1이면 돌려 보낼꺼임
		System.out.println(check);
		if(check > 0 ) {
			int responseData = 99999 ;
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(responseData);
		}else {
			int result2 =  new PlaceService().likeInput(memNo , pNo);//resutl2 도 필요없긴해 사실 void 하고 싶었어..
			int result = new PlaceService().likeUp(pNo); //좋아요 증가result 필요없을듯?
			int likeCount = new PlaceService().likeCount(pNo);
			
			//좋아요 눌리면 그 쓴놈의 포인트를 증가시켜줍니다
			int result4 = new PlaceService().upPoint(writer);
			
			//그 등급도 업데이트를 시켜야 할듯합니다..
			int result3 = new PlaceService().upGrade(writer);
			System.out.println(result3 + " "+ result4);
			
			int responseData = likeCount ;
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(responseData);
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
