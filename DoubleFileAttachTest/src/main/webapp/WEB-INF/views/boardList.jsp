<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멀티 파일올리기 및 썸네일 파일 생성하기</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/BootStrapStudy/css/bootstrap.css">
  <script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/jquery-2.0.0.js"></script>
  <script type="text/javascript" src="<%= request.getContextPath() %>/resources/BootStrapStudy/js/bootstrap.js"></script>

<style type="text/css">
	/* table, th, td {border: solid gray 1px;} */
	/* #table {border-collapse: collapse; width: 700px;} */
	/* #table th, #table td {padding: 5px;} */
	#table th {background-color: #EEEEEE; text-align: center;} 
	
	a{text-decoration: none; 
	  color: blue;}
</style>

<script type="text/javascript">
	
	function goWrite(){
		location.href= "<%= request.getContextPath() %>/add.action";
	}

</script>

</head>
<body>

	<div align="center" style="border: red solid 0px; width: 90%; margin: 3% auto;">
	<h2 class="bg-info" style="border: red solid 0px; width: 60%;" >멀티 파일올리기 및 썸네일 파일 생성하기</h2>
	<table id="table" class="table table-bordered" style="width: 60%; margin-top: 50px;">
		<tr>
			<th style="width: 70px;">글번호</th>
			<th style="width: 360px;">제목</th>
			<th style="width: 70px;">성명</th>
			<th style="width: 180px;">날짜</th>
		</tr>
		
		<c:forEach var="vo" items="${boardList}"> <%-- DoubleFileAttachController 컨트롤러에서 넘겨받은 키값  --%>
			<tr>
				<td align="center">${vo.seqcontent}</td>
				
				<!-- 글제목에 클릭을 하면 해당글을 보여주도록 링크를 건다. -->
				<td><a href="<%= request.getContextPath() %>/viewDetail.action?seqcontent=${vo.seqcontent}">${vo.subject}</a></td>
				<td>${vo.name}</td>
				<td align="center">${vo.regDate}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	
	<div align="center" style="width: 90%; margin: 3%;">
		<button type="button" class="btn btn-success" style="width: 70px; height: 40px;" onClick="goWrite();">글쓰기</button>
	</div>
</body>
</html>