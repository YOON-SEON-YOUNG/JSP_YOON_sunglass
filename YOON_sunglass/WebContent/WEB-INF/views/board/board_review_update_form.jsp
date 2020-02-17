<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/board_header.jsp"%>
<script>
$(function () {
	$("#updateForm").submit(function() {
		// 새로 선택한 파일이 있는 경우에는 바이너리
		// 없는 경우에는 텍스트 데이터로 폼 전송하기.
		var new_filename = $("input[name=new_filename]").val();
		console.log("new_filename: " + new_filename);
		if (new_filename != "")	{
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
		<div class="col-md-6" align="center">	<!-- 4 -->
			<h1>상품NO. ${reviewVo.review_num}수정</h1>
			<br />	
			<br />	
			<form id="updateForm" action="member-update-pro.mem" method="post" >
				<input type="hidden" name="review_num" 		value="${reviewVo.review_num}"/>
				<input type="hidden" name="review_filename" 	value="${reviewVo.review_filename}"/>
				<input type="hidden" name="isBinary" 		value="N"/>
				<input type="hidden" name="review_writer" 	value="${reviewVo.review_writer}"/>
				<table border="1">
					<tr>
						<th><span class="red">*</span>제목</th>
						<td><input type="text" name="review_subject"
								value="${reviewVo.review_subject}"
								maxlength="30" required/></td>
					</tr>
					<tr>
						<th><span class="red">*</span>작성자</th>
						<td>${reviewVo.review_subject}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="review_content" cols="50" rows="10">
${reviewVo.review_content}
						</textarea>
					</td>
				</tr>
				<tr>
					<c:if test="${not empty reviewVo.review_filename}">
					<th>첨부된 파일</th>
					<td>
						<img src="upload/${reviewVo.review_filename}" width="200"/>
					</td>
					</c:if>
				</tr>
				<tr>
					<th>새 첨부파일</th>
					<td><input type="file" name="new_filename"/></td>
				</tr>
			</table>
			<input type="submit" value="수정 완료"/>
		</form>
		</div>
		<div class="col-md-3">	<!-- 5 -->
		</div>
	</div>
</div>
<%@ include file="include/board_footer.jsp" %>