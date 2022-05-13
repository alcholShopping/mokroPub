package controller;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import vo.*;


@WebServlet("/registerController")
public class RegisterController extends HttpServlet {
	private RegisterDao registerDao = new RegisterDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 로그인 상태 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		if(sessionMemberId != null) {
			// 이미 로그인이 되어 있는 상태라면
			response.sendRedirect(request.getContextPath()+"/indexController"); // 초기화면으로
		}	
		
		request.getRequestDispatcher("/WEB-INF/view/login/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 상태 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		if(sessionMemberId != null) {
			// 이미 로그인이 되어 있는 상태라면
			response.sendRedirect(request.getContextPath()+"/indexController"); // 초기화면으로
		}
		
		
		int row = 999;
		
		// register.jsp에서 값을 받아옴
		String consumerPwRe = request.getParameter("consumerPwRe"); // 비밀번호 재입력 (확인용)
		// consumer에 값 정재
		Consumer consumer = new Consumer();
		
		
		String consumerId = request.getParameter("consumerId");
		String consumerPw = request.getParameter("consumerPw");
		String passwordRe = request.getParameter("consumerPwRe");
		String name = request.getParameter("consumerName");
		String addressResult = request.getParameter("addressResult");
		String zipCode;
		zipCode = addressResult.substring(addressResult.length()-5, addressResult.length());
		String detailedAddress = request.getParameter("detailedAddress");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String residentNumber = request.getParameter("residentNumber");
		String accountNumber = request.getParameter("account");
		
		//성인인증용
		int birthYear = Integer.parseInt(request.getParameter("birthYear"));
				
		//성인인가요?
		int yearNow = Calendar.getInstance().get(Calendar.YEAR);
		consumer.setConsumerId(request.getParameter("consumerId"));
		consumer.setPassword(request.getParameter("consumerPw"));
		consumer.setName(request.
				getParameter("consumerName"));
		consumer.setEmail(request.getParameter("email"));
		consumer.setPhone(request.getParameter("phone"));
		consumer.setResidentNumber(request.getParameter("residentNumber"));
		consumer.setAccount(request.getParameter("account"));
		consumer.setAddress(addressResult.substring(0,addressResult.length()-5)); 
		consumer.setZipcode(addressResult.substring(addressResult.length()-5, addressResult.length()));
		consumer.setDetailedAddr(request.getParameter("detailedAddress"));
		
		// 디버깅
		System.out.println(consumer.getConsumerId() + " <-- getConsumerId() doPost() registerController");
		System.out.println(consumer.getPassword() + " <-- getPassword() doPost() registerController");
		System.out.println(consumer.getName() + " <-- getName() doPost() registerController");
		System.out.println(consumer.getEmail() + " <-- getEmail() doPost() registerController");
		System.out.println(consumer.getPhone() + " <-- getPhone() doPost() registerController");
		System.out.println(consumer.getResidentNumber() + " <-- getResidentNumber() doPost() registerController");
		System.out.println(consumer.getAccount() + " <-- getAccount() doPost() registerController");
		System.out.println(consumer.getZipcode() + " <-- getZipcode() doPost() registerController");
		System.out.println(consumer.getAddress() + " <-- getAddress() doPost() registerController");
		System.out.println(consumer.getDetailedAddr() + " <-- getDetailedAddr() doPost() registerController");
		System.out.println(addressResult + " <-- addressResult doPost() registerController");
		System.out.println(consumerPwRe + " <-- consumerPwRe doPost() registerController");

		
		
		try {
			row = registerDao.registerByCustomer(consumer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(row == 1) {
			response.sendRedirect("loginController");
		} else {
			response.sendRedirect("registerController");
		}
	}

}
