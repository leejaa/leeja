<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover{background-color:#f5f5f5}
</style>


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['혈액형', '사람수'],
         
          <c:forEach var="map" items="${list1}" varStatus="vs">
          ['${map._id}', ${map.cnt}], <c:if test="!vs.last">,</c:if>
       </c:forEach>
          
        
        ]);

        var options = {
          title: '천주교',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('mcview1'));
        chart.draw(data, options);
      }
    </script>
    
    
    
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['혈액형', '사람수'],
         
          <c:forEach var="map" items="${list2}" varStatus="vs">
          ['${map._id}', ${map.cnt}], <c:if test="!vs.last">,</c:if>
       </c:forEach>
          
        
        ]);

        var options = {
          title: '기독교',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('mcview2'));
        chart.draw(data, options);
      }
    </script>
    
    
    
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['혈액형', '사람수'],
         
          <c:forEach var="map" items="${list3}" varStatus="vs">
          ['${map._id}', ${map.cnt}], <c:if test="!vs.last">,</c:if>
       </c:forEach>
          
        
        ]);

        var options = {
          title: '불교',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('mcview3'));
        chart.draw(data, options);
      }
    </script>
    
    
    
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['혈액형', '사람수'],
         
          <c:forEach var="map" items="${list4}" varStatus="vs">
          ['${map._id}', ${map.cnt}], <c:if test="!vs.last">,</c:if>
       </c:forEach>
          
        
        ]);

        var options = {
          title: '기타교',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('mcview4'));
        chart.draw(data, options);
      }
    </script>
    
    
    
     <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['혈액형', '사람수'],
         
          <c:forEach var="map" items="${list5}" varStatus="vs">
          ['${map._id}', ${map.cnt}], <c:if test="!vs.last">,</c:if>
       </c:forEach>
          
        
        ]);

        var options = {
          title: '무교',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('mcview5'));
        chart.draw(data, options);
      }
    </script>


</head>
<body>


<div id="mcview1" style="width: 300; height: 300">


</div>

<div id="mcview2" style="width: 300; height: 300">


</div>

<div id="mcview3" style="width: 300; height: 300">


</div>



<div id="mcview4" style="width: 300; height: 300">


</div>



<div id="mcview5" style="width: 300; height: 300">


</div>


<table>
  <tr style="border-color: navy;"> <h2 align="center">천주교</h2> 
       <th>혈액형</th>
       <th>cnt</th>
    
  </tr>
 <c:forEach var="map"  items="${list1}">
 	<tr>
	 	<th>${map._id}</th>
	 	<th>${map.cnt}</th>
	   	    
	 </tr>
 </c:forEach>
</table>

<table>
  <tr style="border-color: navy;"> <h2 align="center">기독교</h2> 
       <th>혈액형</th>
       <th>cnt</th>
    
  </tr>
 <c:forEach var="map"  items="${list2}">
 	<tr>
	 <th>${map._id}</th>
	 	<th>${map.cnt}</th>
	   	    
	 </tr>
 </c:forEach>
</table>


<table>
  <tr style="border-color: navy;"> <h2 align="center">불교</h2> 
       <th>혈액형</th>
       <th>cnt</th>
    
  </tr>
 <c:forEach var="map"  items="${list3}">
 	<tr>
	 	<th>${map._id}</th>
	 	<th>${map.cnt}</th>
	   	    
	 </tr>
 </c:forEach>
</table>

<table>
  <tr style="border-color: navy;"> <h2 align="center">기타교</h2> 
       <th>혈액형</th>
       <th>cnt</th>
    
  </tr>
 <c:forEach var="map"  items="${list4}">
 	<tr>
	 	<th>${map._id}</th>
	 	<th>${map.cnt}</th>
	   	    
	 </tr>
 </c:forEach>
</table>



<table>
  <tr style="border-color: navy;"> <h2 align="center">무교</h2> 
       <th>혈액형</th>
       <th>cnt</th>
    
  </tr>
 <c:forEach var="map"  items="${list5}">
 	<tr>
	 	<th>${map._id}</th>
	 	<th>${map.cnt}</th>
	   	    
	 </tr>
 </c:forEach>
</table>
	
	  
    
    
    
</body>
</html>