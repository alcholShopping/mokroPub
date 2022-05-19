<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
</head>
<body>
<div class="super_container">
	<!-- Header -->	
	<jsp:include page="/WEB-INF/inc/navBar.jsp"></jsp:include>
	<!-- contents -->
	<div class="nullbox">
	</div>
	<!-- contents -->
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="section_title_container text-center">
					<div class="section_subtitle">
					목로주점
					</div>
					<div class="section_title">
					WELCOME
					</div>
					<br>
					<div class="row">
					<div class="col-sm-3">
					</div>
					<div class="col-sm-6">
						<form action="${pageContext.request.contextPath}/loginController" method="post">
							<input type="text" placeholder="USER ID" class="form-control text-center" name="userId">
							<br>				
							<input type="password"  placeholder="PASSWORD" class="form-control text-center" name="userPw">
							<br>
							<button type="submit" class="btn btn-info text-White btn-block">Log In</button>
							<hr>
							<a href="${pageContext.request.contextPath}/registerController" type="submit" class="btn btn btn-outline-secondary btn-block">Sing Up</a>
							<a href="${pageContext.request.contextPath}/findConsumerPwController" type="submit" class="btn btn btn-outline-secondary btn-block">Find Password</a>
						</form>
					</div>
					<div class="col-sm-3">
					
					</div>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>	

<!-- Footer -->
<div class ="fixFooter">
	<jsp:include page="../../../WEB-INF/inc/footer.jsp" ></jsp:include>
</div>
</html>