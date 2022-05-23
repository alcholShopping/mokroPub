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

import dao.*;
import vo.*;


@WebServlet("/orderAfterController")
public class OrderAfterController extends HttpServlet {
	OrdereAfterDao ordereAfterDao = new OrdereAfterDao();
	private ConsumerDao consumerDao = new ConsumerDao();
	ReviewDao rd = new ReviewDao();
	CartDao cartDao = new CartDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		System.out.println(sessionMemberId + " <-- sessionMemberId doGet() consumerOneController");
		if(sessionMemberId == null) {
			// 로그인 안되어있을시에 LoginController 이동
			System.out.println("doGet() consumerOneController 로그인 해야합니다.");
			response.sendRedirect(request.getContextPath()+"/loginController");
			return;
		}	
		
		// 아이디를 번호로 교체
		int consumerNo = consumerDao.changeConsumerIdToNo(sessionMemberId);
		
		// 사용자아이디로 번호를 찾기 orList로 반환
		List<Map<String,Object>> orList = ordereAfterDao.selectOrderedById(consumerNo);
		
		for(Map m : orList) {
			int isReviewExist;
			
			isReviewExist = rd.isExistReviewByOrderNo((int)m.get("orderNo"));
			
			
			m.put("isReviewExist", isReviewExist);
			
		
			System.out.println(m.get("orderNo") + "<----orderNo  doGet()  OrderAfterController");
			System.out.println(m.get("consumerNo") + "<----consumerNo  doGet()  OrderAfterController");
			System.out.println(m.get("productName") + "<----productName  doGet()  OrderAfterController");
			System.out.println(m.get("zipcode") + "<----zipcode  doGet()  OrderAfterController");
			System.out.println(m.get("address") + "<----address  doGet()  OrderAfterController");
			System.out.println(m.get("payment") + "<----payment  doGet()  OrderAfterController");
			System.out.println(m.get("method") + "<----method  doGet()  OrderAfterController");
			System.out.println(m.get("count") + "<----count  doGet()  OrderAfterController");
			System.out.println(m.get("couponListNo") + "<----couponListNo  doGet()  OrderAfterController");
			System.out.println(m.get("createDate") + "<----createDate  doGet()  OrderAfterController");
			System.out.println(m.get("updateDate") + "<----updateDate  doGet()  OrderAfterController");
			System.out.println(m.get("status") + "<----status  doGet()  OrderAfterController");
		}
		
		for(Map m : orList) {
			System.out.println(m.get("isReviewExist") + "////////isReviewExistisReviewExistisReviewExistisReviewExistisReviewExistisReviewExistisReviewExistisReviewExistisReviewExistisReviewExistisReviewExistisReviewExistisReviewExistisReviewExistisReviewExist");
		}
		// ISSUE : 리뷰가 존재하면 리뷰 작성이 불가능해야 함
		// 근데 개별적으로 확인해야하니까 orList안에 작성하는게..
		
		request.setAttribute("orList", orList); // jsp에 보여줄 값을 반환
		request.getRequestDispatcher("/WEB-INF/view/review/orderAfter.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
