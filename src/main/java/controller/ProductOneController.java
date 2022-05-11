package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductOneController
 */
@WebServlet("/productOneController")
public class ProductOneController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// index.jsp 로부터 넘어온 categoryNo을 받아옴
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		System.out.println(productNo + " <-- productNo ProductOneController");
		if(productNo == 0) { // 카테고리 번호가 없을 시
			response.sendRedirect("/indexController");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

