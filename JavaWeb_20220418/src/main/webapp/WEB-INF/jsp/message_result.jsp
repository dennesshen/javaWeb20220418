<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message Result</title>
</head>
<body style="padding: 20px">
	<form action="/JavaWeb_20220418/html/message_form.html" class="pure-form">
		<fieldset>
			<legend>Message Result</legend>
			訊息內容 : ${content} <p/>
			回應碼(HttpCode) : ${httpCode}<p/>
			<button type="submit" class="pure-button pure-button-primary">返回</button> 
		</fieldset>
	</form>

</body>
</html>