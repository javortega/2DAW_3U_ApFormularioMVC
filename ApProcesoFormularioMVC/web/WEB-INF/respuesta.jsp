<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Respuesta</title>
</head>
<body>
<c:set var="usr" value="${requestScope.modelo}" scope="page"/>
<h3>Sus datos:</h3>
<c:out value="${modelo.login}"/><br>
<c:out value="${modelo.clave}"/>
<form action="controlador" method="post">
<input type="submit" value="Inicio"/>
<%session.invalidate(); %>
</form>
</body>
</html>