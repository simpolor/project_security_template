<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>custom login</title>
</head>
<body>
	<h1>custom login</h1>

	<form method="post" action="/member/login"> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="hidden" name="target_url" value="/member/register"/> 
		<table>
			<tr>
				<td><label for="email">아이디</label></td>
				<td><input type="text" name="member_id" id="member_id" placeholder="아이디" required /></td>
			</tr>
			<tr>
				<td><label for="password">비밀번호</label></td>
				<td><input type="password" name="member_pw" id="member_pw" placeholder="비밀번호" required /></td>
			</tr>
			<tr>
				<td colspan="2">	
					<input type="checkbox" name="remember-me" /><label for="remember-me">Remember-me</label>
				</td>
			</tr>
		</table>
	 	<button type="submit" class="btn btn-default">로그인</button>
	</form> 
	<hr> 
	<div> 
		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
			<span class="text-danger"><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></span> 
			<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
		</c:if> 
	</div> 
</body>
</html>