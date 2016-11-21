<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<style>
	table, tr, td {border : solid grey 1px;}
	#table {border-collapse: collapse; width : 750px;}
	#table th, #table td {padding : 5px;}
	#table th {background-color : #DDDDDD;}
	
	a{text-decoration : none;
	  color : blue;}
</style>

<script type = "text/javascript" src = "<%=request.getContextPath() %>/resources/js/jquery-2.0.0.js"></script>
<script type = "text/javascript">
	$(document).ready(function(){
		searchKeep();
		
	});
	
	function searchKeep(){
		<c:if test = "${not empty search}">
			$("#colname").val("${colname}");
			$("#search").val("${search}");
		</c:if>
	}
	
	function goSearch(){
		
		var searchFrm = document.searchFrm
		var search = $("#search").val();
		
		if (search.trim() == "") {
			alert("검색어를 입력하세요");
		}
		else{
			searchFrm.submit();
		}
	}
	
	function getView(seq){
		
		var readCountCheck = "no";
		document.getElementsByName("seq")[0].value = seq;
		
		var viewFrm = document.viewFrm
		viewFrm.submit();
	}
</script>

<head>
<meta charset="UTF-8">
<title>글목록 보기</title>
</head>
<body>
	<h1>게시판</h1>
	<form name = "viewFrm" action = "<%= request.getContextPath() %>/view.action" method = "get" >
		<input type = "hidden" name = "readCountCheck" value = "no" />
		<input type = "hidden" name = "seq" value = "" />
		<table id="table">
			<tr>
				<th style = "width : 70px;">글번호</th>
				<th style = "width : 360px;">제목</th>
				<th style = "width : 70px;">성명</th>
				<th style = "width : 180px;">날짜</th>
				<th style = "width : 70px;">조회수</th>
			</tr>
			<c:forEach var = "list" items = "${contentList}" varStatus = "status">
				<tr>
					<td align = "center">${list.seq}</td>
					<td>
						<!-- #81. 답변글인 경우 제목 앞에 공백을 주겠다 -->
						<c:if test="${list.depth != 0}">
							<span style = "color : red; font-style: italic; padding-left : ${list.depth * 20}px;">└Re</span>
						</c:if>
						<a href = "#" onClick = "getView(${list.seq});">${list.subject}
						<c:if test="${list.commentCount > 0}">
							<span style = "color : red; font-weight : bold; font-style : italic; font-size : smaller; vertical-align : super;">[${list.commentCount}]</span>
						</c:if>
						</a>
					</td>
					<td>${list.name}</td>
					<td align = "center">${list.regDate}</td>
					<td align = "center">${list.readCount}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<br/>
	<div align = "center" style = "width : 400px; margin-left : 100px;">
		${pagebar}
	</div>
	
	<!-- #61. 글 검색폼 추가하기 : 제목, 내용, 글쓴이 -->
	<form name = "searchFrm" action = "<%= request.getContextPath() %>/list.action" method = "get">
		<select name = "colname" id = "colname">
			<option value = "subject">제목</option>
			<option value = "content">내용</option>
			<option value = "name">글쓴이</option>
		</select>
		<input type = "text" name = "search" id = "search" size = "40" />
		<button type = "button" onClick = "goSearch()">검색</button>
	</form>
	
	</br>
	<button type = "button" onClick = "javascript:location.href='<%=request.getContextPath()%>/add.action'">글쓰기</button>
	<button type = "button" onClick = "javascript:location.href='<%=request.getContextPath()%>/list.action'">글목록</button>
</body>
</html>


