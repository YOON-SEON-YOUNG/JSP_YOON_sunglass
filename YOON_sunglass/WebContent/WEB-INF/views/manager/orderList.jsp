<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
</head>
<body>

<h3>주문목록</h3>

<br />
<br />
<br />
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
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
				<h5>구매된 상품관련 작업</h5>
				<li class="nav-item">
					<a class="nav-link disabled" href="manager-ordered-form.yoon">전체 구매 목록</a>
				</li>
				<h5>쇼핑몰로 가기</h5>
			</ul>
		</div>
		<div class="row">
			<div class="col-md-8" align="center">
			
				<!-- 검색기능 -->
				<form action="manager-list.yoon" id="searchForm" style="width: 500px;">
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
					<input type="submit" value="검색" style="height: 25px;"/>
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
							<td align="center" width="20">상품 번호</td>
							<td align="center" width="20">상품 분류</td>
							<td align="center" width="100">상품명</td>
							<td align="center" width="50">이미지</td>
							<td align="center" width="50">상품 금액</td>
							<td align="center" width="30">상품 수량</td>
							<td align="center" width="50">등록일</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="sunglassesVo">
						<tr align="center">
							<td align="center" width="20">${sunglassesVo.sunglasses_num}</td>
							<td align="center" width="20">${sunglassesVo.sunglasses_kind}</td>
							<td align="center" width="100"><a href="manager-content.yoon?sunglasses_num=${sunglassesVo.sunglasses_num}"
									title="${sunglassesVo.sunglasses_content}">${sunglassesVo.sunglasses_name}</a></td>
							<td align="center" width="50">
							<c:choose>
								<c:when test="${empty sunglassesVo.sunglasses_img }">
									<img src="images/default.png" width="50"/>
								</c:when>
								<c:otherwise>
									<img src="upload/${sunglassesVo.sunglasses_img}" width="50"/>
								</c:otherwise>
							</c:choose>
							</td>
							<td align="center" width="50">${sunglassesVo.sunglasses_price}</td>
							<td align="center" width="30">${sunglassesVo.sunglasses_count}</td>
							<td align="center" width="50">${sunglassesVo.reg_date}</td>
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
			<div class="row">
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="include/footer.jsp" %>