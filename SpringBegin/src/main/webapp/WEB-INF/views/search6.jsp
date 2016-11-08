<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 페이지</title>

<script type="text/javascript">
	function goSearch() {
		var myFrm = document.myFrm;
		myFrm.submit();
	}

</script>

</head>
<body>
	<div align="center">
		<h1>성명의 일부분을 입력받아 이름을 검색해주는 페이지(/mybatis/mybatisTest12.action)</h1>
		
		<form name="myFrm"  action="<%= request.getContextPath() %>/mybatis/mybatisTest12End.action" method="post">  
			성명 : <input type="text" name="name" /><br/>
			<p>
			<button type="button" onClick="goSearch();">조회</button>
		</form>
	</div>
</body>
</html>
