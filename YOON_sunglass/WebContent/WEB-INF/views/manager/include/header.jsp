<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Free Board</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12" style="background-color: olive; height: 100px;">
			<br/>
			<h1><a href="manager-main.yoon" style="color: white;">SUNNY 관리자 페이지</a></h1>
		</div>
<!-- 		<div class="row"> -->
<!-- 			<div class="col-md-12" style="background-color: black; color: white; height: 50px;" > -->
<%-- 				<c:remove var="msg" scope="session"/>	<!-- 세션지우기 --> --%>
<%-- 				${sessionScope.manager_id} 로그인 유저 정보 --%>
<!-- 				<br/> -->
<%-- 				<c:choose> --%>
<%-- 					<c:when test="${not empty manager_id}"> --%>
<%-- 						${manager_id}님 반갑습니다. |  --%>
<!-- 						<a href="manager-logout.yoon" style="color: white;" >로그아웃</a> -->
<%-- 					</c:when> --%>
<%-- 				</c:choose> --%>
<!-- <!-- 			<a href="manager-main.yoon"><img src="images/logo_01.jpg" alt="로고 이미지" /></a> -->
<!-- 			</div> -->
<!-- 		</div> -->
	</div>
</div>