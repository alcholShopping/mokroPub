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
		int cnt = 0; // 정렬 확인용 변수

		if(request.getParameter("startPrice") != null) {
			startPrice = Integer.parseInt(request.getParameter("startPrice"));
		}
		if(request.getParameter("endPrice") != null) {
			endPrice = Integer.parseInt(request.getParameter("endPrice"));
		}
		
		//페이직 작업
		int totalData = priceDao.selectPriceTotal(startPrice, endPrice);
		int currentPage = 1;
		// 현재 페이지 , 마지막 페이지
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			System.out.println(currentPage + " <-- currentPage doGet() PriceProductListController if");
		}
		
		int rowPerPage = 6;
		int beginRow = (currentPage-1) * rowPerPage; 
		int lastPage = (int)(Math.ceil((double)totalData/(double)rowPerPage)); 
		// -----------------------------디버깅-----------------------------
		System.out.println(currentPage + " <-- currentPage doGet() PriceProductListController");	
		System.out.println(totalData + " <-- totalData doGet() PriceProductListController");
		System.out.println(rowPerPage + " <-- rowPerPage doGet() PriceProductListController");
		System.out.println(beginRow + " <-- beginRow doGet() PriceProductListController");
		System.out.println(currentPage + " <-- currentPage doGet() PriceProductListController");
		System.out.println(lastPage+"<-- lastPage doGet() PriceProductListController");
		
		
		list = priceDao.seleselectPriceByPageAsc(startPrice, endPrice,beginRow,rowPerPage);
		if(request.getParameter("cnt") == null) {
			list = priceDao.seleselectPriceByPageAsc(startPrice, endPrice,beginRow,rowPerPage);
		}else {
			//높은순, 낮은순을 판단해주는 변수
			cnt = Integer.parseInt(request.getParameter("cnt"));
			list = priceDao.seleselectPriceByPageDesc(startPrice, endPrice,beginRow,rowPerPage);
		}

		request.setAttribute("cnt",cnt);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage" , lastPage);
		request.setAttribute("list", list);
		request.setAttribute("startPrice",startPrice);
		request.setAttribute("endPrice",endPrice);
		
		request.getRequestDispatcher("/WEB-INF/view/price/priceProductList.jsp").forward(request, response);
		
	}



}
