package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.IndexDao;
import vo.Category;
import vo.Product;

@WebServlet("/categoryProductListController")
public class CategoryProductListController extends HttpServlet {
	private CategoryDao categoryDao = new CategoryDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// index.jsp 로부터 넘어온 categoryNo을 받아옴
		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		System.out.println(categoryNo + " <-- categoryNo categoryProductListController");
		if(categoryNo == 0) { // 카테고리 번호가 없을 시
			response.sendRedirect("/indexController");
		}
		
		// categoryNo에 따른 category Type 출력
		Category category = new Category();
		String type = null;
		type = categoryDao.selectCategoryType(categoryNo);
		
		// -----------------------------디버깅-----------------------------
		System.out.println(type + " <-- type doGet() categoryProductListController");		
		
		// categoryNo에 따른 produc 갯수
		Product product = new Product();
		int total = 0;
		total = categoryDao.selectCategoryTotal(categoryNo);
						
		// -----------------------------디버깅-----------------------------
		System.out.println(total + " <-- total doGet() categoryProductListController");
		
		// 페이징
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int rowPerPage = 6;
		int beginRow = (currentPage-1)*rowPerPage; 
		int lastPage = (int)(Math.ceil((double)total/(double)rowPerPage)); 
		// -----------------------------디버깅-----------------------------
		System.out.println(currentPage + " <-- currentPage doGet() categoryProductListController");		
		System.out.println(rowPerPage + " <-- rowPerPage doGet() categoryProductListController");
		System.out.println(beginRow + " <-- beginRow doGet() categoryProductListController");
		System.out.println(currentPage + " <-- currentPage doGet() categoryProductListController");
		
		
		// categoryNo에 따른 product 목록 출력
		List<Product> list = new ArrayList<>();
		list = categoryDao.selectCategoryByPage(categoryNo, beginRow, rowPerPage);
				
		// -----------------------------디버깅-----------------------------
		for(Product p : list) {
			System.out.println(p.getName() + " <-- getName() doGet() categoryProductListController");		
		}
				
		request.setAttribute("categoryNo", categoryNo);
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);

		request.setAttribute("type", type);
		request.setAttribute("total", total);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/category/categoryProductList.jsp").forward(request, response);	
	}

}
