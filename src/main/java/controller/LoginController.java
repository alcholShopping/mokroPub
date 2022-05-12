package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import vo.*;

	
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private IndexDao indexDao = new IndexDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/login/login.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String sessionMemberId = null;

		LoginDao ld = new LoginDao();
		try {
			sessionMemberId = ld.selectMemberByIdPw(id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(sessionMemberId == null) {
			// 로그인 실패시 로그인폼을 재요청
			response.sendRedirect(request.getContextPath()+"/LoginController");
			return;
		} 
		// 현재 연결한 client(browser)의 세션값을 받아을 받아서 httpsession 객체를 만들어 저장
			HttpSession session = request.getSession();
			session.setAttribute("sessionMemberId", sessionMemberId);
			response.sendRedirect(request.getContextPath()+"/indexController");
	}

}
