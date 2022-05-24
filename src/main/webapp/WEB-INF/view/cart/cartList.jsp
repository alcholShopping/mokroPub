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
					<div class="section_title">장바구니</div>
				</div>
				<c:if test="${fn:length(cartList) == 0}">
				<div class="page_msg">상품 정보가 없습니다.</div>
	  			<a href="${pageContext.request.contextPath}/indexController" class="btn" >상품 보러 가기</a>
				</c:if>
			</div>
		</div>
	</div>
	<div class="container">
	<div class="row">
			<c:if test="${fn:length(cartList) != 0}">
			<div class="col-lg-7">
							<table class ="table">
								<tr>
				                     <td colspan="3"></td>
				                     <td>
				                        <div class="float-right">
				                              <a href="${pageContext.request.contextPath}/deleteProductInCartController" class= "btn btn-outline-secondary btn-sm">
				                              모두삭제</a>
				                        </div>
				                     </td>
			                  	</tr> 	
			                  	<c:forEach items="${cartList}" var="item">
			                  	<c:if test="${fn:length(cartList) > 0}">
								<form method="post" action="${pageContext.request.contextPath}/deleteProductInCartController">
								<tr>
									<td>
										<input type="hidden" value="${item.cartNo}" name="cartNo" >
										<input type="hidden" value="${item.productNo}" name="cartNo">
										<img src="images/${item.picture}" width="100px">
									</td>
									<td>
									<div class="product_info">
										<div class="product_name"><b>${item.name}</b></div>
										<div class="product_price">${item.price}원</div>
										</div>
									</td>
		
									<td>
									<script>
											if(${item.count > 5}){
												alert("${item.name}의 수량은 5개까지만 등록 가능합니다.");
												}
									</script>
										<div class="selectCount">
												<c:if test="${item.count<= 5}">현재 수량 : ${item.count} 개 <br></c:if> 
												<c:if test="${item.count > 5}">${item.count = 5}<br></c:if>
												<select onchange="window.open(value,'blank');">
		                                       <option value = "">수량변경</option>
		                                       <option value =${pageContext.request.contextPath}/updateProductInCartController?count=1&productNo=${item.productNo}>1개</option>
		                                       <option value =${pageContext.request.contextPath}/updateProductInCartController?count=2&productNo=${item.productNo}>2개</option>
		                                       <option value =${pageContext.request.contextPath}/updateProductInCartController?count=3&productNo=${item.productNo}>3개</option>
		                                       <option value =${pageContext.request.contextPath}/updateProductInCartController?count=4&productNo=${item.productNo}>4개</option>
		                                       <option value =${pageContext.request.contextPath}/updateProductInCartController?count=5&productNo=${item.productNo}>5개</option>
		                                       </select>
										</div>
									</td>
									<td>
										<button type="submit" class="deleteBtn">Ⅹ</button>
									</td>
								</tr>	
								</form>
								</c:if>	
							</c:forEach>
						</table>  
							<a href="${pageContext.request.contextPath}/consumerOneController">나의 정보</a>
						</div>
					</c:if>
				<div class="col-lg-5">
				<div class="fix_cart">
				<h4><b>결제 예정 금액</b></h4><hr>
				<c:set var = "total" value = "0" />
				<c:forEach items="${cartList}" var="item">
				<div class="cart_one_product">${item.name} <span class="float-right">+ ${item.price * item.count}원</span><br></div>
				<c:set var= "total" value="${total + (item.price * item.count)}"/>
				</c:forEach>
				<hr>
				<h3>합계 <span class="float-right"><b>${total}</b>원</span></h3>
				<!--  주문하기 버튼 -->
				<a href="${pageContext.request.contextPath}/orderController">
					<div class="orderBtn">
					주문하기
				  	</div>
			   </a>
   			</div>
   			</div>
   		</div> 
   	</div> 

<c:if test="${fn:length(cartList) > 4}">
	</div>
		<!-- Footer -->	
		<jsp:include page="../../../WEB-INF/inc/footer.jsp"></jsp:include>
	</div>
</c:if>

<c:if test="${fn:length(cartList) < 5}">
	</div>
	<!-- Footer -->
	<div class ="fixFooter">
		<jsp:include page="../../../WEB-INF/inc/footer.jsp" ></jsp:include>
	</div>
</c:if>
</body>
</html>