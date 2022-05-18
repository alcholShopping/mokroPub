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

import dao.CartDao;
import dao.ConsumerDao;
import dao.ReviewDao;


@WebServlet("/myReviewListController")
public class MyReviewListController extends HttpServlet {

	ReviewDao reviewDao = new ReviewDao();		
	private ConsumerDao consumerDao = new ConsumerDao();
	
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
		int consumerNo = consumerDao.changeConsumerIdToNo(sessionMemberId);
		// 디버깅
		System.out.println(consumerNo + " <-- consumerId doGet() myReviewListController");
		
		List<Map<String,Object>> myReviewList = reviewDao.SelectMyReviewById(consumerNo);
		
		request.setAttribute("myReviewList", myReviewList); // jsp에 보여줄 값을 반환	
		request.getRequestDispatcher("/WEB-INF/view/review/myReviewList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.getRequestDispatcher("/WEB-INF/view/review/myReviewList.jsp").forward(request, response);
	}

}
