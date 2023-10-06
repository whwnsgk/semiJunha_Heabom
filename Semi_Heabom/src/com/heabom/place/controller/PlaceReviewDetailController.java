package com.heabom.place.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.heabom.common.MyFileRenamePolicy;
import com.heabom.member.model.vo.MemberAttachment;
import com.heabom.place.model.service.PlaceService;
import com.heabom.place.model.vo.Review;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class PlaceReviewDetailController
 */
@WebServlet("/review.pl")
public class PlaceReviewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceReviewDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			System.out.println("여기는 리뷰 컨트롤러");
			int maxSize = 10*1024*1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resource/img/place_review/");
		
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",new MyFileRenamePolicy());		
			
			
			String content = multiRequest.getParameter("content");
			int star = Integer.parseInt(multiRequest.getParameter("star"));
			String refNo = multiRequest.getParameter("refNo");
			String writer = multiRequest.getParameter("writer");
			String file1 = (multiRequest.getFile("file1")+"");
			System.out.println("file(좀 넘어와) : " + file1);
			MemberAttachment at = null ; //넘어온 첨부 파일이 있다면 생성
			if(file1.length() > 10) {
				String[] fileList = file1.split("\\\\");
				String getOriginalFileName = fileList[7];
				String getFilesystemName = fileList[7];
				
				at = new MemberAttachment();
				at.setOriginName(getOriginalFileName);
				at.setChangeName(getFilesystemName);
				at.setFilePath("resource/img/place_review");
			}
			
			Review re = new Review();
			re.setReRefNo(refNo);
			re.setReContent(content);
			re.setReRefStar(star);
			re.setReWriter(writer);
			
			int result = new PlaceService().insertReview(re, at);
			System.out.println("돌아온result : " + result);
			//response.setContentType("text/html; charset=utf-8");
			response.getWriter().print(result);
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
