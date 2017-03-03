<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<h3>로그인</h3>
</div>
<div class="well">
	<form action="/login/step01" method="post">
		<p>
			<b>ID</b>
			<br/>
			<input type="text" class="form-control" name="id"/>
		</p>
		<p>
			<b>PASS</b><br/>
			<input type="password" class="form-control" name="pass"/>
		</p>
		<p>
			<input type="checkbox" name="keep" />로그인 유지&nbsp;&nbsp;&nbsp;
			<button type="submit" class="btn">로그인</button>
		</p>
	</form>
	<a href="/views/login/join.jsp">회원가입할래?</a>
</div>