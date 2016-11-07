<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 조회하기(단일데이터)</title>
</head>
<body>
	<c:if test = "${empty name}">
		조회하려는 회원번호 ${no}는 존재하지 않습니다.
	</c:if>
	
	<c:if test = "${not empty name}">
		회원번호 ${no} 님의 성명은 ${name}입니다.
	</c:if>
	
</body>
</html>