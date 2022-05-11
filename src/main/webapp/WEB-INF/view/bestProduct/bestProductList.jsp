<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bestProductList</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Wish shop project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/responsive.css">
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
               <% String type = (String)request.getAttribute("type"); %>
               <div class="section_subtitle">목로주점</div>
                  <div class="section_title">인기순</div>
            </div>
         </div>
      </div>
      <div class="row products_container">
         <!-- Product -->
               <%
                  List<Map<String,Object>> list = (List<Map<String,Object>>)request.getAttribute("list");
                  for(Map m : list){
               %>
         <div class="col-lg-4 product_col">

         <div class="product">

               <div class="product_image">
               <a href="${pageContext.request.contextPath}/bestProductListController?productNo=<%=m.get("productNo")%>">
                  <img src="images/product_1.jpg" alt="">
                  </a>
               </div>
               <div class="product_content clearfix">
                  <div class="product_info">
                     <div class="product_name"><a href="#"><%=m.get("name")%> <%=m.get("volume")%>ml <%=m.get("alcoholLevel")%>도</a></div>
                     <div class="product_price"><%=m.get("price")%>원</div>
                  </div>
                  <div class="product_options">
                     <div class="product_buy product_option"><img src="images/shopping-bag-white.svg" alt=""></div>
                     <div class="product_fav product_option">+</div>
                  </div>
               </div>

            </div>

         </div>
         <%
         	}
         %>
      </div>
   </div>
   </div>
</body>
</html>