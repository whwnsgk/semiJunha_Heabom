package com.heabom.place.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heabom.common.model.vo.File;
import com.heabom.place.model.service.PlaceService;
import com.heabom.place.model.vo.Place;

/**
 * Servlet implementation class MyPlaceViewController
 */
@WebServlet("/myplaceView.mp")
public class MyPlaceViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPlaceViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("이거타냐?");
		String pNo = request.getParameter("pNo");
		Place p = new PlaceService().selectMyPlace(pNo);
		ArrayList<File> myfileList = new PlaceService().selectFileList(pNo);
		if(!(myfileList.isEmpty())) {
			request.setAttribute("fileList", myfileList);
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
