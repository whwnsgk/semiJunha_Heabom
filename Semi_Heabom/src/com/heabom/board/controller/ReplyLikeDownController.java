package com.heabom.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heabom.board.model.service.BoardService;
import com.heabom.place.model.service.PlaceService;

/**
 * Servlet implementation class ReplyLikeDownController
 */
@WebServlet("/likedown.bo")
public class ReplyLikeDownController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyLikeDownController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String rpno = request.getParameter("rpno");
		String loginMem = request.getParameter("loginMem");
		System.out.println(writer);	// 글쓴이
		System.out.println(rpno);	// 댓글 번호
		System.out.println(loginMem); // 로그인한 회원
		
		BoardService bservice = new BoardService();
		
		// 먼저 댓글번호를 가지고 가서 리뷰 리플라이 테이블 like 를 증가시킨다
		bservice.replyLikeDown(rpno,writer);
		
		// 좋아요 몇개인지 가져온다
		int replyLikeCount = new BoardService().replyLikeCount(rpno);
		
		// tb_like로가서 로그인멤버와 댓글 번호 업데이트
//		bservice.deleteLike(loginMem, rpno);
		
		// 등급업데이트
		if(!writer.equals("M1")) {
			new PlaceService().upGrade(writer);			
		}
		
		System.out.println("댓글수는 ? :" + replyLikeCount);
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(replyLikeCount);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
