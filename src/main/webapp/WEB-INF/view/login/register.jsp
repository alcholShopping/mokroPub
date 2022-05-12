<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript">
</script>

<style>
	.helper {
    	color: #FF0000;
    }
</style>
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
							<img src="${pageContext.request.contextPath}/images/avatar.svg"alt="">
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
									<table class="table">
									 	
										<tr>
											<th>주소 검색 <br><br><br> 주소 등록 <br><br><br>상세주소</th>
											<th>
												<div class="input-group mb-3">
													<input type="text" class="form-control"
														placeholder="소하동 32번지" name="address" id="address">
													<button type="submit" onclick="javascript: form.action='FindAddress';">검색하기</button>
												</div>
												
												
												<div>
													<select name="addressResult" class="form-control">
														<option value="" >::: 주소 선택 :::</option>
														<c:forEach var="m" items="${searchList}">
															<option value="${m.addr} ${m.zipcode}">${m.addr} ${m.zipcode}</option>
														</c:forEach>
													</select>
												</div>
												
												<br>
												<div>
												<input type="text" class="form-control"
												placeholder="302호" name="detailedAddress" id="detailedAddress">
												<span id="detailedAddressHelper" class="helper"></span>
												</div>

												
											</th>
										</tr>
										
										<tr>
											<th>아이디</th>

											<th>
											<input type="text" class="form-control"
												placeholder="Enter ID" name="customerId" id="id">
												<span id="idHelper" class="helper"></span>
											</th>
										</tr>

										<tr>
											<th>비밀번호</th>

											<th>
											<input type="password" class="form-control"
												placeholder="Enter password" name="password" id="pw">
											<span id="pwHelper" class="helper"></span>
											</th>
										</tr>

										<tr>
											<th>비밀번호 재입력</th>

											<th><input type="password" class="form-control"
												placeholder="Re password" name="passwordRe" id="pwConfirm">
												<span id="pwConfirmHelper" class="helper"></span></th>
										</tr>

										<tr>
											<th>이름</th>

											<th><input type="text" class="form-control"
												placeholder="Won Seoung Hyun" name="name" id="name">
												<span id="nameHelper" class="helper"></span></th>
										</tr>


										<tr>
											<th>이메일</th>

											<th><input type="text" class="form-control"
												placeholder="abc_fox@naver.com" name="email" id="email">
												<span id="emailHelper" class="helper"></span></th>
										</tr>

										<tr>
											<th>전화번호</th>

											<th><input type="text" class="form-control"
												placeholder="010-4123-5342" name="phone" id="phone">
												<span id="phoneHelper" class="helper"></span></th>
										</tr>

										<tr>
											<th>주민등록번호</th>

											<th><input type="text" class="form-control"
												placeholder="980492-312423" name="residentNumber" id="residentNumber">
												<span id="residentNumberHelper" class="helper"></span></th>
										</tr>

										<tr>
											<th>태어난 연도</th>

											<th><input type="number" class="form-control"
												placeholder="1998" name="birthYear" id="birthYear">
												<span id="birthYearHelper" class="helper"></span></th>
										</tr>

										<tr>
											<th>계좌번호</th>

											<th><input type="text" class="form-control"
												placeholder="NH농협 302-1302-1392-443" name="accountNumber" id="accountNumber">
												<span id="accountNumberHelper" class="helper"></span>
											</th>
										</tr>

										<tr>

											<th colspan="2">
												<button type="submit" class="btn btn-primary">제출</button>
												<a href="indexController" type="submit" class="btn btn-primary">취소</button>
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
	
	
	$('#id').blur(function(){
		if($('#id').val().length < 4) {
			$('#idHelper').text('id는 4자이상');
			$('#id').focus();
		} else {
			$('#idHelper').text('');
		}
	});
	
	$('#pwConfirm').blur(function(){
		if($('#pw').val().length < 4) {
			$('#pwHelper').text('pw는 4자이상');
			$('#pw').focus();
		} else if($('#pw').val() != $('#pwConfirm').val()) {
			$('#pwHelper').text('pw가 일치하지 않습니다');
			$('#pw').focus();
		} else {
			$('#pwHelper').text('');
		}
	});
	
	
	$('#birthYear').blur(function() {
		if($('#birthYear').val() == '') {
			$('#birthYearHelper').text('birth을 입력하세요');
			$('#birthYear').focus();
		} else {
			$('#birthYearHelper').text('');
			// age 계산
			let today = new Date();
			let y = today.getFullYear();
			let age = y - Number($('#birthYear').val().substr(0, 4));
			$('#age').val(age);
			if(age < 19) {
				$('#birthYearHelper').text('성인만 가입가능합니다.');
				$('#birthYear').focus();
			}
		}
	});
	
	$('#name').blur(function() {
		if($('#name').val() == '') {
			$('#nameHelper').text('이름을 입력해주세요');
			$('#name').focus();
		} else {
			$('#nameHelper').text('');

		}
	});
	
	$('#email').blur(function() {
		if($('#email').val() == '') {
			$('#emailHelper').text('이메일을 입력해주세요');
			$('#email').focus();
		} else {
			$('#emailHelper').text('');

		}
	});
	
	$('#phone').blur(function() {
		if($('#phone').val() == '') {
			$('#phoneHelper').text('번호을 입력해주세요');
			$('#phone').focus();
		} else {
			$('#phoneHelper').text('');

		}
	});
	$('#residentNumber').blur(function() {
		if($('#residentNumber').val() == '') {
			$('#residentNumberHelper').text('주민번호을 입력해주세요');
			$('#residentNumber').focus();
		} else {
			$('#residentNumberHelper').text('');

		}
	});
	$('#accountNumber').blur(function() {
		if($('#accountNumber').val() == '') {
			$('#accountNumberHelper').text('계좌를 입력해주세요');
			$('#accountNumber').focus();
		} else {
			$('#accountNumberHelper').text('');

		}
	});
</script>

</html>