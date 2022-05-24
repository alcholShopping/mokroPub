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

@WebServlet("/inquiryListController")
public class InquiryListController extends HttpServlet {
	private InquiryDao inquiryDao = new InquiryDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sessionMemeberId 값 받아오기
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		System.out.println(sessionMemberId + " <-- sessionMemberId doGet() inquiryListController"); // 디버깅
		
		// inquiryList 나오게 하는 메서드 실행
		// 페이징
		int totalCnt = inquiryDao.selectInquiryTotal();
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int rowPerPage = 7;
		int beginRow = (currentPage-1) * rowPerPage; 
		int lastPage = (int)(Math.ceil((double)totalCnt/(double)rowPerPage)); 
		// 디버깅
		System.out.println(currentPage + " <-- currentPage doGet() inquiryListController");	
		System.out.println(totalCnt + " <-- totalCnt doGet() inquiryListController");
		System.out.println(rowPerPage + " <-- rowPerPage doGet() inquiryListController");
		System.out.println(beginRow + " <-- beginRow doGet() inquiryListController");
		System.out.println(lastPage+"<-- lastPage doGet() inquiryListController");
		
		// notice의 리스트들을 보여주는 메서드 실행
		List<Map<String,Object>> inquiryList = inquiryDao.selectInquiryList(beginRow,rowPerPage);
		// 디버깅
		for(Map m : inquiryList) {
			System.out.println(m.get("consumerId") + " <-- consumerId doGet() inquiryListController ");
			System.out.println(m.get("inquiryNo") + " <-- inquiryNo doGet() inquiryListController ");
			System.out.println(m.get("title") + " <-- title doGet() inquiryListController ");
			System.out.println(m.get("createDate") + " <-- createDate doGet() inquiryListController ");
		}
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage" , lastPage);
		request.setAttribute("inquiryList", inquiryList);	
		
		request.getRequestDispatcher("/WEB-INF/view/community/inquiry/inquiryList.jsp").forward(request, response);
	}

}
