<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inquiryOne</title>
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
</head>
<body>
<div class="super_container">
	<!-- Header -->
	<jsp:include page="../../../../WEB-INF/inc/navBar.jsp"></jsp:include>
	
	<div class="nullbox">
	</div>	
	<div class="container">		
      <div class="row">
         <div class="col">
			<div class="section_title_container text-center">
				<div class="section_subtitle">목로주점</div>
				<div class="section_title">문의사항</div>
			</div>
				<div style="display:none" class="conusmerBtn text-right">
					<a href="${pageContext.request.contextPath}/updateInquiryController?inquiryNo=${m.inquiryNo}&consumerId=${m.consumerId}" class="btn btn-outline-secondary btn-sm">수정하기</a>
				</div>
				<div style="display:none" class="conusmerBtn text-right">
					<a href="${pageContext.request.contextPath}/deleteInquiryController?inquiryNo=${m.inquiryNo}&consumerId=${m.consumerId}" class="btn btn-outline-secondary btn-sm">삭제하기</a>
				</div>
            	<c:forEach var="m" items="${inquiryOneList}">
	            	<table class ="table table-boedered">
		            	<tr>
			            	<td class="text-left">No.${m.inquiryNo} </td>
			            	<td class="text-left">${m.title}</td>
			            	<td class="text-right">${m.category}</td>
		            	</tr>
		            	<tr>
			            	<td>작성자</td>
			            	<td>${m.consumerId}</td>
			            	<td class="text-right">${m.createDate}</td>
		            	</tr>
		            	<tr>
			            	<td colspan="3">
			            		${m.content}
			            	</td>
		            	</tr>
	            	</table>						
					<table class ="table table-boedered">
						<tr>
							<td>
							<div id="adminBtn" style="display:none">
								<a href="${pageContext.request.contextPath}/answerInquiryController?inquiryNo=${m.inquiryNo}" class="btn btn-outline-secondary btn-sm">답변하기</a>
								</div>
							→ ${m.answer}
								
							</td>
						</tr>
					</table>
				</c:forEach>
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
	
	if('${sessionScope.sessionMemberId}' == 'admin'){
		console.log('admin입니다');
		$("#adminBtn").show();	
	}
	
	<c:forEach var="m" items="${inquiryOneList}">
		if('${sessionScope.sessionMemberId}' == '${m.consumerId}' ){
			console.log('작성자 입니다');
			$(".conusmerBtn").show();	
		} 
	</c:forEach>
</script>
</html>