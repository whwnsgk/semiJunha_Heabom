package com.heabom.board.controller;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.heabom.board.model.dao.BoardDao;
import com.heabom.board.model.service.BoardService;
import com.heabom.board.model.vo.Board;
import com.heabom.common.MyFileRenamePolicy;
import com.heabom.common.model.vo.File;
import com.heabom.common.model.vo.HashTag;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/update.bo")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10*1024*1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resource/img/board/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "utf-8", new MyFileRenamePolicy());
			
			String boardTitle = multiRequest.getParameter("title");
			String boardCategory = multiRequest.getParameter("category");
			String boardContent = multiRequest.getParameter("content");
			String noticeUp = multiRequest.getParameter("noticeUp");
			String MemNo = multiRequest.getParameter("userNo");
			String boardNo = multiRequest.getParameter("boardNo");
			System.out.println(boardNo + "뭐냐");
			
			Board b = new Board();
			
			b.setBoardTitle(boardTitle);
			b.setBoardNo(boardNo);
			b.setBoardContent(boardContent);
			if(noticeUp == null) {
				noticeUp = "N";
			}
			b.setBoardup(noticeUp);	
			b.setBoardContent(boardContent);
			b.setWriter(MemNo);
			

			int result = new BoardService().updateBoard(b);
			// 기존에 사진이 3개있었다면 첫번째 두번째 세번째에 있던 사진의 사진 no 가필요함 
			// 그 사진 no를 이용해서 file1 의 값이 있다면 원래사진 no를 가져감
			System.out.println(boardNo);
			
			ArrayList<File> originFileList = new BoardService().selectAttachmentList(boardNo);
			System.out.println("오리진 파일리스트" + originFileList.size());
			
			for(File f : originFileList) {
				System.out.println(f);
			}
			ArrayList<File> updateInsertList = new ArrayList<File>();
			
			
			
			for(int i = 1; i <= 5; i++) {
				String key = "file" + i;
				
				System.out.println(multiRequest.getOriginalFileName(key));
				if(multiRequest.getOriginalFileName(key) != null) {	// 새롭게 추가된 파일이라면
					
					// 첫번째 파일이 그대로 두번째 삽입
						System.out.println(key);
						File f = new File();
			
						// 보드넘버 세팅
						if(i < originFileList.size()) {
							f.setFileNo(originFileList.get(i-1).getFileNo());							
							}
						else {
							f.setFileNo("");							
						}
						f.setOriginName(multiRequest.getOriginalFileName(key));
						f.setChangeName(multiRequest.getFilesystemName(key));
						f.setFilePath("resource/img/board");
						updateInsertList.add(f);
				}else {
					File f = new File();
//					String fNo = (String)multiRequest.getParameter("hidden" + i);
					String fNo ="";
					if(i <= originFileList.size()) {
						fNo = originFileList.get(i-1).getFileNo();
						
					}else {
						fNo = "";
					}
					
					f.setFileNo(fNo);
					updateInsertList.add(f);
				}
			}
			
			int result1 =1;
			int result2 =1;
			
			for(int i = 0; i < updateInsertList.size(); i++) {
				String fNo = "";
				if(i < originFileList.size()) {
					fNo = originFileList.get(i).getFileNo();
				}else {
					fNo ="";
				}
				
				
				if(!fNo.isEmpty()) { 
					String s = (String)multiRequest.getParameter("hidden" + (i+1));
					
					if(updateInsertList.get(i).getOriginName()==null&&(s.isEmpty()|| s==null)&& updateInsertList.get(i).getFileNo()!=null) {
						// 기존파일을 삭제한 경우
						result1 = new BoardService().updateFileStatus(originFileList.get(i));
					}else {
						// 기존파일을 수정한경우
						if(updateInsertList.get(i).getOriginName()!=null) {
							result1 = new BoardService().updateFile(updateInsertList.get(i));
						}
					}
				}else if(updateInsertList.get(i).getOriginName()!=null) {
					result1 = new BoardService().insertFile2(updateInsertList.get(i),boardNo);	
					// 새로운 파일을 추가한경우
				}
				// 그냥 비어있는 경우
			}
			int check = new BoardService().checkHash(boardNo);
			
			int checkyn  = 0;
			
			String hashList = multiRequest.getParameter("tag");
			if(!hashList.isEmpty()) {
				HashTag ht = new HashTag();
				ht.setCategoryNo(boardNo);
				ht.setHashTagName(hashList);
				System.out.println(ht + "해시태그임");
				if(check == 0) {
					checkyn = new BoardService().insertHash(ht); 
				}else {
					
					result2 = new BoardService().updateHash(ht);
				}

			}
			System.out.println(result);
			System.out.println(result1);
			System.out.println(result2);
			System.out.println(b);
			
			if(result*result1*result2 > 0 ) {
				response.sendRedirect(request.getContextPath()+"/detail.bo?bno="+boardNo.substring(1));
				
			}else {
				request.setAttribute("errorMsg", "게시물 수정에 실패했습니다.");
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				view.forward(request, response);
				
			}


		}
	}
			
			
			
			
			
			
			
				
			
		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
