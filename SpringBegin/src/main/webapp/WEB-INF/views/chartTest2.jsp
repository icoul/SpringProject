<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Highcharts Example</title>

		<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/jquery-2.0.0.js"></script>
		<script src="<%= request.getContextPath() %>/resources/js/highcharts.js"></script>
		<script src="<%= request.getContextPath() %>/resources/js/modules/exporting.js"></script>
		
		<style type="text/css">
${demo.css}
		</style>
		<script type="text/javascript">
$(function () {
    $('#container').highcharts({
        title: {
            text: '월별 판매량',
            x: -20 //center
        },
        subtitle: {
            text: 'Source: www.naver.com',
            x: -20
        },
        xAxis: {
            categories: ['1월', '2월', '3월', '4월', '5월', '6월',
                '7월', '8월', '9월', '10월', '11월', '12월']
        },
        yAxis: {
            title: {
                text: '판매량'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '판매량(만 개)'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [
        		 <c:set var="cnt" value="1" />
        		 <c:set var="cityNameArr" value="<%= new String[]{\"서울\", \"부산\", \"대구\", \"광주\", \"인천\"} %>" />
        		 
        		 <c:forEach var="subList" items="${list}" varStatus="status">
        		 	{
        		 		name : "${cityNameArr[status.index]}",
        		 		data : [
        		 					<c:forEach var="val" items="${subList}">
        		 						${val},
        		 					</c:forEach>
        		 				]
        		 	}
        		 	<c:if test="${cnt != list.size()}">
        		 		,
        		 	</c:if>
        		 	
        		 	<c:set var="cnt" value="${cnt+1}" />
        		 </c:forEach>
        		]
    });
});
		</script>
	</head>
	<body>

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

	</body>
</html>
