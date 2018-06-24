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
				<th>순번</th>
				<th>URL</th>
				<th>권한 목록</th>
				<th>등록일</th>
				<th>수정일</th>
			</tr>
		</thead>
		
		<tbody>
			<c:choose>
				<c:when test="${! empty accessList}">
					<c:forEach var="list" items="${accessList}">
						<tr>
							<td>${list.access_seq}</td>
							<td>${list.access_url}</td>
							<td>${list.access_role}</td>
							<td></td>
							<td></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="5">비어있음</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>	
	</table>
	
	<button onclick="f_move('${pageContext.request.contextPath}/access/register')">등록</button>
	<button onclick="f_move('${pageContext.request.contextPath}/index')">뒤로가기</button>
	
	<hr> 
</body>
</html>