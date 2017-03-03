<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.id eq null }">
<script>
	window.alert("로그인이 필요합니다.");
	window.close();
</script>
</c:if>
<html>
<head>
<title>CHAT - Wep Apps</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="well" id="result"
			style="height: 83%; overflow-y: scroll; margin-top: 20px;"></div>
		<div>
			<input type="text" class="form-control" id="msg" placeholder="남길내용" />
		</div>
	</div>
</body>
</html>
<script>
	document.getElementById("msg").onkeyup=function(e) {
		if(e.key=='Enter') {
			var xhr = new XMLHttpRequest();
				
				xhr.open("get", "/chat/chatAjax?msg="+this.value,true);
				xhr.send();
			this.value ="";
		}
	}
	
	function getChatLog() {
		var xhr =new XMLHttpRequest();
			xhr.open("get", "/chat/logAjax", true);
			xhr.send();
			xhr.onreadystatechange=function() {
				if(xhr.readyState==4&&xhr.status==200) {
					var obj = JSON.parse(xhr.responseText);
					var html = "";
					for(var i=0; i<obj.length; i++) {
						html += "<b>["+obj[i].id+"]</b> ";
						html += obj[i].msg+"<br/>";
					}
					document.getElementById("result").innerHTML = html;
					document.getElementById("result").scrollTop = document.getElementById("result").scrollHeight;
				}
			}
	}
	setInterval(getChatLog, 200 );
</script>









