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

	<hr />

	<sec:authorize access="isAnonymous()">
		<a href="/member/login">로그인</a><br />
		<a href="/member/register">회원가입</a><br />
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<sec:authentication var="principal" property="principal" />
		<sec:authentication var="username" property="principal.username" />
		<sec:authentication var="identity" property="principal.identity" />
		<sec:authentication var="password" property="principal.password" />
		<sec:authentication var="name" property="principal.name" />
		<sec:authentication var="email" property="principal.email" />

		<a href="/member/info/${identity}">회원정보</a><br />
		<a href="/member/logout">로그아웃</a><br />
		<hr />
		principal : ${principal}<br />
		username : ${username}<br />
		password : ${password}<br />
		identity : ${identity}<br />
		name : ${name}<br />
		email : ${email}<br />
	</sec:authorize>

	<hr />

	<a href="/member/list">회원목록</a><br />
	<a href="/access/list">접근관리</a><br />
	<a href="/role/list">권한관리</a><br />
	<hr />
	<a href="/demo">데모</a><br />
	<a href="/demo/1">데모seq</a><br />
	<a href="/demo1">데모1</a><br />
	<a href="/demo2">데모2</a><br />

	<hr />

	<sec:authorize access="permitAll()">
		전체 허용<br />
	</sec:authorize>

	<sec:authorize access="hasAuthority('USER')">
		USER 권한 사용자<br />
	</sec:authorize>

	<sec:authorize access="hasRole('USER')">
		USER 권한 사용자<br />
	</sec:authorize>

	<sec:authorize access="hasAnyAuthority('USER', 'ADMIN')">
		USER 또는 ADMIN 권한<br />
	</sec:authorize>

	<sec:authorize access="hasAnyRole('USER', 'ADMIN')">
		USER 또는 ADMIN 권한<br />
	</sec:authorize>



	<%--
		hasRole([role])
		hasAnyRole([role1,role2])
		principal
		authentication
		permitAll
		denyAll
		isAnonymous()
		isRememberMe()
		isAuthenticated(
		isFullyAuthenticated()
	--%>
</body>
</html>