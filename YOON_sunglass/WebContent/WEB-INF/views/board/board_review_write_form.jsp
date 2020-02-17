<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/board_header.jsp"%>
</head>
<body>

<br />
<br />
<br />
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
		</div>	
		<div class="row">
			<div class="col-md-8" align="center">
				<h1>후기 등록</h1>
				<form action="member-write-pro.mem" method="post" enctype="multipart/form-data">
					<table class="table" border="1" style="align-content: center;">
						<tr>
							<th>제목</th>
							<td><input type="text" name="review_subject"
									maxlength="30" required/></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td><input type="file" name="review_filename"/></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="review_content"
									cols="50" rows="10"></textarea></td>
						</tr>
					</table>
					<input type="submit" value="작성완료"/>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
			</div>
		</div>
	</div>
</div>

<%@ include file="include/board_footer.jsp" %>