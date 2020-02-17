<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>
var v = "${param.msg}";
if (v == "login_success")	{		// MemberloginProService.java
	alert("로그인 성공");
} else if (v == "login_fail")	{ 	// MemberloginProService.java
	alert("로그인 실패");
} 
</script>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12" align="center">
			<br/>
			<br/>
			<a href="board-list.board"><img src="images/logo.jpg"></a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-5">
		</div>
		<div class="col-md-2" style="background-color: ">
			<br />
			<br />
			<br />
			<br />
			<h3 class="text-center" style="font-size: 41px;">
				회원 로그인
			</h3>
			<br />
			<br />
				<form  role="form" class="form-inline"   
						id="loginForm" action="board-login-pro.board" method="post">
			
					<div class="login-form-group" align="center">
	<!-- 					<label for="exampleInputId"> -->
	<!-- 					</label> -->
						<input type="text" name="mem_id" placeholder="아이디" maxlength="41"
								style="width: 320px; height: 51px;" required />
					</div>
					<br />
					<div class="login-form-group" align="center"  >
	<!-- 					<label for="exampleInputPassword"> -->
	<!-- 					</label> -->
						<input type="password" name="mem_pass" placeholder="패스워드" maxlength="16" 
								style="width: 320px; height: 51px;"  required   />
					</div>
					<br />
					<br />
					<div class="login-form-group" align="center" > 
						<input type="submit" value="로그인" style="width: 320px; height: 51px;" /> 
					</div>
					<hr />
					<div class="login-form-group" align="right"> 
						<a href="member-join-form.mem" >회원가입</a>
					</div>
				</form>
		</div>
		<div class="col-md-5">
		</div>
	</div>
</div>
<%@ include file="include/board_footer.jsp" %>