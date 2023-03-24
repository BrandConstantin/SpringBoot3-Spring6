<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>Student confirmation</title>
</head>
<body>
	<h1>Student confirmation</h1>
	<p>The student is ${student.firstName} ${student.lastName}</p>
	<p>The student country is ${student.country}</p>
	<p>The student like ${student.language} and operating with: </p>
	<ul>
		<c:forEach var="temp" items="${student.os}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
</body>
</html>