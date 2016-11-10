<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 페이지</title>

<script type="text/javascript">
	function goChart() {
		var myFrm = document.myFrm;
		myFrm.submit();
	}

</script>

</head>
<body>
	<div align="center">
		<h1>차트보기 버튼을 클릭하면 DB정보를 차트로 보여주는 페이지(/mybatis/mybatisTest20.action)</h1>
		
		<form name="myFrm"  action="<%= request.getContextPath() %>/mybatis/mybatisTest20End.action" method="get">  
			<button type="button" onClick="goChart();">차트보기</button>
		</form>
	</div>
</body>
</html>
