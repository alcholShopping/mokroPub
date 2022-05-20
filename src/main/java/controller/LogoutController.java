package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConsumerDao;
import dao.LoginDao;

@WebServlet("/logoutController")
public class LogoutController extends HttpServlet {
	private LoginDao loginDao;
	private ConsumerDao consumerDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
	     String sessionMemberId = (String)session.getAttribute("sessionMemberId");
	     System.out.println(sessionMemberId + " <-- sessionMemberId doGet() consumerOneController");
		
		request.getSession().invalidate(); // session 갱신 메서드 : 기존 session을 지우고 새로운 새션을 부여함
		response.sendRedirect(request.getContextPath()+"/loginController");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
	     String sessionMemberId = (String)session.getAttribute("sessionMemberId");
	     String check = "1";
	     System.out.println(sessionMemberId + " <-- sessionMemberId doPost() logoutController");
	     System.out.println(request.getParameter("check") + " <-- check doPost() logoutController");	     
	     
		if(request.getParameter("check").equals(check)){
			System.out.println(request.getParameter("check") + "<-- check doPost() logoutController ");		
			
			String currentPw = request.getParameter("currentPw");
			String changePw = request.getParameter("changePw");
			String checkChangePw = request.getParameter("checkChangePw");
			
			System.out.println(currentPw + " <-- currentPw doPost() logoutController");
			System.out.println(changePw + " <-- changePw doPost() logoutController");
			System.out.println(checkChangePw + " <-- checkChangePw doPost() logoutController");
			
			loginDao = new LoginDao();
			consumerDao = new ConsumerDao();
			currentPw = loginDao.changePwToEncryptionPw(sessionMemberId, currentPw);
			System.out.println(currentPw + " <-- currentPw doPost() logoutController"); // 디버깅
			
			String checkConsumerPw  = consumerDao.checkConsumerPw(sessionMemberId);
			System.out.println(checkConsumerPw + " <-- checkConsumerPw doPost() logoutController"); // 디버깅
			
			if(!currentPw.equals(checkConsumerPw)) {
				request.getRequestDispatcher("/WEB-INF/view/login/requestChangePw.jsp").forward(request, response);    
			}
			
			consumerDao = new ConsumerDao();
			int consumerId = consumerDao.changeConsumerIdToNo(sessionMemberId);
			loginDao.UpdateConsumerPwAndDate(consumerId, changePw);
			loginDao.insertPasswordAndDate(consumerId, changePw);					
		}
		
		request.getSession().invalidate(); // session 갱신 메서드 : 기존 session을 지우고 새로운 새션을 부여함
		response.sendRedirect(request.getContextPath()+"/loginController");
	}
}