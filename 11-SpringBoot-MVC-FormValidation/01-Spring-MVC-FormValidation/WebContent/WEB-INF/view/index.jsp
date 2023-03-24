<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
    <script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
</head>
<body>
	<img alt="" src="${pageContext.request.contextPath}/resources/images/spring-logo.png">
	<h2>Spring MVC Demo - Home Page</h2>
	<p>Click to <a href="home/showForm">Controller</a></p>
	<p>Click to <a href="home/showForm2">Spring Model</a></p>
	<p>Click to <a href="home/showForm3">RequestParams</a></p>
	<p>Click to <a href="home/showForm">RequestMapping</a></p>
	<p>Click to <a href="student/showForm">Form tags</a></p>
	<p>Click to <a href="professor/showForm">Professor form</a></p>
</body>
</html>