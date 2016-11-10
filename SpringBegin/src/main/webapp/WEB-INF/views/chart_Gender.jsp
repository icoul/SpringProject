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
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: '직원통계 (성별)'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            name: '성별 구성비율',
            colorByPoint: true,
            data: [{
                name: '남자',
                y: Number(dataArr[0]) // Number 함수를 써야 나온다.
            }, {
                name: '여자',
                y: Number(dataArr[1]),
                sliced: true,
                selected: true
            }]
        }]
    });
});
		</script>
	</head>
	<body>
		<div>
			<table align = "center" style = "border-collapse: collapse;">
				<thead>
					<tr style = "height: 30px; background-color : lightgrey;">
						<th style = "width : 80px; border : solid 1px black;">성별</th>
						<th style = "width : 120px; border : solid 1px black;">인원수</th>
						<th style = "width : 120px; border : solid 1px black;">비율(%)</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${list}" varStatus = "status">
						<c:if test="${status.index == 2 }">
							<tr align = "center" style = "height: 30px; font-weight : bold; background-color : yellow;">
								<td style = "border : solid 1px black;">${list.gender}</td>
								<td style = "border : solid 1px black;">${list.cnt}</td>
								<td style = "border : solid 1px black;">${list.percent}</td>
							</tr>	
						</c:if>
						<c:if test="${status.index != 2 }">
							<tr align = "center" style = "height: 30px;">
								<td style = "border : solid 1px black;">${list.gender}</td>
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
		<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>

	</body>
</html>
