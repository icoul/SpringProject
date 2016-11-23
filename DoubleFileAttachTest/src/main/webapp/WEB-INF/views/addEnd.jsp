<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기 완료 페이지</title>
	
<script type="text/javascript">
    <c:if test="${result == null}">     <%-- 첨부파일이 없는 경우 --%>
	   <c:if test="${seqcontent >= 1}"> <%-- seqcontent(글번호)가 1 이상 이라면  --%>
		   alert("글쓰기 성공!!");
	       location.href="<%= request.getContextPath() %>/list.action"; 
		   // 해당글을 보여주는 페이지로 이동
	   </c:if>

	   <c:if test="${seqcontent == 0}"> <%-- seqcontent(글번호)가 0 이라면  --%>
		   alert("글쓰기 실패!!");
	       location.href="<%= request.getContextPath() %>/add.action";
		   // 글쓰기 페이지로 이동
	   </c:if>	
	</c:if>	
	
	<c:if test="${result != null}">     <%-- 첨부파일이 있는 경우 --%>
	   <c:if test="${seqcontent >= 1 && result == 1}"> <%-- seqcontent(글번호)가 1 이상 이고 파일첨부가 올바른 경우  --%>
		   alert("글쓰기 성공!!");
	       location.href="<%= request.getContextPath() %>/list.action"; 
		   // 해당글을 보여주는 페이지로 이동
	   </c:if>

	   <c:if test="${seqcontent == 0 && result == 0}"> <%-- seqcontent(글번호)가 0 이고 파일첨부가 올바르게 안된 경우 --%>
		   alert("글쓰기 실패!!");
	       location.href="<%= request.getContextPath() %>/add.action";
		   // 글쓰기 페이지로 이동
	   </c:if>	
	</c:if>	
</script>
</head>

<body>	
</body>
</html>