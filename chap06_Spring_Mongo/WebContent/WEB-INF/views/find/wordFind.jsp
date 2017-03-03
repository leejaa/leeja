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
    outline-style: groove;
    outline-color: fuchsia;
    
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
    outline-style: groove;
    outline-color: fuchsia;
}

tr:hover{background-color:#f5f5f5}
</style>
</head>
<body>
<table>
  <tr>
  	<th>단어명</th>
    <th>횟수</th>
  </tr>
 <c:forEach var="map" items="${list }">
 	<tr>
 		<th>${map._id }</th>
	 	<th>${map.cnt }</th>
	 </tr>
 </c:forEach>
</table>
</body>
</html>