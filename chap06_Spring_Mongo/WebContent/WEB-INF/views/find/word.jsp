<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="/find/result">

<div align="center">
  단어입력 <br>
  <input type="text" name="word" >
  <br>
  <input type="submit" value="단어등록">
  
  </div>
  
</form>



<form action="/find/result2">

<div align="center">
  단어검색 <br>
  <input type="text" name="word" id="word" list="wordList">
  <p id="wordList">
  </p>
  <br>
  <input type="submit" value="단어검색">
  
  </div>
  
  <textarea rows="50" cols="50" id="test"></textarea>
</form>



<script>
	document.getElementById("word").onkeyup=function() {
			
			var start = document.getElementById("word").value;
		
			
			
			var xhr = new XMLHttpRequest();
				
			xhr.open("get", "/find/wordAjax?start="+start, true);
			xhr.send();
			xhr.onreadystatechange=function() {
				if(xhr.readyState==4&&xhr.status==200) {
					var obj = JSON.parse(xhr.responseText);
					var html = "";
					for(var i=0; i<obj.length; i++) {
						html += "<b>["+obj[i]._id+"]</b> ";
						html += obj[i].cnt+"<br/>";
					}
					document.getElementById("wordList").innerHTML = html;
					document.getElementById("test").innerHTML = html;
				}
			}
		
	}
	
	
</script>