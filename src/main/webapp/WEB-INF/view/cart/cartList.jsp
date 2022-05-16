<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<div class="section_title">장바구니</div>
					</div>
				</div>
			</div>
      <div class="row">
         <div class="col">
					<table class ="table table-bordered">
					<c:forEach items="${cartList}" var="item">
						<form method="post" action="${pageContext.request.contextPath}/deleteProductInCartController">
						<tr>
		                     <td>상품사진</td>
		                     <td>정보</td>
		                     <td>가격</td>
		                     <td>수량</td>
		                     <td>
		                        <div class="float-right">
		                              <a href="${pageContext.request.contextPath}/deleteProductInCartController">
		                              <div class= "btn btn-outline-secondary btn-sm">모두삭제</div>
		                           </a>
		                        </div>
		                     </td>
	                  	</tr>
						<tr>

							<td>
								<input type="hidden" value="${item.cartNo}" name="cartNo" >
								<input type="hidden" value="${item.productNo}" name="cartNo">
								<img src="images/product_1.jpg" width="150px">
							<br>
								${item.picture}
							</td>
							
							<td>
								${item.name}
							</td>
							
							<td>
								${item.price}원
							</td>

							<td>
							<script>
										if(${item.count > 5}){
											alert("${item.name}의 수량은 5개까지만 등록 가능합니다.");
										}
							</script>
								<div class="selectCount">
										<c:if test="${item.count<= 5}">현재 수량 : ${item.count} 개</c:if> 
										<c:if test="${item.count > 5}">${item.count = 5}</c:if>
										<select onchange="window.open(value,'blank');">
                                       <option value = "">:: 변경하기 ::</option>
                                       <option value =${pageContext.request.contextPath}/updateProductInCartController?count=1&productNo=${item.productNo}>1개</option>
                                       <option value =${pageContext.request.contextPath}/updateProductInCartController?count=2&productNo=${item.productNo}>2개</option>
                                       <option value =${pageContext.request.contextPath}/updateProductInCartController?count=3&productNo=${item.productNo}>3개</option>
                                       <option value =${pageContext.request.contextPath}/updateProductInCartController?count=4&productNo=${item.productNo}>4개</option>
                                       <option value =${pageContext.request.contextPath}/updateProductInCartController?count=5&productNo=${item.productNo}>5개</option>
                                       </select>
								</div>
							</td>
							<td>
								<button type="submit">x</button>
							</td>
						</tr>
						</form>
						
					</c:forEach>
				</table>  
			</div>  
	</div>
	<!--  주문하기 버튼 -->
	<div class="text-center orderBar">
      <a href="#" class="orderBtn">주문하기</a>
   </div>
</div>
	<!-- Footer -->	
	<jsp:include page="../../../WEB-INF/inc/footer.jsp"></jsp:include>
</div>
</body>

</html>