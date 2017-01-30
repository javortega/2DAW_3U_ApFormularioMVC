<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ page import="formulario.vista.excepciones.ExcepcionAp" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="err" value="${requestScope.error}"/>

Se ha producido un error.<br>
El mensaje de la excepción es: <c:out value="${err.mensajeError}"/> <br>

<form action="controlador" method="post">

<input type="submit" value="Inicio">
</form>
</body>
</html>