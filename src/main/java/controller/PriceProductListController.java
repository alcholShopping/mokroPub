package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.*;
import dao.PriceDao;

/**
 * Servlet implementation class priceProductListController
 */
@WebServlet("/priceProductListController")
public class PriceProductListController extends HttpServlet {
	private PriceDao priceDao = new PriceDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list = new ArrayList<>();
		int startPrice = 0;
		int endPrice = 9999999;

		if(request.getParameter("startPrice")!=null) {
			startPrice = Integer.parseInt(request.getParameter("startPrice"));
		}
		if(request.getParameter("endPrice") != null) {
			endPrice = Integer.parseInt(request.getParameter("endPrice"));
		}
		
		if(request.getParameter("cnt") == null) {
			list = priceDao.seleselectPriceByPageAsc(startPrice, endPrice);
		}else {
			list = priceDao.seleselectPriceByPageDesc(startPrice, endPrice);
		}
		

		
		request.setAttribute("list", list);
		request.setAttribute("startPrice",startPrice);
		request.setAttribute("endPrice",endPrice);
		
		request.getRequestDispatcher("/WEB-INF/view/price/priceProductList.jsp").forward(request, response);
		
	}



}
