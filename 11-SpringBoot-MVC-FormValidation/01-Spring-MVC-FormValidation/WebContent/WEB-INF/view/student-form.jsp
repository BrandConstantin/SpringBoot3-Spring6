<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<title>Form</title>
</head>
<body>
	<h1>Form:</h1>
	<form:form action="processForm" modelAttribute="student">
		Fist name <form:input path="firstName"/>
		Second name <form:input path="lastName"/>
		<br><br>
		Country: 
		<form:select path="country">
			<form:options items="${student.countryOptions}"/>
		</form:select>
		<br><br>
		Favorite language:
		<form:radiobuttons path="language" items="${student.languageOptions}"/>
		<br><br>
		OS:
		Linux<form:checkbox path="os" value="Linux"/>
		Mac<form:checkbox path="os" value="Mac"/>
		Windows<form:checkbox path="os" value="Windows"/>
		<br><br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>