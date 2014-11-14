<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@attribute name="title" required="true" %>
<!DOCTYPE html>
<html>

<head>
	<title><%=title %> | OSGi EE</title>
	
	<meta charset="UTF-8">
</head>

<body>

<header>
<h1><%= title %></h1>
</header>

<section>

<div id="content" class="content pure-u-1">
<jsp:doBody/>
</div>

</section>

</body>

</html>