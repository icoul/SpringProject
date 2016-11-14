<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>

<style type="text/css">
	table, th, td, input, textarea {border: solid gray 1px;}
	
	#table {border-collapse: collapse;
	 		width: 600px;
	 		}
	#table th, #table td{padding: 5px;}
	#table th{width: 120px; background-color: #DDDDDD;}
	#table td{width: 480px;}
	.long {width: 470px;}
	.short {width: 120px;} 		
</style>

</head>
<body>
<h1>공지게시판 : 글목록</h1>
	<table id="table">
		<thead>
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>글제목</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="3">데이터가 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="map" items="${list}" varStatus="status">
					<tr>
						<td>${map.SEQ}</td>
						<td>${map.NAME}</td>
						<td>${map.TITLE}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<div style="width: 200px; height: 200px; margin: 30px;">
		<button type="button" onClick="javascript:location.href='add.action'">글작성</button>
	</div>
</body>
</html>