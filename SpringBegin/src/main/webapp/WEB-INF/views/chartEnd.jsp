<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>차트 통계 페이지</title>

<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/jquery-2.0.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
	
	function goSearch(){
		var searchFrm = document.searchFrm;
		searchFrm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<h2>우리회사 직원통계(성별, 부서번호별, 연령대별) 차트로 보기</h2>
		<p>
		
		<!-- 검색 폼 추가 -->
		<form name = "searchFrm" action = "<%= request.getContextPath()%>/mybatis/mybatisTest20End.action" method = "get">
			<select name = "typeName" id = "typeName">
				<option value="all">구분</option>
				<option value="gender">성별</option>
				<option value="deptno">부서번호</option>
				<option value="ageline">연령대</option>
			</select>
			<button type="button" onClick="goSearch();">조회</button>
		</form>
		<p>
		<p>
	</div>
	
	<c:if test="${not empty typeName && typeName eq 'gender' }">
		<jsp:include page="/WEB-INF/views/chart_Gender.jsp" />
	</c:if>
	
	<c:if test="${not empty typeName && typeName eq 'deptno' }">
		<jsp:include page="/WEB-INF/views/chart_Deptno.jsp" />
	</c:if>
	
	<c:if test="${not empty typeName && typeName eq 'ageline' }">
		<jsp:include page="/WEB-INF/views/chart_Ageline.jsp" />
	</c:if>
</body>
</html>