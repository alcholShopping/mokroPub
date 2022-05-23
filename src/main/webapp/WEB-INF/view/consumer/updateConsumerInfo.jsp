<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>consumerOne</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>
	<div class="super_container">
		<!-- Header -->
		<jsp:include page="../../../WEB-INF/inc/navBar.jsp"></jsp:include>
	
		<!-- content -->
		<div class="register">
			<div class="gallery">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="register_title ">				
							<h1>${sessionMemberId}님의 회원정보</h1>
							<form action="${pageContext.request.contextPath}/updateConsumerInfoController" method="post" name="updateForm">
								<table class = "table text-center">
								<!-- consumer_id, password, name, phone, email, address, Detailed_Addreess, Account, UPDATE_DATE -->
									<tr>
										<th>주소 검색 <br><br><br> 주소 등록 <br><br><br>상세주소</th> <!-- 주소 검색 -->
										<th>
											<div class="input-group mb-3">
												<input type="text" class="form-control"
													placeholder="소하동 32번지" name="address" id="address">
												<button type="submit" onclick="javascript: form.action='updateConsumerFindAddressController';">검색하기</button>
											</div>										
											<div>
												<select name="addressResult" class="form-control">
													<option value="" >::: 주소 선택 :::</option>
													<c:forEach var="m" items="${searchList}">
														<option value="${m.searchAddr} ${m.zipcode}">${m.searchAddr} ${m.zipcode}</option>
													</c:forEach>
												</select>
											</div>												
											<br>
											<div>
											<input type="text" class="form-control"
											placeholder="302호" name="detailedAddress" id="detailedAddress">
											<span id="detailedAddressHelper" class="helper"></span>
											</div>
										</th>
									</tr>
									<tr>
										<th>회원 아이디</th>
										<th>
											<input type="text" class="form-control" value ="${consumerList[0].consumerId}" name="consumerId" id="consumerId" readonly="readonly">
										</th>
									</tr>
									<tr>
										<th>회원 이름</th>
										<th>
											<input type="text" class="form-control" value ="${consumerList[0].name}" name="consumerName" id="consumerName">
											<span id="nameHelper" class="helper"></span>
										</th>
									</tr>
									<tr>
										<th>회원 전화번호</th>
										<th>
											<input type="text" class="form-control" value ="${consumerList[0].phone}" name="consumerPhone" id="consumerPhone">
											<span id="phoneHelper" class="helper"></span>
										</th>
									</tr>
									<tr>
										<th>회원 이메일</th>
										<th>
											<input type="text" class="form-control" value ="${consumerList[0].email}" name="consumerEmail" id="consumerEmail">
											<span id="emailHelper" class="helper"></span>
										</th>
									</tr>					
									<tr>
										<th>회원 계좌</th>
										<th>
											<input type="text" class="form-control" value ="${consumerList[0].account}" name="consumerAccount" id="consumerAccount">
											<span id="accountNumberHelper" class="helper"></span>
										</th>
									</tr>
									<tr>
										<th>회원 수정 날짜</th>
										<th>
											<input type="text" class="form-control" value ="${consumerList[0].updateDate}" name="consumerUpdateDate" id="consumerUpdateDate">
											<span id="accountNumberHelper" class="helper"></span>
										</th>
									</tr>
									<tr>
										<th colspan="2">
											<button type="button" class="btn btn-primary"  id="registerBtn" onclick="updateMemberCheck()">회원정보 수정</button>
										</th>
									</tr>
								</table>							
							</form>
							<a href="${pageContext.request.contextPath}/indexController">취소</a>								
							</div>
						</div>
					</div>
				</div>	
			</div>
		</div>
		
	</div>
</body>
	<script>
		$(".actionHover").mouseover( function(){ 
			$(".submenu").stop().slideDown(500); 
			}) 
			
		$(".actionHover").mouseout(function(){
			$(".submenu").stop().slideUp(1000); 
		})

		$('#consumerName').blur(function() {
			if($('#consumerName').val() == '') {
				$('#nameHelper').text('이름을 입력해주세요');
				$('#consumerName').focus();
			}  else {
				$('#nameHelper').text('');
			}
		});
		
		$('#consumerPhone').blur(function() {
			if($('#consumerPhone').val().length != 13) {
				$('#phoneHelper').text('휴대전화를 입력해주세요');
				$('#consumerPhone').focus();
			} else {
				$('#phoneHelper').text('');

			}
		});
		
		$('#consumerEmail').blur(function() {
			if($('#consumerEmail').val().includes('@') == false) {
				$('#emailHelper').text('이메일을 입력해주세요');
				$('#consumerEmail').focus();
			} else {
				$('#emailHelper').text('');
			}
		});
		
		$('#consumerAccount').blur(function() {
			if($('#consumerAccount').val() == '') {
				$('#accountNumberHelper').text('계좌를 입력해주세요');
				$('#consumerAccount').focus();
			} else {
				$('#accountNumberHelper').text('');
			}
		});
		
		$('#registerBtn').on("click", function(){      
	         var u = updateForm;
	         u.action ='updateConsumerInfoController';

	         if(u.detailedAddress.value.trim() == ""){
	            alert('상세주소를 입력하세요');
	            u.detailedAddress.focus();
	            return;
	         }
	         if(u.consumerName.value.trim() == ""){ // 이름 빈칸 검사
	            alert('이름을 입력하세요');
	            u.consumerName.focus();
	            return;
	         }
	         if(u.consumerEmail.value.trim() == ""){ // 이메일 빈칸 검사
	            alert('이메일을 입력하세요');
	            u.consumerEmail.focus();
	            return;
	         }
	         if(u.consumerPhone.value.trim() == ""){ // 전화번호 빈칸 검사
	            alert('전화번호를 입력하세요');
	            u.consumerPhone.focus();
	            return;
	         }
	         if(u.consumerAccount.value.trim() == ""){ // 계좌번호 빈칸 검사
	            alert('계좌번호를 입력하세요');
	            u.consumerAccount.focus();
	            return;
	         }
	         u.submit();   
	      });
		
	</script>
</html>
