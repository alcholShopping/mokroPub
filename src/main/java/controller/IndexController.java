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
import dao.IndexDao;
import vo.Category;

	
@WebServlet("/indexController")
public class IndexController extends HttpServlet {
	private CartDao cartDao;
	private ConsumerDao consumerDao;
	private BestDao bestDao;
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
