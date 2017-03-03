<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page trimDirectiveWhitespaces="true"%>
<html>
<head>
<style>
table {
    width:100%;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
   background-color:#fff;
}
table#t01 th {
    background-color: black;
    color: white;
}
</style>

</head>
<body>

<table>

<tr>
    <th>writer</th>
    <th>content</th> 
    <th>ip</th>
  </tr>
<c:forEach var="map" items="${requestScope.list}" varStatus="status">
	<tr>
    <td>${map.WRITER}</td>
    <td>${map.CONTENT}</td>
    <td>${map.IP}</td>
  </tr>
</c:forEach>
