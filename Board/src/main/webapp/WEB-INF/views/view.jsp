<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해당 글 보기</title>

<style type="text/css">
	table, th, td, input, textarea {border: solid gray 1px;}
	
	#table {border-collapse: collapse;
	 		width: 600px;
	 		}
	#table th, #table td{padding: 5px;}
	#table th{width: 120px; background-color: #DDDDDD;}
	#table td{width: 480px;}
	.long {width: 470px;}
	.short {width: 120px;}
	
	a{color : black; text-decoration: none; vertical-align: middle;}
	
	a:hover{color : blue; text-decoration: underline;} 		
</style>
<script type = "text/javascript" src = "<%=request.getContextPath() %>/resources/js/jquery-2.0.0.js"></script>
<script type = "text/javascript">
	
	function goWrite(){
		var addWriteFrm = document.addWriteFrm;
		addWriteFrm.submit();
	}
	
	
</script>

</head>
<body>
	<h1>게시판</h1>
	<table id="table">
			<tr>
				<th>글번호</th>
				<td>${vo.seq}</td>
			</tr>
			<tr>
				<th>성명</th>
				<td>${vo.name}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${vo.subject }</td>
			</tr>
			<tr>
            	<th>내용</th>
            	<td>${vo.content}</td>
         	</tr>
         	<tr>
				<th>첨부파일</th>
				<td>
					<a href = "<%=request.getContextPath()%>/download.action?seq=${vo.seq}">
						${vo.orgFileName}(<fmt:formatNumber value="${vo.fileSize}" pattern="#,###,###" />&nbsp;bytes)
					</a>
				</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${vo.readCount}</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${vo.regDate}</td>
			</tr>
			
		</table>
		</br>
		<button type = "button" onClick = "javascript:location.href = '<%=request.getContextPath() %>/list.action'">목록보기</button>
		<button type = "button" onClick = "javascript:location.href = '<%=request.getContextPath() %>/edit.action?seq=${vo.seq}'">수정</button>
		<button type = "button" onClick = "javascript:location.href = '<%=request.getContextPath() %>/del.action?seq=${vo.seq}'">삭제</button>
		</br>
		</br>
		
		<!-- #75. 답변글 쓰기 버튼 추가하기(현재 보고 있는 글이 작성하려는 답변글의 원글[부모글]이 된다. -->
		<button type = "button" onClick = "javascript:location.href = '<%=request.getContextPath() %>/add.action?fk_seq=${vo.seq}&groupno=${vo.groupno}&depth=${vo.depth}'">답변글쓰기</button>
		
		<!-- #46. 댓글 쓰기 폼 추가 -->
		
		<form name = "addWriteFrm" action="<%=request.getContextPath() %>/addComment.action" method = "post">
			성명 : <input type = "text" name = "name" class="short" />
			내용 : <input type = "text" name = "content" class="long" />
			
			<!-- 댓글이 달리는 원게시물 글번호 -->
			<input type = "hidden" name = "parentSeq" value = "${vo.seq}" />
			
			<button type="button" onClick="goWrite();">쓰기</button>
		</form>
		</br>
		<!-- 댓글 보여주는 창 -->
		<table id = "table">
			<c:forEach var = "commentvo" items="${commentList}">
				<tr>
					<td>${commentvo.name}</td>
					<td>${commentvo.content}</td>
					<td>${commentvo.regDate}</td>
				</tr>
			</c:forEach>
		</table>
		
</body>
</html>