<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
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
<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
</head>
<body>
<div class="super_container">
	<!-- Header -->	
	<jsp:include page="/WEB-INF/inc/navBar.jsp"></jsp:include>
	<!-- contents -->
	<div class="nullbox">
	</div>
	<!-- contents -->
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="section_title_container text-center">
					<div class="section_subtitle">
					목로주점
					</div>
					<div class="section_title">
					Sign Up
					</div>
					<br>
					<div class="row">
					<div class="col-sm-1">
					</div>
					<div class="col-sm-10">
						<form action="registerController" method="post" name="registerForm">
							<table class="table">
								<tr>
									<th>주소 검색 <br><br><br> 주소 등록 <br><br><br>상세주소</th> <!-- 주소 검색 -->
									<th>
										<div class="input-group mb-3">
											<input type="text" class="form-control"
												placeholder="소하동 32번지" name="address" id="address">
											<button type="submit" onclick="javascript: form.action='findAddressController';">검색하기</button>
										</div>										
										<div>
											<select name="addressResult" class="form-control">
												<option value="${addressResult}">
												
													<c:if test="${addressResult != '' || addressResult ne null}">
														${addressResult}
													</c:if>
													
													<c:if test="${addressResult} eq NULL">
														::: 주소검색 :::
													</c:if>
												</option>
												<c:forEach var="m" items="${searchList}">
													<option value="${m.searchAddr} ${m.zipcode}">${m.searchAddr} ${m.zipcode}</option>
												</c:forEach>
											</select>
										</div>												
										<br>
										<div>
											<input type="text" class="form-control" placeholder="302호" name="detailedAddress" id="detailedAddress" value="${detailedAddress}">
											<span id="detailedAddressHelper" class ="helper"></span>
										</div>
									</th>
								</tr>					
								<tr>
									<th>아이디</th>
									<th>
										<div class="input-group mb-3">
											<input type="text" class="form-control"
											placeholder="Enter ID" name="consumerId" id="id" value="${consumerId}">
											<button type="submit" onclick="javascript: form.action='confirmIdController';">ID중복확인</button>								
										</div>
										<span id="idHelper" class="helper" value="${cofirmResult}">${cofirmResult}</span>
										
									</th>
								</tr>
	
								<tr>
									<th>비밀번호</th>
									<th>
									<input type="password" class="form-control"
										placeholder="Enter password" name="consumerPw" id="pw">
									<span id="pwHelper" class="helper"></span>
									</th>
								</tr>
								<tr>
									<th>비밀번호 재입력</th>
									<th><input type="password" class="form-control"
										placeholder="Re password" name="consumerPwRe" id="pwConfirm">
										<span id="pwConfirmHelper" class="helper"></span></th>
								</tr>
								<tr>
									<th>이름</th>
									<th><input type="text" class="form-control"
										placeholder="Won Seoung Hyun" name="consumerName" id="name">
										<span id="nameHelper" class="helper"></span></th>
								</tr>
								<tr>
									<th>이메일</th>
									<th><input type="text" class="form-control"
										placeholder="abc_fox@naver.com" name="email" id="email">
										<span id="emailHelper" class="helper"></span></th>
								</tr>
								<tr>
									<th>전화번호(-를 포함하여 입력)</th>
									<th><input type="text" class="form-control"
										placeholder="010-4123-5342" name="phone" id="phone">
										<span id="phoneHelper" class="helper"></span></th>
								</tr>
								<tr>
									<th>주민등록번호</th>
									<th><input type="text" class="form-control"
										placeholder="980492-312423" name="residentNumber" id="residentNumber">
										<span id="residentNumberHelper" class="helper"></span></th>
								</tr>
								
									<!-- <th>태어난 연도</th>  -->
									<input type="hidden" class="form-control" 
										placeholder="1998" name="birthYear" id="birthYear" value="" readonly="readonly">
										<span id="birthYearHelper" class="helper"></span>
								
								<tr>
									<th>계좌번호</th>
									<th><input type="text" class="form-control"
										placeholder="NH농협 302-1302-1392-443" name="account" id="accountNumber">
										<span id="accountNumberHelper" class="helper"></span>
									</th>
								</tr>
								<tr>
									<th colspan="2">
										<button type="button" class="btn btn-primary" id="registerBtn" onclick="memberJoinCheck()">회원가입</button>
									</th>
								</tr>
							</table>
						</form>
						</div>
						<div class="col-sm-1">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<jsp:include page="../../../WEB-INF/inc/footer.jsp" ></jsp:include>
