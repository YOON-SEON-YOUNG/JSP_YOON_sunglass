<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<script>
var v = "${param.msg}";
if (v == "manager_login_success")	{ // ManagerloginProService.java
	alert("관리자 로그인 성공");
} else if (v == "manager_login_fail")	{ // ManagerloginProService.java
	alert("관리자 로그인 실패");
} 
</script>
</head>
<body>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-5">
		</div>
		<div class="col-md-2" style="background-color: ">
			<br />
			<br />
			<br />
			<br />
			<h3 class="text-center" style="font-size: 41px;">
				관리자 로그인
			</h3>
			<br />
			<br />
				<form  role="form" class="form-inline"   
						id="loginForm" action="manager-login-pro.yoon" method="post">
			
					<div class="login-form-group" align="center">
	<!-- 					<label for="exampleInputId"> -->
	<!-- 					</label> -->
						<input type="text" name="manager_id" placeholder="아이디" maxlength="41"
								style="width: 320px; height: 51px;" required />
					</div>
					<br />
					<div class="login-form-group" align="center"  >
	<!-- 					<label for="exampleInputPassword"> -->
	<!-- 					</label> -->
						<input type="password" name="manager_pw" placeholder="패스워드" maxlength="16" 
								style="width: 320px; height: 51px;"  required   />
					</div>
					<br />
					<br />
					<div class="login-form-group" align="center" > 
						<input type="submit" value="로그인" style="width: 320px; height: 51px;" /> 
					</div>
					<hr />
					<div class="login-form-group" align="right"> 
						<a href="manager-join-form.yoon" >회원가입</a>
					</div>
				</form>
		</div>
		<div class="col-md-5">
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp" %>