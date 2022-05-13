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

	
@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private LoginDao loginDao = new LoginDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 상태 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		if(sessionMemberId != null) {
			// 이미 로그인이 되어 있는 상태라면
			response.sendRedirect(request.getContextPath()+"/indexController"); // 초기화면으로
		}	
		request.getRequestDispatcher("/WEB-INF/view/login/login.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		// 디버깅
		System.out.println(userId + " <-- userId doPost() loginController");
		System.out.println(userPw + " <-- userPw doPost() loginController");

		String checkId = loginDao.selectMemberByIdPw(userId, userPw);
		System.out.println(checkId + " <-- checkId doPost() loginController"); // 디버깅
		
		// 로그인 실패시
		 if(checkId == null) {
			System.out.println("로그인 실패!");
			response.sendRedirect(request.getContextPath()+"/loginController");
			return;
		} 		
		
		String sessionMemberId = userId; // sessionId 저장
		
		System.out.println(sessionMemberId + " <-- sessionMemberId After login doPost() loginController");
		
		// sessionMemberId 세션에 저장
		HttpSession session = request.getSession();
		session.setAttribute("sessionMemberId", sessionMemberId);
		response.sendRedirect(request.getContextPath()+"/indexController");
	}

}
