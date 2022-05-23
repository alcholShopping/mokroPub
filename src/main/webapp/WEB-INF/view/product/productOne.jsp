<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productOne</title>
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
<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<div class="super_container">
	<!-- Header -->
	<jsp:include page="../../../WEB-INF/inc/navBar.jsp"></jsp:include>
	
<!-- contents -->
<div class="nullbox">
</div>
<!-- Product -->
	<div class="container">
	<c:forEach var="m" items="${list}">
			<div class="section_title_container text-center">
				<div class="section_subtitle">목로주점</div>
			</div>
			<br>
					<div class="row product_row">
						<!-- Product Image -->
						<div class="col-lg-6">
							<div class="product_image">
								<div class="product_image_large"><img src="images/${m.picture}" alt=""></div>
								<div class="product_image_thumbnails d-flex flex-row align-items-start justify-content-start">
								</div>
							</div>
						</div>
			
						<!-- Product Content -->
						<div class="col-lg-6">
							<div class="product_content">
							<div class="product_one_title">#${m.categoryType} </div>
								<div class="product_one_name">${m.name} ${m.volume}ml ${m.alcoholLevel}도</div>
								<div class="product_price">${m.price}원</div>
								<div class="product_one_content">
								<hr>
								배송비 &nbsp; &nbsp;무료배송 
								<hr>
								제조연월일 &nbsp; &nbsp; ${m.manufactureDate}
								<hr>
								유통기한 &nbsp; &nbsp; ${m.expirationDate}
								<hr>
								</div>
								<!-- Product Cart -->
								<form method="get" action="${pageContext.request.contextPath}/productOneController">
									<div class="product_quantity_container">
										<input type="button" value="-" id="minus">
										<span id="productcnt">1</span>
										
										<input type="button" value="+" id="plus"> <span class="float-right all_count">총 상품 금액 &nbsp; &nbsp; &nbsp;<span id="priceCount"></span> 원</span>
										<br>
											<input type="hidden" name = "count" value="1" min="1" max="5" id="productCntNumber">
											<input type="hidden" name = "productNo" value="${productNo}">
											<input type="hidden" id = "price" value="${m.price}">
										</div>
									<br>
										<!-- Product Size -->
									<div class="product_size_container">
										<button type="submit" class="btnCart">장바구니</button>
									</div>
								</form>
							</div>
						</div>	
					</div>		
						<br><br><br>
						<!-- Product Memo(설명) -->
						<div class="reviews_title">상품설명</div>
						<hr>
						<div class="row">
							<div class="col-lg-8">
								<div class="product_text">
								<p>${m.memo}</p>
								</div>
							</div>
							<div class="col-lg-4">			
							<table class="table">
											<tr>
												<td>원료</td>
												<td>${m.materialName}</td>
											</tr>
											<tr>
												<td>원산지</td>
												<td>${m.originName}</td>
											</tr>
											<tr>
												<td>주종</td>
												<td>${m.categoryType}</td>
											</tr>
											<tr>
												<td>색상</td>
												<td>${m.color}</td>
											</tr>
											<tr>
												<td>향</td>
												<td>${m.smell}</td>
											</tr>
											<tr>
												<td>당도</td>
												<td>${m.sweet}</td>
											</tr>
											<tr>
												<td>숙성도</td>
												<td>${m.maturity}</td>
											</tr>
											<tr>
												<td>산미</td>
												<td>${m.acidity}</td>
											</tr>
											<tr>
												<td>바디감</td>
												<td>${m.thin}</td>
											</tr>
											<tr>
												<td>청량감</td>
												<td>${m.refreshment}</td>
											</tr>
											<tr>
												<td>재질</td>
												<td>${m.bottle}</td>
											</tr>
											<tr>
												<td>지역</td>
												<td>${m.region}</td>
											</tr>
											<tr>
												<td>품목보고번호</td>
												<td>${m.report_number}</td>
											</tr>
											<tr>
												<td>제조회사</td>
												<td>${m.companyName}</td>
											</tr>
											<tr>
												<td>제조공장</td>
												<td>${m.factory}</td>
											</tr>
										</table>
								</div>
							</div>
						</c:forEach>
		<!-- Reviews -->
							<div class="reviews">
								<div class="reviews_title">reviews</div>
								<c:if test="${fn:length(reviewList) > 2}">
									<div class="text-right">
										<a href="${pageContext.request.contextPath}/productReviewFullController?productNo=${productNo}">더보기</a>
									</div>
								</c:if>
								<hr>
								<c:if test="${fn:length(reviewList) < 1}">
								<p> 아직 작성된 리뷰가 없습니다.
								</c:if>
								<c:if test="${fn:length(reviewList) > 0}">
								<!-- Review -->
								<c:forEach items="${reviewList}" var="item">
									<table class="table">
										<tr>
											<td><div class="review_name">${item.name}님의 review</div></td>
											<td class="text-right" width="300px"> ${item.createDate}에 작성</td>
										</tr>
										<tr>
										<td>								
											<div class="rating rating_${item.star} review_rating" data-rating="">
												<i class="fa fa-star"></i>
												<i class="fa fa-star"></i>
												<i class="fa fa-star"></i>
												<i class="fa fa-star"></i>
												<i class="fa fa-star"></i>
											</div>
											<div class="review_text">
											<p>${item.content}</p></div>
										</td>
										<td class="text-right" width="300px">
											<c:if test="${item.picture != 'fileX.jpg'}">
	                       						 <img src="./images/${item.picture}" width="150px">
	                       					 </c:if>
										</td>
									<tr>
								</table>
							</c:forEach>
						</c:if>
					</div>
				</div>
   <!-- Footer -->   
   <jsp:include page="/WEB-INF/inc/footer.jsp"></jsp:include>
</div>
</body>
<script>



	let cnt = $("#productcnt").text();
	let price= $("#price").val();
	$('#priceCount').text((parseInt(price)));
	// 수량을 더하는 스크립트
	
	
	$("#plus").click(function(){
		let cnt = $("#productcnt").text();
		let price= $("#price").val();
		console.log("수량증가");
		if(cnt<5){
		$("#productcnt").text(parseInt(cnt) + 1);
		$('#productCntNumber').val(parseInt(cnt)+1);
		$('#priceCount').text((parseInt(cnt)+1)*(parseInt(price)));
		}else{
			alert("5개까지만 담을 수 있습니다.");
		}
	}) ;
	
	// 수량을 뼤는 스크립트
	$("#minus").click(function(){
		let cnt = $("#productcnt").text();
		let price= $("#price").val();
		console.log("수량감소");
		if(cnt>1){
		$("#productcnt").text(parseInt(cnt) - 1);
		$('#productCntNumber').val(parseInt(cnt) - 1);
		$('#priceCount').text((parseInt(cnt)-1)*(parseInt(price)));
		}else{
			alert("1개 미만은 담을 수 없습니다.");
		}
	}) ;

</script>
</html>