package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;
import dao.ConsumerDao;

/**
 * Servlet implementation class updateCartController
 */
@WebServlet("/updateProductInCartController")
public class UpdateProductInCartController extends HttpServlet {
	private CartDao cartDao = new CartDao();
	private ConsumerDao consumerDao = new ConsumerDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//받아야할거 : count개수랑 productNo > 판별용
		
		int count = Integer.parseInt(request.getParameter("count"));
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		
		//로그인 여부 확인 로직(세션이용)
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		if(sessionMemberId == null) {
			// 로그인 안되어있을시에 LoginController 이동
			  response.sendRedirect(request.getContextPath()+"/loginController");
			  return;
		}

		int consumerId = consumerDao.changeConsumerIdToNo(sessionMemberId);
		// -----------------------------디버깅-----------------------------
		System.out.println(consumerId + " <-- consumerId doGet() insertProductInCartController");
		
		
		// 같은 상품이 존재한다면 update
		cartDao.updateProductInCartSelectClick(productNo, count, consumerId);
		// -----------------------------디버깅-----------------------------

		response.sendRedirect(request.getContextPath()+"/cartController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
