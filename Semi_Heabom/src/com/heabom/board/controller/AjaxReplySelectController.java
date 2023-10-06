package com.heabom.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.heabom.board.model.service.BoardService;
import com.heabom.board.model.vo.Reply;

/**
 * Servlet implementation class AjaxReplySelectController
 */
@WebServlet("/rlist.bo")
public class AjaxReplySelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplySelectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bno = request.getParameter("bno");
		ArrayList<Reply> rlist = new BoardService().selectReplyList(bno);
		for(Reply r : rlist) {
			System.out.println(r);
		}
		System.out.println(bno);
		System.out.println("댓글 조회 에이작스 컨트롤러");
		response.setContentType("application/json; charset=UTF-8");
		System.out.println(rlist);
		new Gson().toJson(rlist, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
