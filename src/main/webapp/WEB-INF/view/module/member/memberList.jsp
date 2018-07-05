<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Member List</title>
<script>
	function f_move( url ){
		location.href = url;
	}
</script>
</head>
<body>
	<h1>Member List</h1>

	<table>
		<thead>
			<tr>
				<th>Member Id</th>
				<th>Member Name</th>
				<th>Member Email</th>
				<th>Member Roles</th>
				<th>Regi Date</th>
				<th>Modi Date</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
			<c:choose>
				<c:when test="${! empty memberList}">
					<c:forEach var="list" items="${memberList}">
						<tr>
							<td>${list.member_id}</td>
							<td>${list.member_name}</td>
							<td>${list.member_email}</td>
							<td>${list.member_roles}</td>
							<td>${list.regi_date}</td>
							<td>${list.modi_date}</td>
							<td><button onclick="f_move('${pageContext.request.contextPath}/member/modify/${list.member_id}')">수정</button></td>
							<td><button onclick="f_move('${pageContext.request.contextPath}/member/delete/${list.member_id}')">삭제</button></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="8">Empty</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>	
	</table>
	
	<hr> 
	
	<button onclick="f_move('${pageContext.request.contextPath}/index')">뒤로가기</button>
	
</body>
</html>