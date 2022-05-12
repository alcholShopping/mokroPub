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

import dao.CartDao;
import dao.IndexDao;
import vo.Category;

	
@WebServlet("/indexController")
public class IndexController extends HttpServlet {
	private CartDao cartDao = new CartDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//로그인 여부 확인 로직(세션이용)
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");		
		// 아이디를 번호로 교체
		int consumerId = cartDao.changeConsumerIdToNo(sessionMemberId);
		// -----------------------------디버깅-----------------------------
		System.out.println(consumerId + " <-- consumerId doGet() insertProductInCartController");
		// 장바구니 담긴 갯수 
		int cartCount = cartDao.CartCountNum(consumerId);
		System.out.println(cartCount + "cartCount=================================");
		session.setAttribute("cartCount", cartCount);
		
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
