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
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
</head>
<body>
<form method="post"  name="orderForm" action="${pageContext.request.contextPath}/orderCompleteController">
<div class="super_container">
   <!-- Header -->
   <jsp:include page="../../../WEB-INF/inc/navBar.jsp"></jsp:include>
   <!-- contents -->
   <div class="nullbox">
   </div>
   
<div class="payBar">
   <table>
      <tr>
         <td class="table_td">총 상품 금액</td>
         <td rowspan="2" class="table_td">-</td>
         <td class="table_td">할인률</td>
         <td rowspan="2" class="table_td">=</td>
         <td class="table_td">실제 구매 금액</td>
         <td rowspan="2">
            <button type="button" onclick="orderBtn()" class="btn btn-primary">주문하기</button>
         </td>
         </tr>
         <tr>
         <td class="table_td_price"><span id="totalPriceWon"></span></td>
         <td class="table_td_price"><span id="discountWon"></span></td>
         <td class="table_td_price_fix"><span id="paymentWon"></span></td>
      </tr>
   </table>
   <input type="hidden" value="${item.cartNo}" name="cartNo" >
   <input type="hidden" value="${item.productNo}" name="productNo">
   <input type="hidden" id="realpayment" name="realpayment">
   <input type="hidden" id="count" name="count">
   <!--  정보 다 나오고 주문 버튼 -->
   
</div>
   <!--  장바구니 내역 -->
   <div class="container">
      <div class="row">
         <div class="col">
         <div class="section_title_container text-center">
               <div class="section_subtitle">목로주점</div>
                  <div class="section_title">주문창</div>
            </div>
            <h3>상품정보</h3>
            <table class ="table">
               <c:forEach items="${cartList}" var="item">
                  <tr>
                     <td>
                        <img src="images/${item.picture}" width="100px">
                     </td>
                     <td>
                        <div class="product_name"><b>${item.name}</b></div>
                     </td>
                     <td>
						총 ${item.count} 개
                        </td>
                     <td class="text-right">
                        <div class="product_name"><b>${item.price}</b>원</div>
                     </td>
                  </tr>
               </c:forEach>
            <tr>
               <td colspan="2">
               <span class="text-left"><h4>주문 수량 - ${cartCount}개 </h4></span>
               </td>
               <td colspan="2"> 
               <span class="text-right"><h4>총 금액  ₩ ${totalPrice} 원 </h4></span>
               </td>
            </tr>
            </table>   
            <br>
      <!-- 회원정보 내역 -->
      <h3>주문자정보</h3>
         <table class ="table">
         <!-- 주소 검색 -->
         <tr>
            <th width="200px" class="text-center">주소 검색</th> 
            <td>
                  <div class="input-group mb-3">
                     <input type="text" class="form-control"
                        placeholder="주소 변경을 원하시면 검색해주세요" name="address" id="address">
                     <button onclick="javascript: form.action='orderFindAddressController';">검색하기</button>
                  </div>  
            </td> 
           </tr>
           <tr> 
           <th width="200px" class="text-center">주소 등록</th>  
           <td>                    
               <select name="addressResult" class="form-control">
                  <option value="${consumerList[0].address}" >${consumerList[0].address}</option>
                  <c:forEach var="m" items="${searchList}">
                     <option value="${m.searchAddr} ${m.zipcode}">${m.searchAddr} ${m.zipcode}</option>
                  </c:forEach>
               </select>       
           </td>
           </tr>
           <tr>
           <th width="200px" class="text-center">상세주소</th>
           <td>
               <input type="text" class="form-control"
               value="${consumerList[0].detailedAddr}" name="detailedAddress" id="detailedAddress">
               <span id="detailedAddressHelper" class="helper"></span>
         </td>
         </tr>
            <tr>
              <th width="200px" class="text-center">수취인</th>
               <td>
               <input type="text" id="name" name ="name" value="${consumerList[0].name}" class="form-control">
               <span id="nameHelper" class="helper"></span>
               </td>
            </tr>
            <tr>
               <th width="200px" class="text-center">연락처</th>
               <td>
               <input type="text" id="phone" name="phone" value="${consumerList[0].phone}" class="form-control">
               <span id="phoneHelper" class="helper"></span>
               </td>
            </tr>
            <tr>
               <th width="200px" class="text-center">이메일</th>
               <td>
               <input type="text" id="email" name="email" value="${consumerList[0].email}" class="form-control">
               <span id="emailHelper" class="helper">&nbsp; </span>
               </td>
            </tr>
        </table>
        <br><br>
        
     	<!-- 결제방법 -->
        <h3>결제방법</h3>
     	  <table class ="table">
            <tr>
               <th width="200px" class="text-center">결제방법</th>
               <td>
                  <input type="radio" value="" id="method" class="method" name="method" class="form-control">무통장입금
               </td>
                 <td>
                   <span id="methodHelper" class="helper"></span>
               </td>
            </tr>
        </table>
        <br><br>
        
        <h3>쿠폰선택</h3>
            <table class ="table">
               <tr>
                  <th width="200px" class="text-center">쿠폰목록</th>
                  <td>
                     <select name="selectCoupon" id="selectCoupon" class="form-control">
                        <option value="0" selected>:::쿠폰 선택 :::</option>   
                        <c:forEach var="c" items="${couponList}">
                           <option value="${c.discount}" value="${c.couponNo}">
                           ${c.discount}% 할인쿠폰 ${c.count}개 유효기간:${c.validity}까지</option>
                        </c:forEach>
                     </select>
                  </td>
               </tr>
            </table>
            <br><br>
         </div>
      </div>  
   </div>
   <!-- Footer -->   
   <jsp:include page="../../../WEB-INF/inc/footer.jsp"></jsp:include>
