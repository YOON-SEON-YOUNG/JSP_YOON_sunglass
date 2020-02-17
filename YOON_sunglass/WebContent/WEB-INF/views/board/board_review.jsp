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
	<div class="row">
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
		<div class="col-md-3">
		</div>
		<!-- 검색기능 -->
		<div class="col-md-6" align="center">
			<br/>
			<br/>
			
			<form action="board-review.board" id="searchForm" style="width: 500px;">
			<input type="hidden" name="nowPage" value="${pagingDto.nowPage}"/>
				<select name="searchType" style="height: 25px;">
					<option value="reivew_subject"
					<c:if test="${searchDto.searchType == 'review_subject'}">
					selected
					</c:if>
					 >제목</option>
					<option value="reivew_content"
					<c:if test="${searchDto.searchType == 'review_content'}">
					selected
					</c:if>
					>내용</option>
				</select>
				<input type="text" name="keyword" value="${searchDto.keyword}" style="height: 25px;"/>
				<input type="submit" value="검색" style="height: 25px; align-items: center;" class="btn btn-info"/>
				<!-- 5 ~ 20줄 -->
				<select name="perPage" style="height: 25px;">
					<c:forEach var="i" begin="5" end="20" step="5">
						<option value="${i}"
							<c:if test="${ i == pagingDto.perPage }">selected</c:if>
						>${i}줄씩 보기</option>
					</c:forEach>
				</select>
			</form>
			<br />
			<div align="right">
				<a href="member-write-form.mem" >
					<input type="button" value="리뷰 작성"  class="btn btn-outline-warning" />
				</a>
			</div>
			<br />
			<!-- 글 목록 -->
			<table class="table" align="center">
				<thead>
					<tr align="center" height="30" style="background-color: orange; color: white;">
						<td align="center" width="50">작성자</td>
						<td align="center" width="50">제목</td>
						<td align="center" width="50">이미지</td>
						<td align="center" width="50">등록일</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${reviewList}" var="reviewVo">
					<tr align="center">
						<td align="center" width="50">${reviewVo.review_writer}</td>
						<td align="center" width="100"><a href="board-review-content.board?review_num=${reviewVo.review_num}"
								title="${reviewVo.review_content}">${reviewVo.review_subject}</a></td>
						<td align="center" width="50">
						<c:choose>
							<c:when test="true">
								<img src="images/default_02.png" width="70"/>
							</c:when>
							<c:otherwise>
								<img src="upload/${reviewVo.review_filename}" width="70" />
							</c:otherwise>
						</c:choose>
						</td>
						<td align="center" width="50">${reviewVo.review_reg_date}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav >
				<ul class="pagination" >
					<li class="page-item">
						<c:if test="${pagingDto.startPage != 1}">
							<a class="paging" href="${pagingDto.startPage - 1}">[이전]</a>
						</c:if>
					</li>
					<li class="page-item">
						<c:forEach var="i" begin="${pagingDto.startPage}" end="${pagingDto.endPage}">
							<a class="paging" href="${i}">${i}</a>
						</c:forEach>
					</li>
					<li class="page-item">
						<c:if test="${pagingDto.endPage != pagingDto.totalPage}">
							<a class="paging" href="${pagingDto.endPage + 1}">[다음]</a>
						</c:if>
					</li>
				</ul>
			</nav>
		</div>
		<div class="col-md-3">
		</div>
	</div>
</div>
		
								
<%@ include file="include/board_footer.jsp" %>