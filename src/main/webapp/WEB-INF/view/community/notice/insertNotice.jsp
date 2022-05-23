<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertNotice</title>
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
				<div class="section_title">공지사항</div>
					<form action="${pageContext.request.contextPath}/insertNoticeController" method="post" name="noticeForm" enctype="multipart/form-data">
						<table class="table table-bordered">	
							<tr>
								<td class="text-left">
									<input type="text" placeholder="제목" name="title" class="form-control">
								</td>
							</tr>
							
							<tr> 
								<td class="text-left">
									<input type="file" name="photo" class="form-control">
								</td>
							</tr>
							
							<tr>
								<td class="text-left">
									<textarea rows="10" cols="120" placeholder="공지사항을 입력해주세요." name="content" class="form-control"></textarea>
								</td>
							</tr>	
						</table>
						<button type="button" onclick="insertNoticeCheck()" class="btn btn-primary">등록하기</button>
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
	function insertNoticeCheck(){
		var n = noticeForm;
		n.action ='insertNoticeController';
	
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