package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConsumerDao;
import dao.LoginDao;

@WebServlet("/deleteCheckConsumerController")
public class DeleteCheckConsumerController extends HttpServlet {
   private ConsumerDao consumerDao = new ConsumerDao();   
   private LoginDao loginDao = new LoginDao();
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
      request.getRequestDispatcher("/WEB-INF/view/consumer/deleteCheckConsumerPw.jsp").forward(request, response);                  
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
      
      // JSP에서 pw를 받아야함 
      String password = request.getParameter("userPw");
      System.out.println(password + "<-- password doPost() CheckCosumerPwController");
      
      password = loginDao.changePwToEncryptionPw(sessionMemberId, password); // 복호화된 비밀번호 가져오기
      System.out.println(password + "<-- changeEncryptionPw doPost() CheckCosumerPwController");

      String checkConsumerPw  = consumerDao.checkConsumerPw(sessionMemberId);
      System.out.println(checkConsumerPw + "<-- checkConsumerPw doPost() CheckCosumerPwController");
      
      // 아이디를 번호로 교체
   	  int consumerId = consumerDao.changeConsumerIdToNo(sessionMemberId);
   		
      if(password.equals(checkConsumerPw)) {
         // response.sendRedirect(request.getContextPath() + "/updateConsumerInfoController");
         System.out.println("비밀번호가 일치합니다.");
         
         consumerDao.deleteConsumer(consumerId);
    	 System.out.println("계정이 정상적으로 삭제되었습니다. ============================================================================================================================================================================================================");
    	 //삭제하고 세션을 초기화해야겠지?
         request.getSession().invalidate(); // session 갱신 메서드 : 기존 session을 지우고 새로운 새션을 부여함
         
         String deleteId = "true";
         HttpSession session2 = request.getSession();
         session2.setAttribute("deleteId", deleteId);
         response.sendRedirect(request.getContextPath() + "/indexController");
      } else {
         response.sendRedirect(request.getContextPath() + "/consumerOneInfoController");
         System.out.println("비밀번호가 불일치합니다.");
      }
   
   }
}