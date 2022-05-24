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
                  <div class="section_title">제품 리뷰</div>
                  <div class=text-left>
                     <a href="${pageContext.request.contextPath}/productOneController?productNo=${productNo}">상품상세보기</a>
                  </div> 
               </div>
            </div>
         </div>
        <div class="row">
         <div class="col">
               <table class ="table">
                  <tr>
                           <th width="150px">작성자</th>
                           <th colspan="2">내용</th>                       
                           <th width="100px">별점</th>
                           <th width="200px">작성일</th>                    
                        </tr>
                  <c:forEach items="${reviewList}" var="item">                                    
                  <tr>

                     <td>
                        ${item.name}
                     </td>
                        
                     <td>
                        ${item.content}
                     </td>
                     <td>                           
                        <c:if test="${item.picture != 'fileX.jpg'}">
                                   <img src="./images/${item.picture}" width="150px">
                                 </c:if>
                     </td>
                     
                     <td>
                     <c:forEach var="star" begin="1" end="${item.star}">
                     <img src="./images/star.svg" width="10">
                     </c:forEach>
                     </td>
                     
                     <td>
                        ${item.createDate}
                     </td>
                  
                  </tr>               
               </c:forEach>
            </table>  
         </div>  
   </div>
</div>
   </div>
</div>
   <!-- Footer -->   
   <jsp:include page="../../../WEB-INF/inc/footer.jsp"></jsp:include>
</div>
</body>

</html>