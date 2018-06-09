<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>adminLogin</title>
</head>
<body>
	<h1>adminLogin</h1>
	
	<form>
		<fieldset>
			<legend>관리자 로그인</legend>
			관리자 아이디 : <input type="text" /><br />
			관리자 비밀번호 : <input type="password" /><br />
			<input type="submit"  value="로그인" />
		</fieldset>
	</form>
</body>
</html>