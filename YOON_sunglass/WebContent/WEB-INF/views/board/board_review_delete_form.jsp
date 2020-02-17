<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/board_header.jsp"%>
<body>

<h1>삭제 폼</h1>
<form action="member-delete-pro.mem">
	<input type="hidden" name="board_num" value="${board_num}"/>
	<table border="1">
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="board_pass"/></td>
		</tr>
	</table>
	<input type="submit" value="삭제하기"/>
</form>
<%@ include file="include/board_footer.jsp" %>