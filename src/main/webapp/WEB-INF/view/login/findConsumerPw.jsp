<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findConsumerPassword</title>
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
					Find Password
					</div>
					<br>
					<div class="row">
					<div class="col-sm-3">
					</div>
					<div class="col-sm-6">
					<div class="errorText">${errorText}</div> 
					<form action="${pageContext.request.contextPath}/findConsumerPwController" method="post">
						<table class = "table text-center ">
							<tr>
								<th>아이디</th>
								<th>
									<input type="text" class="form-control" name="consumerId" id="consumerId">
								</th>
							</tr>
							<tr>
								<th>이름</th>
								<th>
									<input type="text" class="form-control" name="consumerName" id="consumerName">
								</th>
							</tr>
							<tr>
								<th>연락처</th>
								<th>
									<input type="text" class="form-control" name="phone" id="phone" placeholder="010-0000-0000">
								</th>
							</tr>	
							<tr>
								<td colspan="2">
								<button type="submit" class="btn btn-info text-White btn-block" id="registerBtn">
								비밀번호 변경</button>
								</td>
							</tr>								
						</table>
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
</body>
</html>
<script>
	if()
</script>