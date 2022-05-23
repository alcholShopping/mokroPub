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
	<jsp:include page="../../../../WEB-INF/inc/navBar.jsp"></jsp:include>
	
	<!-- contents -->
	<div class="nullbox">
	</div>
	<div class="container">		
      <div class="row">
         <div class="col">
			<div class="section_title_container text-center">
				<div class="section_subtitle">목로주점</div>
				<div class="section_title">문의사항</div>
				<br>
					<form action="${pageContext.request.contextPath}/insertInquiryController" method="post" name="inquiryForm" enctype="multipart/form-data">
						<table class="table">	
							<tr>
								<td>
									<input type="text" name="title" class="form-control" placeholder="${sessionScope.sessionMemberId}님의 문의사항 제목">
									<input type="hidden" value="${sessionScope.sessionMemberId}" readonly="readonly">
								</td>
								<td>
									<select name="category" class="form-control">
										<option value=""> 문의종류선택 </option>
										<option value="배송"> 배송 </option>
										<option value="상품"> 상품 </option>
										<option value="상품"> 환불 </option>
										<option value="기타"> 기타 </option>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									 <input type="file" name="photo" class="form-control">
								</td>
							</tr>
							
							<tr>
								<td colspan="2">
									<textarea rows="10" cols="120" name="content" class="form-control"></textarea>
								</td>
							</tr>
						</table>
						<button type="button" class="btn btn-primary" onclick="insertInquiryCheck()">문의하기</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<div class ="fixFooter">
	<!-- Footer -->	
	<jsp:include page="../../../../WEB-INF/inc/footer.jsp"></jsp:include>
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