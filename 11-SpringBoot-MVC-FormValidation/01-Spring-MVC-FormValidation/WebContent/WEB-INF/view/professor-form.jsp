<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head></head>
<style>.error{color:red;}</style>

<body>
	<h2>Spring MVC Demo - Form Page</h2>
	
	<form:form action="processForm" modelAttribute="professor" >
		First name(*):
		<form:input placeholder="What's your name?" path="firstName" />
		<form:errors path="firstName" cssClass="error"/>
		Last name(*):
		<form:input placeholder="What's your surname?" path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
		<br><br>
		Cualification:
		<form:input path="cualification"/>
		<form:errors path="cualification" cssClass="error"/>
		<br><br>
		Postal Code:
		<form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/>
		<br><br>
		Course Code:
		<form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"/>
		<br><br>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>