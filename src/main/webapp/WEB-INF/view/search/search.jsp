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
</head>
<body>
<div class="super_container">
	<!-- Header -->	
	<jsp:include page="/WEB-INF/inc/navBar.jsp"></jsp:include>
	<!-- contents -->
	<!-- -------------------------------------- nav 끝-------------------------------------- -->
		<div class="register">

			<div class="gallery">
				<!--  <div class="gallery_image" style="background-image:url(images/temp_main1.jpg)"></div>  -->
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="register_title text-center">
								<form  method="post" action="${pageContext.request.contextPath}/searchController">
									<h2>상세 검색</h2>
									<table class="table">
										<tr>
											<th>회사 / 술 이름 검색</th>
											<th>
											<input type="text" class="form-control"
												placeholder="명천두견주" name="name" id="id">
											</th>
										</tr>
										
										<tr>
											<th>가격</th>

											<th>
											<input type="number" class="" value="0" name="priceBefore"> ~ <input type="number" class="" value="200000" name="priceAfter">
												
											</th>
										</tr>

										<tr>
											<th>용량</th>

											<th>
											<label><input type="radio" name="volume" value="3000" checked="checked">전체</label>
											<label><input type="radio" name="volume" value="500">500ml 이하</label>
    										<label><input type="radio" name="volume" value="750">~ 750ml</label>
    										<label><input type="radio" name="volume" value="1000">~ 1000ml</label>
    										<label><input type="radio" name="volume" value="1500">~ 1500ml</label>
											</th>
										</tr>

										<tr>
											<th>색상</th>

											<th>
												<label><input type="radio" name="color" value="" checked="checked">전체</label>
												<label><input type="radio" name="color" value="하양">투명 혹은 흰색</label>
	    										<label><input type="radio" name="color" value="빨강">RED</label>
	    										<label><input type="radio" name="color" value="주황">Orange</label>
	    										<label><input type="radio" name="color" value="노랑">Yellow</label>
	    										<label><input type="radio" name="color" value="초록">Green</label>
	    										<label><input type="radio" name="color" value="파랑">Blue</label>
	    										<label><input type="radio" name="color" value="남색">Indigo</label>
	    										<label><input type="radio" name="color" value="보라">Violet</label>
											</th>
										</tr>
										
										<tr>
											<th>상세 검색표(0 ~ 선택까지)</th>

											<th>
												<div>
												  <input type="range" id="alcoholLevel" name="alcoholLevel" min="0" max="30" value="30">
												  <label for="volume">도수</label>
												</div>
												
												<div>
												  <input type="range" id="sweet" name="sweet" min="0" max="10" value="10">
												  <label for="volume">당도</label>
												</div>
												
												<div>
												  <input type="range" id="maturity" name="maturity" min="0" max="10" value="10">
												  <label for="volume">숙성도</label>
												</div>
												
												<div>
												  <input type="range" id="acidity" name="acidity" min="0" max="10" value="10">
												  <label for="volume">산미</label>
												</div>
												
												<div>
												  <input type="range" id="thin" name="thin" min="0" max="10" value="10">
												  <label for="volume">바디감</label>
												</div>
												
												<div>
												  <input type="range" id="refreshment" name="refreshment" min="0" max="10" value="10">
												  <label for="volume">청량감</label>
												</div>
												
											</th>
										</tr>

										
										<tr>
											<th colspan="2">
												<button type="submit" class="btn btn-primary">검색</button>
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
		<!--  검색결과 -->
		
		<div class="row">
         <div class="col">
					<table class ="table table-bordered">
					<c:forEach items="${searchMapList}" var="item">					
						<tr>
		                     <td>이름</td>
		                     <td>가격</td>
		                     <td>용량</td>
		                     <td>번호</td>	                                       
	                  	</tr>
	                  	
						<tr>

							<td>
								${item.name}
							</td>
								
							<td>
								${item.price}
							</td>
							
							<td>
								${item.volume}
							</td>
							
							<td>
								${item.product_no}
							</td>
							
						</tr>					
					</c:forEach>
				</table>  
			</div>  
	</div>
	<!-- Footer -->	
	<jsp:include page="/WEB-INF/inc/footer.jsp"></jsp:include>
</div>
</body>
</html>