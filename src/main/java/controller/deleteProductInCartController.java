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

@WebServlet("/deleteProductInCartController")
public class deleteProductInCartController extends HttpServlet {
	private ConsumerDao consumerDao = new ConsumerDao();
	private CartDao cartDao = new CartDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 여부 확인 로직(세션이용)
		   HttpSession session = request.getSession();
		   String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		   if(sessionMemberId == null) {
				// 로그인 안되어있을시에 LoginController 이동
			   response.sendRedirect(request.getContextPath()+"/loginController");
			   return;
			}
			
		   // 아이디를 번호로 교체
			int consumerId = consumerDao.changeConsumerIdToNo(sessionMemberId);
			// -----------------------------디버깅-----------------------------
			System.out.println(consumerId + " <-- consumerId doGet() insertProductInCartController");
			
			// 전체 삭제 버튼을 클릭 했는지 0이면 클릭 안함 1이면 클릭 함			

	
			// cartNo에 따른 장바구니 삭제 (전체삭제)
			System.out.println("삭제 버튼 눌림");
			cartDao.DeleteProductInCartAll(consumerId);
			response.sendRedirect("cartController");
			
			return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		//로그인 여부 확인 로직(세션이용)
		   HttpSession session = request.getSession();
		   String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		   if(sessionMemberId == null) {
				// 로그인 안되어있을시에 LoginController 이동
			   response.sendRedirect(request.getContextPath()+"/loginController");
			   return;
			}

			
			int cartNo = Integer.parseInt(request.getParameter("cartNo"));
			
			// cartNo에 따른 장바구니 삭제 (단일삭제)
			cartDao.DeleteProductInCart(cartNo);
			
			response.sendRedirect("cartController");
	}

}
