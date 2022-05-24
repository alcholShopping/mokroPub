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

import dao.ConsumerDao;
import dao.OrdereAfterDao;
import vo.Consumer;

@WebServlet("/consumerOneController")
public class ConsumerOneController extends HttpServlet {
	private OrdereAfterDao orderafterDao;
	private ConsumerDao consumerDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		System.out.println(sessionMemberId + " <-- sessionMemberId doGet() consumerOneController");

		// 아이디를 번호로 교체
		consumerDao = new ConsumerDao();
		int consumerId = consumerDao.changeConsumerIdToNo(sessionMemberId);

		orderafterDao = new OrdereAfterDao();
		List<Map<String,Object>> orList = orderafterDao.selectOrderedById(consumerId);
		if(sessionMemberId == null) {
			// 로그인 안되어있을시에 LoginController 이동
			System.out.println("doGet() consumerOneController 로그인 해야합니다.");
			response.sendRedirect(request.getContextPath()+"/loginController");
			return;
		}
		request.setAttribute("orList",orList);
		request.getRequestDispatcher("/WEB-INF/view/consumer/consumerOne.jsp").forward(request, response);			
	}

}
