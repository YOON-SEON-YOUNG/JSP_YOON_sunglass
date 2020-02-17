<%@page import="java.sql.Connection"%>
<%@page import="net.yoon.persistence.SunglassesDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	BoardDao dao = BoardDao.getInstance();
// 	Connection conn = dao.getConnection();
// 	out.println(conn);
	
	response.sendRedirect("board-list.board");
%>