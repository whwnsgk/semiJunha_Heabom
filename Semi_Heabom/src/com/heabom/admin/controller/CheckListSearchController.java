package com.heabom.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heabom.board.model.service.BoardService;
import com.heabom.board.model.vo.Board;
import com.heabom.common.model.vo.PageInfo;
import com.heabom.member.model.service.MemberService;
import com.heabom.member.model.vo.Member;

/**
 * Servlet implementation class CheckListSearchController
 */
@WebServlet("/search.ck")
public class CheckListSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckListSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount; // 현재 총 게시글 개수
		int currentPage; // 현재 페이지
		int pageLimit; //  하단에 보여지는 페이징바의 최대개수
		int boardLimit; // 한 페이지내에 보여질 게시글 최대개수
		
		int maxPage; // 가장마지막 페이지
		int startPage; // 페이징바의 시작수
		int endPage; // 페이징바의 끝 수
		
		String keyWord = request.getParameter("keyword");
	
		listCount = new MemberService().selectMemberKeyWordCount(keyWord);
		currentPage = Integer.parseInt(request.getParameter("cpage"));
	
		boardLimit= 10;

		pageLimit = 10;
		System.out.println(boardLimit);
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		 if(endPage > maxPage) { 
			 endPage = maxPage;
		 }
		 
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		ArrayList<Member> list = new MemberService().selectAdminList(pi, keyWord);
		
		request.setAttribute("pi", pi);	
		request.setAttribute("list", list);
		request.setAttribute("keyWord", keyWord);
		
		request.getRequestDispatcher("views/admin/checkListSearchView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
