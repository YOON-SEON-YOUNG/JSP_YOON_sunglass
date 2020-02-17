<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_join_form.jsp</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>
var v = "${param.msg}";
if (v == "mem_join_fail")	{ // MemberJoinProService.java
	alert("회원 가입 실패");
} 
$(function () {
	var isCheckId = false;
	$("#btnCheckId").click(function () {
		var mem_id = $("input[name=mem_id]").val();
		var url = "member-check-id.ajax";
		var sendData = {
				"mem_id" : mem_id
		};
		$.get(url, sendData, function(receivedData) {
			var v = receivedData.trim();	// 공백제거
			console.log(receivedData);
			if ( v == "used_id" ){
				 $("#resultSpan").text("사용중인 아이디");
			} else if ( v == "available_id"){
				$("#resultSpan").text("사용 가능한 아이디");
				isCheckId = true;
			}
		});
	});
	
	$("#joinForm").submit(function () {
		var mem_pass = $("input[name=mem_pass]").val();
		var mem_pass2 = $("input[name=mem_pass2]").val();
		if (mem_pass != mem_pass2){
			alert("패스워드가 일치하지 않습니다.");
			return false;
		}
		
		if(isCheckId == false){
			alert("아이디 중복 체크를 해주세요.");
			return false;
		}
		
		var mem_id = $("input[name=mem_id]").val();	// h@@$&*
		console.log("----------------------");
		for (var v  = 0; v < mem_id.length; v++){
			var keyCode = mem_id.charCodeAt(v);		// 해당위치번째 문자의 코드값
			console.log(keyCode);
			
			if( !(97 <= keyCode && keyCode <= 122) &&	// 대,소문자가 아니고
					!(48 <= keyCode && keyCode <= 57)) {	// 숫자가 아니면
				alert("유효하지 않은 아이디\n영문자와 숫자 조합으로 입력");
				$("input[name=mem_id]").val("").focus();
// 				break; // for 종료
				return false; // for 종료, 폼 전송하지 않음
			}
		}
// 		return false;
	});
	
	$("input[name=mem_id]").keyup(function (e) {
		isCheckId = false;
		
	});
});
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
		<div class="col-md-3">
		</div>
		<div class="col-md-6" style="background-color: " align="center">
			<br />
			<br />
			<br />
			<br />
			<h3 class="text-center" style="font-size: 41px;">
				회원가입
			</h3>
			<br />
			<br />
			<form  role="form" class="form-inline" 
					id="joinForm" action="member-join-pro.mem" method="post" >
<!-- 				<h5 class="text-left">아이디</h5> -->
					<div class="join-form-group" align="center">
						<input type="text" name="mem_id" placeholder="아이디" maxlength="41"
								style="width: 320px; height: 51px;" required />
						<input type="button" value="아이디 중복 확인" id="btnCheckId"
								style="width: 320px; height: 51px; background-color: red; color: white;"/>
								<br/>
								<br/>
						<span id="resultSpan"></span>
					</div>
				<br />
<!-- 				<h5 class="text-left">이름</h5> -->
					<div class="join-form-group" align="center">
						<input type="text" name="mem_name"  placeholder="이름" maxlength="16"
								style="width: 640px; height: 51px;" />
					</div>
				<br />
<!-- 				<h5 class="text-left">패스워드</h5> -->
					<div class="join-form-group" align="center">
						<input type="password" name="mem_pass" placeholder="패스워드" maxlength="16" 
								style="width: 640px; height: 51px;"  required   />
					</div>
				<br />
<!-- 				<h5 class="text-left">패스워드 확인</h5> -->
					<div class="join-form-group" align="center">
						<input type="password" name="mem_pass2" placeholder="패스워드 확인" maxlength="16" 
								style="width: 640px; height: 51px;"  required   />
					</div>
				<br />
				<hr>
				<br />
				<div class="join-form-group" align="center"> 
					<input type="submit" value="회원가입 완료" style="width: 320px; height: 51px;"/>
				</div>
			</form>
		</div>
		<div class="col-md-3">
		</div>
	</div>
</div>
</body>
</html>