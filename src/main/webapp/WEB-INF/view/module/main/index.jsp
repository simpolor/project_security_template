<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>Welcome</title>
</head>
<body>
	<h1>Welcome</h1>
	
	<a href="/member/login">로그인</a><br />
	<a href="/member/join">회원가입</a><br />
	<a href="/member/info">회원정보</a><br />
	<a href="/access/list">접근관리</a><br />

	<a href="/demo">데모</a><br /><br />
	
	<a href="/member/logout">로그아웃</a><br />
</body>
</html>