</div>
</body>
<script>


	if( ($('#idHelper').text()) == '중복입니다'){
		console.log( $('#idHelper').text() + "아이디 상태 확인");
		 alert('중복');
	}
	
	$('#id').blur(function(){
		if( ($('#id').val().length < 4) || ($('#id').val().length > 20) ) {
			console.log('아이디 갯수' + $('#id').val().length);
			$('#idHelper').text('id는 4글자 이상 20글자만 가능합니다');
			$('#id').focus();
		}else{
			$('#idHelper').text('');
		}
	});
	
	$('#pwConfirm').blur(function(){
		if($('#pw').val().length < 4) {
			$('#pwHelper').text('pw는 4자이상');
			$('#pw').focus();
		} else if($('#pw').val() != $('#pwConfirm').val()) {
			$('#pwHelper').text('pw가 일치하지 않습니다');
			$('#pw').focus();
		} else {
			$('#pwHelper').text('');
		}
	});

	$('#name').blur(function() {
		if($('#name').val() == '') {
			$('#nameHelper').text('이름을 입력해주세요');
			$('#name').focus();
		} else {
			$('#nameHelper').text('');
		}
	});
	
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
	
	// 주민등록번호를 입력후 앞 두자리 변수
	let two = 0;
	let sex = 0;
	let ageY = 0; // 태어난 연도
	let age = 0; // 나이
	$('#residentNumber').blur(function() {
		if($('#residentNumber').val().length != 14) {
			$('#residentNumberHelper').text('주민번호을 입력해주세요');
			$('#residentNumber').focus();
		} else {
			$('#residentNumberHelper').text('');
			two = $('#residentNumber').val().substr(0,2);
			sex = $('#residentNumber').val().substr(7,1);
			console.log('주민등록번호앞 두자리' + two);
			console.log('주민등록번호 뒷 한자리' + sex);
			
			// 두자리 나이 판별 
			if( (sex == 1) || (sex == 2) ){
				ageY = 19 + two;
				console.log('태어난 연도' + ageY);
			}else if( (sex == 3) || (sex == 4) ){
				ageY = 20 + two;
				console.log('태어난 연도' + ageY);
			}
			
			// 현재 연도 출력
			let today = new Date();
			let y = today.getFullYear();
			
			//나이 판별
			age = y - ageY;
			console.log('나이' + age);
			
			// 태어난 연도 값 넘겨주기
			$('input#birthYear').val(ageY);
			
			if(age < 19) {
				console.log('성인만 가입가능합니다.');
				alert('성인만 가입가능합니다.');
				return;
			}
		}
	});

	$('#accountNumber').blur(function() {
		if($('#accountNumber').val() == '') {
			$('#accountNumberHelper').text('계좌를 입력해주세요');
			$('#accountNumber').focus();
		} else {
			$('#accountNumberHelper').text('');
		}
	});
	
	// 빈칸 확인	
	function memberJoinCheck(){
		var r = registerForm;
		r.action ='registerController';

		if(r.detailedAddress.value.trim() == ""){
			alert('상세주소를 입력하세요');
			r.detailedAddress.focus();
			return;
		}
		if(r.id.value.trim() == ""){ // 아이디 빈칸 검사
			alert('아이디를 입력하세요');
			r.id.focus();
			return;
		}
		if(r.pw.value.trim() == ""){ // 비밀번호 빈칸 검사
			alert('비밀번호를 입력하세요');
			r.pw.focus();
			return;
		}
		if(r.pwConfirm.value.trim() == ""){ // 비밀번호 재입력 빈칸 검사
			alert('비밀번호 재입력을 입력하세요');
			r.pwConfirm.focus();
			return;
		}
		if(r.name.value.trim() == ""){ // 이름 빈칸 검사
			alert('이름을 입력하세요');
			$('name').focus();
			return;
		}
		if(r.email.value.trim() == ""){ // 이메일 빈칸 검사
			alert('이메일을 입력하세요');
			r.email.focus();
			return;
		}
		if(r.phone.value.trim() == ""){ // 전화번호 빈칸 검사
			alert('전화번호를 입력하세요');
			r.phone.focus();
			return;
		}
		if(r.residentNumber.value.trim() == ""){ // 주민번호빈칸 검사
			alert('주민번호를 입력하세요');
			r.residentNumber.focus();
			return;
		}
		if(age < 19){
			alert('성인만 가입이 가능합니다');
			return;
		}
		if(r.accountNumber.value.trim() == ""){ // 계좌번호 빈칸 검사
			alert('계좌번호를 입력하세요');
			r.accountNumber.focus();
			return;
		}
		r.submit();
	}
	


	
</script>

</html>