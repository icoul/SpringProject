<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해당 글 보기</title>

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
	
	a{tet-decoration : noneW} 		
</style>

<script type = "text/javascript">
</script>

</head>
<body>
	<h1>게시판</h1>
	<table id="table">
			<tr>
				<th>글번호</th>
				<td>${vo.seq}</td>
			</tr>
			<tr>
				<th>성명</th>
				<td>${vo.name}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${vo.subject }</td>
			</tr>
			<tr>
            	<th>내용</th>
            	<td>${vo.content}</td>
         	</tr>
			<tr>
				<th>조회수</th>
				<td>${vo.readCount}</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${vo.regDate}</td>
			</tr>
			
		</table>
		</br>
		<button type = "button" onClick = "javascript:location.href = '<%=request.getContextPath() %>/list.action'">목록보기</button>
		<button type = "button" onClick = "javascript:location.href = '<%=request.getContextPath() %>/edit.action?seq=${vo.seq}'">수정</button>
		<button type = "button" onClick = "javascript:location.href = '<%=request.getContextPath() %>/del.action?seq=${vo.seq}'">삭제</button>

</body>
</html>