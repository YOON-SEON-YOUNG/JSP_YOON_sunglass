<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
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
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
			
		</div>	
		<div class="row">
			<div class="col-md-8" align="center">
				<h1>상품 등록</h1>
				<form action="manager-write-pro.yoon" method="post" enctype="multipart/form-data">
					<table class="table" border="1" style="align-content: center;">
						<tr>
							<th>분류 선택</th>
							<td>
								<select name="sunglasses_kind">
									<option>SUNGLASSES</option>
									<option>OPTICAL</option>
									<option>TINT SELECTION</option>
									<option>ICONIC SELECTION</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>상품명</th>
							<td><input type="text" name="sunglasses_name"
									maxlength="30" required/></td>
						</tr>
						<tr>
							<th>금액</th>
							<td><input type="text" name="sunglasses_price"
									maxlength="10" />원</td>
						</tr>
						<tr>
							<th>수량</th>
							<td><input type="text" name="sunglasses_count"
									maxlength="5" />개</td>
						</tr>
						<tr>
							<th>이미지</th>
							<td><input type="file" name="sunglasses_img"/></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="sunglasses_content"
									cols="50" rows="10"></textarea></td>
						</tr>
					</table>
					<input type="submit" value="작성완료"/>
<!-- 					<a href="manager-main-yoon"><input type="submit" value="작성취소"/></a> -->
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
			</div>
		</div>
	</div>
</div>

<%@ include file="include/footer.jsp" %>