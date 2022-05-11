<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
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
<!-- Header -->

	<header class="header">
		<div class="header_inner d-flex flex-row align-items-center justify-content-start">
			<div class="logo"><a href="#">목로주점木壚酒店</a></div>
			<nav class="main_nav">
				<ul>
					<li class="actionHover"><a href="#">주종</a>
						<ul class="submenu">
						<%
							List<Category> list = new ArrayList<>();
							Category category = new Category();
							list =(List<Category>)request.getAttribute("categoryList");
							for(Category c : list){
						%>
							<li><a href="${pageContext.request.contextPath}/categoryProductListController?categoryNo=<%=c.getCategoryNo()%>"><%=c.getType()%></a></li>
						<%		
							}
						%>
						</ul>
						</li>
					<li><a href="#">지역</a></li>
					<li><a href="${pageContext.request.contextPath}/bestProductListController">인기순</a></li>
					<li><a href="#">커뮤니티</a></li>
					<li><a href="#">contact</a></li>
				</ul>
			</nav>
			
			<div class="header_content ml-auto">
				<!-- search -->
				<div class="search header_search">
					<form action="#">
						<input type="search" class="search_input" required="required">
						<button type="submit" id="search_button" class="search_button"><img src="${pageContext.request.contextPath}/images/magnifying-glass.svg" alt=""></button>
					</form>
				</div>
				<!-- Cart -->
				<div class="shopping">
					<a href="#">
						<div class="cart">
							<img src="${pageContext.request.contextPath}/images/shopping-bag.svg" alt="">
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
							<img src="${pageContext.request.contextPath}/images/avatar.svg" alt="">
						</div>
					</a>
				</div>
				
				<div>
			    	
			    </div>
				
			</div>
				<div class="logo">
					<c:if test="${sessionMemberId != null}">
						${sessionMemberId}님 반갑습니다.
						<a href="LogoutController">로그아웃</a>
					</c:if>
					
					<c:if test="${sessionMemberId == null}">
						<a href="LoginController">로그인 해주세요!</a>
					</c:if>

				</div>
				
				
			</div>
	</header>
	
	<!-- -------------------------------------- nav 끝-------------------------------------- -->
	
	<!-- line 29줄 nav에 넣어야 할 list(주류) 이것듦을 hover처리 해야함 -->
		<div>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

		</div>
		
		<!-- Footer -->

	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<div class="footer_logo"><a href="#">목로주점木壚酒店</a></div>
					<nav class="footer_nav">
						<ul>
							<div><li>서울특별시 광진구 천호대로 515 목로주점 사무실</li></div>
							<div><li>대표 : 오렌지조</li></div>
							<div><li>사업자 등록번호 : 405-85-08714</li></div>
							<div><li>대표번호 : 070-1111-2222</li></div>
							<div><li>이메일 : 123@naver.com</li></div>
						</ul>
					</nav>
					<div class="footer_social">
						<ul>
							<li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-reddit-alien" aria-hidden="true"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
						</ul>
					</div>
					<div class="copyright"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
		Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
		<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></div>
				</div>
			</div>
		</div>
	</footer>
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