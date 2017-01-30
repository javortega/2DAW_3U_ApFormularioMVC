<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Presentación</title>
</head>
<body>
<c:choose>
<c:when test="${requestScope.inicio==null}">

<form action="controlador">
<input type="hidden" name="accion" value="general">
<input type="submit" value="Info">
</form>
<form action="controlador">
<input type="hidden" name="accion" value="index">
<input type="submit" value="Login">
</form>
</c:when>
<c:otherwise>
<form action="controlador">
<h5>Iniciar sesión</h5>
<fieldset>

${requestScope.validacion==null? "":"Los campos no deben estar vacíos"}
<br>
<input type="hidden" name="accion" value="loguear">
<label>Su login:</label><br>
<input type="text" name="login" required="required" ><br>
<label>Su clave:</label><br>
<input type="text" name="clave" required="required" ><br>
<input type="submit" value="Login">
</fieldset>
</form>

</c:otherwise>
</c:choose>
<%if(!session.isNew()){ %>
<h5>Formulario de registro</h5>
<form action="controlador" method="post">
<fieldset>
<input type="hidden" name="accion" value="registrar">
<label>Su login:</label><br>
<input type="text" name="login" required="required" ><br>
<label>Su clave:</label><br>
<input type="text" name="clave" required="required" ><br>
<input type="submit" value="Registrarse">
</fieldset>
</form>
<%} %>
</body>
</html>