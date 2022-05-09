<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Wish</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Wish shop project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript">
            function findAddr(){
                window.open("<%= request.getContextPath() %>/findAddress.jsp", "member", "width=640, height=400")
            };
</script>

</head>
<body>

<div class="super_container">
	
	<!-- Header -->

	<header class="header">
		<div class="header_inner d-flex flex-row align-items-center justify-content-start">
			<div class="logo"><a href="#">Wish</a></div>
			<nav class="main_nav">
				<ul>
					<li><a href="#">home</a></li>
					<li><a href="categories.html">clothes</a></li>
					<li><a href="categories.html">accessories</a></li>
					<li><a href="categories.html">lingerie</a></li>
					<li><a href="contact.html">contact</a></li>
				</ul>
			</nav>
			<div class="header_content ml-auto">
				<div class="search header_search">
					<form action="#">
						<input type="search" class="search_input" required="required">
						<button type="submit" id="search_button" class="search_button"><img src="images/magnifying-glass.svg" alt=""></button>
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
					<!-- Star -->
					<a href="#">
						<div class="star">
							<img src="images/star.svg" alt="">
							<div class="star_num_container">
								<div class="star_num_inner">
									<div class="star_num">0</div>
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

			<div class="logo">XXX님 반갑습니다 <div></div><div></div><div></div></div>
		</div>
	</header>

	<!-- Menu -->

	<div class="menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400">
		<div class="menu_close_container"><div class="menu_close"><div></div><div></div></div></div>
		<div class="logo menu_mm"><a href="#">Wish</a></div>
		<div class="search">
			<form action="#">
				<input type="search" class="search_input menu_mm" required="required">
				<button type="submit" id="search_button_menu" class="search_button menu_mm"><img class="menu_mm" src="images/magnifying-glass.svg" alt=""></button>
			</form>
		</div>
		<nav class="menu_nav">
			<ul class="menu_mm">
				<li class="menu_mm"><a href="#">home</a></li>
				<li class="menu_mm"><a href="#">clothes</a></li>
				<li class="menu_mm"><a href="#">accessories</a></li>
				<li class="menu_mm"><a href="#">lingerie</a></li>
				<li class="menu_mm"><a href="#">contact</a></li>
			</ul>
		</nav>
	</div>

	<!-- Home -->

	<div class="register">
		
		<!-- Home Slider -->

	  <div class="gallery">
		<!--  <div class="gallery_image" style="background-image:url(images/temp_main1.jpg)"></div>  -->
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="register_title text-center">
						
						<form action="/action_page.php">
						
						<h2>회원가입</h2>
						<table class = "table">
							<tr>
								<th>
									아이디
								</th>
								
								<th>
									<input type="email" class="form-control" placeholder="Enter email" id="email">
								</th>
							</tr>
							
							<tr>
								<th>
									비밀번호
								</th>
								
								<th>
									<input type="password" class="form-control" placeholder="Enter password" id="pwd">
								</th>
							</tr>
							
							<tr>
								<th>
									비밀번호 재입력
								</th>
								
								<th>
									<input type="password" class="form-control" placeholder="Enter password" id="pwd">
								</th>
							</tr>
							
							<tr>
								<th>
									주소
								</th>
								
								<th>
									 <div class="input-group mb-3">
									    <input type="text" class="form-control" placeholder="Your Email">
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
									<input type="text" class="form-control" placeholder="" id="pwd">
								</th>
							</tr>
							
							<tr>
								<th>
									상세주소
								</th>
								
								<th>
									<input type="text" class="form-control" placeholder="" id="pwd">
								</th>
							</tr>
							
							<tr>
								<th>
									이메일
								</th>
								
								<th>
									<input type="text" class="form-control" placeholder="" id="pwd">
								</th>
							</tr>
							
							<tr>
								<th>
									전화번호
								</th>
								
								<th>
									<input type="text" class="form-control" placeholder="" id="pwd">
								</th>
							</tr>
							
							<tr>
								<th>
									주민등록번호(성인인증용)
								</th>
								
								<th>
									<input type="text" class="form-control" placeholder="" id="pwd">
								</th>
							</tr>
							
							<tr>
								<th>
									계좌번호
								</th>
								
								<th>
									<input type="text" class="form-control" placeholder="" id="pwd">
								</th>
							</tr>
							
							<tr>
								
								<th colspan="2">
									<button type="submit" class="btn btn-primary">Submit</button>
								</th>
							</tr>
							
						</table>
						  

						
					</div>
					
					
				</div>
			</div>
		</div>	
		
	</div>
	</div>


	<!-- Footer -->

	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<div class="footer_logo"><a href="#">Wish</a></div>
					<nav class="footer_nav">
						<ul>
							<li><a href="index.html">home</a></li>
							<li><a href="categories.html">clothes</a></li>
							<li><a href="categories.html">accessories</a></li>
							<li><a href="categories.html">lingerie</a></li>
							<li><a href="contact.html">contact</a></li>
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

<script>
	var jusoCallBack = function(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo){ 
		document.getElementById("zipNo").value = zipNo; 
		document.getElementById("addr").value = roadAddrPart1; 
		if(addrDetail.length>30){ 
			alert('상세주소가 너무 길어 다시 입력해야 합니다.'); 
			return; 
			} 
		document.getElementById("addrDetail").value = addrDetail; 
	}

</script>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/colorbox/jquery.colorbox-min.js"></script>
<script src="js/custom.js"></script>
</body>
</html>