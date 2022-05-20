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

@WebServlet("/findConsumerPwController")
public class FindConsumerPwController extends HttpServlet {
   private ConsumerDao consumerDao = new ConsumerDao();
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 로그인 확인
      HttpSession session = request.getSession();
      String sessionMemberId = (String)session.getAttribute("sessionMemberId");
      System.out.println(sessionMemberId + " <-- sessionMemberId doGet() findConsumerPwController");
      if(sessionMemberId != null) {
         // 로그인 되어있을시에 indexController 이동
         response.sendRedirect(request.getContextPath()+"/indexController");
         return;
      }
      
      request.getRequestDispatcher("/WEB-INF/view/login/findConsumerPw.jsp").forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// findConsumerPw.jsp에서 입력한 값 받아오기
		String consumerId = request.getParameter("consumerId");
		String consumerName = request.getParameter("consumerName");
		String phone = request.getParameter("phone");
		
		// 디버깅
		System.out.println(consumerId + " <-- consumerId doPost() findConsumerPwController");
		System.out.println(consumerName + " <-- consumerName doPost() findConsumerPwController");
		System.out.println(phone + " <-- phone doPost() findConsumerPwController");
		
		// 입력한 consumerId에 대한 정보 가져오기
		List<Consumer> consumerList = consumerDao.selectConsumerOneInfo(consumerId);
		for(Consumer consumer : consumerList) {
			System.out.println(consumer.getConsumerId() + " <-- consumerId doGet() findConsumerPwController ");
			System.out.println(consumer.getName() + " <-- name doGet() findConsumerPwController ");
			System.out.println(consumer.getPhone() + " <-- phone doGet() findConsumerPwController ");
			System.out.println(consumer.getEmail() + " <-- email doGet() findConsumerPwController ");
			System.out.println(consumer.getAddress() + " <-- address doGet() findConsumerPwController ");
			System.out.println(consumer.getDetailedAddr() + " <-- detailedAddress doGet() findConsumerPwController ");
			System.out.println(consumer.getConsumerLevel() + " <-- consumerLevel doGet() findConsumerPwController ");
			System.out.println(consumer.getAccount() + " <-- ACCOUNT doGet() findConsumerPwController ");
			System.out.println(consumer.getCreateDate() + " <-- createDate doGet() findConsumerPwController ");
		}
		
		System.out.println("---------------------------------");
		
		System.out.println(consumerList.get(0).getName() + " <-- consumerList.get(0).getName()");
		System.out.println(consumerList.get(0).getPhone() + " <-- consumerList.get(0).getPhone()");
		
		if( (!consumerList.get(0).getName().equals(consumerName)) || (!consumerList.get(0).getPhone().equals(phone)) ){
			response.sendRedirect(request.getContextPath() + "/loginController");
			System.out.println("정확히 입력하세요");
			return;
		}
		// consumerId, name, phone이 일치하면 비밀번호 재설정창으로 감
		request.setAttribute("consumerId", consumerId);
		request.getRequestDispatcher("/WEB-INF/view/login/updateConsumerPw.jsp").forward(request, response);
	
   }

}