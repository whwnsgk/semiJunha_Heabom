package com.heabom.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10*1024*1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resource/img/profile/");
		
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",new MyFileRenamePolicy());		
			
			MemberAttachment at = null ; //넘어온 첨부 파일이 있다면 생성
			if(multiRequest.getOriginalFileName("viewTitleImg") != null) {//넘어온게 있어.
				at = new MemberAttachment();
				at.setOriginName(multiRequest.getOriginalFileName("viewTitleImg"));
				at.setChangeName(multiRequest.getFilesystemName("viewTitleImg"));
				at.setFilePath("resource/img/profile");
			}
			
			String memId = multiRequest.getParameter("userId");
			String memPwd = multiRequest.getParameter("userPwd");
			String memName = multiRequest.getParameter("userName");
			String nickName = multiRequest.getParameter("nickName");
			String email = (multiRequest.getParameter("userEamil") == null) ? "" : multiRequest.getParameter("userEamil");
			String mbti = (multiRequest.getParameter("userMbti") == null) ? "" : multiRequest.getParameter("userMbti");
			String memphone = multiRequest.getParameter("userPhone");
			String memBirth = (multiRequest.getParameter("userBirth") == null) ? "1111-11-11" : multiRequest.getParameter("userBirth"); 
			String memNo = multiRequest.getParameter("userNo");
			
			Member m = new Member();
			m.setNickname(nickName);
			m.setMemId(memId);
			m.setMemPwd(memPwd);
			m.setEmail(email);
			m.setMbit(mbti);
			m.setMemPhone(memphone);
			m.setMemBirthday(memBirth);
			m.setMemNo(memNo);

			int result = new MemberService().myDetailUpdate(at , m); //db 에 넘기기
			Member updateMem = new MemberService().loginMember(memId, memPwd);
			
			HttpSession session = request.getSession();
			if (result > 0) {
				session.setAttribute("alertMsg", "개인정보수정 성공");
				session.setAttribute("loginMember", updateMem);
				request.getRequestDispatcher("views/member/myPage.jsp").forward(request, response);
			}else {
				session.setAttribute("alertMsg", "개인정보수정 실패");
				request.getRequestDispatcher("views/member/myPage.jsp").forward(request, response);
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
