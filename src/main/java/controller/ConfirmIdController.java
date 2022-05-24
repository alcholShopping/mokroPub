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
		
		// 아이디 검색할때 기존에 검색한 데이터들을 가져옴
		
		String addressResult = "";  // 주소데이터
		if(request.getParameter("addressResult") != null) {
			addressResult = request.getParameter("addressResult");	
		}
		
		String detailedAddress = ""; // 상세주소 
		if(request.getParameter("detailedAddress") != null) {
			detailedAddress = request.getParameter("detailedAddress");	
		}
		
		String consumerId = ""; // 비교할 아이디
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
			request.setAttribute("consumerId", consumerId);
		} 
		request.setAttribute("addressResult", addressResult );
		request.setAttribute("detailedAddress", detailedAddress );
		request.getRequestDispatcher("/WEB-INF/view/login/register.jsp").forward(request, response);
	} 

}
