<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/board_header.jsp"%>
</head>
<body>
<br />
<br />
<br />
<div class="container-fluid">	<!-- 1 -->
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
	<div class="row">			<!-- 2 -->
		<div class="col-md-3">	<!-- 3 -->
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
			<a href="board-shop.board" >
				<input type="button" value="목록으로" class="btn btn-outline-info"/>
			</a>
		</div>
		<div class="col-md-2">	<!-- 5 -->
		</div>
	</div>
</div>


<!-- 본인글일때만 수정, 삭제 보이도록 -->
<%@ include file="include/board_footer.jsp" %>