<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글수정 완료 페이지</title>
</head>
<body>
	<script type = "text/javascript">
		<c:if test = "${result == 1}">
			alert("삭제 성공!!");
			// 글목록을 보여주는 페이지로 이동
			location.href = "<%= request.getContextPath() %>/list.action";
		</c:if>
		
		<c:if test = "${result != 1}">
			alert("삭제 실패!!");
			location.href = "<%= request.getContextPath() %>/view.action?seq=${seq} ";
		</c:if>
	</script>
</body>
</html>