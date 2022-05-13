package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import java.util.*;

@WebServlet("/cartController")
public class CartController extends HttpServlet {
	CartDao cartDao = new CartDao();


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
		int consumerId = cartDao.changeConsumerIdToNo(sessionMemberId);
		// -----------------------------디버깅-----------------------------
		System.out.println(consumerId + " <-- consumerId doGet() insertProductInCartController");
				
		// 사용자 번호로 장바구니 리스트 호출 > hashmap
		List<Map<String,Object>> cartList = cartDao.selectConsumerCartList(consumerId);
		// 디버깅
		for(Map m : cartList) {
			System.out.println(m.get("cartNo") + " <-- cartNo doGet() CartController ");
			System.out.println(m.get("name") + " <-- name doGet() CartController ");
			System.out.println(m.get("price") + " <-- price doGet() CartController ");
			System.out.println(m.get("count") + " <-- volume doGet() CartController ");
			System.out.println(m.get("picture") + " <-- picture doGet() CartController ");
		}
		
		// 장바구니 담긴 갯수 
		int cartCount = cartDao.CartCountNum(consumerId);
		System.out.println(cartCount + "cartCount doGet() CartController");
		session.setAttribute("cartCount", cartCount);
		
		// 전체 삭제 버튼을 클릭 했는지 0이면 클릭 안함 1이면 클릭 함
		String deleteBtn = request.getParameter("deleteBtn");
		
		if(deleteBtn != null ) {
			// cartNo에 따른 장바구니 삭제 (전체삭제)
			System.out.println("삭제 버튼 눌림");
			cartDao.DeleteProductInCartAll(consumerId);
		}

		request.setAttribute("cartList", cartList);
		request.getRequestDispatcher("/WEB-INF/view/cart/cartList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 여부 확인 로직(세션이용)
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		if(sessionMemberId == null) {
			// 로그인 안되어있을시에 LoginController 이동
			response.sendRedirect(request.getContextPath()+"/LoginController");
		}
		// 아이디를 번호로 교체
		int consumerId = cartDao.changeConsumerIdToNo(sessionMemberId);
		// -----------------------------디버깅-----------------------------
		System.out.println(consumerId + " <-- consumerId doGet() CartController");
		
		
		Integer.parseInt(request.getParameter("cartNo"));
		
		 
		int cartNo = Integer.parseInt(request.getParameter("cartNo"));
		// cartNo에 따른 장바구니 삭제 (단일삭제)
		cartDao.DeleteProductInCart(cartNo);
		
		// 장바구니 담긴 갯수 
		int cartCount = cartDao.CartCountNum(consumerId);
		System.out.println(cartCount + "cartCount=================================");
		session.setAttribute("cartCount", cartCount);
						
		response.sendRedirect(request.getContextPath()+"/cartController");
		
	}

}
