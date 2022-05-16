<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="vo.*"%>
<!DOCTYPE html>
<html>
<head><style>.gm-control-active>img{box-sizing:content-box;display:none;left:50%;pointer-events:none;position:absolute;top:50%;transform:translate(-50%,-50%)}.gm-control-active>img:nth-child(1){display:block}.gm-control-active:hover>img:nth-child(1),.gm-control-active:active>img:nth-child(1),.gm-control-active:disabled>img:nth-child(1){display:none}.gm-control-active:hover>img:nth-child(2){display:block}.gm-control-active:active>img:nth-child(3){display:block}.gm-control-active:disabled>img:nth-child(4){display:block}
</style><link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Google+Sans:400,500,700|Google+Sans+Text:400&amp;lang=ko"><link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Google+Sans+Text:400&amp;text=%E2%86%90%E2%86%92%E2%86%91%E2%86%93&amp;lang=ko"><style>.gm-ui-hover-effect{opacity:.6}.gm-ui-hover-effect:hover{opacity:1}.gm-ui-hover-effect>span{background-color:#000}@media (forced-colors:active),(prefers-contrast:more){.gm-ui-hover-effect>span{background-color:ButtonText}}
</style><style>.gm-style .gm-style-cc a,.gm-style .gm-style-cc button,.gm-style .gm-style-cc span,.gm-style .gm-style-mtc div{font-size:10px;box-sizing:border-box}.gm-style .gm-style-cc a,.gm-style .gm-style-cc button,.gm-style .gm-style-cc span{outline-offset:3px}
</style><style>@media print {  .gm-style .gmnoprint, .gmnoprint {    display:none  }}@media screen {  .gm-style .gmnoscreen, .gmnoscreen {    display:none  }}</style><style>.dismissButton{background-color:#fff;border:1px solid #dadce0;color:#1a73e8;border-radius:4px;font-family:Roboto,sans-serif;font-size:14px;height:36px;cursor:pointer;padding:0 24px}.dismissButton:hover{background-color:rgba(66,133,244,.04);border:1px solid #d2e3fc}.dismissButton:focus{background-color:rgba(66,133,244,.12);border:1px solid #d2e3fc;outline:0}.dismissButton:focus:not(:focus-visible){background-color:#fff;border:1px solid #dadce0;outline:none}.dismissButton:focus-visible{background-color:rgba(66,133,244,.12);border:1px solid #d2e3fc;outline:0}.dismissButton:hover:focus{background-color:rgba(66,133,244,.16);border:1px solid #d2e2fd}.dismissButton:hover:focus:not(:focus-visible){background-color:rgba(66,133,244,.04);border:1px solid #d2e3fc}.dismissButton:hover:focus-visible{background-color:rgba(66,133,244,.16);border:1px solid #d2e2fd}.dismissButton:active{background-color:rgba(66,133,244,.16);border:1px solid #d2e2fd;box-shadow:0 1px 2px 0 rgba(60,64,67,.3),0 1px 3px 1px rgba(60,64,67,.15)}.dismissButton:disabled{background-color:#fff;border:1px solid #f1f3f4;color:#3c4043}
</style><style>.gm-style-moc{background-color:rgba(0,0,0,.45);pointer-events:none;text-align:center;transition:opacity ease-in-out}.gm-style-mot{color:white;font-family:Roboto,Arial,sans-serif;font-size:22px;margin:0;position:relative;top:50%;transform:translateY(-50%);-webkit-transform:translateY(-50%);-ms-transform:translateY(-50%)}
</style><style>.gm-style img{max-width: none;}.gm-style {font: 400 11px Roboto, Arial, sans-serif; text-decoration: none;}</style>
<title>consumerOneInfo</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Wish shop project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/contact.css">
<link rel="stylesheet" type="text/css" href="styles/contact_responsive.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/responsive.css">
<script type="text/javascript" charset="UTF-8" src="https://maps.googleapis.com/maps-api-v3/api/js/48/12/intl/ko_ALL/common.js"></script><script type="text/javascript" charset="UTF-8" src="https://maps.googleapis.com/maps-api-v3/api/js/48/12/intl/ko_ALL/util.js"></script><script type="text/javascript" charset="UTF-8" src="https://maps.googleapis.com/maps-api-v3/api/js/48/12/intl/ko_ALL/map.js"></script><script type="text/javascript" charset="UTF-8" src="https://maps.googleapis.com/maps-api-v3/api/js/48/12/intl/ko_ALL/onion.js"></script><script type="text/javascript" charset="UTF-8" src="https://maps.googleapis.com/maps-api-v3/api/js/48/12/intl/ko_ALL/controls.js"></script></head>

<body>
	<div class="super_container">
		<!-- Header -->
		<jsp:include page="../../../WEB-INF/inc/navBar.jsp"></jsp:include>	
		<br><br><br>
		<!-- content -->
		<div class="contact_text">
			<div class="container">
				<div class="row">
				<!-- Contact Info -->
					<div class="col-lg-8">
						<div class="contact_info">
							<div class="contact_title"><h1>${sessionMemberId}님의 회원정보</h1></div>
							<div class="contact_info_content">
								<ul>
									<li>
										<div class="contact_info_text">회원아이디 : <span>${consumerList[0].consumerId}</span></div>
									</li>
									<li>
										<div class="contact_info_text">회원 이름 : <span>${consumerList[0].name}</span></div>
									</li>
									<li>
										<div class="contact_info_text">회원 전화번호 : <span>${consumerList[0].phone}</span></div>
									</li>
									<li>
										<div class="contact_info_text">회원 이메일 : <span>${consumerList[0].email}</span></div>
									</li>
									<li>
										<div class="contact_info_text">회원 주소 : <span>${consumerList[0].address}</span></div>
									</li>
									<li>
										<div class="contact_info_text">회원 상세주소  : <span>${consumerList[0].detailedAddr}</span></div>
									</li>
									<li>
										<div class="contact_info_text">회원 등급 : <span>${consumerLevelText}</span></div>
									</li>
									<li>
										<div class="contact_info_text">회원 계좌 : <span>${consumerList[0].account}</span></div>
									</li>
									<li>
										<div class="contact_info_text">회원 생성날짜 : <span>${consumerList[0].createDate}</span></div>
									</li>
									<li>
										<div class="contact_info_text">회원 수정날짜 : <span>${consumerList[0].updateDate}</span></div>
									</li>
									
								</ul>
							</div>
						</div>		
						<div><a href="#">수정하기</a></div>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer -->	
		<jsp:include page="/WEB-INF/inc/footer.jsp"></jsp:include>
		
	</div>
</body>
	<script>
		$(".actionHover").mouseover( function(){ 
			$(".submenu").stop().slideDown(500); 
			}) 
			
		$(".actionHover").mouseout(function(){
			$(".submenu").stop().slideUp(1000); 
		})
	</script>
</html>