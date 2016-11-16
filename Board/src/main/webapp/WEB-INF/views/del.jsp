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

	function goDel(){
		var delFrm = document.delFrm;
		delFrm.submit();
	}

</script>

</head>
<body>
	<h1>해당 글을 삭제하시겠습니까?</h1>
	
	<form name = "delFrm" action = "<%= request.getContextPath() %>/delEnd.action" method = "post">
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
				<td>${vo.subject}</td>
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
			<tr>
				<th>암호를 입력해주세요</th>
				<td><input type = "password" name = "pw" class = "short" /></td>
			</tr>
			
		</table>
		</br>
		<button type = "button" onClick = "goDel();">완료</button>
		<button type = "button" onClick = "history.back();">취소</button>
	</form>
	
</body>
</html>