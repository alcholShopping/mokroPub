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
		System.out.println(consumerId + " <-- consumerId doGet() insertProductInCartController");
		
		loginDao =  new LoginDao();
		
		// 기존에 있던 비밀번호 검사 
		String changePwToEncryptionPw = loginDao.changePwToEncryptionPw(updateId, updatePw);
		String consumerPw = consumerDao.checkConsumerPw(updateId);
		
		if(consumerPw.equals(changePwToEncryptionPw)) {
			String errorText = null;
			errorText = "기존과 동일한 비밀번호 입니다.";
			
				request.setAttribute("errorText", errorText);
				request.setAttribute("consumerId", updateId);
				request.getRequestDispatcher("/WEB-INF/view/login/updateConsumerPw.jsp").forward(request, response);
				return;

		}
			// changePwToEncryptionPw에서 문자열이 없다면 기존에 없던 비밀번호
			// 비밀번호와 마지막 비밀번호 날짜 변경
			loginDao.UpdateConsumerPwAndDate(consumerId, updatePw);
			
			// 마지막 비밀번호 업데이트 내역 추가
			loginDao.insertPasswordAndDate(consumerId, updatePw);
			
			// -----------------------------디버깅-----------------------------
			System.out.println("비밀번호 변경 성공 consumerId doPost() UpdateConsumerPwController");
			request.getRequestDispatcher("/WEB-INF/view/login/login.jsp").forward(request, response);}

	}


