<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requestChangePw</title>
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
					고객님의 소중한 개인정보 보호를 위해 목로주점 고객님의 비밀번호를 변경해주세요!
					</div>
					<br>
					<div class="row">
					<div class="col-sm-3">
					</div>
					<div class="col-sm-6">
					<div class="errorText">${errorText}</div> 
					<form action="logoutController" method="post" name="pwForm">
						<table class = "table text-center ">
							<tr>
								<th>현재 비밀번호</th>
								<th>
									<input type="password" class="form-control" name="currentPw" id="currentPw">
								</th>
							</tr>
							<tr>
								<th>변경할 비밀번호</th>
								<th>
									<input type="password" class="form-control" name="changePw" id="changePw">
									<span id="ChangePwHelper" class="helper"></span>
								</th>
							</tr>
							<tr>
								<th>변경할 비밀번호 확인</th>
								<th>
									<input type="password" class="form-control" name="checkChangePw" id="checkChangePw">
									<span id="checkChangePwHelper" class="helper"></span>
								</th>
							</tr>
							<tr>
								<th>
									<input type="hidden" class="form-control" name="check" value="1">
								</th>
							</tr>		
							<tr>
								<td>
								<a href="${pageContext.request.contextPath}/indexController">다음에 변경</a>
								</td>
								<td>
								<button type="button" class="btn btn-info text-White btn-block" id="changePwBtn" >비밀번호 변경</button>
								</td>
							</tr>								
						</table>
					</form>			
					</div>
					<div class="col-sm-3">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<!-- Footer -->
<div class ="fixFooter">
	<jsp:include page="../../../WEB-INF/inc/footer.jsp" ></jsp:include>
</div>
</body>
<script>

	$('#changePw').blur(function(){
		if($('#changePw').val().length < 4) {
			$('#ChangePwHelper').text('pw는 4자이상');
			$('#changePw').focus();
		} else {
			$('#ChangePwHelper').text('');
		}
	});

	$('#checkChangePw').blur(function(){
		if( $('#changePw').val() != $('#checkChangePw').val() ) {
			$('#checkChangePwHelper').text('변경할 비밀번호와 다릅니다.');
			$('#changePw').focus();
		}else{
			$('#checkChangePwHelper').text('');
			
		}
	});

	$('#changePwBtn').on("click", function(){		
		var p = pwForm;		
		p.action ='logoutController';	
		if(p.currentPw.value.trim() == ""){
			console.log('p.currentPw.value');
			alert('현재비밀번호를 입력하세요');
			p.currentPw.focus();
			return;
		}
		if(p.changePw.value.trim() == ""){ // 아이디 빈칸 검사
			alert('변경할 비밀번호를 입력하세요');
			p.changePw.focus();
			return;
		}
		if(p.checkChangePw.value.trim() == ""){ // 비밀번호 빈칸 검사
			alert('비밀번호 재확인을 입력하세요');
			p.checkChangePw.focus();
			return;
		}
		p.submit();	
	});

</script>
</html>