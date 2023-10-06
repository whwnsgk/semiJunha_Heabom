package com.heabom.common.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heabom.common.model.service.MainService;
import com.heabom.common.model.vo.File;
import com.heabom.place.model.service.PlaceService;
import com.heabom.place.model.vo.Place;

/**
 * Servlet implementation class MoveBestController
 */
@WebServlet("/movebest.mi")
public class MoveBestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveBestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNo = request.getParameter("pNo");
		ArrayList<File> fileList = new PlaceService().selectFileList(pNo); //재활용좀 합시다..
		Place p = new MainService().selectBestPlace(pNo);
//		ArrayList<File> fileList =new ArrayList<File>();
//		Place p = new Place();
		request.setAttribute("placeInfo", p);
		request.setAttribute("fileList", fileList);
		request.getRequestDispatcher("views/place/placeDetailView.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
