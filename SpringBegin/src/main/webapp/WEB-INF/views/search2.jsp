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
		<h1>번호를 입력받아 이름을 검색해주는 페이지(/mybatis/mybatisTest8.action)</h1>
		
		<form name="myFrm"  action="<%= request.getContextPath() %>/mybatis/mybatisTest8End.action" method="post">  
			번호 : <input type="text" name="no" /><br/>
			<p>
			<button type="button" onClick="goSearch();">조회</button>
		</form>
	</div>
</body>
</html>
