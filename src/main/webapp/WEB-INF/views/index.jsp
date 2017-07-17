<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="../js/jquery.cookie.js"></script>
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	/* var id=$.cookie('JSESSIONID');
	console.log($.cookie('localhost')); */
	$.cookie("test",123,{
		httponly:true
	});
	
	alert(document.cookie);
</script>
</body>
</html>