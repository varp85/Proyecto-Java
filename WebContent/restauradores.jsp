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

		<form action="Controlador" method="post" >

			<table>
				<tr>
					<td width="50%"><label for="nombre">Nombre/Empresa: </label></td>
					<td><input type="text" name="nombre" id="nombre"></td>
				</tr>
				<tr>
					<td><label for="cif">CIF/DNI: </label></td>
					<td><input type="text" name="cif" id="cif"></td>
				</tr>
				<tr>
					<td><label for="email">E-mail: </label></td>
					<td><input type="text" name="email" id="email"></td>
				</tr>
				<tr>
					<td><label for="contra">Contraseña: </label></td>
					<td><input type="text" name="contra" id="contra"></td>
				</tr>
				<tr>
					<td><label for="telefono">Teléfono: </label></td>
					<td><input type="text" name="telefono" id="telefono"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="button" id="button" value="Enviar"></td>
				</tr>
			</table>
		</form>
	</div>

	<footer>@Contrata</footer>
</body>
</html>