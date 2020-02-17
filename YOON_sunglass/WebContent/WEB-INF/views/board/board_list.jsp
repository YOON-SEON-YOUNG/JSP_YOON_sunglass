<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/board_header.jsp"%>
<style>
.container {										
		width: 1000px;								
	}	
</style>
</head>
<body>

<div class="container-fluid">
	<!-- 로그인/회원가입 -->
	<div class="row">
		<div class="col-md-12" align="right">
			<c:remove var="msg" scope="session"/>	<!-- 세션지우기 -->
			<c:choose>
				<c:when test="false">
					님 반갑습니다.
					<a href="logout.mem">로그아웃</a> |
				</c:when>
				<c:otherwise>
					<a href="board-login-form.board">
						로그인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</a>
					<a href="member-join-form.mem">
						회원가입&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</a>
					<br />
					<br />
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<!-- 탭 -->
	<div class="row">
		<div class="col-md-12" style="background-color: black;" align="center">
		<br/>
			<a href="board-shop.board" style="color: white;">&nbsp;&nbsp;&nbsp;&nbsp;선글라스&nbsp;&nbsp;&nbsp;&nbsp;</a>
			<a href="board-review.board" style="color: white;">&nbsp;&nbsp;&nbsp;&nbsp;리뷰&nbsp;&nbsp;&nbsp;&nbsp;</a>
		<br/>
		<br/>
		</div>
	</div><!-- 탭  끝 -->
	
	<!-- 		슬라이드 이미지 -->
	<div class="row">
		<div class="col-md-12">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
		    <!-- Indicators -->
				<ol class="carousel-indicators">
		      		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		      		<li data-target="#myCarousel" data-slide-to="1"></li>
		      		<li data-target="#myCarousel" data-slide-to="2"></li>
		   		</ol>
			    <!-- Wrapper for slides -->
				<div class="carousel-inner">
				  	<div class="item active">
				    	<img class="d-block w-743 h-743 " src="images/slide_01.jpg" alt="이미지_01"  style="width:100%;">
							<div class="carousel-caption">
								<h4 style="font-weight: bold;">
									SUNNY
								</h4>
							</div>
				  	</div>
				   	<div class="item">
				      	<img class="d-block w-1004 h-743" src="images/slide_02.jpg" alt="이미지_02"  style="width:100%;">
							<div class="carousel-caption">
								<h4 style="font-weight: bold;">
										SUNNY
									</h4>
							</div>
					</div>
					<div class="item">
						<img class="d-block w-830 h-743" src="images/slide_03.jpg" alt="이미지_03"  style="width:100%;">
							<div class="carousel-caption">
								<h4 style="font-weight: bold;">
									SUNNY
								</h4>
							</div>
					</div>
						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel" data-slide="prev">
						  	<span class="glyphicon glyphicon-chevron-left""></span>
						  	<span class="sr-only">Previous</span>				
						</a>
						<a class="right carousel-control" href="#myCarousel" data-slide="next">
							  <span class="glyphicon glyphicon-chevron-right"></span>
							  <span class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div><!-- 슬라이드 -->
		
								
<%@ include file="include/board_footer.jsp" %>