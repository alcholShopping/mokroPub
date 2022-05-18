package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.InquiryDao;

@WebServlet("/deleteInquiryController")
public class DeleteInquiryController extends HttpServlet {
	private InquiryDao inquiryDao = new InquiryDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		// inquiryOne.jsp에서 값 받아오기
		int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
		String accessId = request.getParameter("consumerId");		
		// 디버깅
		System.out.println(accessId + " <-- sessoinMemberId doGet() updateInquiryController");
		System.out.println(sessionMemberId + " <-- sessoinMemberId doGet() updateInquiryController");
		System.out.println(inquiryNo + " <-- inquiryNo doGet() updateInquiryController");
		
		if( (sessionMemberId == null) || (!sessionMemberId.equals(accessId)) ) {
			// sessionMemberId가 글쓴이가 아니고 비로그인상태면 loginController로 이동
			response.sendRedirect(request.getContextPath()+"/loginController");
			return;
		}		
		inquiryDao.deleteInquiry(inquiryNo);
		
		response.sendRedirect(request.getContextPath()+"/inquiryListController");
	}
}
