<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ include file="include/header.jsp"%>
<script>
$(function () {
	$("#managerUpdateForm").submit(function() {
		// 새로 선택한 파일이 있는 경우에는 바이너리
		// 없는 경우에는 텍스트 데이터로 폼 전송하기.
		var new_img = $("input[name=new_img]").val();
		console.log("new_img: " + new_img);
		if (new_img != "")	{
// 			console.log("선택 파일 있음");
			$(this).attr("enctype", "multipart/form-data");
			$("input[name=isBinary]").val("Y");
		}
	});
});
</script>
</head>
<body>
<br />
<br />
<div class="container-fluid"> 	<!-- 1 -->
	<div class="row">			<!-- 2 -->
		<div class="col-md-3">	<!-- 3 -->
		</div>
<%-- ${boardVo} --%>
		<div class="col-md-6" align="center">	<!-- 4 -->
			<h1>상품NO. ${sunglassesVo.sunglasses_num}수정</h1>
			<br />	
			<br />	
			<form id="managerUpdateForm" action="manager-update-pro.yoon" method="post" >
				<input type="hidden" name="sunglasses_num" 		value="${sunglassesVo.sunglasses_num}"/>
				<input type="hidden" name="sunglasses_img" 	value="${sunglassesVo.sunglasses_img}"/>
				<input type="hidden" name="isBinary" 		value="N"/>
			<%-- 	<input type="hidden" name="sunglasses_writer" 	value="${sunglassesVo.sunglasses_writer}"/> --%>
				<table class="table" border="1">
					<thead>
						<tr>
							<th align="center">분류 선택</th>
							<td>
								<select name="sunglasses_kind" value="${sunglassesVo.sunglasses_kind}">
									<option>SUNGLASSES</option>
									<option>OPTICAL</option>
									<option>TINT SELECTION</option>
									<option>ICONIC SELECTION</option>
								</select>
							</td>
						</tr>
						<tr >
							<th align="center">상품명</th>
							<td><input type="text" name="sunglasses_name"
									value="${sunglassesVo.sunglasses_name}"
									maxlength="30" required/></td>
						</tr>
						<tr>
							<th align="center">작성자</th>
							<td>${sunglassesVo.sunglasses_writer}</td>
						</tr>
						<tr>
							<th align="center">금액</th>
							<td><input type="text" name="sunglasses_price"
									maxlength="10" value="${sunglassesVo.sunglasses_price}"/>원</td>
						</tr>
						<tr>
							<th align="center">수량</th>
							<td><input type="text" name="sunglasses_count"
										maxlength="5" value="${sunglassesVo.sunglasses_count}"/>개</td>
						</tr>
						<tr>
							<c:if test="${not empty sunglassesVo.sunglasses_img}">
							<th align="center">이미지</th>
							<td>
								<img src="upload/${sunglassesVo.sunglasses_img}" width="200"/>
							</td>
							</c:if>
						</tr>
						<tr>
							<th align="center">새 첨부파일</th>
							<td><input type="file" name="new_img"/></td>
						</tr>
						<tr>
							<th align="center">내용</th>
							<td>
								<textarea name="sunglasses_content" cols="50" rows="10">
${sunglassesVo.sunglasses_content}
								</textarea>
							</td>
						</tr>
					</thead>
				</table>
				<input type="submit" class="btn btn-info btn-lg btn-block"  value="수정 완료">
			</form>
		</div>
		<div class="col-md-3">	<!-- 5 -->
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp" %>