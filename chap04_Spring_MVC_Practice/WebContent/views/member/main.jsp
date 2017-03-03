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
</head>
<body>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>


<div id="mcview" style="width: 300; height: 300">


</div>

<div id="mcview2" style="width: 300; height: 300">


</div>

<div id="mcview3" style="width: 300; height: 300">


</div>
<table>
  <tr style="border-color: navy;"> <h2 align="center">연령대별</h2> 
    <th>연령대</th>
    <th>사람수</th>
  </tr>
 <c:forEach var="map"  items="${list1}">
 	<tr>
	 	<th>${map.AGE_GROUP}대</th>
	    <th>${map.COUNT}명</th>
	 </tr>
 </c:forEach>
</table>
	<table>
	  <tr style="border-color: navy;"> <h2 align="center">남녀별</h2>
	    <th>성별</th>
	    <th>사람수</th>
	  </tr>
	 <c:forEach var="map" items="${list2}">
	 	<tr>
		 	<th>${map.GENDER}</th>
		    <th>${map.COUNT}명</th>
		 </tr>
	 </c:forEach>
	</table>
	
	<table>
	  <tr style="border-color: navy;"> <h2 align="center">연령별 로그인</h2>
	    <th>연령대</th>
	    <th>로그인횟수</th>
	  </tr>
	 <c:forEach var="map" items="${list3}">
	 	<tr>
		 	<th>${map.GENERATION}대</th>
		    <th>${map.AGE_LOGIN}회</th>
		 </tr>
	 </c:forEach>
	</table>
	
	<table>
	  <tr style="border-color: navy;"> <h2 align="center">성별 로그인</h2>
	    <th>성별</th>
	    <th>로그인횟수</th>
	  </tr>
	 <c:forEach var="map" items="${list4}">
	 	<tr>
		 	<th>${map.GENDER}</th>
		    <th>${map.GENDER_LOGIN}회</th>
		 </tr>
	 </c:forEach>
	</table>
	
<script>
 // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'gender');
        data.addColumn('number', '회원수');
        data.addRows([
        	
       <c:forEach var="map" items="${list2}" varStatus="vs">
          ['${map.GENDER}', ${map.COUNT}], <c:if test="!vs.last">,</c:if>
       </c:forEach>
        ]);

        // Set chart options
        var options = {'title':'회원분석',
                       'width':400,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('mcview'));
        chart.draw(data, options);
      }
      </script>
      
      
      
      <script>
 // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', '연령대');
        data.addColumn('number', '회원수');
        data.addRows([
        	<c:forEach var="map" items="${list1}" varStatus="vs">
            ['${map.AGE_GROUP}', ${map.COUNT}], 
         </c:forEach>
        ]);

        // Set chart options
        var options = {'title':'회원분석',
                       'width':400,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('mcview2'));
        chart.draw(data, options);
      }
      </script>
      
      
      
  <script>
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Year', 'Sales'],
          
          <c:forEach var="map" items="${list3}" varStatus="vs">
          		['map.GENERATION',  map.AGE_LOGIN],
          </c:forEach>
        ]);

        var options = {
          title: 'Company Performance',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('mcview3'));

        chart.draw(data, options);
      }
    </script>
    
    
   
    
    
    
    
    
    
    
</body>
</html>