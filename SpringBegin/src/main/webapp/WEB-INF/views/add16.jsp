<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>

<script type="text/javascript">
	function submit() {
		var myFrm = document.myFrm;
		myFrm.submit();
	}

</script>

</head>
<body>
	<div align="center">
		<h1>글쓰기(/mybatis/mybatisTest16.action)</h1>
		
		<form name="myFrm"  action="<%= request.getContextPath() %>/mybatis/mybatisTest16End.action" method="post">  
			이름 : <input type="text" name="name" /><br/>
			메일 : <input type="text" name="email" /><br/>
			전화 : <input type="text" name="tel" /><br/>
			주소 : <input type="text" name="addr" /><br/>
			<p>
			<button type="button" onClick="submit();">등록</button>
		</form>
	</div>
</body>
</html>
