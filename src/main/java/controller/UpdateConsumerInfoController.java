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


@WebServlet("/updateConsumerInfoController")
public class UpdateConsumerInfoController extends HttpServlet {
	private ConsumerDao consumerDao = new ConsumerDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직을 통해 로그인여부 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		System.out.println(sessionMemberId + " <-- sessionMemberId doGet() consumerOneController");
		if(sessionMemberId == null) {
			// 로그인이 안되있을경우 LoginController 이동
			System.out.println("doGet() CheckConsumerPwController");
			response.sendRedirect(request.getContextPath()+"/loginController"); // 로그인컨트롤러로 이동 
			return;
	
		}
		// jsp파일을 보여주기전에 수정 전
		// selectConsumerOneInfo Dao에 있던 데이터값 호출 후 표시
		ConsumerDao consumerDao = new ConsumerDao();
		List<Consumer> consumerList = consumerDao.selectConsumerOneInfo(sessionMemberId);
		
		// 수정 전 보여줄 호출할 Dao값이 잘 있나 디버깅
		// consumer_id, password, name, phone, email, address, Detailed_Addreess, Account, UPDATE_DATE
		for(Consumer consumer : consumerList) {						
			System.out.println(consumer.getConsumerId() + " <-- consumerId doGet() UpdateConsumerInfoController ");
			System.out.println(consumer.getPassword() + " <-- password doGet() UpdateConsumerInfoController ");
			System.out.println(consumer.getName() + " <-- name doGet() UpdateConsumerInfoController ");
			System.out.println(consumer.getPhone() + " <-- phone doGet() UpdateConsumerInfoController ");
			System.out.println(consumer.getEmail() + " <-- email doGet() UpdateConsumerInfoController ");
			System.out.println(consumer.getAddress() + " <-- address doGet() UpdateConsumerInfoController ");
			System.out.println(consumer.getDetailedAddr() + " <-- detailedAddress doGet() UpdateConsumerInfoController ");			
			System.out.println(consumer.getAccount() + " <-- ACCOUNT doGet() UpdateConsumerInfoController ");
			System.out.println(consumer.getUpdateDate() + " <-- updateDate doGet() UpdateConsumerInfoController ");
		}
		request.setAttribute("consumerList",consumerList);

		request.getRequestDispatcher("/WEB-INF/view/consumer/updateConsumerInfo.jsp").forward(request, response);						
	}
		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직을 통해 로그인여부 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		System.out.println(sessionMemberId + " <-- sessionMemberId doGet() consumerOneController");
		if(sessionMemberId == null) {
			// 로그인이 안되있을경우 LoginController 이동
			System.out.println("doGet() CheckConsumerPwController");
			response.sendRedirect(request.getContextPath()+"/loginController"); // 로그인컨트롤러로 이동 
			return;
		}
		
		// jsp파일에서 받아온 값을(수정된 값)
		// consumer에 정재	
		// consumer_id, password, name, phone, email, address, Detailed_Addreess, Account, UPDATE_DATE
		String consumerId = request.getParameter("consumerId");
		String password = request.getParameter("password");
		String consumerName = request.getParameter("consumerName");
		String consumerPhone = request.getParameter("consumerPhone");
		String consumerEmail = request.getParameter("consumerEmail");
		String consumerAddress = request.getParameter("consumerAddress");
		String consumerDetailedAddress = request.getParameter("consumerDetailedAddress");
		String consumerAccount = request.getParameter("consumerAccount");
		String consumerUpdateDate = request.getParameter("consumerUpdateDate");
		
		// (Dao)DB에서 업데이트된 내용을 불러옴
		
		// Update문 호출
		Consumer consumer = new Consumer();
		consumer.setConsumerId(consumerId);
		consumer.setPassword(password);
		consumer.setName(consumerName);
		consumer.setEmail(consumerEmail);
		consumer.setPhone(consumerPhone);
		consumer.setResidentNumber(consumerAddress);
		consumer.setAccount(consumerDetailedAddress);
		consumer.setDetailedAddr(consumerAccount);
		consumer.setDetailedAddr(consumerUpdateDate);
		
		System.out.println(consumerId + " <-- consumerId doPost() UpdateConsumerInfoController");
		System.out.println(password + " <-- password doPost() UpdateConsumerInfoController");
		System.out.println(consumerName + " <-- consumerName doPost() UpdateConsumerInfoController");
		System.out.println(consumerPhone + " <-- consumerPhone doPost() UpdateConsumerInfoController");
		System.out.println(consumerEmail + " <-- consumerEmail doPost() UpdateConsumerInfoController");
		System.out.println(consumerAddress + " <-- consumerAddress doPost() UpdateConsumerInfoController");
		System.out.println(consumerDetailedAddress + " <-- consumerDetailedAddress doPost() UpdateConsumerInfoController");
		System.out.println(consumerAccount + " <-- consumerAccount doPost() UpdateConsumerInfoController");
		System.out.println(consumerUpdateDate + " <-- consumerUpdateDate doPost() UpdateConsumerInfoController");
		
		consumerDao.updateConsumerInfo(consumer);
		response.sendRedirect(request.getContextPath()+"/consumerOneInfo");
	}
	
}
