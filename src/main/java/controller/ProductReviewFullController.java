package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReviewDao;


@WebServlet("/productReviewFullController")
public class ProductReviewFullController extends HttpServlet {
	private ReviewDao reviewDao = new ReviewDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// productNo을 받아옴
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		reviewDao = new ReviewDao();
		List<Map<String, Object>> reviewList = reviewDao.SelectReviewByProductFull(productNo);
		
		
		
		request.setAttribute("reviewList", reviewList);
		request.getRequestDispatcher("/WEB-INF/view/review/productReviewFull.jsp").forward(request, response);	
		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
