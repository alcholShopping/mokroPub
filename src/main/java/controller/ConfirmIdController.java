package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDao;

@WebServlet("/confirmIdController")
public class ConfirmIdController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/login/register.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		if(sessionMemberId != null) {
			// 이미 로그인이 되어 있는 상태라면
			response.sendRedirect(request.getContextPath()+"/indexController"); // 초기화면으로
		}
		String addressResult = "";
		String consumerId = "";
		
		if(request.getParameter("addressResult") != null) {
			addressResult = request.getParameter("addressResult");	
		}
		if(request.getParameter("consumerId") != null) {
			consumerId = request.getParameter("consumerId");
		}
		
		RegisterDao registerDao = new RegisterDao();
		int confirmNo = registerDao.confirmId(consumerId);
		System.out.println(confirmNo + "<- confirmNo ");
		
		if(confirmNo == 1) {		
			request.setAttribute("cofirmResult", "중복입니다" );
		} else {
			request.setAttribute("cofirmResult", "중복되지 않습니다" );
		} 
		request.setAttribute("addressResult", addressResult );
		request.getRequestDispatcher("/WEB-INF/view/login/register.jsp").forward(request, response);
	} 

}
