package controller;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import vo.*;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private IndexDao indexDao = new IndexDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 확인
		
		// 상단바 주류 올릴시(hover)
		List<Category> list = new ArrayList<>();
		Category category = new Category();
		list = indexDao.selectCategoryList();
		// 디버깅 
		for(Category c : list) {
			System.out.println(c.toString());
		}
		request.setAttribute("list", list);
				
		request.getRequestDispatcher("/WEB-INF/view/login/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
		Customer co = new Customer();
		int row = 999;
		
		String customerId = request.getParameter("customerId");
		String password = request.getParameter("password");
		String passwordRe = request.getParameter("passwordRe");
		String name = request.getParameter("name");
		String addressResult = request.getParameter("addressResult");
		String zipCode;
		System.out.println(addressResult+"<<<<<<Address");
		System.out.println(addressResult.length()-5+"<<<<<<address.length()-5");
		zipCode = addressResult.substring(addressResult.length()-5, addressResult.length());
		String detailedAddress = request.getParameter("detailedAddress");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String residentNumber = request.getParameter("residentNumber");
		String accountNumber = request.getParameter("accountNumber");
		
		//성인인증용
		int birthYear = Integer.parseInt(request.getParameter("birthYear"));
				
		//성인인가요?
		int yearNow = Calendar.getInstance().get(Calendar.YEAR);

				
		co.setConsumerId(customerId);
		co.setPassword(password);
		co.setName(name);
		co.setAddress(addressResult);
		co.setZipCode(zipCode);
		co.setDetailedAddress(detailedAddress);
		co.setEmail(email);
		co.setPhone(phone);
		co.setResidentNumber(residentNumber);
		co.setAccountNumber(accountNumber);
		
		RegisterDao rd = new RegisterDao();
		
		try {
			row = rd.registerByCustomer(co);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(row == 1) {
			response.sendRedirect("LoginController");
		} else {
			response.sendRedirect("RegisterController");
		}
	}

}
