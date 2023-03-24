<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>Professor confirmation</title>
</head>
<body>
	<h1>Professor confirmation</h1>
	<p>The professor is ${professor.firstName} ${professor.lastName}</p>
	<p>The cualification is ${professor.cualification}</p>
	<p>The posta code is ${professor.postalCode}</p>
	<p>The course is ${professor.courseCode}</p>
	
	<p>Click to <a href="/07-Spring-MVC-02">Index</a></p>
</body>
</html>