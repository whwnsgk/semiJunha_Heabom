package com.heabom.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.heabom.board.model.dao.AnswerDao;
import com.heabom.board.model.service.AnswerService;
import com.heabom.board.model.service.QuestionService;
import com.heabom.board.model.vo.Answer;
import com.heabom.board.model.vo.Question;

/**
 * Servlet implementation class JqAjaxMyQnADetailController
 */
@WebServlet("/myQnaDetailAjax.do")
public class JqAjaxMyQnADetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxMyQnADetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memNo = request.getParameter("memNo");

		ArrayList<Question> quArr = new QuestionService().selectQuestion(memNo);

		request.setAttribute("quArr", quArr);
		
		request.getRequestDispatcher("views/member/myQnA.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
