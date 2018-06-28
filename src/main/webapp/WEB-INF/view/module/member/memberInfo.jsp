<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Memer Info</title>
<script>
	function f_move( url ){
		location.href = url;
	}
</script>
</head>
<body>
	<h1>Memer Info</h1>

	<table>
		<tr>
			<td><label for="member_id">아이디</label></td>
			<td>${Member.member_id}</td>
		</tr>
		<tr>
			<td><label for="member_pw">비밀번호</label></td>
			<td>${Member.member_pw}</td>
		</tr>
		<tr>
			<td><label for="member_name">이름</label></td>
			<td>${Member.member_name}</td>
		</tr>
		<tr>
			<td><label for="member_email">이메일</label></td>
			<td>${Member.member_email}</td>
		</tr>
	</table>
	
	<hr>
	
	<button onclick="f_move('${pageContext.request.contextPath}/index')">홈으로</button>
	 
</body>
</html>