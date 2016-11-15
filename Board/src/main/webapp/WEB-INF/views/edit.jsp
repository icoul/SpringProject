<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 페이지</title>

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

	function goEdit(){
		var editFrm = document.editFrm;
		editFrm.submit();
	}

</script>

</head>
<body>
	<h1>게시판</h1>
	
	<form name = "editFrm" action = "<%= request.getContextPath() %>/editEnd.action" method = "post">
		<table id="table">
			<tr>
				<th>글번호</th>
				<td>${vo.seq}
				    <input type = "hidden" name = "seq" value = "${vo.seq}" /></td>
				
			</tr>
			<tr>
				<th>성명</th>
				<td>${vo.name}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type = "text" name = "subject" value = "${vo.subject}" class = "short"/></td>
			</tr>
			<tr>
            	<th>내용</th>
            	<td><textarea name = "content" class = "long" style = "height : 200px;">${vo.content}</textarea></td>
         	</tr>
			<tr>
				<th>조회수</th>
				<td>${vo.readCount}</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${vo.regDate}</td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type = "password" name = "pw" class = "short" /></td>
			</tr>
			
		</table>
		</br>
		<button type = "button" onClick = "goEdit();">완료</button>
		<button type = "button" onClick = "history.back();">취소</button>
	</form>
	
</body>
</html>