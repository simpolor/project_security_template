<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Memer Modify</title>
<script>
	function f_submit(){
		document.getElementById("memberModifyForm").submit();
	}

	function f_move( url ){
		location.href = url;
	}
</script>
</head>
<body>
	<h1>Memer Modify</h1>
	
	<form id="memberModifyForm" action="/member/modify/${Member.member_id}" method="post"> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<table>
			<tr>
				<td><label for="member_id">아이디</label></td>
				<td><input type="text" name="member_id" id="member_id" value="${Member.member_id}" disabled="disabled" /></td>
			</tr>
			<tr>
				<td><label for="member_name">이름</label></td>
				<td><input type="text" name="member_name" id="member_name" value="${Member.member_name}" placeholder="이름" /></td>
			</tr>
			<tr>
				<td><label for="member_email">이메일</label></td>
				<td><input type="text" name="member_email" id="member_email" value="${Member.member_email}" placeholder="이메일" /></td>
			</tr>
		</table>
	</form>
	
	<hr>
	
		<button onclick="f_submit()">수정</button>
	<button onclick="f_move('${pageContext.request.contextPath}/index')">홈으로</button>
	 
</body>
</html>