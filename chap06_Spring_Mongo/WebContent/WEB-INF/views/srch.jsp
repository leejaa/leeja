<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>상세 검색</h3>
<form action="/quiz/search/result" method="get">
	성별 : <input type="checkbox" name="gender" value="male"/>남
			<input type="checkbox" name="gender" value="female"/>여
	<hr/>
	성향 : <input type="checkbox" name="taste" value="진보"/>진보
		<input type="checkbox" name="taste" value="중도"/>중도
		<input type="checkbox" name="taste" value="보수"/>보수	
	
	<hr/>
	<button type="submit">검색</button>
</form>