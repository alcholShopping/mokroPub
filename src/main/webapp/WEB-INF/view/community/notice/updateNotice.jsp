<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateNotice</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Wish shop project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/main_styles.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/responsive.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/animate.css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet"
	type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
</script>

<style>
	.helper {
    	color: #FF0000;
    }
</style>
</head>
<body>
	<div class="super_container">
		<!-- Header -->		
		<jsp:include page="../../../../WEB-INF/inc/navBar.jsp"></jsp:include>
		<div class="nullbox">
		</div>	
		
		<div class="register">
			<div class="gallery">
				<!--  <div class="gallery_image" style="background-image:url(images/temp_main1.jpg)"></div>  -->
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="register_title text-center">
							<c:forEach var="m" items="${noticeOneList}">
								<form action="${pageContext.request.contextPath}/updateNoticeController" method="post" name = "noticeForm"enctype="multipart/form-data">
									<h1>공지사항 수정</h1>
									<table class="table">
										<tr>
											<th>
												noticeNo : <input type="text" name="noticeNo" class="form-control" value="${m.noticeNo}" readonly="readonly">
											</th>
										</tr>
										<tr>
											<th>
												제목 : <input type="text" name="title" class="form-control" value="${m.title}">
											</th>
										</tr>
										
										<tr>
											<th>
												이미지 파일 : <input type="file" name="photo" value="${m.photo}">
											</th>
										</tr>
										
										<tr>
											<th>
												내용 : <textarea rows="5" cols="30" name="content" value="${m.content}"></textarea>
											</th>
										</tr>
										<tr>
											<th colspan="2">
												<button type="button" onclick="updateNoticeCheck()" class="btn btn-primary">공지사항 수정</button>
											</th>
										</tr>
									</table>
								</form>
							</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			
		</div>
</body>
<script>
	function updateNoticeCheck(){
		var n = noticeForm;
		n.action ='updateNoticeController';
	
		if(n.title.value.trim() == ""){
			alert('제목을 입력하세요');
			n.title.focus();
			return;
		}
		if(n.content.value.trim() == ""){
			alert('내용을 입력하세요');
			n.content.focus();
			return;
		}
		n.submit();	
	}
</script>
</html>