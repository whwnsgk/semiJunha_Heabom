package com.heabom.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heabom.board.model.service.BoardService;
import com.heabom.board.model.vo.Board;
import com.heabom.common.model.vo.File;
import com.heabom.common.model.vo.HashTag;
import com.google.gson.Gson;

/**
 * Servlet implementation class BoardUpdateFormController
 */
@WebServlet("/updateForm.bo")
public class BoardUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardNo = request.getParameter("bno");
		System.out.println(boardNo + "업데이트전 bno");
		
		BoardService bservice = new BoardService();
		Board b = bservice.selectBoard(boardNo.substring(1));
		System.out.println("업데이트에서 b출력 : " + b);
		
		ArrayList<File> list = bservice.selectAttachmentList(boardNo);
		System.out.println("업뎃전 리스트"+list);
		Gson gson = new Gson();
		String gsonList = gson.toJson(list);
		
		HashTag htag = bservice.selectHashTag(boardNo);
		System.out.println("업데이트에서 htag 출력 : " + htag);
		
		String htagList = htag.getHashTagName();
	
		request.setAttribute("htagList", htagList);
		request.setAttribute("b", b);
		request.setAttribute("gsonList", gsonList);
		request.getRequestDispatcher("views/board/boardUpdateForm.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
