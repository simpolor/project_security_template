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
				<td><label for="access_url">ACCESS URL : </label></td>
				<td><input type="text" name="access_url" id="access_url" value="${access.access_url}" /></td>
			</tr>
			<tr>
				<td><label for="access_url">ACCESS ROLES : </label></td>
				<td><input type="text" name="access_roles" id="access_roles" value="${access.access_roles}" /></td>
			</tr>
		</table>
	</form>


	<c:if test="${! empty roleList}">
	<hr />

	<table>
		<c:forEach var="role" items="${roleList}">
		<tr>
			<td>${role.role_code}</td>
			<td>${role.role_name}</td>
		</tr>
		</c:forEach>
	</table>
	</c:if>

	<hr />
	
	<button onclick="f_submit()">등록</button>
	<button onclick="f_move('${pageContext.request.contextPath}/access/list')">뒤로가기</button>
	
</body>
</html>