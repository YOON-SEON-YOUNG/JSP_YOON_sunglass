<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<script>
	var v = "${sessionScope.msg}";
	if (v == "success")	{					// ManagerDeleteProService.java
		alert("게시글 삭제 성공.");
	} else if (v == "fail")	{				// ManagerDeleteProService.java
		alert("게시글 삭제 실패");
	} else if (v == "login_success")	{	// ManagerLoginProService.java
		alert("로그인 성공");
	} else if (v == "login_fail") { 		// ManagerLoginProService.java
		alert("로그인 실패");
	} else if (v == "not_login") {			// ManagerFrontController.java
		alert("로그인 후 이용 가능합니다.")
	}
</script>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12" style="background-color: black; color: white; height: 50px;" >
			<c:remove var="msg" scope="session"/>	<!-- 세션지우기 -->
			<%-- ${sessionScope.manager_id} 로그인 유저 정보 --%>
			<br/>
			<c:choose>
				<c:when test="${not empty manager_id}">
					${manager_id}님 반갑습니다. | 
					<a href="manager-logout.yoon" style="color: white;" >로그아웃</a>
				</c:when>
			</c:choose>
<!-- 			<a href="manager-main.yoon"><img src="images/logo_01.jpg" alt="로고 이미지" /></a> -->
	</div>
</div>
<br />
<br />
<br />
<div class="container-fluid">	<!-- 1 -->
	<div class="row">			<!-- 2 -->
		<div class="col-md-2">	<!-- 3 -->
			<ul class="nav flex-column">
				<li class="nav-item">
					<a class="nav-link active" href="manager-main.yoon">메인</a>
				</li>
				<h5>상품관련 작업</h5>
					<li class="nav-item">
						<a class="nav-link active" href="manager-write-form.yoon">상품 등록</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="manager-list.yoon">상품 목록</a>
					</li>
<!-- 				<li class="nav-item"> -->
<!-- 					<a class="nav-link disabled" href="manager-update-form.yoon">상품 수정</a> -->
<!-- 				</li> -->
<!-- 				<li class="nav-item"> -->
<!-- 					<a class="nav-link disabled" href="manager-delete-form.yoon">상품 삭제</a> -->
<!-- 				</li> -->
<!-- 				<h5>구매된 상품관련 작업</h3> -->
<!-- 					<li class="nav-item"> -->
<!-- 						<a class="nav-link disabled" href="orderList-form.yoon">전체 구매 목록</a> -->
<!-- 					</li> -->
				<h5>쇼핑몰로 가기</h5>
					<li class="nav-item">
<!-- 						<a class="nav-link disabled" href="board/board-list.board">쇼핑몰로</a> -->
						<a class="nav-link disabled" href="board-list.board"><img src="images/logo.jpg" width=100></a>
					</li>
			</ul>
		</div>
		<div class="col-md-8" align="center">	<!-- 4 -->
			<h1>새로 등록된 상품 리스트</h1>
			<table class="table" style="align-content: center;" border="1">
				<tr align="center">
					<th>공지사항 1</th>
					<td bordercolor="red">SUNNY 관리자 페이지 입니다.</td>
				</tr>
				<tr align="center">
					<th>공지사항 2</th>
					<td bordercolor="red">SUNNY 관리자 페이지 입니다.</td>
				</tr>
				<tr align="center">
					<th>공지사항 3</th>
					<td bordercolor="red">SUNNY 관리자 페이지 입니다.</td>
				</tr>
			</table>
		</div>
		<div class="col-md-2">	<!-- 5 -->
		</div>
	</div>
</div>

<%@ include file="include/footer.jsp" %>