</div>
</form>
</body>
<script>
   // 최종 결제 금액 창 화면에 필요한 코드
   
   // 쿠폰 선택 되기 전에는 쿠폰 값 0
   let totalPrice = ${totalPrice}; // 총상품 금액
   let discount = 0; // 쿠폰 할인 금액
   let payment = totalPrice; // 실제 구매 금액 

   console.log(totalPrice + "totalPrice");
   $('#totalPriceWon').text(totalPrice+'원');
   $('#discountWon').text(discount+'%');
   $('#paymentWon').text(payment+'원');
   $('#realpayment').val(discount);
   
   // 쿠폰이 선택 되면 쿠폰 값 적용
   $("select[name=selectCoupon]").change(function(){
	   discount =  $(this).val() // 선택된 값 바로 가져오기
	   console.log(discount + "discount"); //value값 가져오기
	   payment =  totalPrice-(totalPrice * (discount/100)); // 총 상품 금액 - 쿠폰 할인 금액
	   console.log(payment + "실제 결제 금액");
	   $('#totalPriceWon').text(totalPrice+'원');
	   $('#discountWon').text(discount+'%');
	   $('#paymentWon').text(payment+'원');
	   $('#realpayment').val(discount);
	   
	   //실제 지불금액이 마이너스면 쿠폰 선택 취소
	   if(payment < 10000){
		   alert("실제 결제 금액이 10000원 미만은 쿠폰을 사용할 수 없습니다.");
		   $("#selectCoupon option:eq(0)").prop("selected", true);
		   totalPrice = ${totalPrice}; // 총상품 금액
		   discount = 0; // 쿠폰 할인 금액
		   payment = totalPrice; // 실제 구매 금액 
		   $('#totalPriceWon').text(totalPrice+'원');
		   $('#discountWon').text(discount+'%');
		   $('#paymentWon').text(payment+'원');
		   $('#realpayment').val(discount);
	   }
   });
   
   
   
   //상세주소 유효성 검사
   $('#detailedAddress').blur(function() {
      if($('#detailedAddress').val().length == 0) {
         $('#detailedAddressHelper').text('상세주소를  입력해주세요');
         $('#detailedAddress').focus();
      } else {
         $('#detailedAddressHelper').text('');

      }
   });
   //수취인 유효성 검사
   $('#name').blur(function() {
      if($('#name').val().length == 0) {
         $('#nameHelper').text('이름을 입력해주세요');
         $('#name').focus();
      } else {
         $('#nameHelper').text('');
      }
   });
   //이메일 유효성 검사
   $('#email').blur(function() {
      if($('#email').val().includes('@') == false) {
         $('#emailHelper').text('이메일을 입력해주세요');
         $('#email').focus();
      } else {
         $('#emailHelper').text('');
      }
   });
   
   // 11자리를 입력해야함 하이픈 포함
   $('#phone').blur(function() {
      if($('#phone').val().length != 13) {
         $('#phoneHelper').text('휴대전화를 입력해주세요');
         $('#phone').focus();
      } else {
         $('#phoneHelper').text('');

      }
   });   
   //결제방법을 선택 후 쿠폰 선택
   $('#selectCoupon').click(function() {
      if($('.method:checked').length == 0){
         $('#methodHelper').text('결제 방법을 선택해주세요');
         alert("결제 방법을 선택해주세요");
         $('.method').focus();
      } else {
         $('#methodHelper').text('');
         
      }
   });
	function orderBtn(){
		var r = orderForm;
		r.action ='orderCompleteController'
		   if($('#detailedAddress').val().length == 0) {
	         $('#detailedAddressHelper').text('상세주소를  입력해주세요');
	         $('#detailedAddress').focus();
	         
	      } else {
	         $('#detailedAddressHelper').text('');

	      }
	      if($('#name').val().length == 0) {
	          $('#nameHelper').text('이름을 입력해주세요');
	          $('#name').focus();
	          return;
	       } else {
	          $('#nameHelper').text('');
	       }
	      if($('#phone').val().length != 13) {
	          $('#phoneHelper').text('휴대전화를 입력해주세요');
	          $('#phone').focus();
	          return;
	       } else {
	          $('#phoneHelper').text('');

	       }
	      if($('.method:checked').length == 0){
	          $('#methodHelper').text('결제 방법을 선택해주세요');
	          alert("결제 방법을 선택해주세요");
	          $('.method').focus();
	          return;
	       } else {
	          $('#methodHelper').text('');
	          
	          
	       }
	      r.submit();
	   };
</script>
</html>