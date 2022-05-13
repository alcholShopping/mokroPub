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
         <div class="float-right">
         
		</div>
		
		<h2>주문 테이블</h2>
					<table class ="table table-bordered">
					<c:forEach items="${cartList}" var="item">

						<tr>
							<td>
								<input type="text" value="${item.cartNo}" name="cartNo">
							</td>
							<td>
								<input type="text" value="${item.productNo}" name="cartNo">
							</td>
							<td>
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
								<div class="selectCount">
									<ul class="countList">
										<li class="currentCount">현재수량 : ${item.count}
										</li>
									</ul>
								</div>
							</td>
						</tr>
						
						
					</c:forEach>
				  
				<tr>
					<td></td>
			
					<td></td>
					<td></td>
				
					<td></td>
					<td>총 금액 : ${totalPrice}</td>
					<td>주문 수량 : ${cartCount} </td>
					
				
					</tr>

				</table>
				
				<form method="post" action="${pageContext.request.contextPath}/deleteProductInCartController">
				<button type="submit" class="btn btn-primary">주문하기</button>
				</form>
			</div>  
	</div>
	
</div>
	<!-- Footer -->	
	<jsp:include page="../../../WEB-INF/inc/footer.jsp"></jsp:include>
</div>
</body>
</html>