<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Memer Register</title>
<script>
	function f_submit(){
		document.getElementById("memberRegisterForm").submit();
	}
	
	function f_move( url ){
		location.href = url;
	}
</script>
</head>
<body>
	<h1>Memer Register</h1>

	<form id="memberRegisterForm" action="/member/register" method="post"> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<table>
			<tr>
				<td><label for="member_id">아이디</label></td>
				<td><input type="text" name="member_id" id="member_id" placeholder="아이디" required /></td>
			</tr>
			<tr>
				<td><label for="member_pw">비밀번호</label></td>
				<td><input type="password" name="member_pw" id="member_pw" placeholder="비밀번호" required /></td>
			</tr>
			<tr>
				<td><label for="member_pw_confirm">비밀번호 확인</label></td>
				<td><input type="password" name="member_pw_confirm" id="member_pw_confirm" placeholder="비밀번호 확인" required /></td>
			</tr>
			<tr>
				<td><label for="member_name">이름</label></td>
				<td><input type="text" name="member_name" id="member_name" placeholder="이름" required /></td>
			</tr>
			<tr>
				<td><label for="member_email">이메일</label></td>
				<td><input type="text" name="member_email" id="member_email" placeholder="이메일" required /></td>
			</tr>
		</table>
	</form>
	
	<hr> 
	
	<button onclick="f_submit()">회원가입</button>
	<button onclick="f_move('${pageContext.request.contextPath}/index')">뒤로가기</button>
	
</body>
</html>