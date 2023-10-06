package com.heabom.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heabom.board.model.service.BoardService;

/**
 * Servlet implementation class ReplyDeleteController
 */
@WebServlet("/delete.rp")
public class ReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String rpNo = request.getParameter("rpno");
		String bno = request.getParameter("bno");
		System.out.println("rpno");
		int result = new BoardService().deleteReply(rpNo);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 댓긇이 삭제됐습니다.");
			response.sendRedirect(request.getContextPath()+"/detail.bo?bno="+bno.substring(1));
		}else {
			request.setAttribute("errorMsg", "댓글 삭제에 실패했습니다.");
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
