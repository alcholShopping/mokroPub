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
	private ConsumerDao consumerDao;
	private LoginDao loginDao = new LoginDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 상태 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		if(sessionMemberId != null) {
			// 이미 로그인이 되어 있는 상태라면
			response.sendRedirect(request.getContextPath()+"/indexController"); // 초기화면으로
			return;
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
	
		consumerDao = new ConsumerDao();
		// pwUpdateDate를 가져오기 위해 회원정보 list를 뽑음
		List<Consumer> list = consumerDao.selectConsumerOneInfo(sessionMemberId);
		String pwUpdateDate = "";
		for(Consumer c : list) {
			pwUpdateDate= c.getPwUpdateDate();
			System.out.println(pwUpdateDate + " <-- pwUpdateDate doPost() loginController");
		}
		
		int period = consumerDao.UsingPwPeriod(sessionMemberId,pwUpdateDate);
		System.out.println(period + "<-- period doPost() loginController");
		
		if(period >= 3) {
			request.getRequestDispatcher("/WEB-INF/view/login/requestChangePw.jsp").forward(request, response);
			return;
		}
		/* consumer테이블에서 pw_update_date가 현재날짜기준으로 3개월이 지났다.
		 비밀번호를 변경해야됩니다. ->
		1) 다음에 변경 -> index 
		2) 지금 변경 -> 회원정보창
		
		*/
		response.sendRedirect(request.getContextPath()+"/indexController");
	}

}
