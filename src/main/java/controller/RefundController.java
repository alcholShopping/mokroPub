package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RefundDao;

/**
 * Servlet implementation class RefundController
 */
@WebServlet("/refundController")
public class RefundController extends HttpServlet {
	private RefundDao refundDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		System.out.println(sessionMemberId + " <-- sessionMemberId doGet() consumerOneController");
		if(sessionMemberId == null) {
			// 로그인 안되어있을시에 LoginController 이동
			System.out.println("doGet() consumerOneController 로그인 해야합니다.");
			response.sendRedirect(request.getContextPath()+"/loginController");
			return;
		}	
		if(request.getParameter("status") == "환불") {
			response.sendRedirect(request.getContextPath() + "/orderAfterController");
		}
		
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		
		refundDao = new RefundDao();
		
		refundDao.refundProduct(orderNo);
		
		response.sendRedirect(request.getContextPath() + "/orderAfterController");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
