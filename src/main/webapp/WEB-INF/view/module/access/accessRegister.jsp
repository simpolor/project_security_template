<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Access Register</title>
<script>
	function f_submit(){
		document.getElementById("accessRegisterForm").submit();
	}
	
	function f_move( url ){
		location.href = url;
	}
</script>
</head>
<body>
	<h1>Access Register</h1>

	<form id="accessRegisterForm" action="/access/register" method="post"> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<table>
			<tr>
				<td><label for="member_id">아이디</label></td>
				<td><input type="text" name="member_id" id="member_id" placeholder="아이디" required /></td>
			</tr>
			<tr>
				<td><label for="member_pw">접근URL</label></td>
				<td><input type="password" name="member_pw" id="member_pw" placeholder="비밀번호" required /></td>
			</tr>
		</table>
	</form>
	
	<hr> 
	
	<button onclick="f_submit()">등록</button>
	<button onclick="f_move('${pageContext.request.contextPath}/access/list')">뒤로가기</button>
	
</body>
</html>