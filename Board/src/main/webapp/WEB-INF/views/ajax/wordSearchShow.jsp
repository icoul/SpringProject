<%-- Ajax에서 주석을 넣을때는 무조건 이렇게 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${searchWordCompleteList != null}"> 
		<c:set var="listSize" value="${searchWordCompleteList.size()}" />
			${listSize}|
		<c:forEach var="val" items="${searchWordCompleteList}" varStatus="status"> 
			<c:if test="${status.count < listSize}"> 
				${val},
			</c:if>
			<c:if test="${status.count == listSize}">
				${val}
			</c:if>
		</c:forEach>	
	</c:if>

