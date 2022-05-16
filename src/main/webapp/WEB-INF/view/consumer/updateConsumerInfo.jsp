<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>consumerOne</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Wish shop project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/responsive.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>
   <div class="super_container">
      <!-- Header -->
      <jsp:include page="../../../WEB-INF/inc/navBar.jsp"></jsp:include>
   
      <!-- content -->
      <div class="register">
         <div class="gallery">
            <div class="container">
               <div class="row">
                  <div class="col">
                     <div class="register_title ">            
                     <h1>${sessionMemberId}님의 회원정보</h1>
                        <table class = "table text-center">
                        <!-- consumer_id, password, name, phone, email, address, Detailed_Addreess, Account, UPDATE_DATE -->
                           <tr>
                              <th>회원 아이디</th>
                              <th>
                                 <input type="text" class="form-control" value ="${consumerList[0].consumerId}" name="consumerId" id="consumerId" readonly="readonly">
                              </th>
                           </tr>
                           <tr>
                              <th>비밀번호</th>
                              <th>
                                 <input type="password" class="form-control" value ="${consumerList[0].password}" name="password" id="password">
                              </th>
                           </tr>
                           <tr>
                              <th>회원 이름</th>
                              <th>
                                 <input type="text" class="form-control" value ="${consumerList[0].name}" name="consumerName" id="consumerName">
                              </th>
                           </tr>
                           <tr>
                              <th>회원 전화번호</th>
                              <th>
                                 <input type="text" class="form-control" value ="${consumerList[0].phone}" name="consumerPhone" id="consumerPhone">
                              </th>
                           </tr>
                           <tr>
                              <th>회원 이메일</th>
                              <th>
                                 <input type="text" class="form-control" value ="${consumerList[0].email}" name="consumerEmail" id="consumerEmail">
                              </th>
                           </tr>
                           <tr>
                              <th>회원 주소</th>
                              <th>
                                 <input type="text" class="form-control" value ="${consumerList[0].address}" name="consumerAddress" id="consumerAddress">
                              </th>
                           </tr>
                           <tr>
                              <th>회원 상세주소</th>
                              <th>
                                 <input type="text" class="form-control" value ="${consumerList[0].detailedAddr}" name="consumerDetailedAddress" id="consumerDetailedAddress">
                              </th>
                           </tr>                           
                           <tr>
                              <th>회원 계좌</th>
                              <th>
                                 <input type="text" class="form-control" value ="${consumerList[0].account}" name="consumerAccount" id="consumerAccount">
                              </th>
                           </tr>
                           <tr>
                              <th>회원 수정 날짜</th>
                              <th>
                                 <input type="text" class="form-control" value ="${consumerList[0].updateDate}" name="consumerUpdateDate" id="consumerUpdateDate">
                              </th>
                           </tr>
                           
                        </table>
                        <a href="${pageContext.request.contextPath}/consumerOneController">회원정보 수정</a>
                        <a href="${pageContext.request.contextPath}/indexController">취소</a>
                        <!-- response.sendRedirect(request.getContextPath()+"/loginController"); 수정컨트롤러 이동 -->
                        
                     </div>
                  </div>
               </div>
            </div>   
         </div>
      </div>
      
   </div>
</body>
   <script>
      $(".actionHover").mouseover( function(){ 
         $(".submenu").stop().slideDown(500); 
         }) 
         
      $(".actionHover").mouseout(function(){
         $(".submenu").stop().slideUp(1000); 
      })
   </script>
</html>