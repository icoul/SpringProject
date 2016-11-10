<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
		<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/jquery-2.0.0.js"></script>
		<script src="<%= request.getContextPath() %>/resources/js/highcharts.js"></script>
		<script src="<%= request.getContextPath() %>/resources/js/modules/exporting.js"></script>

		<style type="text/css">
${demo.css}
		</style>
		<script type="text/javascript">
$(function () {

	var dataArr = new Array(); // 자바스크립트에서 배열을 선언하는 것
	
	<c:forEach var="list" items="${list}" varStatus="status">
		dataArr.push("${list.percent}"); //배열속에 값을 넣어주는것
	</c:forEach>
	
	$('#container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '직원통계(부서별)'
        },
        subtitle: {
            text: 'Source: employees'
        },
        xAxis: {
            type: 'category',
            labels: {
                rotation: -45,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: '부서인원수(명)'
            }
        },
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: '부서인원수: <b>{point.y:.0f} 명</b>'
        },
        series: [{
            name: 'Population',
            data: [
                ['10번부서', parseInt(dataArr[0])],
                ['20번부서', parseInt(dataArr[1])],
                ['30번부서', parseInt(dataArr[2])],
                ['40번부서', parseInt(dataArr[3])],
                ['50번부서', parseInt(dataArr[4])],
                ['60번부서', parseInt(dataArr[5])],
                ['70번부서', parseInt(dataArr[6])],
                ['80번부서', parseInt(dataArr[7])],
                ['90번부서', parseInt(dataArr[8])],
                ['100번부서', parseInt(dataArr[9])],
                ['110번부서', parseInt(dataArr[10])],
                ['부서없음', parseInt(dataArr[11])]
            ],
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                format: '{point.y:.0f}', // one decimal
                y: 10, // 10 pixels down from the top
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        }]
    });
});
		</script>
	</head>
	<body>
		<c:set var="size" value="${list.size()}" />
		<div>
			<table align = "center" style = "border-collapse: collapse;">
				<thead>
					<tr style = "height: 30px; background-color : lightgrey;">
						<th style = "width : 80px; border : solid 1px black;">부서번호</th>
						<th style = "width : 120px; border : solid 1px black;">인원수</th>
						<th style = "width : 120px; border : solid 1px black;">비율(%)</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${list}" varStatus = "status">
						<c:if test="${status.count == size }">
							<tr align = "center" style = "height: 30px; font-weight : bold; background-color : yellow;">
								<td style = "border : solid 1px black;">${list.deptno}</td>
								<td style = "border : solid 1px black;">${list.cnt}</td>
								<td style = "border : solid 1px black;">${list.percent}</td>
							</tr>	
						</c:if>
						<c:if test="${status.count != size }">
							<tr align = "center" style = "height: 30px;">
								<td style = "border : solid 1px black;">${list.deptno}</td>
								<td style = "border : solid 1px black;">${list.cnt}</td>
								<td style = "border : solid 1px black;">${list.percent}</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</br>
		</br>
		</br>
		<div id="container" style="min-width: 300px; height: 400px; margin: 0 auto"></div>
	</body>
</html>
