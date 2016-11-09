<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 부서직원 정보 보여주기(/mybatis/mybatisTest17End.action)</title>

<style type="text/css">
	table {border: solid gray 1px;
	       border-collapse: collapse;}
	th {background-color: #d0d0d0; font-weight: bold;}       
	th, td {border: solid gray 1px;}       
	td.total {background-color: #ffff99; font-weight: bold; text-align: center;}
</style>

<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/jquery-2.0.0.js"></script>

<script type="text/javascript">

	$(document).ready(function(){
		putSearchWord();
	});
	
	function goSearch(){
		var searchFrm = document.searchFrm;
		searchFrm.submit();
	}
	
	function putSearchWord(){
		<c:if test="${not empty department_id_Arr}">
			<c:forEach var="val" items="${department_id_Arr}" varStatus="status">
				var department_id = "department_id_" + ${val};
				document.getElementById(department_id).checked = true;
			</c:forEach>
		</c:if>
		
		<c:if test = "${not empty gender}">
			$("#gender").val("${gender}");
		</c:if>
		
		<c:if test = "${not empty ageline}">
			$("#ageline").val("${ageline}");
		</c:if>
	}
</script>

</head>
<body>
	<div align="center" style="margin-top: 50px;">
	<h2>직원 정보 검색하기</h2>
	<p>
	<form name = "searchFrm" action = "<%=request.getContextPath() %>/mybatis/mybatisTest19End.action" method = "get">
		<input type = "checkbox" name = "department_id" id = "department_id_10" value = "10" /><label for = "department_id_10">10번부서</label>&nbsp;
		<input type = "checkbox" name = "department_id" id = "department_id_20" value = "20" /><label for = "department_id_20">20번부서</label>&nbsp;
		<input type = "checkbox" name = "department_id" id = "department_id_30" value = "30" /><label for = "department_id_30">30번부서</label>&nbsp;
		<input type = "checkbox" name = "department_id" id = "department_id_40" value = "40" /><label for = "department_id_40">40번부서</label>&nbsp;
		<input type = "checkbox" name = "department_id" id = "department_id_50" value = "50" /><label for = "department_id_50">50번부서</label>&nbsp;
		
		<select name = "gender" id = "gender">
			<option value = "전체">성별</option>
			<option value = "남">남</option>
			<option value = "여">여</option>
		</select>
		
		<select name = "ageline" id = "ageline">
			<option value = "-10">연령대</option>
			<option value = "0">10대미만</option>
			<option value = "10">10대</option>
			<option value = "20">20대</option>
			<option value = "30">30대</option>
			<option value = "40">40대</option>
			<option value = "50">50대</option>
			<option value = "60">60대</option>
		</select>
		
		<button type = "button" onClick = "goSearch();">검색</button>
	</form>
		<table>
			<thead>
				<tr>
				    <th>번호</th>
					<th>부서번호</th>
					<th>부서명</th>
					<th>사원번호</th>
					<th>사원명</th>
					<th>입사일자</th>
					<th>주민번호</th>
					<th>성별</th>
					<th>현재나이</th>
					<th>연봉</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty empdeptList}">
				<tr>
					<td colspan="10">
						존재하지 않습니다.
					</td>
				</tr>
				</c:if>
				<c:if test="${not empty empdeptList}">
				<c:forEach var="map" items="${empdeptList}" varStatus="status" >
					<tr>
					    <td>${status.count}</td>
						<td>${map.DEPARTMENT_ID}</td>
						<td>${map.DEPARTMENT_NAME}</td>
						<td>${map.EMPLOYEE_ID}</td>
						<td>${map.ENAME}</td>
						<td>${map.HIRE_DATE}</td>
						<td>${map.JUBUN}</td>
						<td>${map.GENDER}</td>
						<td>${map.AGE}</td>
						<td>${map.YEARPAY}</td>
					</tr>
					    <c:set var="count" value="${status.count}" />
				</c:forEach>	
					<tr>	
						<td class="total" colspan="5">전체직원수</td>
						<td class="total" colspan="5">${count}명</td>
					</tr>
				</c:if>
			
			</tbody>
		</table>
	</div>

</body>
</html>
