<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@attribute name="title" required="true" %>
<!DOCTYPE html>
<html>

<head>
	<title><%=title %> | OSGi EE with Spring</title>
	
	<meta charset="UTF-8">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/default.css" />
</head>

<body>

<header>
<h1><%= title %></h1>
</header>

<section>

<div id="content">
<jsp:doBody/>
</div>

</section>

</body>

</html>