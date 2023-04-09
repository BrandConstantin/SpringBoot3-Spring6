<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Home Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="Content-Type" content="text/html">
	
	<!-- Reference Bootstrap files -->
	<!-- 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	-->
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap/bootstrap.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script type="text/javascript" src="resources/js/bootstrap/bootstrap.js"></script>

</head>
<body>
	<h2>Welcome</h2>
	<p>This web is working</p>
	
	<form:form action="${pageContext.request.contextPath}/logout" 
	   method="POST" class="form-horizontal">
	   
	   <input type="submit" value="Logout" />
   	</form:form>
</body>
</html>