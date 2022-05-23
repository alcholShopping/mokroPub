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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/responsive.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
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
			<div class="section_title">공지사항 수정</div>
				<form action="${pageContext.request.contextPath}/updateNoticeController" method="post" name = "noticeForm"enctype="multipart/form-data">
					<table class="table">
					<c:forEach var="m" items="${noticeOneList}">
						<tr>
							<td width="50px">
								NO.${m.noticeNo}
								<input type="hidden" name="noticeNo" class="form-control" value="${m.noticeNo}" readonly="readonly">
							</td>
							<td>
								<input type="text" name="title" value="${m.title}"  class="form-control">	
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="file" name="photo" value="${m.photo}"  class="form-control">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<textarea rows="10" cols="120" name="content" value="${m.content}"  class="form-control"></textarea>
							</td>
						</tr>
						</c:forEach>
					</table>
					<button type="button" onclick="updateNoticeCheck()" class="btn btn-primary">수정하기</button>
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