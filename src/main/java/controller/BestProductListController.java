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



@WebServlet("/bestProductListController")
public class BestProductListController extends HttpServlet {
	private BestDao bestDao = new BestDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sessionMemberId 가져오기
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		System.out.println(sessionMemberId + " <-- sessionMemberId doGet() consumerOneController"); // 디버깅
		
		// 인기순(order주문 순으로 보여주기)
		List<Map<String,Object>> list = bestDao.selectBestListByPage();
		
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
		request.setAttribute("BestProductList", list);
		
		request.getRequestDispatcher("/WEB-INF/view/bestProduct/bestProductList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
