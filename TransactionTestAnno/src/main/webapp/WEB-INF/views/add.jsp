<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>

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

<script type="text/javascript">
	function goWrite() {
		var writeFrm = document.writeFrm;
		writeFrm.submit();
	}

</script>

</head>
<body>
	<h1>공지게시판 : 글쓰기</h1>
	
	<form name="writeFrm" action="<%= request.getContextPath() %>/addEnd.action" method="post" >
		<table id="table">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="writerid" class="short"  /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" class="long" /></td>
			</tr>
			<tr>
            	<th>내용</th>
            	<td><textarea name="content" class="long" style="height: 200px;"></textarea></td>
         	</tr>
		</table>
		<br/>
		
		<button type="button" onClick="goWrite();">쓰기</button>
		<button type="button" onClick="history.back();">취소</button>
		<button type="button" onClick="javascript:location.href='list.action'">글목록</button>
	</form>

</body>
</html>