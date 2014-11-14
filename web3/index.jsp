<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h:main title="JSTL Foo Bar">

<c:url var="url" value="/test" >
    <c:param name="Add" value="value1" />
</c:url>

<p>Value: ${url }</p>

</h:main>