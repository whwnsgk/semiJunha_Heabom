package com.heabom.place.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heabom.place.model.service.PlaceService;
import com.heabom.place.model.vo.Place;
import com.heabom.search.model.service.SearchService;

/**
 * Servlet implementation class SearchListViewController
 */
@WebServlet("/searchListView.pl")
public class SearchListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchListViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관련된 모든 장소들이 검색되어서 나올것이다.
		
		
		int lNo = Integer.parseInt(request.getParameter("lNo"));
		
		ArrayList<Place> list = new PlaceService().selectPlaceList(lNo);
		
		if(!(list.isEmpty())) {
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/place/placeListView.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg","등록된맛집이 없네용");
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
