<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>
	<div class="super_container">
	<header class="header">
		<div class="header_inner d-flex flex-row align-items-center justify-content-start">
			<div class="logo">
				<a href="${pageContext.request.contextPath}/indexController">목로주점木壚酒店</a>
			</div>
			
			<nav class="main_nav">
				<ul>
					<li class="actionHover"><a href="#">주종</a>
						<ul class="submenu">
							<li><a href="${pageContext.request.contextPath}/categoryProductListController?categoryNo=1">증류수</a></li>
							<li><a href="${pageContext.request.contextPath}/categoryProductListController?categoryNo=2">리큐르</a></li>
							<li><a href="${pageContext.request.contextPath}/categoryProductListController?categoryNo=3">막걸리</a></li>
							<li><a href="${pageContext.request.contextPath}/categoryProductListController?categoryNo=4">약주</a></li>
							<li><a href="${pageContext.request.contextPath}/categoryProductListController?categoryNo=5">청주</a></li>
							<li><a href="${pageContext.request.contextPath}/categoryProductListController?categoryNo=6">과실주</a></li>
							<li><a href="${pageContext.request.contextPath}/categoryProductListController?categoryNo=7">기타주류</a></li>
						</ul></li>
					<li><a
						href="${pageContext.request.contextPath}/priceProductListController">가격순</a></li>
					<li><a href="${pageContext.request.contextPath}/bestProductListController">인기순</a></li>
					<li><a href="#">커뮤니티</a></li>
					<li><a href="#">contact</a></li>
				</ul>
			</nav>
	
			<div class="header_content">
				<!-- search -->
				<div class="search header_search">
					<form action="#">
						<input type="search" class="search_input" value=">>상세검색 >>" readonly="readonly">
						<button type="submit" id="search_button" class="search_button">
							<img
								src="${pageContext.request.contextPath}/images/magnifying-glass.svg"alt="">
						</button>
					</form>
				</div>
				<!-- Cart -->
				<div class="shopping">
					<a href="#">
						<div class="cart">
							<img
								src="${pageContext.request.contextPath}/images/shopping-bag.svg"alt="">
							<div class="cart_num_container">
								<div class="cart_num_inner">
									<div class="cart_num">0</div>
								</div>
							</div>
						</div>
					</a>
	
					<!-- Avatar -->
					<a href="#">
						<div class="avatar">
							<img src="${pageContext.request.contextPath}/images/avatar.svg"
								alt="">
						</div>
					</a>
				</div>
			</div>
		</div>
	</header>
	
		<!-- -------------------------------------- nav 끝-------------------------------------- -->
		<div class="register">
			<div class="gallery">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="register_title text-center">
							
								<form action="${pageContext.request.contextPath}/loginController" method="post">
									<table class = "table">
										<tr>
											<th>USER ID:</th>
											<th>
											<input type="text" class="form-control" placeholder="아이디를 입력하세요" name="userId">
											</th>
										</tr>
										
										<tr>
											<th>Password:</th>
											<th>
												<input type="password" class="form-control" placeholder="비밀번호를 입력하세요" name="userPw">
											</th>
										</tr>
										
										<tr>
											<td colspan="2">
												<button type="submit" class="btn btn-primary">로그인</button>
												<a href="${pageContext.request.contextPath}/registerController" type="submit" class="btn btn-primary">`</button>
											</td>
										
										<tr>
									</table>
								</form>
							</div>
						</div>
					</div>
				</div>	
			</div>
		</div>
	</div>
</body>
	<script>
		$(".actionHover").mouseover( function(){ 
			$(".submenu").stop().slideDown(500); 
			}) 
		$(".actionHover").mouseout(function(){
			$(".submenu").stop().slideUp(1000); 
		})
	</script>
</html>