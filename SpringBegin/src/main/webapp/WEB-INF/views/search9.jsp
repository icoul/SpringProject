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
		<h1>전체회원을 검색해주는 페이지(/mybatis/mybatisTest15.action)</h1>
		
		<form name="myFrm"  action="<%= request.getContextPath() %>/mybatis/mybatisTest15End.action" method="get">  
			번호 : <input type="text" name="no" /><br/>
			<p>
			<button type="button" onClick="goSearch();">회원전체조회</button>
		</form>
	</div>
</body>
</html>
