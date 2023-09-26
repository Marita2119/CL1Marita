<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lista de Empleados</title>
<link rel="stylesheet" type="text/css" href="estilos.css">

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	margin: 0;
	padding: 0;
}

h1 {
	text-align: center;
	background-color: #007BFF;
	color: #fff;
	padding: 20px;
}

.tabla-empleados {
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
}

.tabla-empleados th, .tabla-empleados td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

.tabla-empleados th {
	background-color: #007BFF;
	color: #fff;
}

.tabla-empleados tr:nth-child(even) {
	background-color: #f2f2f2;
}

.tabla-empleados tr:hover {
	background-color: #ddd;
}

input[type="submit"] {
	background-color: #007BFF;
	outline: none;
	color: white;
}
</style>

</head>
<body>
	<h1>Lista de Empleados</h1>
	<table class="tabla-empleados">
		<thead>
			<tr>
				<th>ID</th>
				<th>Apellidos</th>
				<th>Nombres</th>
				<th>Edad</th>
				<th>Sexo</th>
				<th>Salario</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empleados}" var="empleado">
				<tr>
					<td>${empleado.getIdEmpleado()}</td>
					<td>${empleado.getApellidos()}</td>
					<td>${empleado.getNombres()}</td>
					<td>${empleado.getEdad()}</td>
					<td>${empleado.getSexo()}</td>
					<td>${empleado.getSalario()}</td>
					<td><input type="submit" value="Actualizar" name="accion">
						<input type="submit" value="Eliminar" name="accion"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
