<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/header.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h3 class="text-center">
					등록된 상품 목록
				</h3>
				<hr>
				<a href="manager-main.yoon"> 관리자 메인으로</a>
				<hr>
				<br/>
				<br/>
				<tr>
					<th>제품 분류 목록:</th>
					<td>
						<c:choose>
						<c:when test="${empty sunglassesVo.sunglasses_kind}">
							<${sunglasses_count}>개
						</c:when>
							<c:otherwise>
								<${sunglasses_count}>개
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h3>상품관련 작업</h3>
				<table class="table">
					<tbody>
						<tr class="table-active">
							<td>제품 번호</td>
							<td>제품 분류</td>
							<td>제품명</td>
							<td>제품 가격</td>
							<td>제품 수량</td>
							<td>제품 이미지</td>
							<td>수정</td>
							<td>삭제</td>
						</tr>
						<c:forEach items="${list}" var="boardVo">
						<tr>
							<td>${sunglassesVo.sunglasses_num}</td>
							<td>${sunglassesVo.sunglasses_kind}</td>
							<td>${sunglassesVo.sunglasses_name}</td>
							<td>${sunglassesVo.sunglasses_price}</td>
							<td>${sunglassesVo.sunglasses_count}</td>
							<td>
							<c:choose>
								<c:when test="${empty sunglassesVo.sunglasses_img }">
									<img src="images/default.jpg" width="50"/>
								</c:when>
								<c:otherwise>
									<img src="upload/${sunglassesVo.sunglasses_img}" width="50"/>
								</c:otherwise>
							</c:choose>
							</td>
							<td><a href="content.kh?board_num=${sunglassesVo.board_num}"
									title="${sunglassesVo.board_content}">${sunglassesVo.board_subject}	[${sunglassesVo.reply_count}]</a>
							</td>
						</tr>
						</c:forEach>
					<tbody>
				</table>
			</div>
		</div>
	</div>
<%@ include file="include/footer.jsp" %>