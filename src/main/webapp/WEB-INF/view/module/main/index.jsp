<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"  %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>Welcome</title>
</head>
<body>
	<h1>Welcome</h1>
	
	<a href="/member/login">로그인</a><br />
	<a href="/member/register">회원가입</a><br />
	<a href="/member/info/abc">회원정보</a><br />
	<a href="/member/list">회원목록</a><br />
	<a href="/access/list">접근관리</a><br />
	<a href="/role/list">권한관리</a><br />
	<hr />
	<a href="/demo">데모</a><br />
	<a href="/demo/1">데모seq</a><br />
	<a href="/demo1">데모1</a><br />
	<a href="/demo2">데모2</a><br />
	<hr />
	<a href="/member/logout">로그아웃</a><br />

	<sec:authorize access="isAnonymous()">
		<a href="/member/login">로그인</a>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<a href="/member/logout">로그아웃</a>
	</sec:authorize>

</body>
</html>