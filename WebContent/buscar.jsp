<%@page import="datos.LogicaBDCortadores"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css?family=Quattrocento" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah" rel="stylesheet">
<title>Página con formato HTML5</title>
<link href="estilo/estilo1V.css" rel="Stylesheet">
</head>
<body><%ServletContext contextoAplicacion = this.getServletContext();
		LogicaBDCortadores ldb = (LogicaBDCortadores) contextoAplicacion.getAttribute("LDB"); 
		%>



	<header>Tu Cortador de Jamón</header>
	
	<div id="contenido" class="tabla">
	
	<p><%=ldb.tablaCortador()%></p>
		
		
	</div>
	<footer># opina</footer>
</body>
</html>