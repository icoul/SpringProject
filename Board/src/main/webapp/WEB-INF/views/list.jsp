<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
	table, tr, td {border : solid grey 1px;}
	#table {border-collapse: collapse; width : 750px;}
	#table th, #table td {padding : 5px;}
	#table th {background-color : #DDDDDD;}
	
	a{text-decoration : none;
	  color : blue;}
</style>

<script type = "text/javascript" src = "<%=request.getContextPath() %>/resources/js/jquery-2.0.0.js"></script>
<script type = "text/javascript">
	
</script>

<head>
<meta charset="UTF-8">
<title>글목록 보기</title>
</head>
<body>
	<h1>게시판</h1>
	<table id="table">
		<tr>
			<th style = "width : 70px;">글번호</th>
			<th style = "width : 360px;">제목</th>
			<th style = "width : 70px;">성명</th>
			<th style = "width : 180px;">날짜</th>
			<th style = "width : 70px;">조회수</th>
		</tr>
		<c:forEach var = "list" items = "${contentList}" varStatus = "status">
			<tr>
				<td align = "center">${list.seq}</td>
				<td>
					<a href = "<%= request.getContextPath() %>/view.action?seq=${list.seq}">${list.subject}
					<c:if test="${list.commentCount > 0}">
						<span style = "color : red; font-weight : bold; font-style : italic; font-size : smaller; vertical-align : super;">[${list.commentCount}]</span>
					</c:if>
					</a>
				</td>
				<td>${list.name}</td>
				<td align = "center">${list.regDate}</td>
				<td align = "center">${list.readCount}</td>
			</tr>
		</c:forEach>
	</table>
	</br>
	<button type = "button" onClick = "javascript:location.href='<%=request.getContextPath()%>/add.action'">글쓰기</button>
	<button type = "button" onClick = "javascript:location.href='<%=request.getContextPath()%>/list.action'">취소</button>
</body>
</html>