<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateConsumerPw</title>
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
					비밀번호 변경 
					</div>
					<br>
					<div class="row">
					<div class="col-sm-3">
					</div>
					<div class="col-sm-6">
					<div class="errorText">${errorText}</div> 
					<br>
						<form action="${pageContext.request.contextPath}/updateConsumerPwController" method="post" id="pwForm">
							<input type="hidden" value="${sessionScope.sessionMemberId}" name="updateId">
							<input type="password" placeholder="변경할 PASSWORD를 입력하세요" class="form-control text-center" name="updatePw" id="updatePw">
							<span id="pwHelper" class="helper"></span>
							<br>				
							<button type="button" class="btn btn-info text-White btn-block" id="changePwBtn">password 변경</button>
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


	$('#updatePw').blur(function(){
		if($('#updatePw').val().length < 4) {
			$('#pwHelper').text('pw는 4자이상');
			$('#updatePw').focus();
		} else {
			$('#pwHelper').text('');
		}
	});
	
	$('#changePwBtn').on("click", function(){		
		var p = pwForm;		
		p.action ='updateConsumerPwController';	
		if(p.updatePw.value.trim() == ""){
			console.log('p.updatePw.value');
			alert('비밀번호를 입력하세요');
			p.updatePw.focus();
			return;
		}
		p.submit();	
	});

	
</script>
</html>