<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Access List</title>
<script>
	function f_move( url ){
		location.href = url;
	}
</script>
</head>
<body>
	<h1>Access List</h1>

	<table>
		<thead>
			<tr>
				<th>Seq</th>
				<th>Access URL</th>
				<th>Access Roles</th>
				<th>Regi Date</th>
				<th>Modi Date</th>
				<th>Del Yn</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
			<c:choose>
				<c:when test="${! empty accessList}">
					<c:forEach var="list" items="${accessList}">
						<tr>
							<td>${list.access_seq}</td>
							<td>${list.access_url}</td>
							<td>${list.access_roles}</td>
							<td>${list.regi_date}</td>
							<td>${list.modi_date}</td>
							<td>${list.del_yn}</td>
							<td><button onclick="f_move('${pageContext.request.contextPath}/access/modify/${list.access_seq}')">수정</button></td>
							<td><%--<button onclick="f_move('${pageContext.request.contextPath}/access/delete/${list.access_seq}')">삭제</button>--%></td>
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
	
	<button onclick="f_move('${pageContext.request.contextPath}/access/register')">등록</button>
	<button onclick="f_move('${pageContext.request.contextPath}/index')">뒤로가기</button>
	
</body>
</html>