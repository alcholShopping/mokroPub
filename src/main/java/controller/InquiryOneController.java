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

@WebServlet("/inquiryOneController")
public class InquiryOneController extends HttpServlet {
	private InquiryDao inquiryDao = new InquiryDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sessionMemberId값 가져오기
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		System.out.println(sessionMemberId + " <-- sessionMemberId doGet() inquiryOneController"); // 디버깅
		
		// inquiryList.jsp에서 inquiryNo가져오기
		int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
		// noticeOne의 값을 가져오는 메서드 실행
		List<Map<String,Object>> inquiryOneList = inquiryDao.selectInquiryOne(inquiryNo);
		
		//디버깅 
		for(Map m : inquiryOneList) {
			System.out.println(m.get("inquiryNo") + " <-- inquiryNo doGet() inquiryOneController ");
			System.out.println(m.get("consumerId") + " <-- consumerId doGet() inquiryOneController ");
			System.out.println(m.get("category") + " <-- category doGet() inquiryOneController ");
			System.out.println(m.get("title") + " <-- title doGet() inquiryOneController ");
			System.out.println(m.get("content") + " <-- content doGet() inquiryOneController ");
			System.out.println(m.get("status") + " <-- status doGet() inquiryOneController ");
			System.out.println(m.get("answer") + " <-- answer doGet() inquiryOneController ");
			System.out.println(m.get("photo") + " <-- photo doGet() inquiryOneController ");
			System.out.println(m.get("createDate") + " <-- createDate doGet() inquiryOneController ");
		}
		
		request.setAttribute("inquiryOneList", inquiryOneList);
		request.getRequestDispatcher("/WEB-INF/view/community/inquiry/inquiryOne.jsp").forward(request, response);
	}

}
