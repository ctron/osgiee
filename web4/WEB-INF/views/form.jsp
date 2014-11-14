<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h:main title="Form Sample">

<form:form action="" method="POST">

<table>

<tr>
<th><form:label path="name">Name (*):</form:label></th>
<td><form:input path="name"/></td>
<td><form:errors path="name" cssClass="error"/>
</tr>

</table>

<div class="note box">
Fields marked with (*) are required.
</div>

<br/>

<input type="submit" value="Submit">
<input type="reset" value="Reset">

</form:form>

</h:main>