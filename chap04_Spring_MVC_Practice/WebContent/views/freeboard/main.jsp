<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
	<h3>자유 게시판 </h3>
	${cnt } 개의 글이 존재합니다.
</div>
<div align="right">
	<a href="/freeboard/step03"><button type="button" class="btn">글작성</button></a>
</div>
<hr />
<c:forEach var="one" items="${list }">
	<div class="well">
		<h4><a href="/freeboard/step05?num=${one.NUM }">${one.TITLE}</a></h4>
		<p style="color: gray;">
			${one.get('CATEGORY')} ｜작성자 : ${one.WRITER} | 조회수:${one.VIEWCOUNT} 
			(추천:<span style="color: red;">${one.HITCOUNT}</span>)
		</p>
		<p>
				내용 : ${one.CONTENT}
				
		</p>
	</div>
</c:forEach>
<!-- 페이지 뷰 -->
<div align="center" class="well">
	<c:if test="${page ne 1 }">
		<a href="/freeboard/step02?page=${page -1 }">이전</a>
	</c:if>
	<c:forEach var="p" begin="1" end="${size }" varStatus="vs">
		<c:choose>
			<c:when test="${p eq page }">
				<b style="color: red;">${p }</b>
			</c:when>
			<c:otherwise>
				<a href="/freeboard/step02?page=${p }">${p }</a>
			</c:otherwise>
		</c:choose>
		<c:if test="${vs.last eq false }">|</c:if>
	</c:forEach>
	<c:if test="${page ne size }">
		<a href="/freeboard/step02?page=${page +1 }">다음</a>
	</c:if>
</div>