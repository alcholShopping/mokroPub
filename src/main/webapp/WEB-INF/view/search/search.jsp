<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                           <td class="text-left" colspan="3">
                           <input type="text" class="form-control" placeholder="원하는 상품을 검색해보세요" name="name" value="">
                           </td>
                        </tr>
                        
                        <tr>
                           <td>가격</td>
                           <td class="text-left">
                           <input type="number" placeholder="0원" value="0" name="priceBefore" min="0" max="999999">원 ~ 
                           <input type="number" placeholder="999999원" value="999999" name="priceAfter" min="0" max="999999">원
                           </td>
                           <td>용량</td>
                           <td class="text-left">
                           <input type="number" placeholder="0ml" value="0" name="volumeBefore" min="0" max="99999">ml ~ 
                           <input type="number" placeholder="99999ml" value="99999" name="volumeAfter" min="0" max="99999">ml

                           </td>
                        </tr>
                        <tr>
                           <td>도수</td>
                           <td class="text-left">
                           <input type="number" value="0" name="alcoholLevelBefore" min="0" max="100">도 ~ <input type="number"  value="100" name="alcoholLevelAfter" min="0" max="100">도
                           </td>                            
                           <td>당도</td>
                           <td class="text-left">
                           <input type="number" value="0" name="sweetBefore" min="0" max="10">단계 ~ <input type="number" value="10" name="sweetAfter" min="0" max="10">단계
                           </td>
                        </tr>
                        <tr>
                           <td>숙성도</td>
                           <td class="text-left">
                           <input type="number" value="0" name="maturityBefore" min="0" max="10">단계 ~ <input type="number" value="10" name="maturityAfter" min="0" max="10">단계
                           </td>
                           <td>산미</td>
                           <td class="text-left">
                           <input type="number" value="0" name="acidityBefore" min="0" max="10">단계 ~ <input type="number" value="10" name="acidityAfter" min="0" max="10">단계
                           </td>
                        </tr>
                        <tr>
                           <td>바디감</td>
                           <td class="text-left">
                           <input type="number" value="0" name="thinBefore" min="0" max="10">단계 ~ <input type="number" value="10" name="thinAfter" min="0" max="10">단계
                           </td>
                           <td>청량감</td>
                           <td class="text-left">
                           <input type="number" value="0" name="refreshmentBefore" min="0" max="10">단계 ~ <input type="number" value="10" name="refreshmentAfter" min="0" max="10">단계
                           </td>
                        </tr>
                        <tr>
                           <td>색상</td>

                           <td class="text-left" colspan="4">
                              <label><input type="radio" name="color" value="" checked="checked">전체</label> &nbsp; &nbsp;
                              <label><input type="radio" name="color" value="투명">투명</label> &nbsp; &nbsp;
                              <label><input type="radio" name="color" value="흰색">흰색</label> &nbsp; &nbsp;
                                 <label><input type="radio" name="color" value="빨강">빨강</label>&nbsp; &nbsp;
                                 <label><input type="radio" name="color" value="주황">주황</label>&nbsp; &nbsp;
                                 <label><input type="radio" name="color" value="노랑">노랑</label>&nbsp; &nbsp;
                                 <label><input type="radio" name="color" value="초록">초록</label>&nbsp; &nbsp;
                                 <label><input type="radio" name="color" value="파랑">파랑</label>&nbsp; &nbsp;
                                 <label><input type="radio" name="color" value="남색">남색</label>&nbsp; &nbsp;
                                 <label><input type="radio" name="color" value="보라">보라</label>&nbsp; &nbsp;
                                 <label><input type="radio" name="color" value="검정">검정</label>&nbsp; &nbsp;
                                 <label><input type="radio" name="color" value="갈색">갈색</label>
                        </tr>
                     </table>
                     <button type="submit" class="btn btn-primary">검색</button>
                  </form>
               </div>
      <div class="row products_container">
      <!--  검색결과 -->
      <c:if test="${fn:length(searchResultList) < 1}">
      <div class="page_msg text-center">
      검색 결과가 없습니다.<br>
      다른 옵션으로 검색해주세요.
      </div>
      </c:if>
      <c:if test="${fn:length(searchResultList) != null}">
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
       </c:if>
   </div>
            </div>
         </div>
	<c:if test="${fn:length(searchResultList) > 3}">
	</div>
			<!-- Footer -->	
			<jsp:include page="../../../WEB-INF/inc/footer.jsp"></jsp:include>
	</c:if>
	
	<c:if test="${fn:length(searchResultList) < 4}">
		</div>
		<!-- Footer -->
		<div class ="fixFooter">
			<jsp:include page="../../../WEB-INF/inc/footer.jsp" ></jsp:include>
		</div>
	</c:if>
</body>
</html>