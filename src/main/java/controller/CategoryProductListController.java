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
		
		Product product = new Product();
		List<Product> list = new ArrayList<>();
		list = categoryDao.selectCategoryByPage(categoryNo);
		
		// -----------------------------디버깅-----------------------------
		for(Product p : list) {
			System.out.println(p.getName() + " <-- getName() doGet() categoryProductListController");		
		}
		
		request.getRequestDispatcher("/WEB-INF/view/category/categoryProductList.jsp").forward(request, response);	
	}

}
