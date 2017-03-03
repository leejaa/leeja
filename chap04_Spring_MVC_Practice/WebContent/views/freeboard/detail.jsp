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
}

table, td, th {
    border: 1px solid black;
}
</style>
</head>
<body>

<h2>Let the borders collapse:</h2>

<table align="center">
  <tr style="height: 50px;">
    <th style="width: 1000px;">${map.TITLE }</th>
  </tr>
  <tr style="height: 50px;">
    <th style="width: 1000px;">${map.WRITER }</th>
  </tr>
  <tr style="height: 100px;">
    <td style="width: 1000px">${map.CONTENT }</td>
  </tr>
  
</table>

<a href="/freeboard/step06">
<button type="button"> 좋아요 !</button></a>

<c:if test="${map.WRITER eq sessionScope.id }">
<a href="/freeboard/step07?num=${map.NUM}">
<button>글 수정하기</button>
</a>
</c:if>

</body>
</html>