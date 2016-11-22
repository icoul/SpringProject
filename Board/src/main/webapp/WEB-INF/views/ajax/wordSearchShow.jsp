<%-- Ajax에서 주석을 넣을때는 무조건 이렇게 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${searchWordCompleteList != null}"> 
		<c:set var="listSize" value="${searchWordCompleteList.size()}" />
			
		<c:forEach var="val" items="${searchWordCompleteList}" varStatus="status"> 
			<c:if test="${colname != content}">
				<div> 
					<a href = "javascript:wordChoice('${val.forwardWord}${val.searchword}${val.backword}')">
						${val.forwardWord}<span style = "color : red;">${val.searchword}</span>${val.backword}
					</a>
				</div>
			</c:if>
			<c:if test="${colname == content}">
				<div>
					<a href = "javascript:wordChoice('${val.searchword}${val.content}')">
						<span style = "color : red;">${val.searchword}</span>${val.content}
					</a>
				</div>	
			</c:if>
		</c:forEach>	
	</c:if>

