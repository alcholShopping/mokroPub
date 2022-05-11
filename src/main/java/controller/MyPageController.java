package controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IndexDao;
import vo.Category;

/**
 * Servlet implementation class MyPageController
 */
@WebServlet("/myPageController")
public class MyPageController extends HttpServlet {
	private IndexDao indexDao =new IndexDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		//로그인 여부 확인 로직(세션이용)
		   HttpSession session = request.getSession();
		   String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		   if(sessionMemberId == null) {
				// 이미 로그인이 되어 있는 상태라면
			   response.sendRedirect(request.getContextPath()+"/LoginController");
			}
			*/
		   
		// 상단바 주류 올릴시(hover)
		List<Category> list = new ArrayList<>();
		Category category = new Category();
		list = indexDao.selectCategoryList();
		// 디버깅 
		for(Category c : list) {
			System.out.println(c.toString());
		}
		request.setAttribute("list", list);
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/myPage/myPage.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
