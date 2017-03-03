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
<table>
  <tr>
    <th>NUM</th>
    <th>TITLE</th>
    <th>FILENAME</th>
    <th>FILESIZE</th>
    <th>FILEADDRESS</th>
    <th>FILELINK</th>
    <th>다운로드 횟수</th>
  </tr>
 <c:forEach var="map" items="${list }">
 	<tr>
	 	<th>${map.NUM }</th>
	    <th><a href="/share/down?num=${map.NUM}">${map.TITLE }</a></th>
	    <th>${map.FILENAME }</th>
	    <th>${map.FILESIZE }</th>
	    <th>${map.FILEADDRESS }</th>
	    <th>${map.FILELINK }</th>
	     <th>${map.COUNT }</th>
	 </tr>
 </c:forEach>
</table>
</body>
</html>