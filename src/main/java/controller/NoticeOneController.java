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

import dao.NoticeDao;

@WebServlet("/noticeOneController")
public class NoticeOneController extends HttpServlet {
	private NoticeDao noticeDao = new NoticeDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sessionMemberId값 가져오기
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		System.out.println(sessionMemberId + " <-- sessionMemberId doGet() consumerOneController"); // 디버깅
		
		// notice.jsp에서 noticeNo가져오기
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		// noticeOne의 값을 가져오는 메서드 실행
		List<Map<String,Object>> noticeOneList = noticeDao.selectNoticeOne(noticeNo);
		
		//디버깅 
		for(Map m : noticeOneList) {
			System.out.println(m.get("consumerId") + " <-- consumerId doGet() noticeOneController ");
			System.out.println(m.get("noticeNo") + " <-- noticeNo doGet() noticeOneController ");
			System.out.println(m.get("title") + " <-- title doGet() noticeOneController ");
			System.out.println(m.get("content") + " <-- content doGet() noticeOneController ");
			System.out.println(m.get("photo") + " <-- photo doGet() noticeOneController ");
			System.out.println(m.get("createDate") + " <-- createDate doGet() noticeOneController ");
			System.out.println(m.get("updateDate") + " <-- updateDate doGet() noticeOneController ");
		}

		request.setAttribute("noticeOneList", noticeOneList);
		request.getRequestDispatcher("/WEB-INF/view/community/notice/noticeOne.jsp").forward(request, response);
	}

}
