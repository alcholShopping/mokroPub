package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConsumerDao;
import vo.Consumer;

@WebServlet("/consumerOneInfoController")
public class ConsumerOneInfo extends HttpServlet {
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
		
		// consumerlist를 보여줘는 메서드 실행
		List<Consumer> consumerList = consumerDao.selectConsumerOneInfo(sessionMemberId);
		
		// 회원등급을 숫자가 아닌 글자로 --> 얼마나 등급이 있을지 몰라서 우선 1일떄 VIP라고 정함
		String consumerLevelText = "";
		if( consumerList.get(0).getConsumerLevel() == 1) {
			consumerLevelText = "BRONZE";
		} else if( consumerList.get(0).getConsumerLevel() == 2) {
			consumerLevelText = "SILVER";
		} else if( consumerList.get(0).getConsumerLevel() == 3) {
			consumerLevelText = "GOLD";
		}
		
		// 디버깅
		for(Consumer consumer : consumerList) {
			System.out.println(consumer.getConsumerId() + " <-- consumerId doGet() consumerOneInfo ");
			System.out.println(consumer.getName() + " <-- name doGet() consumerOneInfo ");
			System.out.println(consumer.getPhone() + " <-- phone doGet() consumerOneInfo ");
			System.out.println(consumer.getEmail() + " <-- email doGet() consumerOneInfo ");
			System.out.println(consumer.getAddress() + " <-- address doGet() consumerOneInfo ");
			System.out.println(consumer.getDetailedAddr() + " <-- detailedAddress doGet() consumerOneInfo ");
			System.out.println(consumer.getConsumerLevel() + " <-- consumerLevel doGet() consumerOneInfo ");
			System.out.println(consumer.getAccount() + " <-- ACCOUNT doGet() consumerOneInfo ");
			System.out.println(consumer.getCreateDate() + " <-- createDate doGet() consumerOneInfo ");
			System.out.println(consumer.getUpdateDate() + " <-- updateDate doGet() consumerOneInfo ");
		}
		System.out.println(consumerLevelText + " <-- consumerLevelText doGet() consumerOneInfo");
		
		request.setAttribute("consumerList", consumerList);
		request.setAttribute("consumerLevelText", consumerLevelText);
		
		request.getRequestDispatcher("/WEB-INF/view/consumer/consumerOneInfo.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
