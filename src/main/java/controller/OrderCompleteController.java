package controller;

import java.io.IOException;
import java.util.ArrayList;
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
import dao.IndexDao;
import dao.OrderCompleteDao;
import vo.Cart;
import vo.Consumer;
import vo.Product;

/**
 * Servlet implementation class OrderCompleteController
 */
@WebServlet("/orderCompleteController")
public class OrderCompleteController extends HttpServlet {
	private OrderCompleteDao orderCompleteDao;
	private CartDao cartDao;
	private ConsumerDao consumerDao;
	private CouponDao couponDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 여부 확인 로직(세션이용)
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		if(sessionMemberId == null) {
			// 로그인 안되어있을시에 LoginController 이동
			response.sendRedirect(request.getContextPath()+"/loginController");
			return;
		}
		
		// 아이디를 번호로 교체
		consumerDao = new ConsumerDao();
		int consumerId = consumerDao.changeConsumerIdToNo(sessionMemberId);
	
		
		String addressResult = request.getParameter("addressResult");				  
		String zipcode = addressResult.substring(addressResult.length()-5, addressResult.length());		        
		String addr = addressResult.replace(zipcode, ""); 
		String detailedAddress = request.getParameter("detailedAddress");
		int discount = Integer.parseInt(request.getParameter("selectCoupon"));		      
		int realpayment = Integer.parseInt(request.getParameter("realpayment"));
		
		//-----------------------------------------------디버깅
		System.out.println(zipcode + "<-- zipcode doPost() OrderCompleteController");
		System.out.println(addr + "<-- addr doPost() OrderCompleteController");
		System.out.println(detailedAddress +"<-- detailedAddress doPost() OrderCompleteController");
		System.out.println(discount +"<-- discount doPost() OrderCompleteController");
		System.out.println(realpayment +"<-- realpayment doPost() OrderCompleteController");
	      

		orderCompleteDao = new OrderCompleteDao();
		
		int couponNo = orderCompleteDao.selectCouponNo(consumerId, discount);
		System.out.println(couponNo + "<--- couponNo doPost orderCompleteController ");
		
		// 쿠폰의 갯수
		int UseCouponCount = 0;
		
		
		// 카트에 있는 상품번호와 갯수를 가져오는 리스트
		List<Map<String,Object>> list = orderCompleteDao.selectCartProduct(consumerId);
				
		cartDao = new CartDao();
		// 디버깅
		for(Map m : list) {
			System.out.println(m.get("productNo") + " <-- productNo doPost() OrderCompleteController");
			System.out.println(m.get("count") + " <-- count doPost() OrderCompleteController");
			System.out.println(m.get("price") + " <-- count doPost() OrderCompleteController");
			
			//-------------------------------------디버깅
			int productNo = (Integer)m.get("productNo");
			int count = (Integer)m.get("count");
			int price = (Integer)m.get("price");
			System.out.println(productNo +"  " +count+ " "+ price);
			// 할인된 상품의 가격 
			int priceProductNoCount = (price - (price * realpayment/100));
			
			System.out.println(priceProductNoCount + "실제 결제 금액 -============================");
			
			// 주문테이블에 넣는 메소드 호출
			orderCompleteDao.insertInOrder(consumerId, productNo, zipcode, addr, detailedAddress, priceProductNoCount, count, couponNo);
		
			//주문 번호를 찾아주는 쿼리
			int orderNo = orderCompleteDao.selectOrderNo(consumerId, productNo);
			System.out.println(orderNo + "<-----orderNo doPost OrderCompleteController");
			//찾아온 주문번호를 이용해 배달 테이블에 입력
			orderCompleteDao.insertInDelivery(orderNo);
		}
			couponDao = new CouponDao();
			// 쿠폰 사용 쿠폰-1
			couponDao.updateCouponCount(couponNo);
			// 사용할 쿠폰의 갯수를 조회
			UseCouponCount = couponDao.selectUseCouponCount(couponNo);
			if( UseCouponCount == 0 ) {
				// 사용하고 난후 남은 쿠폰의 개수가 0개이면 기존쿠폰은 지우지 않고 유효기간은 0000년으로 update
				couponDao.updateCouponValidity(couponNo);
			}
			System.out.println(UseCouponCount + " <-- UseCouponCount doPost() OrderCompleteController");
			
			//구매 완료 후 상품을 모두 삭제하는 쿼리
			cartDao.DeleteProductInCartAll(consumerId);
			
			
			// 장바구니 담긴 갯수 
			int cartCount = cartDao.CartCountNum(consumerId);
			System.out.println(cartCount + "cartCount=================================");
			session.setAttribute("cartCount", cartCount);

			request.getRequestDispatcher("/WEB-INF/view/order/orderFinish.jsp").forward(request, response);	
			return;
		
	}
	
}
