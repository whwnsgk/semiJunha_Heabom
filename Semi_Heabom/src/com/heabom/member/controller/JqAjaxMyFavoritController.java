package com.heabom.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heabom.board.model.service.BoardService;
import com.heabom.board.model.vo.Board;
import com.heabom.place.model.service.PlaceService;
import com.heabom.place.model.vo.Place;

/**
 * Servlet implementation class JqAjaxMyFavoritController
 */
@WebServlet("/myFavoritAjax.do")
public class JqAjaxMyFavoritController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxMyFavoritController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memNo = request.getParameter("memNo");
		
		ArrayList<Place> fList = new PlaceService().myFavorSelect(memNo);
		
		request.setAttribute("fList", fList);
		request.getRequestDispatcher("views/member/myFavorit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
