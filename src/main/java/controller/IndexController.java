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

import dao.BestDao;
import dao.CartDao;
import dao.ConsumerDao;
import dao.CouponDao;
import dao.IndexDao;
import vo.Category;

	
@WebServlet("/indexController")
public class IndexController extends HttpServlet {
	private CartDao cartDao;
	private ConsumerDao consumerDao;
	private BestDao bestDao;
	private CouponDao couponDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//로그인 여부 확인 로직(세션이용)
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");		
		
		consumerDao = new ConsumerDao();
		// 아이디를 번호로 교체
		int consumerId = consumerDao.changeConsumerIdToNo(sessionMemberId);
		// -----------------------------디버깅-----------------------------
		System.out.println(consumerId + " <-- consumerId doGet() insertProductInCartController");
		
		cartDao = new CartDao();
		// 장바구니 담긴 갯수 
		int cartCount = cartDao.CartCountNum(consumerId);
		System.out.println(cartCount + "cartCount=================================");
		session.setAttribute("cartCount", cartCount);
		
		//인기순 3개만 보여줌
		bestDao =  new BestDao();
		List<Map<String,Object>> list = bestDao.selectBestListByPageIndex();
		
		//쿠폰을 받자
		int couponNum = 0;
		if(request.getParameter("couponNum") != null) {
			couponNum = Integer.parseInt(request.getParameter("couponNum"));
		}
		
		couponDao = new CouponDao();
		
		// 세션 로그인 안했을때 : 쿠폰받기 불가능
		if(sessionMemberId != null) {
			// 쿠폰 선택을 했을경우면 메서드 실행
			if(couponNum != 0) {
				//만약에 내가 허용치 이상(*하루) 의 쿠폰을 수령하려고 할 경우에
				if(couponDao.isDayCouponByDay(couponNum, consumerId) >= 1  || couponDao.isDayCouponByDay(couponNum, consumerId) == -999) {
					//쿠폰을 안받았으면 insert 받았으면 update
					if(couponDao.isSameCouponByCouponNum(couponNum, consumerId) == 0) {
						couponDao.insertCouponListByName(consumerId, couponNum);
					} else {
						couponDao.UpdateCouponListByName(consumerId, couponNum);
					}
				} else {
					request.setAttribute("isCouponGet", "true");
					System.out.println("이미 허용치 이상의 쿠폰을 수령하셨습니다!!");
				}
				
			}
		}
		
		
		
		
		
		
		
		// 디버깅
		for(Map m : list) {
			System.out.println(m.get("productNo") + " <-- productNo doGet() bestProductListController");
			System.out.println(m.get("name") + " <-- name doGet() bestProductListController");
			System.out.println(m.get("picture") + " <-- picture doGet() bestProductListController");
			System.out.println(m.get("price") + " <-- price doGet() bestProductListController");
			System.out.println(m.get("volume") + " <-- volume doGet() bestProductListController");
			System.out.println(m.get("alcoholLevel") + " <-- alcoholLevel doGet() bestProductListController");
			System.out.println(m.get("ranking") + " <-- ranking doGet() bestProductListController");
		}
		request.setAttribute("BestProductListIndex", list);
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
