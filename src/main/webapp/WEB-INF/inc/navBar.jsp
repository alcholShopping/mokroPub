<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
						<img src="${pageContext.request.contextPath}/images/magnifying-glass.svg"alt="">
					</button>
				</form>
			</div>
			<!-- Cart -->
			<div class="shopping">
				<a href="${pageContext.request.contextPath}/cartController">
					<div class="cart">
						<img
							src="${pageContext.request.contextPath}/images/shopping-bag.svg"alt="">
						<div class="cart_num_container">
							<div class="cart_num_inner">
								<div class="cart_num">${cartCount}</div>
							</div>
						</div>
					</div>
				</a>

				<!-- Avatar -->
				<a href="#">
					<div class="avatar">
						<img src="${pageContext.request.contextPath}/images/avatar.svg" alt="">
					</div>
				</a>
				<span class="login">
					<c:if test="${sessionMemberId != null}">
						${sessionMemberId}님 &nbsp;
						<a href="LogoutController" class="btn btn-outline-secondary">로그아웃</a>
					</c:if>
					<c:if test="${sessionMemberId == null}">
						<a href="LoginController" class="btn btn-outline-secondary">로그인</a>
					</c:if>
				</span>
			</div>
		</div>
	</div>
	<script>
		$(".actionHover").mouseover( function(){ 
			$(".submenu").stop().slideDown(500); 
			}) 
		$(".actionHover").mouseout(function(){
			$(".submenu").stop().slideUp(1000); 
		})
	</script>
</header>