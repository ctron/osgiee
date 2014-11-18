<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h:main title="Main">

<table>

<tr><th>ID</th><th>Name</th></tr>

<c:forEach items="${books }" var="book">
<tr>
<td>${book.id }</td><td>${book.name }</td>
</tr>
</c:forEach>
</table>

<p>${books.size() } book(s) found</p>

<ul>
<li><a href="<c:url value="/setup"/>">Setup</a></li>
</ul>

</h:main>