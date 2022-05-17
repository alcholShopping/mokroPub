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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="super_container">
	<!-- Header -->
	<jsp:include page="../../../WEB-INF/inc/navBar.jsp"></jsp:include>
	<!-- contents -->
	<div class="nullbox">
	</div>
	
	<!--  장바구니 내역 -->
	<div class="container">
      <div class="row">
         <div class="col">
			<div class="section_title_container text-center">
					<div class="section_subtitle">목로주점</div>
						<div class="section_title">주문창</div>
				</div>
				<table class ="table table-bordered">
					<tr>
                     <td>상품사진</td>
                     <td>정보</td>
                     <td>가격</td>
                     <td>수량</td>
					</tr>
					<c:forEach items="${cartList}" var="item">
						<tr>
							<input type="hidden" value="${item.cartNo}" name="cartNo" >
							<input type="hidden" value="${item.productNo}" name="cartNo">
							<td>
								<img src="images/product_1.jpg" width="150px">
								<br>${item.picture}
							</td>
							<td>${item.name}</td>
							<td>${item.price}원</td>
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
					<td colspan="4" class="text-right">주문 수량 - ${cartCount}개  총 금액  ₩ ${totalPrice} 원</td>
					</tr>
				</table>	
		<!-- 회원정보 내역 -->
			<table class ="table table-bordered">
			
			<tr>
				<th>주소 검색 <br><br><br> 주소 등록 <br><br><br>상세주소</th> <!-- 주소 검색 -->
				<th>
					<form method="post" action="orderFindAddressController">
						<div class="input-group mb-3">
							<input type="text" class="form-control"
								placeholder="주소 변경을 원하시면 검색해주세요" name="address" id="address">
							<button type="submit" onclick="javascript: form.action='orderFindAddressController';">검색하기</button>
						</div>										
						<div>
							<select name="addressResult" class="form-control">
								<option value="${consumerList[0].address}" >${consumerList[0].address}</option>
								<c:forEach var="m" items="${searchList}">
									<option value="${m.searchAddr} ${m.zipcode}">${m.searchAddr} ${m.zipcode}</option>
								</c:forEach>
							</select>
						</div>				
					</form>								
					<br>
					<div>
					<input type="text" class="form-control"
					value="${consumerList[0].detailedAddr}" name="detailedAddress" id="detailedAddress">
					<span id="detailedAddressHelper" class="helper"></span>
					</div>
			</th>
				
			</tr>
				<tr>
					<td>수취인</td>
					<td>
					<input type="text" value="${consumerList[0].name}"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
					<input type="text" value="${consumerList[0].phone}"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
					<input type="text" value="${consumerList[0].email}"></td>
				</tr>


				</table>
				<!-- 결제방법 -->
				<table class ="table table-bordered">
					<tr>
						<td>결제방법</td>
						<td><input type="radio" value="" name="how_to_order"> 무통장입금</td>
					</tr>
				</table>
			
				<table class ="table table-bordered">
					<tr>
						<td>쿠폰목록</td>
						<td>
							<select name="selectCoupon">
								<option value="" selected="selected" >:: :쿠폰 선택 :::</option>	
								<c:forEach var="c" items="${couponList}">
									<option value="${c.discount}">${c.discount}원 ${c.count}개 유효기간:${c.validity}까지</option>
								</c:forEach>
							</select>
						</td>
					</tr>
				</table>

			</div>
		</div>  
	</div>
	<!-- Footer -->	
	<jsp:include page="../../../WEB-INF/inc/footer.jsp"></jsp:include>
</div>
<div class="payBar">
	<table>
		<tr>
			<td class="table_td">총 상품 금액</td>
			<td rowspan="2" class="table_td">-</td>
			<td class="table_td">할인 금액</td>
			<td rowspan="2" class="table_td">=</td>
			<td class="table_td">실제 구매 금액</td>
			<td rowspan="2">
				<form method="post" action="${pageContext.request.contextPath}/deleteProductInCartController">
				<button type="submit" class="btn btn-primary">주문하기</button>
				</form>
			</td>
			</tr>
			<tr>
			<td class="table_td_price"><span id="totalPriceWon"></span></td>
			<td class="table_td_price"><span id="discountWon"></span></td>
			<td class="table_td_price_fix"><span id="paymentWon"></span></td>
		</tr>
	</table>
	<!--  정보 다 나오고 주문 버튼 -->
	
</div>
</body>
<script>
	let totalPrice = ${totalPrice}; // 총상품 금액
	let discount = 0; // 쿠폰 할인 금액
	let payment = 0; // 실제 구매 금액 
	console.log(totalPrice + "totalPrice");
	
	$("select[name=selectCoupon]").change(function(){
	let discount =  $(this).val() // 선택된 값 바로 가져오기
	console.log(discount + "discount"); //value값 가져오기
	payment = totalPrice - discount; // 총 상품 금액 - 쿠폰 할인 금액
	console.log(payment + "실제 결제 금액");
	$('#totalPriceWon').text(totalPrice+'원');
	$('#discountWon').text(discount+'원');
	$('#paymentWon').text(payment+'원');
	});
</script>
</html>