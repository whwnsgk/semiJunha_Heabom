package com.heabom.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.heabom.common.MyFileRenamePolicy;
import com.heabom.member.model.service.MemberService;
import com.heabom.member.model.vo.Member;
import com.heabom.member.model.vo.MemberAttachment;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MemberEnrollController
 */
@WebServlet("/insert.me")
public class MemberEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			System.out.println("이건되냐?");
			int maxSize = 10*1024*1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resource/img/profile/");
		
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",new MyFileRenamePolicy());		
			
			MemberAttachment at = null ; //넘어온 첨부 파일이 있다면 생성
			//첨부파일이 있는지 없는지 보자
			//multiRequest.getOriginalFileName("키")
			if(multiRequest.getOriginalFileName("upfile") != null) {//넘어온게 있어.
				at = new MemberAttachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				at.setFilePath("resource/img/profile");
			}
			
			String memId = multiRequest.getParameter("userId");
			String memPwd = multiRequest.getParameter("userPwd");
			String memName = multiRequest.getParameter("userName");
			String nickName = multiRequest.getParameter("nickName");
			String email = multiRequest.getParameter("email");
			String mbti = multiRequest.getParameter("mbti");
			String memphone = multiRequest.getParameter("phone");
			
			Member m = new Member();
			m.setMemId(memId);
			m.setMemPwd(memPwd);
			m.setMemName(memName);
			m.setEmail(email);
			m.setMbit(mbti);
			m.setMemPhone(memphone);
			m.setNickname(nickName);
			
			
			
			
			
			int result = new MemberService().insertMember(at , m); //db 에 넘기기 
			if (result>0) {
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "회원가입성공");
				response.sendRedirect(request.getContextPath());
			}else {
				System.out.println("실패");
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
