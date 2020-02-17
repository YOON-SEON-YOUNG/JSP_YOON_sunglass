<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/board_header.jsp"%>
<style>
	.album {
		float:left;
		text-align:center;
		margin: 10px;
	}
	/* clear: both; */
</style>
</head>
<body>

<div class="container-fluid">
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
	<div class="row">
		<div class="col-md-1">
		</div>
		<div class="col-md-10" align="center">	<!-- 4 -->
			<br/>
			<br/>
			<!-- 검색기능 -->
			<form action="board-shop.board" id="searchForm" style="width: 500px;">
			<input type="hidden" name="nowPage" value="${pagingDto.nowPage}"/>
				<select name="searchType" style="height: 25px;">
					<option value="sunglasses_name"
					<c:if test="${searchDto.searchType == 'sunglasses_name'}">
					selected
					</c:if>
					 >상품명</option>
					<option value="sunglasses_kind"
					<c:if test="${searchDto.searchType == 'sunglasses_kind'}">
					selected
					</c:if>
					>상품 분류</option>
				</select>
				<input type="text" name="keyword" value="${searchDto.keyword}" style="height: 25px;"/>
				<input type="submit" value="검색" class="btn btn-info" style="height: 25px; align-items: center;"/>
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
			<!-- 글 목록 -->
			<table class="table" align="center">
				<thead>
					<tr align="center" height="30" style="background-color: orange; color: white;">
						<td align="center" width="20">상품 분류</td>
						<td align="center" width="100">상품명</td>
						<td align="center" width="50">이미지</td>
						<td align="center" width="50">상품 금액</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="sunglassesVo">
					<tr align="center">
						<td align="center" width="20">${sunglassesVo.sunglasses_kind}</td>
						<td align="center" width="100"><a href="board-shop-content.board?sunglasses_num=${sunglassesVo.sunglasses_num}"
								title="${sunglassesVo.sunglasses_content}">${sunglassesVo.sunglasses_name}</a></td>
						<td align="center" width="50">
						<c:choose>
							<c:when test="${empty sunglassesVo.sunglasses_img }">
								<img src="images/default.png" width="150"/>
							</c:when>
							<c:otherwise>
								<img src="upload/${sunglassesVo.sunglasses_img}" width="150" />
							</c:otherwise>
						</c:choose>
						</td>
						<td align="center" width="50">${sunglassesVo.sunglasses_price}</td>
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
		<div class="col-md-1">
		</div>
	</div>
</div>
		
								
<%@ include file="include/board_footer.jsp" %>