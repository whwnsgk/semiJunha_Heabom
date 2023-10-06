package com.heabom.place.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.heabom.common.MyFileRenamePolicy;
import com.heabom.common.model.vo.File;
import com.heabom.member.model.vo.Member;
import com.heabom.place.model.service.PlaceService;
import com.heabom.place.model.vo.Place;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class PlaceInsertController
 */
@WebServlet("/insert.pl")
public class PlaceInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
		if(ServletFileUpload.isMultipartContent(request)) {
			System.out.println("앙기모띠");
			
			int maxSize = 10 *1024 * 1024;
			//저장시킬 폴더의 물리적인 경로
			String savePath = request.getSession().getServletContext().getRealPath("/resource/img/place_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath ,maxSize, "utf-8", new MyFileRenamePolicy());
			
			ArrayList<File> list = new ArrayList<File>();
			//최대 4개 최소 1개
			for(int i = 1 ; i <= 4 ; i ++) { //1 2 3 4
				String key = "file" + i ;
				if(multiRequest.getOriginalFileName(key)!= null ) {
					//원본명 수정명 폴더경로 파일레벨
					File at = new File();
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key)); //이게뭐지?
					at.setFilePath("resource/img/place_upfiles");
					if (i == 1 ) {//대표 이미지 일경우 
						at.setFileLevel(1);
					}else {
						at.setFileLevel(2);
					}
					list.add(at);
				}
				
			}
			
			
			
			
			HttpSession session = request.getSession();
			Member m  = (Member)session.getAttribute("loginMember");
			String writer = m.getMemNo();
			
			
			String placeTitle = multiRequest.getParameter("placeTitle");
			
			int categoryNo = 0 ; 
			String category = multiRequest.getParameter("category");
			if(category.equals("호프")) {
				categoryNo = 1 ;
			}else if (category.equals("카페")) {
				categoryNo = 2 ; 
			}else {
				categoryNo = 3 ; 
			}
			
			int locationNo = 0 ;
			String location = multiRequest.getParameter("location");
			
			switch (location) {
			case "강남구" : 
				locationNo = 1 ; 
				break;
			case "서초구" : 
				locationNo = 2 ; 
				break;
			case "동작구" : 
				locationNo = 3 ; 
				break;
			case "강서구" : 
				locationNo = 4 ; 
				break;
			case "양천구" : 
				locationNo = 5 ; 
				break;
			case "구로구" : 
				locationNo = 6 ; 
				break;
			case "금천구" : 
				locationNo = 7 ; 
				break;
			case "관악구" : 
				locationNo = 8 ; 
				break;
			case "영등포구" : 
				locationNo = 9 ; 
			case "송파구" : 
				locationNo = 10 ; 
				break;
			case "강동구" : 
				locationNo = 11 ; 
				break;
			case "광진구" : 
				locationNo = 12 ; 
				break;
			case "성동구" : 
				locationNo = 13 ; 
				break;
			case "용산구" : 
				locationNo = 14 ; 
				break;
			case "마포구" : 
				locationNo = 15 ; 
			case "서대문구" : 
				locationNo = 16 ; 
				break;
			case "중구" : 
				locationNo = 17 ; 
				break;
			case "동대문구" : 
				locationNo = 18 ; 
				break;
			case "중랑구" : 
				locationNo = 19 ; 
				break;
			case "종로구" : 
				locationNo = 20 ; 
				break;
			case "성북구" : 
				locationNo = 21 ; 
				break;
			case "은평구" : 
				locationNo = 22 ; 
				break;
			case "강북구" : 
				locationNo = 23 ; 
				break;
			case "도봉구" : 
				locationNo = 24 ; 
				break;
			case "노원구" : 
				locationNo = 25 ; 
				break;
			}
			System.out.println("움허허ㅓ허ㅓ" + locationNo);
			
			
			String phone = multiRequest.getParameter("phone");
			String address = multiRequest.getParameter("address");
			String placeContent = multiRequest.getParameter("content");
			int startTime = Integer.parseInt(multiRequest.getParameter("startTime"));
			int endTime = Integer.parseInt(multiRequest.getParameter("endTime"));
			int starPoint =  Integer.parseInt(multiRequest.getParameter("starPoint"));
			String placeUrl = multiRequest.getParameter("placeUrl");
			int useTime =  Integer.parseInt(multiRequest.getParameter("useTime"));
			int usePrice =  Integer.parseInt(multiRequest.getParameter("usePrice"));
			
			Place p = new Place();
			p.setWriter(writer);
			p.setPlaceTitle(placeTitle);
			p.setCategoryNo(categoryNo);
			p.setLocationNo(locationNo);
			p.setPhone(phone);
			p.setAddress(address);
			p.setPlaceContent(placeContent);
			p.setStarPoint(starPoint);
			p.setStartTime(startTime);
			p.setEndTime(endTime);
			p.setStarPoint(starPoint);
			p.setPlaceUrl(placeUrl);
			p.setUseTime(useTime);
			p.setUsePrice(usePrice);
			
			
			
			int result = new PlaceService().insertPlace(p , list);
			
			if (result > 0 ) {
				session.setAttribute("alertMsg", "등록성공");
				response.sendRedirect(request.getContextPath());
			}else {
			
				session.setAttribute("alertMsg", "등록실패 (아마 장소 제약조건 위배했을꺼에요 강남 서초 동작 중에 하나 선택하세요)");
				response.sendRedirect(request.getContextPath());
			}
			
			
			
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
