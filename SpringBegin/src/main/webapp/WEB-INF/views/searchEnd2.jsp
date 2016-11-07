<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한사람의 회원정보 보여주기(/mybatis/mybatisTest8End.action)</title>

<style type="text/css">
	table {border: solid gray 1px;
	       border-collapse: collapse;}
	th, td {border: solid gray 1px;}       

</style>

</head>
<body>

	<div align="center" style="margin-top: 50px;">
		<table>
			<thead>
				<tr>
					<th>회원번호</th>
					<th>성명</th>
					<th>이메일</th>
					<th>전화</th>
					<th>주소</th>
					<th>가입일자</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty vo}">
				<tr>
					<td colspan="6">
						존재하지 않습니다.
					</td>
				</tr>
				</c:if>
				<c:if test="${not empty vo}">
					<tr>
						<td>${vo.no}</td>
						<td>${vo.name}</td>
						<td>${vo.email}</td>
						<td>${vo.tel}</td>
						<td>${vo.addr}</td>
						<td>${vo.writeday}</td>
					</tr>
				</c:if>
			
			</tbody>
		</table>
	</div>

</body>
</html>





