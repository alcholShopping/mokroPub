package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.InquiryDao;

@WebServlet("/answerInquiryController")
public class AnswerInquiryController extends HttpServlet {
	private InquiryDao inquiryDao = new InquiryDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sessionMemeberId 값 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		String accessId = "admin";
		System.out.println(sessionMemberId + " <-- sessoinMemberId doGet() answerInquiryController");
		if( (sessionMemberId == null) || (!sessionMemberId.equals(accessId)) ) {
			// sessionMemberId가 admin이 아니면 inquiryListController로 이동
			System.out.println(sessionMemberId + " <-- sessoinMemberId doGet() answerInquiryController");
			response.sendRedirect(request.getContextPath()+"/inquiryListController");
			return;
		}		
		
		int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
		List<Map<String,Object>> inquiryOneList = inquiryDao.selectInquiryOne(inquiryNo);
		
		request.setAttribute("inquiryOneList", inquiryOneList);	
		
		request.getRequestDispatcher("/WEB-INF/view/community/inquiry/answerInquiry.jsp").forward(request, response);		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sessionMemeberId 값 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		String accessId = "admin";
		System.out.println(sessionMemberId + " <-- sessoinMemberId doPost() answerInquiryController");
		if( (sessionMemberId == null) || (!sessionMemberId.equals(accessId)) ) {
			// sessionMemberId가 admin이 아니면 inquiryListController로 이동
			System.out.println(sessionMemberId + " <-- sessoinMemberId doPost() answerInquiryController");
			response.sendRedirect(request.getContextPath()+"/inquiryListController");
			return;
		}
		
		int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
		String answer = request.getParameter("answer");
		String status = "답변 완료";
		System.out.println(inquiryNo + " <-- inquiryNo doPost() answerInquiryController");
		System.out.println(answer + " <-- answer doPost() answerInquiryController");
		inquiryDao.answerInquiry(inquiryNo,answer,status);
		
		response.sendRedirect(request.getContextPath()+"/inquiryOneController?inquiryNo=" + inquiryNo);
	}

}
