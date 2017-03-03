<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Season', '${list1(0)._id}', '${list1(1)._id}','${list1(2)._id}','${list1(3)._id}','${list1(4)._id}'],
         
          
          ['봄',  ${list1(0).cnt},   ${list1(1).cnt},${list1(2).cnt},${list1(3).cnt},${list1(4).cnt}],
          ['여름', ${list2(0).cnt},${list2(1).cnt},${list2(2).cnt},${list2(3).cnt},${list2(4).cnt}],
          ['가을',  ${list3(0).cnt},${list3(1).cnt},${list3(2).cnt},${list3(3).cnt},${list3(4).cnt}],
          ['겨울',  ${list4(0).cnt},${list4(1).cnt},${list4(2).cnt},${list4(3).cnt},${list4(4).cnt}]
          
          
          
        ]);

        var options = {
          title: 'Company Performance',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('mcview1'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
  
    <div id="mcview1" style="width: 900px; height: 500px"></div>
    
  </body>
  
</html>