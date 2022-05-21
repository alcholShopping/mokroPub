<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>categoryProductList</title>
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
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="section_title_container text-center">
					<div class="section_subtitle">목로주점</div>
						<div class="section_title"> ${type} (${total})</div>
				</div>
			</div>
		</div>
		<div class="row products_container">
			<!-- Product -->
			<c:forEach items="${list}" var="p">
			<div class="col-lg-4 product_col">

			<div class="product">

					<div class="product_image">
						<a href="${pageContext.request.contextPath}/productOneController?productNo=${p.getProductNo()}">
							<img src="images/${p.picture}" alt="">
						</a>
					</div>
					<div class="product_content clearfix">
					
						<div class="product_info">
							<div class="product_name">
								<a href="${pageContext.request.contextPath}/productOneController?productNo=${p.getProductNo()}">
								${p.getName()} ${p.getVolume()}ml ${p.getAlcoholLevel()}도
								</a>
							</div>
							<div class="product_price">
								<a href="${pageContext.request.contextPath}/productOneController?productNo=${p.getProductNo()}">
								${p.getPrice()}원 
								</a>
							</div>
						</div>
						<div class="product_options cnt">
						<a href ="${pageContext.request.contextPath}/insertProductInCartController?productNo=${p.getProductNo()}">
							<div class="product_buy product_option">
							<img src="images/shopping-bag-white.svg" alt="">
							</div>
						</a>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
		<div class="pagebutton text-center">
			<!-- 이전 버튼 -->
			<c:if test="${currentPage > 1}">
				<a href="${pageContext.request.contextPath}/categoryProductListController?currentPage=${currentPage-1}&categoryNo=${categoryNo}" class="btn btn-link">이전</a>
			</c:if>

			<!-- 다음 버튼 -->
			<c:if test="${currentPage < lastPage}">
				<a href="${pageContext.request.contextPath}/categoryProductListController?currentPage=${currentPage+1}&categoryNo=${categoryNo}" class="btn btn-link">다음</a>
			</c:if>
		</div>
	<c:if test="${fn:length(list) > 3}">
	</div>
			<!-- Footer -->	
			<jsp:include page="../../../WEB-INF/inc/footer.jsp"></jsp:include>
	</c:if>
	
	<c:if test="${fn:length(list) < 4}">
		</div>
		<!-- Footer -->
		<div class ="fixFooter">
			<jsp:include page="../../../WEB-INF/inc/footer.jsp" ></jsp:include>
		</div>
	</c:if>
</body>
<script>

</script>
</html>
