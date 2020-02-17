<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>

<script>
var manager_id = "${sessionScope.manager_id}"; // getCommentList 여기에 쓸거임
var msg = "${param.msg}";
if (msg == "invalid_id") {
	alert("본인이 작성한 글만 가능합니다.");
}

$(document).ready(function() {
	// 버튼 수정
	$("#btnUpdate").click(function() {
		location.href = "manager-update-form.yoon?sunglasses_num=${sunglassesVo.sunglasses_num}";
	});
	
	// 버튼 삭제
	$("#btnDelete").click(function() {
		if (confirm("정말 삭제하시겠습니까?")){
			location.href = "manager-delete-pro.yoon?sunglasses_num=${sunglassesVo.sunglasses_num}&sunglasses_writer=${sunglassesVo.sunglasses_writer}";
		}
		
	});
	
	// 목록으로 돌아가기
	$("#btnList").click(function() {
		location.href = "manager-list.yoon";
	});
	
});
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
</div>
<br />
<br />
<br />
<div class="container-fluid">	<!-- 1 -->
	<div class="row">			<!-- 2 -->
		<div class="col-md-3">	<!-- 3 -->
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
<!-- 				<h5>구매된 상품관련 작업</h5> -->
<!-- 					<li class="nav-item"> -->
<!-- 						<a class="nav-link disabled" href="orderList-form.yoon">전체 구매 목록</a> -->
<!-- 					</li> -->
				<h5>쇼핑몰로 가기</h5>
					<li class="nav-item">
						<a class="nav-link disabled" href="board-list.board"><img src="images/logo.jpg" width=100></a>
					</li>
				</ul>
		</div>
		<div class="col-md-7" align="center">	<!-- 4 -->
			<h1>상품NO. ${sunglassesVo.sunglasses_num}상세보기</h1>
			<br />	
			<br />	
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>제품 번호</th>
							<td>${sunglassesVo.sunglasses_num}</td>
						</tr>
						<tr>
							<th>내용</th>
							<td>${sunglassesVo.sunglasses_content}</td>
						</tr>
						<tr>
							<th>제품 분류</th>
							<td>${sunglassesVo.sunglasses_kind}</td>
						</tr>
						<tr>
							<th>상품명</th>
							<td>${sunglassesVo.sunglasses_name}</td>
						</tr>
						<tr>
							<th>판매금액</th>
							<td>${sunglassesVo.sunglasses_price}</td>
						</tr>
						<tr>
							<th>제품수량</th>
							<td>${sunglassesVo.sunglasses_count}</td>
						</tr>
						<tr>
							<th>이미지</th>
							<td>
							<c:choose>
							<c:when test="${empty sunglassesVo.sunglasses_img}">
								<img src="images/default.png" width="300"/>
							</c:when>
								<c:otherwise>
									<img src="upload/${sunglassesVo.sunglasses_img}" width="300"/>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td>${sunglassesVo.sunglasses_content}</td>
						</tr>
				</tbody>
			</table>
				<c:if test="${sunglassesVo.sunglasses_writer == sessionScope.manager_id}">
					<input type="button" value="수정" class="btn btn-warning" id="btnUpdate"/>
					<input type="button" value="삭제" class="btn btn-danger" id="btnDelete"/>
				</c:if> 
				<!-- <input type="button" value="답글" id="btnReply"/> -->
				<input type="button" value="목록" class="btn btn-info" id="btnList"/>
		</div>
		<div class="col-md-2">	<!-- 5 -->
		</div>
	</div>
</div>



<!-- 본인글일때만 수정, 삭제 보이도록 -->


	


<%@ include file="include/footer.jsp" %>