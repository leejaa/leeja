<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

<form action="/review/addNew">
  <fieldset>
    <legend>리뷰 작성</legend>
    	작성자:<br>
    <input type="text" name="writer" >
    <br>
     	내용:<br>
    <input type="text" name="content" >
    <br><br>
    	IP:<br>
    <input type="text" name="ip" value="${requestScope.ip}">
    <br><br>
    <input type="submit" value="Submit">
  </fieldset>
</form>

</body>
</html>
