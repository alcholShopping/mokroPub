<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>categoryProductList</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Wish shop project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/styles/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/styles/main_styles.css">
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/styles/responsive.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css"rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css"href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css"href="plugins/OwlCarousel2-2.2.1/animate.css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet"type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<div class="super_container">
	<!-- Header -->
	<jsp:include page="../../../WEB-INF/inc/navBar.jsp"></jsp:include>
	
	<!-- contents -->
	<div class="nullbox">
	</div>
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="section_title_container text-center">
					<div class="section_title">
						<a href="priceProductListController?startPrice=0&endPrice=5000">0~5000</a>
						<a href="priceProductListController?startPrice=5000&endPrice=10000">5000~10000</a>
						<a href="priceProductListController?startPrice=10000&endPrice=15000">10000~15000</a>
						<a href="priceProductListController?startPrice=20000">20000</a>
					</div>
				</div>
			</div>
		</div>
		<div class="row products_container">
			<!-- Product -->
			<%
				List<Product> list = new ArrayList<>();
				Product product = new Product();
				list = (List<Product>) request.getAttribute("list");
				for (Product p : list) {
			%>
			<div class="col-lg-4 product_col">
				<div class="product">
					<div class="product_image">
						<a href="${pageContext.request.contextPath}/ProductOneController?productNo=<%=p.getProductNo()%>">
								<img src="images/product_1.jpg" alt="">
						</a>
					</div>
					<div class="product_content clearfix">
						<div class="product_info">
							<div class="product_name">
								<a href="${pageContext.request.contextPath}/ProductOneController?productNo=<%=p.getProductNo()%>">
									<%=p.getName()%> <%=p.getVolume()%>ml <%=p.getAlcoholLevel()%>도
								</a>
							</div>
							<div class="product_price">
								<a href="${pageContext.request.contextPath}/ProductOneController?productNo=<%=p.getProductNo()%>">
									<%=p.getPrice()%>원
								</a>
							</div>
						</div>
						<div class="product_options">
							<div class="product_buy product_option">
								<img src="images/shopping-bag-white.svg" alt="">
							</div>
							<div class="product_fav product_option">+</div>
						</div>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
</div>
</body>
</html>