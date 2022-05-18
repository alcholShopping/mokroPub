<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productOne</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Wish shop project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/responsive.css">
</head>
<body>
<div class="super_container">
	<!-- Header -->
	<jsp:include page="../../../WEB-INF/inc/navBar.jsp"></jsp:include>
	
	<!-- contents -->
	<div class="nullbox">
	</div>
	<!-- Product -->
	<div class="product">
		<div class="container">
			<div class="row product_row">

            	<c:forEach var="m" items="${list}">
            	
				<!-- Product Image -->
				<div class="col-lg-7">
					<div class="product_image">
						<div class="product_image_large"><img src="images/product_image_1.jpg" alt=""></div>
						<div class="product_image_thumbnails d-flex flex-row align-items-start justify-content-start">
						</div>
					</div>
				</div>

				<!-- Product Content -->
				<div class="col-lg-5">
					<div class="product_content">
						<div class="product_one_name">${m.name} ${m.volume} ${m.alcoholLevel} 도</div>
						<div class="product_price">${m.price}원</div>
						<div class="product_price">제조연원일 : ${m.manufactureDate}</div>
						<div class="product_price">유통기한 : ${m.expirationDate}</div>
						<br>
						
						<!-- In Stock -->
						<div class="in_stock_container">
							<div class="in_stock in_stock_true"></div>
							<span>상세설명</span>
							<table>
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
						
						<!-- Product Quantity -->
					<form method="get" action="${pageContext.request.contextPath}/productOneController">
						<div class="product_quantity_container">
							<span>수량</span>
							<div class="product_quantity clearfix">
								<input type="number" name = "count" value="1" max="5">
								<input type="number" name = "productNo" value="${productNo}">
							</div>
						</div>
						<!-- Product Size -->
						<div class="product_size_container">
							<button type="submit">add to cart</button>
						</div>
						</form>
						
					</div>
				</div>
					<!-- Product Memo(설명) -->
				<div class="product_text">
					<p>${m.memo}</p>
				</div>
				</c:forEach>
			</div>		
		</div>
	</div>
	<!-- 끝 -->
	
	<!-- 리뷰 시작 -->
	
	<div class="row">
         <div class="col">
					<table class ="table table-bordered">
					<c:forEach items="${reviewList}" var="item">					
						<tr>
		                     <td>작성자</td>
		                     <td>사진</td>
		                     <td>별점</td>
		                     <td>내용</td>	                    
		                     <td>작성일</td>                    
	                  	</tr>
	                  	
						<tr>

							<td>
								${item.name}
							</td>
								
							<td>
								${item.picture}
							</td>
							
							<td>
								${item.star}/5
							</td>
							
							<td>
								${item.content}
							</td>
							
							<td>
								${item.createDate}
							</td>

						
						</tr>					
					</c:forEach>
				</table>  
			</div>  
	</div>
</div>
</body>
</html>