package com.heabom.place.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heabom.common.model.vo.File;
import com.heabom.place.model.service.PlaceService;
import com.heabom.place.model.vo.Place;

/**
 * Servlet implementation class PlaceDetailViewController
 */
@WebServlet("/placeDetailView.pl")
public class PlaceDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		ArrayList<Place> list = (ArrayList<Place>)session.getAttribute("placeSearchList");
		int index = Integer.parseInt(request.getParameter("index"));
		//System.out.println(list.get(0));
		//System.out.println(inde;x)
		Place p = list.get(index);
		String pNo = list.get(index).getPlaceNo();
		ArrayList<File> fileList = new PlaceService().selectFileList(pNo);
		//session.removeAttribute("placeSearchList");
		
		if(!(fileList.isEmpty())) {
			request.setAttribute("fileList", fileList);
			request.setAttribute("placeInfo", p);
			request.getRequestDispatcher("views/place/placeDetailView.jsp").forward(request, response);
		}else {
			System.out.println("실패!");
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
