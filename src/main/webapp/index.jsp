<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL - Hello World</title>

</head>
<body>
<c:set var ="flag" value="${flag}"/>
<c:if test="${isVisible=flag}">
    <p>Visible</p>
</c:if>

<c:if test="${isVisible=false}">
    <p>Invisible</p>
</c:if>
</body>
</html>