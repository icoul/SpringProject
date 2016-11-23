<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%-- JSON을 이용하여 조회수 랭킹 보여주기 --%>
<c:if test = "${jsonObjectList != null}">
	${jsonObjectList}
</c:if>
