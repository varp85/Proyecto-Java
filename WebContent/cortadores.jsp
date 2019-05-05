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
	<header>¡Menos de un minuto!</header>
	
	<div id="contenido" class="tabla">
		
			<form action="Controlador" method="get">

				<table>
					<tr>
						<td width="50%"><label for="nombre">Nombre: </label></td>
						<td><input type="text" name="nombreC" id="nombre" required></td>
					</tr>
					<tr>
						<td><label for="dni">DNI: </label></td>
						<td><input type="text" name="dni" id="dni" required></td>
					</tr>
					<tr>
						<td><label for="apellido">E-mail: </label></td>
						<td><input type="text" name="emailC" id="apellido" required></td>
					</tr>
					<tr>
						<td><label for="telefono">Teléfono: </label></td>
						<td><input type="text" name="telefonoC" id="usuario" required></td>
					</tr>
					<tr>
						<td><label for="contra">Contraseña: </label></td>
						<td><input type="text" name="contraC" id="contra" required></td>
					</tr>
					<tr>
						<td><label for="precio">Precio/hora: </label></td>
						<td><input type="number" name="precioC" id="precio" required min=0></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							name="button" id="button" value="Enviar"></td>
					</tr>
				</table>
			</form>
	</div>
	<footer>@Contacta</footer>
</body>
</html>