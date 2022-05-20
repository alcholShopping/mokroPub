<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertInquiry</title>
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
								<form action="${pageContext.request.contextPath}/insertInquiryController" method="post" name="inquiryForm" enctype="multipart/form-data">
									<h1>공지사항 등록</h1>
									<table class="table">	
										<tr>
											<th>
												제목 : <input type="text" name="title" class="form-control">
											</th>
										</tr>
										<tr>
											<th>작성자 : <input type="text" value="${sessionScope.sessionMemberId}" readonly="readonly"></th>
										</tr>
										<tr>
											<th>카테고리 : 
												<select name="category">
													<option value=""> 선택 </option>
													<option value="배송"> 배송 </option>
													<option value="예시1"> 예시1 </option>
													<option value="기타"> 기타 </option>
												</select>
											</th>
										</tr>
										<tr>
											<th>
												이미지 파일 : <input type="file" name="photo">
											</th>
										</tr>
										
										<tr>
											<th>
												내용 : <textarea rows="10" cols="70" name="content"></textarea>
											</th>
										</tr>
										<tr>
											<th colspan="2">
												<button type="button" class="btn btn-primary" onclick="insertInquiryCheck()">문의사항 등록</button>
											</th>
										</tr>
									</table>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
</body>
<script>
	function insertInquiryCheck(){
		var i = inquiryForm;
		i.action ='insertInquiryController';
	
		if(i.title.value.trim() == ""){
			alert('제목을 입력하세요');
			i.title.focus();
			return;
		}
		if(i.category.value.trim() == ""){ 
			alert('카테고리를 선택하세요');
			i.category.focus();
			return;
		}
		if(i.content.value.trim() == ""){
			alert('내용을 입력하세요');
			i.content.focus();
			return;
		}
		i.submit();	
	}
</script>
</html>