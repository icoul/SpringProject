<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<style>
	table, tr, td {border : solid grey 1px;}
	#table {border-collapse: collapse; width : 920px;}
	#table th, #table td {padding : 5px;}
	#table th {background-color : #DDDDDD;}
	
	a{text-decoration : none;
	  color : blue;}
	
	#displayList {color : blue;}
	
	#table2 {border-collapse: collapse; width : 600px;}
</style>

<script type = "text/javascript" src = "<%=request.getContextPath() %>/resources/js/jquery-2.0.0.js"></script>
<script type = "text/javascript">
	$(document).ready(function(){
		searchKeep();
		
		$("#displayList").hide();
		$("#search").keyup(function(){
			
			var form_data = {
					colname : $("#colname").val(),   // 키값 : 밸류값 
					search  : $("#search").val()     // 키값 : 밸류값
				};
			
			$.ajax({
				url: "/board/wordSearchShow.action",
				type: "POST",
				data: form_data,  // url 요청페이지로 보내는 ajax 요청 데이터
				dataType: "html", // ajax 요청에 의해 url 요청페이지로 부터 리턴받는 데이터타입. xml, json, html, text 가 있음.
				success: function(data) {
					$("#displayList").html(data);
					$("#displayList").show();
				}	
			});
		}); // end of search.keyup
	});
	
	// #123. Ajax(JSON 을 사용하여 조회수 랭킹 보여주기 3 ) 
	function rankN() {
		/*
			jQuery 에서 JSON 형태의 데이터를 
			처리해주는 전용메소드가 getJSON() 메소드이다.
			사용법은 아래와 같다.
			
			$.getJSON("데이터를 가져올 URL 페이지명", function(data){  } ); 
		
			위의 것은 아래의 내용을 단축한 것이다.
			
			$.ajax({
					url : "데이터를 가져올 URL 페이지명",
					method : "GET",
					data : URL 페이지명으로 보내는 데이터,
					dataType : "json",
					success : function(data) {
						
					}
			});
		*/
		
		var rank = parseInt( $("#rankSelect").val() );  
		
		if(rank == 0) { // 조회등수를 선택했을 경우
			$("#displayRankN").empty();
		}
		else if(rank == 5 || rank == 10){
			// 상위5개 또는 상위10개를 선택했을 경우
			
			$.ajax({
				url : "/board/listRankN.action",
				method : "GET",
				data : "rankN=" + $("#rankSelect").val(), // +"&name=" + $("#name").val(), 
					/*
						전송방식이 GET 이든지 POST 이든지 관계없이
						rankN 이라는 키값에 값(지금은 $("#rankSelect").val() )을 실어서 보낸다.
						!!! 그리고 중요한 것은 !!!
						ajax 를 이용한 전송방식에는 
						url 페이지명과 data 가 구분되어져 있으므로
						구분자인 ? 가 필요없다는 것이다.
						GET 방식에서 ? 의 기능은
						WAS(톰캣)가 어디까지가 URL 주소이고, 어디부터가 데이터인지 구분하기 위한
						구분자로 사용되는 것이다.
					    그러므로 ajax에서는 키1=값1&키2=값2&키3=값3 식으로 반복해주면 된다.  
					*/
				dataType : "json", // 응답은 json 타입으로 받는다. 
				success : function(data) {
					// 데이터 전송이 성공적으로 이루어진 후 처리해주는 callback 함수 
					// data 는 ajax 요청에 의해 url 페이지 /board/listRankN.action 으로 부터 리턴받은 데이터
					
					// #129. Ajax(JSON 을 사용하여 조회수 랭킹 보여주기 9 ) 
					$("#displayRankN").empty();
					// <div id="displayRankN"> 엘리먼트를 모두 비워서 새로운 데이터를 받을수 있게 한다.
					
					var resultHtml = "<table id='table2'>";
					    resultHtml += "<tr>";
					    resultHtml += "<th>글번호</th>";
					    resultHtml += "<th>제목</th>";
					    resultHtml += "<th>이름</th>";
					    resultHtml += "<th>날짜</th>";
					    resultHtml += "<th>조회수</th>";
					    resultHtml += "</tr>";
					    
					    /*
					    	$.each() 함수는 
					    	$(selector).each() 와는 다르다.
					    	
					    	$.each(1개짜리 객체, function(key, val));
					        1개짜리 객체일때는 콜백함수의 첫번째 인자는 KEY값을 의미하고, 두번째 인자값은 값을 의미한다.
					        참고> C:\amjsp\MyMVC\WebContent\ajaxstudy\chap6\_1PersonInfoAjax.jsp 을 참조하세요. 
					    	
					    	$.each(배열, function(indexInArray, valueOfElement){ } ); 
					         배열을 다루는 경우, 콜백함수의 첫번째 인자는 배열의 인덱스이고, 두번째 인자는 값을 의미한다. 
					         
					    	
					    */
					    $.each(data, function(indexInArray, entry){
					    				resultHtml += "<tr>";
					    				resultHtml += "<td>"+ entry.seq +"</td>";
					    				resultHtml += "<td>"+ entry.subject +"</td>";
					    				resultHtml += "<td>"+ entry.name +"</td>";
					    				resultHtml += "<td>"+ entry.regDate +"</td>";
					    				resultHtml += "<td>"+ entry.readCount +"</td>";
					    				resultHtml += "</tr>";
					                  }
					    );
					    
					    resultHtml += "</table>";
					    
						$("#displayRankN").html(resultHtml);
				}
					
			});
			
		}// end of else if-----------------
		
	}// end of function rankN()------------
	
	function wordChoice(word){
		$("#search").val(word);
		$("#displayList").hide();
	}
	
	function searchKeep(){
		<c:if test = "${not empty search}">
			$("#colname").val("${colname}");
			$("#search").val("${search}");
		</c:if>
	}
	
	function goSearch(){ // 검색기능
		
		var searchFrm = document.searchFrm
		var search = $("#search").val();
		
		if (search.trim() == "") {
			alert("검색어를 입력하세요");
		}
		else{
			searchFrm.submit();
		}
	}
	
	function getPagebar(pageNo){ // 페이지 이동 기능
		
		<c:if test = "${empty search or empty colname}">
			document.getElementsByName("colname")[0].value = "subject";
			document.getElementsByName("search")[0].value = null;
		</c:if>

		document.getElementsByName("pageNo")[0].value = pageNo;
		
		var pageFrm = document.pageFrm
		pageFrm.submit();
	}
	
	function getView(seq){ // 단일 글 보기 기능
		
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
				
				<th style = "width : 70px;">파일</th>
				<th style = "width : 100px;">크기(bytes)</th>
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
					
					<td align = "center">
						<c:if test="${not empty list.fileName}">
							<a href = "<%=request.getContextPath() %>/download.action?seq=${list.seq}">
								<img width="15px" height="15px" src = "<%=request.getContextPath() %>/resources/images/disk.gif" border = "0" />
							</a>
						</c:if>
					</td>
					<td align = "center"><fmt:formatNumber value="${list.fileSize}" pattern="###,###,###" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<br/>
	<form name = "pageFrm" action = "<%= request.getContextPath() %>/list.action" method = "get">
		<div align = "center" style = "width : 400px; margin-left : 100px;">
			${pagebar}
		</div>
		<input type = "hidden" name = "pageNo" value = "" />
		<input type = "hidden" name = "search" value = "${search}" />
		<input type = "hidden" name = "colname" value = "${colname}" />
	</form>
	
	<!-- #61. 글 검색폼 추가하기 : 제목, 내용, 글쓴이 -->
	<form name = "searchFrm" action = "<%= request.getContextPath() %>/list.action" method = "get" style = "display: inline;">
		<select name = "colname" id = "colname">
			<option value = "subject">제목</option>
			<option value = "content">내용</option>
			<option value = "name">글쓴이</option>
		</select>
		<input type = "text" name = "search" id = "search" size = "40" />
		<button type = "button" onClick = "goSearch()">검색</button>
	</form>
	&nbsp;&nbsp;&nbsp;
	<!-- JSON을 사용하여 조회수 랭킹 보여주기 -->
	<form name = "rankFrm" id = "rankFrm" method = "get" style = "display: inline;">
		<select name = "rankSelect" id = "rankSelect">
			<option value = "0">조회등수</option>
			<option value = "5">상위5개</option>
			<option value = "10">상위10개</option>
		</select>
		<button type = "button" onClick = "rankN();">조회</button>
	</form>
	
	<!-- ajax로 검색어 입력시 자동글 완성하기 -->
	<div id = "display" style = "position : relative; left : 0px; top : 0px;">
		<div id = "displayList" style = "width : 285px; margin-left : 67px; border-top : 0px; border : solid gray 1px;">
			
		</div>
	</div>
	
	<br/>
	<button type = "button" onClick = "javascript:location.href='<%=request.getContextPath()%>/add.action'">글쓰기</button>
	<button type = "button" onClick = "javascript:location.href='<%=request.getContextPath()%>/list.action'">글목록</button>
	<br/>
	<br/>
	<div id="displayRankN" style="width: 700px; position: relative; left:100px; top:20px; margin-bottom: 20px;">
		
	</div>
	
</body>
</html>


