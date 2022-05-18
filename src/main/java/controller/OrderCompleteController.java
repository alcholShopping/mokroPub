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
		
		// 카트에 있는 상품번호와 갯수를 가져오는 리스트
		List<Map<String,Object>> list = orderCompleteDao.selectCartProduct(consumerId);
		
		int couponNo = orderCompleteDao.selectCouponNo(consumerId, discount);
		
		// 디버깅
		for(Map m : list) {
			System.out.println(m.get("productNo") + " <-- productNo doGet() OrderCompleteController");
			System.out.println(m.get("count") + " <-- count doGet() OrderCompleteController");
			
			//-------------------------------------디버깅
			int productNo = (Integer)m.get("productNo");
			int count = (Integer)m.get("count");
			
			System.out.println(productNo +"  " +count);
			// 주문테이블에 넣는 메소드 호출
			orderCompleteDao.insertInOrder(consumerId, productNo, zipcode, addr, detailedAddress, realpayment, count, couponNo);
			request.getRequestDispatcher("/WEB-INF/view/order/orderFinish.jsp").forward(request, response);	
			return;
		}
		
		
	}

}
