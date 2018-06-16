<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Memer Join</title>
</head>
<body>
	<h1>Memer Joinn</h1>

	<form method="post" action="/member/join"> 
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
				<td><label for="password">비밀번호 확인</label></td>
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
	 	<button type="submit">회원가입</button>
	</form> 
	<hr> 
</body>
</html>