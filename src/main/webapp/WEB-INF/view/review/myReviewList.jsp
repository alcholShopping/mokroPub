<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
						<div class="section_title">MY REVIEW</div>
					</div>
					<br>
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
							<c:forEach var="star" begin="1" end="${item.star}">
							<img src="./images/star.svg" width="10">
							</c:forEach>
							</td>
							
							<td>
								${item.name}
							</td>
							
							<td>
								${item.content}
							</td>
							
							<td>
								<img src="./images/${item.picture}" width="200" height="200">
							</td>
																			
							<td>
								<A href="reviewDeleteController?reviewNo=${item.reviewNo}">삭제</A>
								<A href="reviewUpdateController?reviewNo=${item.reviewNo}">수정</A>
							</td>

						
						</tr>					
					</c:forEach>

				</table>  
				<div class="pagebutton text-center">
						<!-- 이전 버튼 -->
						<c:if test="${currentPage > 1}">
							<a href="${pageContext.request.contextPath}/myReviewListController?currentPage=${currentPage-1}" class="btn btn-link">이전</a>
						</c:if>
					
						<!-- 다음 버튼 -->
						<c:if test="${currentPage < lastPage}">
							<a href="${pageContext.request.contextPath}/myReviewListController?currentPage=${currentPage+1}" class="btn btn-link">다음</a>
						</c:if>
				</div>
			</div>  
	</div>
</div>
	<!-- Footer -->	
	<jsp:include page="../../../WEB-INF/inc/footer.jsp"></jsp:include>
</div>
</body>

</html>