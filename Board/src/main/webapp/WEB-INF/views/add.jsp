<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>

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
	<h1>게시판</h1>
	
	
	<form name="writeFrm" action="<%= request.getContextPath() %>/addEnd.action" method="post" enctype="multipart/form-data">
	
		<table id="table">
			<tr>
				<th>성명</th>
				<td><input type="text" name="name" class="short"  /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" class="long" /></td>
			</tr>
			<tr>
            	<th>내용</th>
            	<td><textarea name="content" class="long" style="height: 200px;"></textarea></td>
         	</tr>
         	
         	<tr>
		        <th>파일추가</th>
		        <td><input type="file" name="attach"/></td>
		    </tr>   
         		
			<tr>
				<th>암호</th>
				<td><input type="password" name="pw" class="short" /></td>
			</tr>
			
		</table>
		<br/>
		
		<!-- #77. 답변글쓰기인 경우 부모글의 seq값인 fk_seq값과 부모글의 groupno값과 depth값을 hidden으로 보내준다 -->
		<input type = "hidden" name = "fk_seq" value = "${fk_seq}" />
		<input type = "hidden" name = "groupno" value = "${groupno}" />
		<input type = "hidden" name = "depth" value = "${depth}" />
		
		<button type="button" onClick="goWrite();">쓰기</button>
		<button type="button" onClick="history.back();">취소</button>
	
	</form>

</body>
</html>

