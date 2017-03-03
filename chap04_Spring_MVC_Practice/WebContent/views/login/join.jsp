<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<h3>기본정보 입력</h3>
</div>
<div class="well">
	
	<form action="/login/step02" method="post">
		<p>
			<b>ID</b><span id="chkResult" ></span><br/>
			<input type="text" class="form-control" name="id" id="id"/>
		</p>
		<p>
			<b>PASS</b><br/>
			<input type="password" class="form-control" name="pass" id="pass"/>
		</p>
		<p>
			<b>NAME</b><br/>
			<input type="text" class="form-control" name="name"/>
		</p>
		<p>
			<b>AGE</b><br/>
			<select class="form-control" name="age">
				<%for(int i=19; i<=80; i++){ %>
					<option value="<%=i%>"><%=i %>세</option>
				<%} %>
			</select>
		</p>
		<p>
			<b>GENDER</b><br/>
			<select name="gender" class="form-control">
				<option value="male">남</option>
				<option value="female">여</option>
			</select> 
		</p>
		<p>
			<b>E-MAIL</b><br/>
			<input type="email" class="form-control" name="email"/>
		</p>
		<p>
			<button type="submit" class="btn">등록하기</button>
		</p>
		
	</form>
</div>




