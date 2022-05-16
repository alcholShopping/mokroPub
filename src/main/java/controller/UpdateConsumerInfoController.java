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
      // jsp파일을 보여주기전에 수정 전 데이터값 호출 후 표시
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
      

   }
   
}