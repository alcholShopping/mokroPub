<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/main_styles.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/responsive.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/animate.css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet"
	type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<div class="super_container">
		<!-- Header -->

		<header class="header">
			<div
				class="header_inner d-flex flex-row align-items-center justify-content-start">
				<div class="logo">
					<a href="#">목로주점</a>
				</div>
				<nav class="main_nav">
					<ul>
						<li><a
							href="${pageContext.request.contextPath}/categoryProductListController?">주류</a></li>
						<li><a href="#">지역</a></li>
						<li><a href="#">인기순</a></li>
						<li><a href="#">커뮤니티</a></li>
						<li><a href="#">contact</a></li>
					</ul>
				</nav>
				<div class="header_content ml-auto">
					<div class="search header_search">
						<form action="#">
							<input type="search" class="search_input" required="required">
							<button type="submit" id="search_button" class="search_button">
								<img src="images/magnifying-glass.svg" alt="">
							</button>
						</form>
					</div>
					<div class="shopping">
						<!-- Cart -->
						<a href="#">
							<div class="cart">
								<img src="images/shopping-bag.svg" alt="">
								<div class="cart_num_container">
									<div class="cart_num_inner">
										<div class="cart_num">1</div>
									</div>
								</div>
							</div>
						</a>

						<!-- Avatar -->
						<a href="#">
							<div class="avatar">
								<img src="images/avatar.svg" alt="">
							</div>
						</a>
					</div>
				</div>
			</div>
		</header>
		<!-- contents -->
		<div class="nullbox"></div>
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
							<a
								href="${pageContext.request.contextPath}/ProductOneController?productNo=<%=p.getProductNo()%>">
								<img src="images/product_1.jpg" alt="">
							</a>
						</div>
						<div class="product_content clearfix">
							<div class="product_info">
								<div class="product_name">
									<a
										href="${pageContext.request.contextPath}/ProductOneController?productNo=<%=p.getProductNo()%>">
										<%=p.getName()%> <%=p.getVolume()%>ml <%=p.getAlcoholLevel()%>도
									</a>
								</div>
								<div class="product_price">
									<a
										href="${pageContext.request.contextPath}/ProductOneController?productNo=<%=p.getProductNo()%>">
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
</body>
</html>