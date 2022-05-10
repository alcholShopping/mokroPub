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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/responsive.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
            function findAddr(){
                window.open("FindAddress", "member", "width=640, height=400")
            };
</script>
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
			</div>
			</div>
	</header>
	
	<!-- -------------------------------------- nav 끝-------------------------------------- -->
	
	
	
	
	<!-- Home -->

	<div class="register">
		
		<!-- Home Slider -->

	  <div class="gallery">
		<!--  <div class="gallery_image" style="background-image:url(images/temp_main1.jpg)"></div>  -->
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="register_title text-center">
						
						<form action="RegisterController" method="post">
						
						<h2>회원가입</h2>
						<table class = "table">
							<tr>
								<th>
									아이디
								</th>
								
								<th>
									<input type="text" class="form-control" placeholder="Enter ID" name="customerId">
								</th>
							</tr>
							
							<tr>
								<th>
									비밀번호
								</th>
								
								<th>
									<input type="password" class="form-control" placeholder="Enter password" name="password">
								</th>
							</tr>
							
							<tr>
								<th>
									비밀번호 재입력
								</th>
								
								<th>
									<input type="password" class="form-control" placeholder="Re password" name="passwordRe">
								</th>
							</tr>
							
							<tr>
								<th>
									이름
								</th>
								
								<th>
									<input type="text" class="form-control" placeholder="Won Seoung Hyun" name="name">
								</th>
							</tr>
							
							<tr>
								<th>
									주소
								</th>
								
								<th>
									 <div class="input-group mb-3">
									    <input type="text" class="form-control" placeholder="GwangMyoung" name="address">
									    <div class="input-group-append">
									      <a href="javascript:findAddr()"><span class="input-group-text">주소검색</span></a>
									    </div>
									  </div>
								</th>
							</tr>
							
							<tr>
								<th>
									우편번호
								</th>
								
								<th>
									<input type="text" class="form-control" placeholder="13423" name="zipCode">
								</th>
							</tr>
							
							<tr>
								<th>
									상세주소
								</th>
								
								<th>
									<input type="text" class="form-control" placeholder="302호" name="detailedAddress">
								</th>
							</tr>
							
							<tr>
								<th>
									이메일
								</th>
								
								<th>
									<input type="text" class="form-control" placeholder="abc_fox@naver.com" name="email">
								</th>
							</tr>
							
							<tr>
								<th>
									전화번호
								</th>
								
								<th>
									<input type="text" class="form-control" placeholder="010-4123-5342" name="phone">
								</th>
							</tr>
							
							<tr>
								<th>
									주민등록번호
								</th>
								
								<th>
									<input type="text" class="form-control" placeholder="980492-312423" name="residentNumber">
								</th>
							</tr>
							
							<tr>
								<th>
									태어난 연도
								</th>
								
								<th>
									<input type="number" class="form-control" placeholder="1998" name="birthYear">
								</th>
							</tr>
							
							<tr>
								<th>
									계좌번호
								</th>
								
								<th>
									<input type="text" class="form-control" placeholder="NH농협 302-1302-1392-443" name="accountNumber">
								</th>
							</tr>
							
							<tr>
								
								<th colspan="2">
									<button type="submit" class="btn btn-primary">Submit</button>
								</th>
							</tr>
							
						</table>
					</form>

						
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