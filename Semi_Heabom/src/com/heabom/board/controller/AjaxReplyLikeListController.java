package com.heabom.board.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.heabom.board.model.service.BoardService;
import com.heabom.board.model.vo.Board;

/**
 * Servlet implementation class AjaxReplyLikeListController
 */
@WebServlet("/likelist.bo")
public class AjaxReplyLikeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyLikeListController() {
        
		
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("좋아요 목록 에이작스 들어오냐?");
		String mno = request.getParameter("mno");
				
				
		ArrayList lList = new BoardService().selectLikeList(mno);
		System.out.println(lList);
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(lList, response.getWriter());
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
