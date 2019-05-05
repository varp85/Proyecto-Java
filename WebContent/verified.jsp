<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css?family=Quattrocento"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah"
	rel="stylesheet">
<title>Página con formato HTML5</title>
<link href="estilo/estilo2N.css" rel="Stylesheet">
</head>
<body>
	<header>¡Gracias por registrarte!</header>

	<style type="text/css">
		#contenido2 {
    	margin: 0 auto;
    	text-align: center;
    	}
   		
   		button{
   		margin-top:100px;
   		margin-bottom:100px;
   		background-color: #555555;
   		padding: 15px 32px;
   		color: white;
   		border: none;
   		}
	</style>

	<div id="contenido2">
		<button id="button2" onclick="volver()">Volver</button>
	</div>

	<footer>@Contacta</footer>

	<script type="text/javascript">
		function volver() {
			window.location.href = "home.jsp";
		}
	</script>

</body>
</html>