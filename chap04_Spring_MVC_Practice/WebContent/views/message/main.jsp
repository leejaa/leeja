<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<c:forEach var="one" items="${list }">
	<div class="well">
		<h4>${one.ID}</h4>
		
		<p>
				내용 : ${one.CONTENT}
				
		</p>
		<h3>받는사람 : ${one.RECEIVER }</h3></br>
		<h4>쓴 날짜 : ${one.WRITEDATE }</h4>
		
	</div>
	<hr>
</c:forEach>

<a href="/message/step02">
<button>메세지보내기</button>
</a>
