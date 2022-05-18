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

import dao.SearchDao;
import vo.Product;


@WebServlet("/searchController")
public class SearchController extends HttpServlet {
	Product pro = null;
	SearchDao sd = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/search/search.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		int priceBefore = Integer.parseInt(request.getParameter("priceBefore"));
		int priceAfter = Integer.parseInt(request.getParameter("priceAfter"));
		int volume = Integer.parseInt(request.getParameter("volume"));
		String color = request.getParameter("color");
		int alcoholLevel = Integer.parseInt(request.getParameter("alcoholLevel"));
		int sweet = Integer.parseInt(request.getParameter("sweet"));
		int maturity = Integer.parseInt(request.getParameter("maturity"));
		int acidity= Integer.parseInt(request.getParameter("acidity"));
		int thin= Integer.parseInt(request.getParameter("thin"));
		int refreshment= Integer.parseInt(request.getParameter("refreshment"));
				
		
		HashMap<String, Object> hash = new HashMap<>();
		
		hash.put("name", name);
		hash.put("priceAfter", priceAfter);
		hash.put("priceBefore", priceBefore);
		hash.put("volume", volume);
		hash.put("color", color);
		hash.put("alcoholLevel", alcoholLevel);
		hash.put("sweet", sweet);
		hash.put("maturity", maturity);
		hash.put("acidity", acidity);
		hash.put("thin", thin);
		hash.put("refreshment", refreshment);
		
		System.out.println(name + "=============name============");
		System.out.println(priceBefore + "=============priceBefore============");
		System.out.println(priceAfter + "=============priceAfter============");
		System.out.println(volume + "=============volume============");
		System.out.println(color + "=============color============");
		System.out.println(alcoholLevel + "=============alcoholLevel============");
		System.out.println(sweet + "=============sweet============");
		System.out.println(maturity + "=============maturity============");
		System.out.println(acidity + "=============acidity============");
		System.out.println(thin + "=============thin============");
		System.out.println(refreshment + "=============refreshment============");
		
		sd = new SearchDao();
		List<HashMap<String,Object>> searchMapList = sd.searchSelectProduct(hash);
		
		request.setAttribute("searchMapList",searchMapList);
		request.getRequestDispatcher("/WEB-INF/view/search/search.jsp").forward(request, response);
	}

}
