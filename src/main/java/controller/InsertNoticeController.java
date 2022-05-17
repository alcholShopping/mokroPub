package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ConsumerDao;
import dao.NoticeDao;
import vo.Notice;

@WebServlet("/insertNoticeController")
public class InsertNoticeController extends HttpServlet {
	private NoticeDao noticeDao = new NoticeDao();
	private ConsumerDao consumerDao = new ConsumerDao();
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
		
		request.getRequestDispatcher("/WEB-INF/view/community/notice/insertNotice.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sessionMemeberId 값 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		if(!sessionMemberId.equals("admin")) {
			// sessionMemberId가 admin이 아니면 noticeListController로 이동
			response.sendRedirect(request.getContextPath()+"/noticeListController");
			return;
		}
		
		response.sendRedirect(request.getContextPath()+"/noticeListController");		
	}

}
