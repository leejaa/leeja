<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<h3>메세지 작성</h3>
</div>
<div class="well row">
	<form action="/message/step03">
		<p>
			<b>받는사람</b><br /> <input type="text" id="receiver" class="form-control" name="receiver"/>
		</p>
		<p>
			<b>보낸사람</b><br /> <input type="text" id="id" class="form-control" name="id"/>
		</p>
		
		<p>
			<b>CONTENT</b><br/>
			<textarea rows="12" cols="60" name="content" class="form-control"></textarea>
		</p>
		<hr/>
		<p>
			<button type="submit" class="btn">작성하기</button>
		</p>
	</form>
</div>

