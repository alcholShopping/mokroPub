package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import vo.*;


@WebServlet("/orderedController")
public class OrderedController extends HttpServlet {
	OrderedDao orDao = new OrderedDao();
	CartDao cartDao = new CartDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		System.out.println(sessionMemberId + " <-- sessionMemberId doGet() consumerOneController");
		if(sessionMemberId == null) {
			// 로그인 안되어있을시에 LoginController 이동
			System.out.println("doGet() consumerOneController 로그인 해야합니다.");
			response.sendRedirect(request.getContextPath()+"/loginController");
			return;
		}	
		
		// 아이디를 번호로 교체
		int consumerNo = cartDao.changeConsumerIdToNo(sessionMemberId);
		// 사용자아이디로 번호를 찾기 orList로 반환
		List<Order> orList = orDao.selectOrderedById(consumerNo);
		
		request.setAttribute("orList", orList); // jsp에 보여줄 값을 반환
		request.getRequestDispatcher("/WEB-INF/view/review/ordered.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
