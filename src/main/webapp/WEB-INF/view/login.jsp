<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="vo.*"%>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
           function findAddr(){
                window.open("FindAddress", "member", "width=640, height=400")
            };
</script>
</head>
<body>
<div class="super_container">
<!-- Header -->

	<!-- -------------------------------------- nav 끝-------------------------------------- -->
	<div class="register">
		<!-- Home Slider -->
		<div class="gallery">
		<!--  <div class="gallery_image" style="background-image:url(images/temp_main1.jpg)"></div>  -->
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="register_title text-center">
							<form action="LoginController" method="post">
								<table class = "table">
									<tr>
										<th>USER ID:</th>
										<th>
										<input type="text" class="form-control" placeholder="Enter ID" name="id">
										</th>
									</tr>
									
									<tr>
										<th>Password:</th>
										<th>
											<input type="password" class="form-control" placeholder="Enter password" name="pw">
										</th>
									</tr>
									
									<tr>
										<td colspan="2">
											<button type="submit" class="btn btn-primary">Submit</button>
										</td>
									<tr>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>	
		</div>
	</div>
</div>
</body>
</html>