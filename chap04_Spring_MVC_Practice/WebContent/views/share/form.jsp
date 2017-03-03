<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2>자료등록</h2>
<hr/>
<form action="/share/proc" method="post" enctype="multipart/form-data">
	파일 : <input type="file" name="item"/><br/>
	설명 : <input type="text" name="info"/>
	<button type="submit">등록..</button> 
	
</form>

<a href="/share/goList"><button>리스트 보기</button></a>