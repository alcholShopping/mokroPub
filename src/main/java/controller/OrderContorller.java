package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDao;
import dao.ConsumerDao;


@WebServlet("/orderContorller")
public class OrderContorller extends HttpServlet {
	CartDao cartDao = new CartDao();
	private ConsumerDao consumerDao = new ConsumerDao();
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
						
				// 사용자 번호로 장바구니 리스트 호출 > hashmap
				List<Map<String,Object>> cartList = cartDao.selectConsumerCartList(consumerId);
				
				// 디버깅
				for(Map m : cartList) {
					System.out.println(m.get("productNo") + " <-- productNo doGet() CartController ");
					System.out.println(m.get("cartNo") + " <-- cartNo doGet() CartController ");
					System.out.println(m.get("name") + " <-- name doGet() CartController ");
					System.out.println(m.get("price") + " <-- price doGet() CartController ");
					System.out.println(m.get("count") + " <-- volume doGet() CartController ");
					System.out.println(m.get("picture") + " <-- picture doGet() CartController ");
				}
				
				// 총 가격 구하기
				int totalPrice = 0;
				for(Map total : cartList) {
					totalPrice = totalPrice +((int)total.get("price") * (int)total.get("count"));
				}
				// 장바구니 담긴 갯수 
				int cartCount = cartDao.CartCountNum(consumerId);
				System.out.println(cartCount + "cartCount doGet() CartController");
				session.setAttribute("cartCount", cartCount);
				
				
				request.setAttribute("totalPrice", totalPrice);
				request.setAttribute("cartList", cartList);
				request.getRequestDispatcher("/WEB-INF/view/order/order.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
