<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
</head>
<body>
${sunglasses_num}
<h1>삭제 폼</h1>
<form action="manager-delete-pro.yoon">
	<input type="hidden" name="sunglasses_num" value="${sunglasses_num}"/>
	<table border="1">
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="sunglasses_pw"/></td>
		</tr>
	</table>
	<input type="submit" value="삭제하기"/>
</form>
<%@ include file="include/footer.jsp" %>