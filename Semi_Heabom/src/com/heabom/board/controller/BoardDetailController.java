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
import com.heabom.board.model.vo.PrevNextPage;
import com.heabom.board.model.vo.Reply;
import com.heabom.common.model.vo.File;
import com.heabom.common.model.vo.PageInfo;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/detail.bo")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String bno = (String)request.getParameter("bno");
		System.out.println(bno + "boardDetail 에서 bno");
		
		BoardService bService = new BoardService();
		
		
		int result = bService.increaseCount(bno);
		
		
		
		if(result>0) {
			Board b = bService.selectBoard(bno);
			ArrayList<File> flist = bService.selectFileList(b.getBoardNo());
			PrevNextPage p = new BoardService().prevNextBo(Integer.parseInt(bno));
			request.setAttribute("b", b);
			request.setAttribute("flist", flist);
			request.setAttribute("p", p);
			
			System.out.println(p+"Zzzzzzzzzzzzzzzzzzzzzz");
			
			int listCount; // 현재 총 게시글 개수
			int currentPage; // 현재 페이지
			int pageLimit; //  하단에 보여지는 페이징바의 최대개수
			int boardLimit; // 한 페이지내에 보여질 게시글 최대개수
			
			int maxPage; // 가장마지막 페이지
			int startPage; // 페이징바의 시작수
			int endPage; // 페이징바의 끝 수
			
		
			listCount = new BoardService().selectListCount();
				currentPage = 1;
//				currentPage = Integer.parseInt(request.getParameter("cpage2"));
				
//			currentPage = 1;
		
			boardLimit= 20;

			pageLimit = 10;
			
			maxPage = (int)Math.ceil((double)listCount / boardLimit);
			startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
			endPage = startPage + pageLimit - 1;
			
			if(endPage > maxPage) {
				endPage = maxPage;
			}
			
			PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
			request.setAttribute("pi", pi);
			request.setAttribute("bno", bno);
			request.setAttribute("cpage2", currentPage);
			
			request.getRequestDispatcher("views/board/boardDetailView.jsp").forward(request, response);
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
