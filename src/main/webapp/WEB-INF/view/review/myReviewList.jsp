<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cartList</title>
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
	<jsp:include page="../../../WEB-INF/inc/navBar.jsp"></jsp:include>
	<!-- contents -->
	<div class="nullbox">
	</div>
	
	<!--  구현영역  -->
	<div class="container">
	<div class="row">
				<div class="col">
					<div class="section_title_container text-center">
						<div class="section_subtitle">목로주점</div>
						<div class="section_title">내가 쓴 리뷰</div>
					</div>
				</div>
			</div>
      <div class="row">
         <div class="col">
					<table class ="table table-bordered">
					<c:forEach items="${myReviewList}" var="item">					
						<tr>
		                     <td>리뷰번호</td>
		                     <td>별점</td>
		                     <td>상품정보</td>
		                     <td>리뷰내용</td>	                    
		                     <td>사진</td>                    
	                  	</tr>
	                  	
						<tr>

							<td>
								${item.reviewNo}
							</td>
								
							<td>
								${item.star}/5
							</td>
							
							<td>
								${item.name}
							</td>
							
							<td>
								${item.content}
							</td>
							
							<td>
								${item.picture}
							</td>
																			
							<td>
								<A href="reviewDeleteController?reviewNo=${item.reviewNo}">삭제</A>
								<A href="reviewUpdateController?reviewNo=${item.reviewNo}">수정</A>
							</td>

						
						</tr>					
					</c:forEach>
				</table>  
			</div>  
	</div>
</div>
	<!-- Footer -->	
	<jsp:include page="../../../WEB-INF/inc/footer.jsp"></jsp:include>
</div>
</body>

</html>