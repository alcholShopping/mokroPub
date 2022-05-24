<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>consumerOneInfo</title>
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
					<div class="section_subtitle">목로주점</div>
						<div class="section_title">${sessionMemberId}님 회원정보</div>
						<br>
						<table class="table">
							<tr>
								<td>아이디</td>
								<td>${consumerList[0].consumerId}</td>
							</tr>
							<tr>
								<td>이름</td>
								<td>${consumerList[0].name}</td>
							</tr>
							<tr>
								<td>연락처</td>
								<td>${consumerList[0].phone}</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td>${consumerList[0].email}</td>
							</tr>
							<tr>
								<td>주소</td>
								<td>${consumerList[0].address}</td>
							</tr>
							<tr>
								<td>상세주소</td>
								<td>${consumerList[0].detailedAddr}</td>
							</tr>
							<tr>
								<td>등급</td>
								<td>${consumerLevelText}</td>
							</tr>
							<tr>
								<td>계좌</td>
								<td>${consumerList[0].account}</td>
							</tr>
						</table>
					<a href="${pageContext.request.contextPath}/consumerOneController">나의 정보</a>
					<a href="${pageContext.request.contextPath}/checkConsumerPwController">수정하기</a>
					<a href="${pageContext.request.contextPath}/deleteCheckConsumerController">탈퇴하기</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Footer -->
<div class ="fixFooter">
	<jsp:include page="../../../WEB-INF/inc/footer.jsp" ></jsp:include>
</div>
</body>
</html>