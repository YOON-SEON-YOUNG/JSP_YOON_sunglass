<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/board_header.jsp"%>
</head>
<body>
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
			<h1>리뷰 N0. ${reviewVo.review_num}상세보기</h1>
			<br />	
			<br />	
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>작성자</th>
							<td>${reviewVo.review_writer}</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td>${reviewVo.review_reg_date}</td>
						</tr>
						<tr>
							<th>제목</th>
							<td>${reviewVo.review_subject}</td>
						</tr>
						<tr>
							<th>내용</th>
							<td>${reviewVo.review_content}</td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td>
							<c:choose>
							<c:when test="${empty reviewVo.review_filename}">
								<img src="images/default_02.png" width="300"/>
							</c:when>
								<c:otherwise>
									<img src="upload/${reviewVo.review_filename}" width="300"/>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
				</tbody>
			</table>
			<a href="board-review.board" >
				<input type="button" value="목록으로" class="btn btn-outline-info"/>
			</a>
		</div>
		<div class="col-md-2">	<!-- 5 -->
		</div>
	</div>
</div>
</html>
<%@ include file="include/board_footer.jsp" %>