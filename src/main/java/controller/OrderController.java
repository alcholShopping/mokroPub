package controller;

import java.io.IOException;
import java.util.HashMap;
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
import dao.CouponDao;
import dao.RegisterDao;
import vo.Consumer;


@WebServlet("/orderController")
public class OrderController extends HttpServlet {
	CartDao cartDao = new CartDao();
	ConsumerDao consumerDao = new ConsumerDao();
	CouponDao couponDao = new CouponDao();
	
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
				
		// consumerlist를 보여줘는 메서드 실행
		List<Consumer> consumerList = consumerDao.selectConsumerOneInfo(sessionMemberId);
		
		// 회원등급을 숫자가 아닌 글자로 --> 얼마나 등급이 있을지 몰라서 우선 1일떄 VIP라고 정함
		String consumerLevelText = "";
		if( consumerList.get(0).getConsumerLevel() == 1) {
			consumerLevelText = "VIP";
		}
		
		// 디버깅
		for(Consumer consumer : consumerList) {
			System.out.println(consumer.getConsumerId() + " <-- consumerId doGet() consumerOneInfo ");
			System.out.println(consumer.getName() + " <-- name doGet() consumerOneInfo ");
			System.out.println(consumer.getPhone() + " <-- phone doGet() consumerOneInfo ");
			System.out.println(consumer.getEmail() + " <-- email doGet() consumerOneInfo ");
			System.out.println(consumer.getAddress() + " <-- address doGet() consumerOneInfo ");
			System.out.println(consumer.getDetailedAddr() + " <-- detailedAddress doGet() consumerOneInfo ");
			System.out.println(consumer.getConsumerLevel() + " <-- consumerLevel doGet() consumerOneInfo ");
			System.out.println(consumer.getAccount() + " <-- ACCOUNT doGet() consumerOneInfo ");
			System.out.println(consumer.getCreateDate() + " <-- createDate doGet() consumerOneInfo ");
			System.out.println(consumer.getUpdateDate() + " <-- updateDate doGet() consumerOneInfo ");
		}
		System.out.println(consumerLevelText + " <-- consumerLevelText doGet() consumerOneInfo");
		
		// 쿠폰리스트 받는 list
		List<HashMap<String, Object>> couponList = couponDao.selectConsumerCouponList(consumerId);
		

		request.setAttribute("totalPrice", totalPrice); // 총가격
		request.setAttribute("cartList", cartList); // 장바구니 리스트
		request.setAttribute("consumerList", consumerList); // 회원정보 
		request.setAttribute("consumerLevelText", consumerLevelText); // 회원등급
		request.setAttribute("couponList", couponList); // 총가격
		
		request.getRequestDispatcher("/WEB-INF/view/order/order.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
