<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form</title>
</head>
<body>
	<form action="/binder/submitData">
		<input type="text" name="userId"/>
		<input type="password" name="password"/>
		<input type="text" name="email"/>
		<input type="text" name="createDate"/>
	</form>
	<button>submit</button>
</body>
</html>