<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateInquiry</title>
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
									<h1>???????????? ??????</h1>
									<table class="table">	
										<tr>
											<th>
												<input type="hidden" name="inquiryNo" value="${i.inquiryNo}">
											</th>
										</tr>
										<tr>
											<th>
												?????? : <input type="text" name="title" class="form-control" value="${i.title}">
											</th>
										</tr>
										<tr>
											<th>????????? : <input type="text" value="${sessionScope.sessionMemberId}" name="consumerId" readonly="readonly"></th>
										</tr>
										<tr>
											<th>???????????? : 
												<select name="category">
													<option value="${i.category}">????????? ???????????? : ${i.category}</option>
													<option value="??????"> ?????? </option>
													<option value="??????1"> ??????1 </option>
													<option value="??????"> ?????? </option>
												</select>
											</th>
										</tr>
										<tr>
											<th>
												????????? ?????? : <input type="file" name="photo">
											</th>
										</tr>
										
										<tr>
											<th>
												?????? : <textarea rows="10" cols="70" name="content">${i.content}</textarea>
											</th>
										</tr>
										<tr>
											<th colspan="2">
												<button type="button" onclick="updateInquiryCheck()" class="btn btn-primary">???????????? ??????</button>
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
			alert('????????? ???????????????');
			i.title.focus();
			return;
		}
		if(i.category.value.trim() == ""){ // ????????? ?????? ??????
			alert('??????????????? ???????????????');
			i.category.focus();
			return;
		}
		if(i.content.value.trim() == ""){ // ???????????? ?????? ??????
			alert('????????? ???????????????');
			i.content.focus();
			return;
		}
		i.submit();	
	}
</script>
</html>