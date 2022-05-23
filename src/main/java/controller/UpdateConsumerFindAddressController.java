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

import dao.*;
import vo.Consumer;

@WebServlet("/updateConsumerFindAddressController")
public class UpdateConsumerFindAddressController extends HttpServlet {
	private RegisterDao registerDao = new RegisterDao();
	private ConsumerDao consumerDao = new ConsumerDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/consumer/updateConsumerInfo.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");		
		// register.jsp에 address를 받아옴
		String searchAddr = request.getParameter("address");
		List<Map<String, Object>> list = null;
		List<Consumer> consumerList = null;
		try {
			list = registerDao.selectAddressListBySearch(searchAddr);
			consumerList = consumerDao. selectConsumerOneInfo(sessionMemberId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list +"<-- list======================");
		System.out.println(consumerList +"<-- infoList======================");
		request.setAttribute("searchList", list);
		request.setAttribute("consumerList", consumerList);
		request.getRequestDispatcher("/WEB-INF/view/consumer/updateConsumerInfo.jsp").forward(request, response);
				
	
	}

}
