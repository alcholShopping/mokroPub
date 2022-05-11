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

@WebServlet("/categoryProductListController")
public class CategoryProductListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		System.out.println(categoryNo + " <-- categoryNo categoryProductListController");
		
	}

}
