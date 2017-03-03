<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="text-align: right; background-color: #FAF4C0">
	<a href="/"><button type="button" class="btn">INDEX</button></a>
	<a href="/review/step01"><button type="button" class="btn">REVIEW</button></a>
		<c:choose>
			<c:when test="${sessionScope.id eq null }">
				<a href="/views/login/login.jsp"><button type="button" class="btn">LOG IN</button></a>
			</c:when>
			<c:otherwise>
		
			<a href="/login/step03"><button type="button" class="btn">LOG OUT</button></a>
			</c:otherwise>
		</c:choose>
			
			<a href="/freeboard/step01"><button type="button" class="btn">FREEBOARD</button></a>
			<a href="/chat/open"><button class="btn" id="chat">CHAT</button></a>
			<a href="/message/step01"><button type="button" class="btn">MESSAGE</button></a>
			<a href="/share/form"><button type="button" class="btn">업로드/다운로드</button></a>
			<a href="/member/step01"><button type="button" class="btn">멤버 데이터</button></a>
			
</div>















