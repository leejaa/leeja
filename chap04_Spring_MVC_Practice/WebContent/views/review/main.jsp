<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>리뷰</title>
</head>
<body>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<h3>평가하기 </h3>
		
		<p class="form-inline">
			<input type="text" class="form-control" id="writer" placeholder="작성자" />
		</p>
		<p>
			<textarea rows="3" cols="83" id="content" class="form-control"
				placeholder="남길 내용"></textarea>
		</p>
		<p style="text-align: right; font-size: 14px;">
			
			<button type="submit" id="send" class="btn">작성하기</button>
		</p>
		<p>
		<span id="review"></span>
		</p>
	</div>
</div>

</body>



</html>

<script>
	document.getElementById("send").onclick=function() {
			
		var content = document.getElementById("content").value;
			console.log(content);
			
			var writer = document.getElementById("writer").value;
			
			var xhr = new XMLHttpRequest();
				xhr.open("get", "/review/step02?writer="+writer+"&content="+content,true);
				xhr.send();
			document.getElementById("content").value="";	
	
}
	
	function getReview(){
		var xhr =new XMLHttpRequest();
		xhr.open("get", "/review/reviewAjax", true);
		xhr.send();
		xhr.onreadystatechange=function() {
			if(xhr.readyState==4&&xhr.status==200) {
				var obj = JSON.parse(xhr.responseText);
				var html = "";
				for(var i=0; i<obj.length; i++) {
					html += "<b>["+obj[i].WRITER+"]</b> ";
					html += obj[i].CONTENT+"/    "+obj[i].WRITEDATE+"/     "+obj[i].IP+"<br/>";
				}
				document.getElementById("review").innerHTML = html;
			}
		}
}
	
	setInterval(getReview, 100 );
	
</script>
