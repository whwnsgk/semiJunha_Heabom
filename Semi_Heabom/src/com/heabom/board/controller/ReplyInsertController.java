package com.heabom.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heabom.board.model.service.BoardService;
import com.heabom.board.model.vo.Reply;

/**
 * Servlet implementation class ReplyInsertController
 */
@WebServlet("/insert.rp")
public class ReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String boardNo = request.getParameter("boardNo");
		String replyContent = request.getParameter("reply-content");
		String userNo = request.getParameter("userNo");
		
		Reply r = new Reply();
		r.setBoardNo(boardNo);
		r.setReplyContent(replyContent);
		r.setReplyWriter(userNo);
		int result = new BoardService().insertReply(r);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/detail.bo?bno="+boardNo.substring(1));
		}else {
			request.setAttribute("errorMsg", "게시글 등록에 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
