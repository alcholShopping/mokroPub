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
	<div class="container">		
      <div class="row">
         <div class="col">
			<div class="section_title_container text-center">
				<div class="section_subtitle">목로주점</div>
				<div class="section_title">공지사항</div>
			</div>
	            	<c:forEach var="m" items="${noticeOneList}">
		            	<table class ="table table-boedered">
			            	<tr>
				            	<td class="text-left">No.${m.noticeNo} </td>
				            	<td class="text-left">${m.title}</td>
				            	<td class="text-right">${m.createDate}</td>
			            	</tr>
			            	<tr>
				            	<td>작성자</td>
				            	<td>${m.consumerId}</td>
				            	<td><div class="adminBtn text-right" style="display:none"><a href="${pageContext.request.contextPath}/updateNoticeController?noticeNo=${m.noticeNo}" class="btn btn-outline-secondary btn-sm">수정하기</a></div>
				            	</td>
			            	</tr>
			            	<tr>
				            	<td colspan="3">
				            		${m.content}
				            	</td>
			            	</tr>
		            	</table>			
					<!-- 아이디가 admin인 경우만 보이게 해야함 -->					
					<div class="adminBtn" style="display:none"><a href="${pageContext.request.contextPath}/deleteNoticeController?noticeNo=${m.noticeNo}" class="btn btn-outline-secondary btn-sm">삭제</a></div>
					<div><a href="${pageContext.request.contextPath}/noticeListController">목록</a></div>
					</c:forEach>
				</div>		
			</div>
		</div>
	</div>
	<div class ="fixFooter">
	<!-- Footer -->	
	<jsp:include page="../../../../WEB-INF/inc/footer.jsp"></jsp:include>
</div>
</body>
<script>
	if('${sessionScope.sessionMemberId}' == 'admin'){
		console.log('admind입니다..');
		$(".adminBtn").show();	
	} 
</script>
</html>