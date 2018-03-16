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
	<form id="frm" method="post">
		<div>
			<span>id</span><input type="text" name="userId"/>
		</div>
		<div>
			<span>password</span><input type="password" name="password"/>
		</div>
		<div>
			<span>email</span><input type="text" name="email"/>
		</div>
		<div>
			<span>date</span><input type="text" name="createDate"/>
		</div>
	</form>
	<button id="voSubmit">vo submit</button>
	<button id="mapSubmit">map submit</button>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#voSubmit').on('click',function(){
				$.ajax({
					type: 'POST',  
					url: "/binder/voSubmitData",  
					data: $('#frm').serialize(),  
					success: function(data){
						alert('ajax 통신 성공');
					}
					, error : function(e){
						console.warn("ERROR");
					}
				});
				
			});
			
			$('#mapSubmit').on('click',function(){
				$.ajax({
					type: 'POST',  
					url: "/binder/mapSubmitData",  
					data: $('#frm').serialize(),
					contentType : "application/json; charset=UTF-8",
			        dataType: "json",
					success: function(data){
						alert('ajax 통신 성공');
					}
					, error : function(e){
						console.warn("ERROR");
					}
				});
				
			});
		});
	</script>
</body>
</html>