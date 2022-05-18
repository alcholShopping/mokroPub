<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
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
<style>
	.starR {
	  background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
	  background-size: auto 100%;
	  width: 30px;
	  height: 30px;
	  display: inline-block;
	  text-indent: -9999px;
	  cursor: pointer;
	}
	.starR.on{background-position:0 0;}
</style>
</head>
<body>
<div class="super_container">
	<!-- Header -->	
	<jsp:include page="/WEB-INF/inc/navBar.jsp"></jsp:include>
	<!-- contents -->
	<div class="register">
			<div class="gallery">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="register_title text-center">
							
								<form action="${pageContext.request.contextPath}/reviewUpdateController" method="post" enctype="multipart/form-data">
									<table class = "table">
									
										<tr>
											<td>리뷰 번호 : </td>
											<td> <input type="text" readonly="readonly" name="reviewNo" value="${rev.reviewNo}"></td>
										</tr>
										
										<tr>
											<th>별점</th>
											<th>
											<div class="starRev" name="starRev">
											  <span class="starR on" onClick="setStar(1)">별1</span>
											  <span class="starR on" onClick="setStar(2)">별2</span>
											  <span class="starR on" onClick="setStar(3)">별3</span>
											  <span class="starR" onClick="setStar(4)">별4</span>
											  <span class="starR" onClick="setStar(5)">별5</span>
											  <input type="hidden" id="settedStar" name="settedStar" value="3">
											</div>
											
											
											</th>
										</tr>
										
										<tr>
											<td>내용</td>
											<td><textarea cols="50" rows="10" name="content" >${rev.content}</textarea> </td>
										</tr>
										
										<tr>
											<td>사진</td>
											<td><input type="file" name="picture"></td>
										</tr>
										
										<tr>
											<td></td>
											<td><button type="submit">취소</button><button type="submit">제출</button></td>
										</tr>
										
										
										
									</table>
								</form>
							</div>
						</div>
					</div>
				</div>	
			</div>
		</div>
	</div>
	<!-- Footer -->	
	<jsp:include page="/WEB-INF/inc/footer.jsp"></jsp:include>
	<script>
		$('.starRev span').click(function(){
			  $(this).parent().children('span').removeClass('on');
			  $(this).addClass('on').prevAll('span').addClass('on');
			 
			  return false;
			});
		
		function setStar(point) {
		    // todo 별 이미지 css 관련 처리
		    // global variable 에 파라미터로 받은 point 할당
			$('#settedStar').text(point);
		    $('#settedStar').val(point);
		    console.log(point+ "스타 갯수");
		}
	</script>
</div>
</body>
</html>