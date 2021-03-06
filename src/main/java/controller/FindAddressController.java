package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import vo.*;
import java.util.*;

@WebServlet("/findAddressController")
public class FindAddressController extends HttpServlet {
	private RegisterDao registerDao = new RegisterDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// register.jsp에 address를 받아옴
		String searchAddr = request.getParameter("address");
		List<Map<String, Object>> list = null;
		try {
			list = registerDao.selectAddressListBySearch(searchAddr);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		request.setAttribute("searchList", list);
		request.getRequestDispatcher("/WEB-INF/view/login/register.jsp").forward(request, response);
		
	}

}
