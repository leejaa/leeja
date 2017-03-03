<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<h3>게시글작성</h3>
</div>
<div class="well row">
	<form action="/freeboard/step04">
		<p>
			<b>TITLE</b><br /> <input type="text" class="form-control" name="title"/>
		</p>
		<p>
			<b>CATEGORY</b><br /> 
			<select class="form-control" name="category">
				<option value="free">잡담하기</option>
				<option value="help">도움요청</option>
				<option value="info">정보공유</option>
			</select>
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


