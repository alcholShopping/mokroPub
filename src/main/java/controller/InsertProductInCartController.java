package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;


@WebServlet("/insertProductInCartController")
public class InsertProductInCartController extends HttpServlet {
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
		
		// productNo을 받아옴
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		System.out.println(productNo + " <-- productNo categoryProductListController");
		if(productNo == 0) { // 상품 번호가 없을 시
			System.out.println(productNo + "productNo이 존재하지 않음 doGet() insertProductInCartController");
			response.sendRedirect("/indexController");
		}
		

		int count = 0;
		
		if(request.getParameter("count")!= null) {
			count = Integer.parseInt(request.getParameter("count"));
			System.out.println(count+"<=====================count");	
		}else {
			count  = 1; // 수량 1개  
		}
		
		// 아이디를 번호로 교체
		int consumerId = cartDao.changeConsumerIdToNo(sessionMemberId);
		// -----------------------------디버깅-----------------------------
		System.out.println(consumerId + " <-- consumerId doGet() insertProductInCartController");
		
		
		// 같은 상품이 담겼는지 판별
		int productCnt = cartDao.IsSameProductCart(productNo, consumerId);
		// -----------------------------디버깅-----------------------------
		System.out.println(productCnt + " <-- productCnt doGet() insertProductInCartController");
		
		if(productCnt == 0) {
			// 같은 상품이 없으면 insert
			cartDao.insertProductInCart(productNo, count, consumerId);
			// -----------------------------디버깅-----------------------------
			System.out.println("상품을 추가했습니다." + " <-- productCnt doGet() insertProductInCartController");
			
		}else {
			// 같은 상품이 존재한다면 update
			cartDao.updateProductInCart(productNo, count, consumerId);
			// -----------------------------디버깅-----------------------------
			System.out.println("상품의 수량을 추가했습니다." + " <-- productCnt doGet() insertProductInCartController");
		}
		
		response.sendRedirect("cartController");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
