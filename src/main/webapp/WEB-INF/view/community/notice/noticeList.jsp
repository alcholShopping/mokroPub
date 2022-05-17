<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeList</title>
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
		<div class="nullbox">
		</div>	
		<!-- contents -->
		<div class="container">		
	      <div class="row">
	         <div class="col">
	         <div class="float-right">         
			</div>			
			<h2>공지사항</h2>
				<table class ="table table-bordered">
					<thaed>
						<th>번호</th>
						<th>글쓴이</th>
						<th>제목</th>
						<th>날짜</th>
					</thaed>
					<c:forEach items="${noticeList}" var="item">
					<tbody>
						<tr>
							<td><a href="${pageContext.request.contextPath}/noticeOneController?noticeNo=${item.noticeNo}">${item.noticeNo}</a></td>
							<td><a href="${pageContext.request.contextPath}/noticeOneController?noticeNo=${item.noticeNo}">${item.consumerId}</a></td>
							<td><a href="${pageContext.request.contextPath}/noticeOneController?noticeNo=${item.noticeNo}">${item.title}</a></td>
							<td><a href="${pageContext.request.contextPath}/noticeOneController?noticeNo=${item.noticeNo}">${item.createDate}</a></td>
						</tr>
					</tbody>
					</c:forEach>					  	
					</table>
						<c:if test="${currentPage > 1}">
							<a href="${pageContext.request.contextPath}/noticeListController?currentPage=${currentPage-1}" >이전</a>
						</c:if>
						<!-- 다음 버튼 -->
						<c:if test="${currentPage < lastPage}">
							<a href="${pageContext.request.contextPath}/noticeListController?currentPage=${currentPage+1}">다음</a>
						</c:if>
					<!-- 아이디가 admin인 경우만 보이게 해야함 -->
					<div></div>
					<a href="${pageContext.request.contextPath}/insertNoticeController" id="insertNoticeBtn">글쓰기</a>
				</div>  
			</div>	
		</div>
		<!-- Footer -->	
		<jsp:include page="../../../../WEB-INF/inc/footer.jsp"></jsp:include>
	</div>
</body>
</html>