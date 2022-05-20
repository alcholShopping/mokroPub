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

import dao.ConsumerDao;
import dao.NoticeDao;

@WebServlet("/noticeListController")
public class NoticeListController extends HttpServlet {
	private NoticeDao noticeDao = new NoticeDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sessionMemberId값 가져오기
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		System.out.println(sessionMemberId + " <-- sessionMemberId doGet() consumerOneController"); // 디버깅
		
		// 페이징
		int totalCnt = noticeDao.selectNoticeTotal();
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int rowPerPage = 8;
		int beginRow = (currentPage-1) * rowPerPage; 
		int lastPage = (int)(Math.ceil((double)totalCnt/(double)rowPerPage)); 
		// 디버깅
		System.out.println(currentPage + " <-- currentPage doGet() noticeListController");	
		System.out.println(totalCnt + " <-- totalCnt doGet() noticeListController");
		System.out.println(rowPerPage + " <-- rowPerPage doGet() noticeListController");
		System.out.println(beginRow + " <-- beginRow doGet() noticeListController");
		System.out.println(lastPage+"<-- lastPage doGet() noticeListController");
	

		// notice의 리스트들을 보여주는 메서드 실행
		List<Map<String,Object>> noticeList = noticeDao.selectNoticeList(beginRow,rowPerPage);
		// 디버깅
		for(Map m : noticeList) {
			System.out.println(m.get("consumerId") + " <-- consumerId doGet() noticeListController ");
			System.out.println(m.get("noticeNo") + " <-- noticeNo doGet() noticeListController ");
			System.out.println(m.get("title") + " <-- title doGet() noticeListController ");
			System.out.println(m.get("createDate") + " <-- createDate doGet() noticeListController ");
		}
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage" , lastPage);
		request.setAttribute("noticeList", noticeList);
		
		request.getRequestDispatcher("/WEB-INF/view/community/notice/noticeList.jsp").forward(request, response);
	}

}
