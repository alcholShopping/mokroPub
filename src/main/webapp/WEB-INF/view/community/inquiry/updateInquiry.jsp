<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="vo.*"%>
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
							<c:forEach var="i" items="${inquiryOneList}">
								<form action="${pageContext.request.contextPath}/updateInquiryController" method="post" name="inquiryForm" enctype="multipart/form-data">
									<h1>문의사항 수정</h1>
									<table class="table">	
										<tr>
											<th>
												<input type="hidden" name="inquiryNo" value="${i.inquiryNo}">
											</th>
										</tr>
										<tr>
											<th>
												제목 : <input type="text" name="title" class="form-control" value="${i.title}">
											</th>
										</tr>
										<tr>
											<th>작성자 : <input type="text" value="${sessionScope.sessionMemberId}" name="consumerId" readonly="readonly"></th>
										</tr>
										<tr>
											<th>카테고리 : 
												<select name="category">
													<option value="${i.category}">선택한 카테고리 : ${i.category}</option>
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
												내용 : <textarea rows="10" cols="70" name="content">${i.content}</textarea>
											</th>
										</tr>
										<tr>
											<th colspan="2">
												<button type="button" onclick="updateInquiryCheck()" class="btn btn-primary">문의사항 수정</button>
											</th>
										</tr>
									</table>
								</form>
							</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
</body>
<script>
	function updateInquiryCheck(){
		var i = inquiryForm;
		i.action ='updateInquiryController';
	
		if(i.title.value.trim() == ""){
			alert('제목을 입력하세요');
			i.title.focus();
			return;
		}
		if(i.category.value.trim() == ""){ // 아이디 빈칸 검사
			alert('카테고리를 선택하세요');
			i.category.focus();
			return;
		}
		if(i.content.value.trim() == ""){ // 비밀번호 빈칸 검사
			alert('내용을 입력하세요');
			i.content.focus();
			return;
		}
		i.submit();	
	}
</script>
</html>