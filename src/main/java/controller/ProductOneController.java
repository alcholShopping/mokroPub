package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;



@WebServlet("/productOneController")
public class ProductOneController extends HttpServlet {
	private ProductDao productDao = new ProductDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// index.jsp 로부터 넘어온 categoryNo을 받아옴
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		System.out.println(productNo + " <-- productNo ProductOneController");
		if(productNo == 0) { // 카테고리 번호가 없을 시
			response.sendRedirect("/indexController");
		}
		
		// 인기순(order주문 순으로 보여주기)
		List<Map<String,Object>> list = productDao.selectProductOne(productNo);
						
		// -----------------------------디버깅-----------------------------
		for(Map m : list) {
			System.out.println(m.get("productNo") + " <-- productNo doGet() ProductOneController ");
			System.out.println(m.get("name") + " <-- name doGet() ProductOneController ");
			System.out.println(m.get("price") + " <-- price doGet() ProductOneController ");
			System.out.println(m.get("volume") + " <-- volume doGet() ProductOneController ");
			System.out.println(m.get("materialName") + " <-- materialName doGet() ProductOneController ");
			System.out.println(m.get("originName") + " <-- originName doGet() ProductOneController ");
			System.out.println(m.get("manufactureDate") + " <-- manufactureDate doGet() ProductOneController ");
			System.out.println(m.get("expirationDate") + " <-- expirationDate doGet() ProductOneController ");
			System.out.println(m.get("alcoholLevel") + " <-- alcoholLevel doGet() ProductOneController ");
			System.out.println(m.get("factory") + " <-- factory doGet() ProductOneController ");
			System.out.println(m.get("color") + " <-- color doGet() ProductOneController ");
			System.out.println(m.get("bottle") + " <-- bottle doGet() ProductOneController ");
			System.out.println(m.get("region") + " <-- region doGet() ProductOneController ");
			System.out.println(m.get("smell") + " <-- smell doGet() ProductOneController ");
			System.out.println(m.get("sweet") + " <-- sweet doGet() ProductOneController ");
			System.out.println(m.get("maturity") + " <-- maturity doGet() ProductOneController ");
			System.out.println(m.get("picture") + " <-- picture doGet() ProductOneController ");
			System.out.println(m.get("acidity") + " <-- acidity doGet() ProductOneController ");
			System.out.println(m.get("thin") + " <-- thin doGet() ProductOneController ");
			System.out.println(m.get("refreshment") + " <-- refreshment doGet() ProductOneController ");
			System.out.println(m.get("memo") + " <-- memo doGet() ProductOneController ");
			System.out.println(m.get("categoryType") + " <-- categoryType doGet() ProductOneController ");
			System.out.println(m.get("companyName") + " <--companyName doGet() ProductOneController ");		
		}
		
		request.setAttribute("productNo", productNo);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/product/productOne.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

