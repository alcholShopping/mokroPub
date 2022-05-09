<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
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
							list =(List<Category>)request.getAttribute("list");
							for(Category c : list){
						%>
							<li><a href="${pageContext.request.contextPath}/categoryProductListController?categoryNo=<%=c.getCategoryNo()%>"><%=c.getType()%></a></li>
						<%		
							}
						%>
						</ul>
						</li>
					<li><a href="#">지역</a></li>
					<li><a href="#">인기순</a></li>
					<li><a href="#">커뮤니티</a></li>
					<li><a href="#">contact</a></li>
				</ul>
			</nav>
			
			<div class="header_content ml-auto">
				<!-- search -->
				<div class="search header_search">
					<form action="#">
						<input type="search" class="search_input" required="required">
						<button type="submit" id="search_button" class="search_button"><img src="images/magnifying-glass.svg" alt=""></button>
					</form>
				</div>
				<!-- Cart -->
				<div class="shopping">
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
	
	<!-- -------------------------------------- nav 끝-------------------------------------- -->
	
	<!-- line 29줄 nav에 넣어야 할 list(주류) 이것듦을 hover처리 해야함 -->
		<div>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

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