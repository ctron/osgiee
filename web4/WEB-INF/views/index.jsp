<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h:main title="Spring Sample">

<p>Timestamp: ${timestamp }</p>

<p><a href="<c:url value="/form"></c:url>">Test Form</a></p>

</h:main>