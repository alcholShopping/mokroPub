<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>
   <div class="super_container">
      <!-- Header -->
      <jsp:include page="../../../WEB-INF/inc/navBar.jsp"></jsp:include>
   
      <!-- -------------------------------------- nav 끝-------------------------------------- -->
      <div class="gallery">
         <div class="container">
            <div class="row">
               <div class="col">
                  <div class="section_title_container text-center">   
                  <div class="section_subtitle text-center">목로주점</div><br>         
                     <h1 class="section_title">${sessionMemberId}님</h1>
                        <table class = "table table-borderless table-hover text-center">
                           <tr >
                              <th><a href="${pageContext.request.contextPath}/consumerOneInfoController">회원정보 확인</a></th>
                           </tr>
                     
                           <tr>
                              <th><a href="${pageContext.request.contextPath}/checkConsumerPwController">회원정보 수정</a></th>
                           </tr>
                           
                           <tr>
                              <th><a href="${pageContext.request.contextPath}/cartController">장바구니</a></th>
                           </tr>
                           
                           <tr>
                              <th><a href="${pageContext.request.contextPath}/orderAfterController">주문내역 확인</a></th>
                           </tr>
                           
                           <tr>
                              <th><a href="${pageContext.request.contextPath}/inquiryListController">문의사항</a></th>
                           </tr>                           
                           <tr>
                              <th><a href="${pageContext.request.contextPath}/myReviewListController">내가 작성한 리뷰</a></th>
                           </tr>     
                            <tr>
                              <th><a href="${pageContext.request.contextPath}/updatePwInConsumerOneController">비밀번호 수정</a></th>
                           </tr>                      
                        </table>
                  </div>
               </div>
            </div>
         </div>   
      </div>
   <jsp:include page="../../../WEB-INF/inc/footer.jsp"></jsp:include>   
   </div>
</body>
</html>