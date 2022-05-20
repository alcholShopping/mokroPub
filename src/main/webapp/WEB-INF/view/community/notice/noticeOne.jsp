<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeOne</title>
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
</head>
<body>
	<div class="super_container">
		<!-- Header -->
		<jsp:include page="../../../../WEB-INF/inc/navBar.jsp"></jsp:include>
		
		<!-- contents -->
		<div class="nullbox">
		</div>
		<!-- Product -->
		<div class="product">
			<div class="container">
				<div class="row product_row">
	
	            	<c:forEach var="m" items="${noticeOneList}">
	            	
					<!-- notice Image -->
					<div class="col-lg-7">
						<div class="product_image">
							<div class="product_image_large"><img src="images/${m.photo}" alt=""></div>
							<div class="product_image_thumbnails d-flex flex-row align-items-start justify-content-start">
							</div>
						</div>
					</div>
	
					<!-- Product Content -->
					<div class="col-lg-5">
						<div class="product_content">
							<div>${m.noticeNo}번</div>
							<div>작성자 : ${m.consumerId}</div>
							<div>제목 : ${m.title}</div>
							<div>작성날짜 : ${m.createDate}</div>
							<br>
						</div>
					</div>				
					<!-- content -->
					<div>
						<p>${m.content}</p>
					</div>
					<!-- 아이디가 admin인 경우만 보이게 해야함 -->
					<div id="adminBtn" style="display:none"><a href="${pageContext.request.contextPath}/updateNoticeController?noticeNo=${m.noticeNo}">수정하기</a></div>
					<div id="adminBtn" style="display:none"><a href="${pageContext.request.contextPath}/deleteNoticeController?noticeNo=${m.noticeNo}">삭제</a></div>
					</c:forEach>
				</div>		
			</div>
		</div>
	</div>
</body>
<script>
	if(!${sessionScope.sessionMemberId}.equals('admin')){
		console.log('admin이 아닙니다.');
		$("#adminBtn").hide();	
	} 
</script>
</html>