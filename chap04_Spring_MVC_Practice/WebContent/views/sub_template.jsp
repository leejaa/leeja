<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<div class="row">
	<div class="col-md-3" style="background: #FAF4C0">
		<tiles:insertAttribute name="left"/>
	</div>
	<div class="col-md-9" >
		<tiles:insertAttribute name="right"/>
	</div>
</div>