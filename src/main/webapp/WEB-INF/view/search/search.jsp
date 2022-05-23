<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
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
   <jsp:include page="/WEB-INF/inc/navBar.jsp"></jsp:include>
   <!-- contents -->
   <div class="nullbox">
   </div>

   <div class="container">
      <div class="row">
         <div class="col">
            <div class="section_title_container text-center">
               <div class="section_subtitle">
               목로주점
               </div>
               <div class="section_title">
               상세검색
               </div>
                  <form  method="post" action="${pageContext.request.contextPath}/searchController">
                     <table class="table">
                        <tr>
                           <td>텍스트 검색</td>
                           <td class="text-left">
                           <input type="text" class="form-control" placeholder="원하는 상품을 검색해보세요" name="name" value="">
                           </td>
                        </tr>
                        
                        <tr>
                           <td>가격</td>
                           <td class="text-left">
                           <input type="number" placeholder="0원" value="0" name="priceBefore">원 ~ 
                           <input type="number" placeholder="999999원" value="999999" name="priceAfter">원
                           </td>
                        </tr>

                        <tr>
                           <td>용량</td>
                           <td class="text-left">
                           <input type="number" placeholder="0ml" value="0" name="volumeBefore">ml ~ 
                           <input type="number" placeholder="99999ml" value="99999" name="volumeAfter">ml

                           </td>
                        </tr>
                        <tr>
                           <td>색상</td>

                           <td class="text-left">
                              <label><input type="radio" name="color" value="" checked="checked">전체</label>
                              <label><input type="radio" name="color" value="하양">투명 혹은 흰색</label>
                                 <label><input type="radio" name="color" value="빨강">빨강</label>
                                 <label><input type="radio" name="color" value="주황">주황</label>
                                 <label><input type="radio" name="color" value="노랑">노랑</label>
                                 <label><input type="radio" name="color" value="초록">초록</label>
                                 <label><input type="radio" name="color" value="파랑">파랑</label>
                                 <label><input type="radio" name="color" value="남색">남색</label>
                                 <label><input type="radio" name="color" value="보라">보라</label>
                                 <label><input type="radio" name="color" value="갈색">갈색</label>
                                 <label><input type="radio" name="color" value="검정">검정</label>
                           </td>
                        </tr>
                        <tr>
                           <td>도수</td>
                           <td class="text-left">
                           <input type="number" value="0" name="alcoholLevelBefore">도 ~ <input type="number"  value="100" name="alcoholLevelAfter">도
                           </td>
                        </tr>
                        
                        <tr>                              
                           <td>당도</td>
                           <td class="text-left">
                           <input type="number" value="0" name="sweetBefore">단계 ~ <input type="number" value="10" name="sweetAfter">단계
                           </td>
                        </tr>
                        <tr>
                           <td>숙성도</td>
                           <td class="text-left">
                           <input type="number" value="0" name="maturityBefore">단계 ~ <input type="number" value="10" name="maturityAfter">단계
                           </td>
                        </tr>
                        <tr>
                           <td>산미</td>
                           <td class="text-left">
                           <input type="number" value="0" name="acidityBefore">단계 ~ <input type="number" value="10" name="acidityAfter">단계
                           </td>
                        </tr>
                        <tr>
                           <td>바디감</td>
                           <td class="text-left">
                           <input type="number" value="0" name="thinBefore">단계 ~ <input type="number" value="10" name="thinAfter">단계
                           </td>
                        </tr>
                        <tr>
                           <td>청량감</td>
                           <td class="text-left">
                           <input type="number" value="0" name="refreshmentBefore">단계 ~ <input type="number" value="10" name="refreshmentAfter">단계
                           </td>
                        </tr>
                     </table>
                     <button type="submit" class="btn btn-primary">검색</button>
                  </form>
               </div>
      <div class="row products_container">
      <!--  검색결과 -->
      <c:forEach items="${searchResultList}" var="p">
      <div class="col-lg-4 product_col">

      <div class="product">

            <div class="product_image">
               <a href="${pageContext.request.contextPath}/productOneController?productNo=${p.productNo}">
                  <img src="images/${p.picture}" alt="">
               </a>
            </div>
            <div class="product_content clearfix">
            
               <div class="product_info">
                  <div class="product_name">
                     <a href="${pageContext.request.contextPath}/productOneController?productNo=${p.productNo}">
                     ${p.name} ${p.volume}ml ${p.alcoholLevel}도
                     </a>
                  </div>
                  <div class="product_price">
                     <a href="${pageContext.request.contextPath}/productOneController?productNo=${p.productNo}">
                     ${p.price}원 
                     </a>
                  </div>
               </div>
               <div class="product_options cnt">
               <a href ="${pageContext.request.contextPath}/insertProductInCartController?productNo=${p.productNo}">
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
            </div>
         </div>
      </div>
   <!-- Footer -->   
   <jsp:include page="/WEB-INF/inc/footer.jsp"></jsp:include>
</div>
</body>
</html>