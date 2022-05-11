<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bestProductList</title>
</head>
<body>
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
</body>
</html>