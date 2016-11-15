<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
 <head>
 <meta charset="UTF-8">
 <title>11.1 뉴스 스크롤러 만들기</title>
 <!--
	  웹 사이트 방문자에게 텍스트 형식으로 뉴스를 보여주고 싶다.
	  뉴스는 위로 올라가게 하고 모두 올라가면 윈도우 아래에서 다시 나와 스크롤되게 하고 싶다.
 -->
 <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/resources/styles/animation7.css">
<script type = "text/javascript" src = "<%= request.getContextPath()%>/resources/js/jquery-2.0.0.js"></script>

 <script type="text/javascript">
	$(document).ready(function(){
		var $wrapper = $("#tb");
	
		$wrapper.css({'top':0});
			
		var animator = function(imgblock){
				imgblock.animate(
					{'top':-450}, 20000,
					function(){
						imgblock.css({'top':250});
						animator($(this));
						// animator(imgblock);
					}
				);
		} // 함수정의
	
		animator($wrapper); // 함수호출
	
	});

 </script>
 
 </head>

<body>
	<div id="container">
		<div id="header">Header</div>

		<div id="content">
			<br/>
			<div style="font-size:12pt; color:red; font-weight:bold; text-align:center;">스포츠기사 읽기</div>
			<br/>
			<div id = "scroller">
			<table id = "tb">
				<c:forEach var = "list" items = "${boardList}">
				
					<tr>
						<th>이름</th>
						<th>제목</th>
					</tr>
					<tr>
						<td>${list.name}</td>
						<td><a href = "<%= request.getContextPath()%>/testEnd.action">${list.subject }</a></td>
					</tr>
					<tr>
						<td colspan = "2">내용</td>
					</tr>
					<tr>
						<td colspan = "2">${list.content}</td>
					</tr>
				
				</c:forEach>
				</table>
			</div>
			<!--
				div 엘리먼트를 정의한 이유는 아이디 선택자 #scroller 로 뉴스창의 크기를 자동으로 정하기 위함이다.
				아이디 선택자 #scroller 는 animation7.css 파일에 정의되어 있고, 또한 animation7.css 파일에는
				#scroller p 로 뉴스 텍스트를 표시하는 문단 엘리먼트의 스타일 속성을 정의해두었다.
			
				아이디 선택자 #scroller 는 뉴스창의 너비와 높이를 width:280px; height:350px; 로 정하였다.
				이 창안에서 뉴스의 텍스트가 스크롤되게 할 것이다.
				overflow 속성을 hidden으로 하여 뉴스 창 밖의 텍스트는 보이지 않게 한다.
				position 속성은 relative로 한다(텍스트나 이미지가 스크롤하려면 현 위치에서 상대적인 위치가
				정해져야 하기 때문에 무조건 필수 조건이다.)
				margin 속성을 auto로 하여 스크롤되는 뉴스가 브라우저 윈도우의 가운데에 표시되게 한다.
				border 속성을 2px solid로 하여 2픽셀 두께의 실선으로 테두리를 만들고, padding 10px 로 하여
				텍스트와 뉴스 상자의 테두리 사이에 간격을 정한다.
				타입 선택자 #scroller p 는 font-weight 속성을 bold로 하여 문단 텍스트가 볼드체로 표시되게 하고,
				position 속성을 relative로 하여 문단 텍스트가 스크롤 되게 한다.
			
				jQuery 코드에서는 아이디가 scroller인 div 엘리먼트에 싸인 문단 텍스트 전체를 가져와서
				$wrapper 변수에 저장한다. 텍스트는 맨처음엔 위 경계에서 0px 되는 지점에 나오게 하여
				텍스트가 뉴스상자 상단 첫부분에서 부터 보이도록 한다.
			
				animator() 함수를 정의하여 모든 문단 텍스트를 이 함수에 imgblock 파라미터로 전달한다.
				imgblock(즉, 모든 문단 텍스트)은 윈도우의 위로 애니메이션 되고 뉴스상자의 -450 px 되는 지점,
				즉, 뉴스 텍스트가 모드 올라간 지점에에서 멈추게 한다.
			    이 스크롤은 애니메이션 진행 시간이 20000 밀리초로 지정되어 서서히 일어난다.
				애니메이션이 끝나면 실행되는 animiate() 메소드의 콜백함수에서는 문단 텍스트가 윈도우의 위 테두리에서
				250 px 떨어진 위치에 나오도록 한다. 그리고 animator()함수를 재귀적으로 호출하여 스크롤을 반복한다.
			-->
		</div>

		<div id="sideinfo">Sideinfo</div>
		<div id="footer">Footer</div>
	</div>
</body>
</html>
<!--
	 모든 앵커 엘리먼트는 image 클래스 이름을 할당하여 모든 이미지가 표시되어질 좌표는 
	 절대치로 top:170px; left:940px; 로 동일하게 만든다.
-->
