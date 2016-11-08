<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색된 회원정보 보여주기(/mybatis/mybatisTest12End.action)</title>

<style type="text/css">
	table {border: solid gray 1px;
	       border-collapse: collapse;}
	th {background-color: #d0d0d0; font-weight: bold;}       
	th, td {border: solid gray 1px;}       
	td.total {background-color: #ffff99; font-weight: bold; text-align: center;}
</style>

</head>
<body>

	<div align="center" style="margin-top: 50px;">
		<table>
			<thead>
				<tr>
				    <th>번호</th>
					<th>회원정보</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty memberList}">
				<tr>
					<td colspan="2">
						존재하지 않습니다.
					</td>
				</tr>
				</c:if>
				<c:if test="${not empty memberList}">
				<c:forEach var="info" items="${memberList}" varStatus="status" >
					<tr>
					    <td>${status.count}</td>
						<td>${info}</td>
					</tr>
					    <c:set var="count" value="${status.count}" />
				</c:forEach>	
					<tr>	
						<td class="total" colspan="2">검색된 회원수 : ${count}명</td>
					</tr>
				</c:if>
			
			</tbody>
		</table>
	</div>

</body>
</html>





