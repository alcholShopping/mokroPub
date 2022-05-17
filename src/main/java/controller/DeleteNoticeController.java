package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NoticeDao;

@WebServlet("/deleteNoticeController")
public class DeleteNoticeController extends HttpServlet {
	private NoticeDao noticeDao = new NoticeDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sessionMemeberId 값 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		String accessId = "admin";
		System.out.println(sessionMemberId + " <-- sessoinMemberId doGet() insertNoticeController");
		if( (sessionMemberId == null) || (!sessionMemberId.equals(accessId)) ) {
			// sessionMemberId가 admin이 아니면 noticeListController로 이동
			System.out.println(sessionMemberId + " <-- sessoinMemberId doGet() insertNoticeController");
			response.sendRedirect(request.getContextPath()+"/noticeListController");
			return;
		}
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		noticeDao.deleteNotice(noticeNo);
		
		response.sendRedirect(request.getContextPath()+"/noticeListController");
	}

}
