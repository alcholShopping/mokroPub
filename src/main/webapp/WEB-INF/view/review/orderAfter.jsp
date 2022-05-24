<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cartList</title>
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
</head>

<body>
<div class="super_container">
   <!-- Header -->      
   <jsp:include page="../../../WEB-INF/inc/navBar.jsp"></jsp:include>
   <!-- contents -->
   <div class="nullbox">
   </div>
   
   <!--  구현영역  -->
   <div class="container">
   <div class="row">
            <div class="col">
               <div class="section_title_container text-center">
                  <div class="section_subtitle">목로주점</div>
                  <div class="section_title">결제내역</div>
               </div>
            </div>
         </div>
      <div class="row">
         <div class="col">
               <table class ="table table-bordered">      
                  <tr>
                           <td colspan="2">상품정보</td>
                           <td>결제금액</td>
                           <td>쿠폰 사용내역</td>
                           <td>결제방법</td>
                           <td>배송현황</td>
                           <td>결제일</td>                       
                        </tr>
                        <c:forEach items="${orList}" var="item">         
                  <tr>
                     <td>
                     <a href="${pageContext.request.contextPath}/productOneController?productNo=${item.productNo}">
                     	<img src="images/${item.picture}" width="80px">               
                     </a>
                     </td>
                     <td>
                     <a href="${pageContext.request.contextPath}/productOneController?productNo=${item.productNo}">
                     ${item.productName} ${item.volume}ml ${item.alcoholLevel}도<br>
                         판매가 ${item.price}원   
                     </a>
                     </td>
                     <td>${item.payment} 원 X ${item.count} 개 <br>
                      총 ${item.count*item.payment} 원</td>
                     <td>
                     <c:if test="${item.couponListNo == 0}">없음</c:if> 
                     <c:if test="${item.couponListNo != 0}">${item.couponListNo}번 ${item.discount}% 할인 쿠폰</c:if> 
                     </td>
                     <td>${item.method}</td>
                     <td>
                        ${item.status}
                        <input type="hidden" value="${item.status}" id="status">
                     </td>
                     <td>
                        ${item.createDate}
                        <br>
                        <c:if test="${item.status != '환불 진행 중'}">
                        	<c:if test="${item.isReviewExist == 0}">
		                        <a href="reviewController?orderNo=${item.orderNo}" class="btn btn-outline-secondary btn-sm">
		                        리뷰하기
		                        </a>
	                         </c:if>
                        </c:if>
                        <br>
	                        <a href="refundController?orderNo=${item.orderNo}&status=${item.status}" class=" btn btn-outline-secondary btn-sm" onclick="refund()">
	                        환불하기
                        </a>
                        
                     </td>
                  </tr>               
               </c:forEach>
            </table>  
            	<a href="${pageContext.request.contextPath}/consumerOneController">나의 정보</a>
         </div>  
   </div>
   <c:if test="${fn:length(orList) > 4}">
   </div>
         <!-- Footer -->   
         <jsp:include page="../../../WEB-INF/inc/footer.jsp"></jsp:include>
   </c:if>
   
   <c:if test="${fn:length(orList) < 5}">
      </div>
      <!-- Footer -->
      <div class ="fixFooter">
         <jsp:include page="../../../WEB-INF/inc/footer.jsp" ></jsp:include>
      </div>
   </c:if>
</body>
<script>
   function refund(){   
      if($('#status').val() == "환불 진행 중"){
            alert("환불 진행 중입니다.");
      }
   }
   
</script>
</html>