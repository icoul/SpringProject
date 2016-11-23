<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<title>멀티 파일올리기 및 썸네일 파일 생성하기</title>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/BootStrapStudy/css/bootstrap.css">
  <script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/jquery-2.0.0.js"></script>
  <script type="text/javascript" src="<%= request.getContextPath() %>/resources/BootStrapStudy/js/bootstrap.js"></script>

  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  
  .myborder {
	border: navy solid 1px;
  }
  </style>

<script type="text/javascript">
	
	$(document).ready(function(){
		
		var seqfileno =  ${avoList.get(0).seqfileno}; // 첨부된 파일중 첫번째 파일의 파일번호 얻어오기
		goLargeImgView(seqfileno);
		
		$(".my_thumbnail").hover(
				function(){
					$(this).addClass("myborder");
				},
				function(){
					$(this).removeClass("myborder");
				}
		);
				
	});
	
	/*
	 function goLargeImgView(seqfileno) {
		$.getJSON("getLargeImgFilename.action?seqfileno="+seqfileno,
				  function(data){
						$("#largeImg").empty();
						var html = "";
						$.each(data, function(key, val){
							html += "<img src=\"/fileattach/files/"+val+"\" "+"width='360' height='245' />";    
						});
						
						$("#largeImg").html(html);
				  }
		);
	} 
	*/
	
	
	function goLargeImgView(seqfileno) {
		$.ajax({ 
			url : "getLargeImgFilename.action", 	
			method : "GET",
			data : "seqfileno=" + seqfileno,  
					/*
					   전송방식이 get 이든 post 이든 
					   getLargeImgFilename.action?seqfileno=11 처럼 보내게 된다.
					   !! 그리고 중요한 것은 !!!
					   ajax 를 이용한 전송방식에는 
					   url페이지명과  data가 구분되어져 있으므로
					   구분자인 ? 가 필요없다는 것이다.
					   GET 방식에서 ? 의 기능은
					   WAS(톰캣서버)가 어디까지가 응용프로그램 주소이고,
					   어디부터가 데이터인지 구분하기 위한 구분자로 사용되는 것이다.
					   그러므로 ajax 에서는 키1=값1&키2=값2&키3=값3 으로 반복된다.
				   */
			dataType : "JSON",  // 응답은 JSON 타입으로 받아라.
			success: function(data) { // 데이터 전송이 성공적으로 이루어진 후 처리해줄 callback 함수
					// data 는 ajax 요청에 의해 url 페이지 getLargeImgFilename.action 으로 부터 리턴받은 데이터
			   			   
			   $("#largeImg").empty();
			   // <div id="largeImg"> 엘리먼트를 모두 비워서 새로운 데이터를 받을수 있게 해라
			   
			   var html = "";
			   
			   $.each(data, function(key, val){
					html += "<img src=\"/fileattach/files/"+val+"\" "+"width='460' height='345' />";    
			   });
					
		   	   /*
		   	    	$.each() 함수는 $(selector).each()와는 다르다.
		   	    	$.each(순회해야할 1개의 객체 또는 배열, function(indexInArray, valueOfElement){ } );
		   	    	배열을 다루는 경우, 콜백함수는 배열의 인덱스와 값을 인자로 갖는다
		   	   */
		   	   $("#largeImg").html(html);   // html을  largeImg 넣어주어라
			
			}, // end of success: function(data) ---------------------
			
			error: function(request, status, error){
		        alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
		    } // end of error: function(request,status,error)
			
		}); // end of $.ajax --------------------
	}
	
	
	function goList(){
		location.href= "<%= request.getContextPath() %>/list.action";
	}

</script>

</head>
<body>

<div align="left" style="width: 80%; padding: 2%; margin: 2%; font-size: 14pt; line-height: 180%;">
	 <ol style="list-style-type: decimal;">
	   <li>글번호 : ${vo.seqcontent}</li>
	   <li>작성자 : ${vo.name}</li>
	   <li>글제목 : ${vo.subject}</li>
	   <li>글내용 : ${vo.content}</li>
	   <li>작성시간 : ${vo.regDate}</li>
	 </ol>
</div>

<div class="container" align="center">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel" style="width: 75%;">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <c:forEach var="avo" items="${avoList}" varStatus="status">
      	<c:if test="${status.index == 0}">
      		<li data-target="#myCarousel" data-slide-to="${status.index}" class="active"></li>
      	</c:if>
      	<c:if test="${status.index > 0}">
      		<li data-target="#myCarousel" data-slide-to="${status.index}"></li>
      	</c:if>
      </c:forEach>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

	  <c:forEach var="avo" items="${avoList}" varStatus="status">
	  	  <c:if test="${status.index == 0}">
	  	  	<div class="item active">
	  	  </c:if>
	  	  <c:if test="${status.index > 0}">
	  	  	<div class="item">
	  	  </c:if>
	        	<img src="<%= request.getContextPath() %>/files/${avo.fileName}" width="460px" height="345px">
	        	<div class="carousel-caption">
	          		<h3>${vo.subject}</h3>
	          		<p>${vo.content}</p>
	        	</div>
	      	</div>
	  </c:forEach>
      
    </div>  <%-- end of <div class="carousel-inner" role="listbox"> --%>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div> <%-- end of <div id="myCarousel" class="carousel slide" data-ride="carousel"> --%>
</div> <%-- end of <div class="container"> --%>

<hr style="border: dotted 5px red;">
	  
	
	<div id="largeImg" align="center" style="border: green solid 0px; width: 45%; padding: 2%; margin: 2% auto;">
		<%-- <img src="/fileattach/files/20161027094843250674408795708.jpg" width='460' height='345' /> --%>
	</div>  
		
	
	<div align="center" style="border: red solid 0px; width: 80%; margin: auto; padding: 20px;">
		<c:forEach var="avo" items="${avoList}" varStatus="status">
			<img src="<%= request.getContextPath() %>/files/${avo.thumbnailFileName}" class="my_thumbnail" style="margin-right: 10px;" onClick="goLargeImgView('${avo.seqfileno}')" />
		</c:forEach>
	</div>
	
	<div align="center" style="margin-top: 10px; margin-bottom: 30px;">
		<button type="button" class="btn btn-success" style="width: 70px; height: 40px;" onClick="goList();">글목록</button>
	</div>
</body>
</html>