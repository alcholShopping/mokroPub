package controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConsumerDao;
import dao.LoginDao;


@WebServlet("/updateConsumerPwController")
public class UpdateConsumerPwController extends HttpServlet {
	private ConsumerDao consumerDao;
	private LoginDao loginDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 상태 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		if(sessionMemberId != null) {
			// 이미 로그인이 되어 있는 상태라면
			response.sendRedirect(request.getContextPath()+"/indexController"); // 초기화면으로
			return;
		}	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		consumerDao = new ConsumerDao();
		// 비밀번호 변경전 입력했던 아이디
		String updateId = request.getParameter("updateId");
		// -----------------------------디버깅-----------------------------
		System.out.println(updateId + " <-- updateId doPost() UpdateConsumerPwController");
		// 입력할 비밀번호
		String updatePw = request.getParameter("updatePw");
		// -----------------------------디버깅-----------------------------
		System.out.println(updatePw + " <-- updatePw doPost() UpdateConsumerPwController");
		
		// 아이디를 번호로 교체
		int consumerId = consumerDao.changeConsumerIdToNo(updateId);
		// -----------------------------디버깅-----------------------------
		
		System.out.println(consumerId + " <-- consumerId doPost() UpdateConsumerPwController");
		String checkOverlap = consumerDao.checkPwOverlap(consumerId, updatePw);
		System.out.println(checkOverlap + " <-- checkOverlap doPost() UpdateConsumerPwController ");
		// 빈칸이냐 password로 가져오냐
		if( checkOverlap != null ) { // 중복되면
			String errorText = "password가 중복됩니다.";
			System.out.println("password가 중복됩니다.");
			
			request.setAttribute("errorText",errorText);
			request.getRequestDispatcher("/WEB-INF/view/login/updateConsumerPw.jsp").forward(request, response);
			return;
		}
		
		// 비밀번호가 중복이 안됨		
		loginDao =  new LoginDao();
		
		loginDao.UpdateConsumerPwAndDate(consumerId, updatePw);
		loginDao.insertPasswordAndDate(consumerId, updatePw);
		
		// -----------------------------디버깅-----------------------------
		System.out.println("비밀번호 변경 성공 consumerId doPost() UpdateConsumerPwController");
		request.getSession().invalidate();
		request.getRequestDispatcher("/WEB-INF/view/login/login.jsp").forward(request, response);
		}
	}


