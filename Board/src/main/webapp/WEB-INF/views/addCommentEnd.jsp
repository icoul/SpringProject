<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 댓글 쓰기 완료 페이지</title>

<script type = "text/javascript">

	alert("${msg}");
	location.href = "<%=request.getContextPath() %>/view.action?seq=${seq}"

</script>

</head>
<body>
	
</body>
</html>