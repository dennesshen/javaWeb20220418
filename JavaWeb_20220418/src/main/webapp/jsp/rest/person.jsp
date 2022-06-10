<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://unpkg.com/purecss@2.1.0/build/pure-min.css">
	<meta charset="UTF-8">
	<title>Person RestFul</title>
	<script>
		function loadDoc(method, locate) {
			
			  const xhttp = new XMLHttpRequest();
			  
			  //server回應接收
			  xhttp.onload = function(method, locate) {
				    document.getElementById("show").innerHTML = this.responseText;
			  };
			  
			  let ID = document.getElementById("ID").value;
			  let name = document.getElementById("name").value;
			  let age = document.getElementById("age").value;

			  let args = "id=" + ID + "&name=" + name + "&age=" + age;
			
			  switch(method){
				  case "GET":
					locate = locate + "?" + args;
					//開啟連線
					xhttp.open(method, locate, true); // 第三個參數為是否 非同步(true為非同步)
					break;

				  case "POST":
					//開啟連線
			  		xhttp.open(method, locate, true); // 第三個參數為是否 非同步(true為非同步)
					//xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
					break;

				  case "PUT":
					//開啟連線
			  		xhttp.open(method, locate, true); // 第三個參數為是否 非同步(true為非同步)
					break;

				  case "DELETE":
					//開啟連線
			  		xhttp.open(method, locate, true); // 第三個參數為是否 非同步(true為非同步)

					break;
			  }

			  //傳送
			  xhttp.send(args);
			}
	</script>
</head>
<body style="padding: 20px">
	<form class="pure-form">
		<fieldset>
			<legend>Person Form</legend>
			<table>
				<tr>
					<td align="right">ID:</td>
					<td> 
						<input type="number" id="ID" name="ID" value="1" >
					</td>
				</tr>
				<tr>
					<td align="right">name:</td>
					<td> 
						<input type="text" id="name" name="name" value="John" >
					</td>
				</tr>
				<tr>
					<td align="right">age:</td>
					<td> 
						<input type="number" id="age" name="age" value="18" >
					</td>
				</tr>
			</table>
		</fieldset>
		<button type="button" 
				onclick="loadDoc('GET', '/JavaWeb_20220418/rest/person')"
				class="pure-button pure-button-primary">
				GET
		</button>
		<button type="button" 
				onclick="loadDoc('POST', '/JavaWeb_20220418/rest/person')"
				class="pure-button pure-button-primary">
				POST
		</button>
		<button type="button" 
				onclick="loadDoc('DELETE', '/JavaWeb_20220418/rest/person/1')"
				class="pure-button pure-button-primary">
				DELETE
		</button>
		<button type="button"
				onclick="loadDoc('PUT', '/JavaWeb_20220418/rest/person/1')"
				class="pure-button pure-button-primary">
				PUT
		</button>
	</form><p/>
	
	<pre>
		<div id="show"></div>
	</pre>
</body>
</html>