package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IndexDao;
import vo.Category;

	
@WebServlet("/indexController")
public class IndexController extends HttpServlet {
	private IndexDao indexDao = new IndexDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 확인
		
		// 상단바 주류 올릴시(hover)
		List<Category> list = indexDao.selectCategoryList();
		// 디버깅 
		for(Category c : list) {
			System.out.println(c.toString());
		}
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
