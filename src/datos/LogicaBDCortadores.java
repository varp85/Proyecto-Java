package datos;

import java.sql.*;

public class LogicaBDCortadores {

	private String mensaje;
	private Connection con;// A connection (session) with a specific database.
	// SQL statements are executed and results are returned within the context of a
	// connection.

	public LogicaBDCortadores() { // Establish a connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			mensaje = "Se ha cargado el Driver de MySQL";
		} catch (ClassNotFoundException e) {
			mensaje = "No ha podido cargar el driver\n" + e.getMessage();
			return;
		}
		System.out.println(mensaje);
		String cadenaConexion = "jdbc:mysql://localhost:3306/CORTADORES?serverTimezone=UTC";
		String user = "root";
		String pass = "curso";

		try {
			con = DriverManager.getConnection(cadenaConexion, user, pass);	// Attempts to establish a connection to the
																			// database URL
			mensaje = "Conexión establecida a la BD CORTADORES";
		} catch (SQLException e) {
			mensaje = "No ha podido conectar a la BD\n" + e.getMessage();
		}

		System.out.println(mensaje);
	}

	@Override
	public String toString() {
		return "LogicaBD [mensaje=" + mensaje + "]";
	}

	// MOSTRAR TODAS LAS TABLAS

	public String tablaCortador() {
		Statement sentencia;
		String salida = "<table>";
		try {
			sentencia = con.createStatement();// Creates a Statement object for sending SQL statements to the database.
			ResultSet rs = sentencia.executeQuery("SELECT * FROM CORTADOR");// A table of data representing a database
																			// result set.
			while (rs.next()) {
				salida = salida + "<tr>";
				salida = salida + "<td>" + rs.getString("DNI") + "</td>";
				salida = salida + "<td>" + rs.getString("NOMBRE") + "</td>";
				salida = salida + "<td>" + rs.getString("EMAIL") + "</td>";
				salida = salida + "<td>" + rs.getString("TELEFONO") + "</td>";
				salida = salida + "<td>" + rs.getInt("PRECIO") + "</td>";
				salida = salida + "</tr>";
			}
			salida = salida + "</table>";
			this.mensaje = "Hemos obtenido la tabla de cortadores";
			return salida;
		} catch (SQLException e) {
			this.mensaje = "No se ha podido cerrar la BD\n" + e.getMessage();
			return this.mensaje;
		}
	}

	public ResultSet tablaCortadorRS() {
		Statement sentencia;
		try {
			sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM CORTADOR");
			this.mensaje = "Hemos obtenido los datos de los cortadores";
			return rs;
		} catch (SQLException e) {
			this.mensaje = "No se ha podido cerrar la BD\n" + e.getMessage();
			return null;
		}
	}

	public String tablaEmpresas() {
		Statement sentencia;
		String salida = "<table>";
		try {
			sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM EMPRESA");

			while (rs.next()) {
				salida = salida + "<tr>";
				salida = salida + "<td>" + rs.getString("CIF") + "</td>";
				salida = salida + "<td>" + rs.getString("EMPRESA") + "</td>";
				salida = salida + "<td>" + rs.getString("EMAIL") + "</td>";
				salida = salida + "<td>" + rs.getString("TELEFONO") + "</td>";
				salida = salida + "</tr>";
			}
			salida = salida + "</table>";
			this.mensaje = "Hemos obtenido la tabla de empresas";
			return salida;
		} catch (SQLException e) {
			this.mensaje = "No se ha podido cerrar la BD\n" + e.getMessage();
			return this.mensaje;
		}
	}

	public ResultSet tablaEmpresaRS() {
		Statement sentencia;
		try {
			sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM EMPRESA");
			this.mensaje = "Hemos obtenido los datos de las Empresas";
			return rs;
		} catch (SQLException e) {
			this.mensaje = "No se ha podido cerrar la BD\n" + e.getMessage();
			return null;
		}
	}

	public String tablaValoracion() {
		Statement sentencia;
		String salida = "<table>";
		try {
			sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM VALORACION");

			while (rs.next()) {
				salida = salida + "<tr>";
				salida = salida + "<td>" + rs.getInt("ID") + "</td>";
				salida = salida + "<td>" + rs.getString("CIF") + "</td>";
				salida = salida + "<td>" + rs.getString("DNI") + "</td>";
				salida = salida + "<td>" + rs.getInt("PUNTUACION") + "</td>";
				salida = salida + "<td>" + rs.getString("COMENTARIO") + "</td>";
				salida = salida + "</tr>";
			}
			salida = salida + "</table>";
			this.mensaje = "Hemos obtenido la tabla de las valoraciones";
			return salida;
		} catch (SQLException e) {
			this.mensaje = "No se ha podido cerrar la BD\n" + e.getMessage();
			return this.mensaje;
		}
	}

	public ResultSet tablaValoracionRS() {
		Statement sentencia;
		try {
			sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM VALORACION");
			this.mensaje = "Hemos obtenido los datos de las valoraciones";
			return rs;
		} catch (SQLException e) {
			this.mensaje = "No se ha podido cerrar la BD\n" + e.getMessage();
			return null;
		}
	}

	// MOSTRAR UN ELEMENTO

	public String unCortador(String nombre) {
		String salida = "<table>";

		try {

			String Query = "SELECT * FROM CORTADOR WHERE NOMBRE = ?";
			PreparedStatement preparedstatement = con.prepareStatement(Query);
			preparedstatement.setString(1, nombre);
			ResultSet rs = preparedstatement.executeQuery();
			boolean existe = rs.next();
			if (existe) {
				salida = salida + "<tr>";
				salida = salida + "<td>" + rs.getString("DNI") + "</td>";
				salida = salida + "<td>" + rs.getString("NOMBRE") + "</td>";
				salida = salida + "<td>" + rs.getString("EMAIL") + "</td>";
				salida = salida + "<td>" + rs.getString("TELEFONO") + "</td>";
				salida = salida + "<td>" + rs.getDouble("PRECIO") + "</td>";
				salida = salida + "</tr>";
				salida = salida + "</table>";
				this.mensaje = "Hemos obtenido los datos del cortador";
				return salida;
			} else {
				return "No existe el cortador buscado";
			}
		} catch (SQLException e) {
			this.mensaje = "No se ha podido cerrar la BD\n" + e.getMessage();
			return this.mensaje;
		}
	}

	public String unaEmpresa(String empresa) {
		String salida = "<table>";
		try {

			String Query = "SELECT * FROM EMPRESA WHERE EMPRESA = ?";
			PreparedStatement preparedstatement = con.prepareStatement(Query);
			preparedstatement.setString(1, empresa);
			ResultSet rs = preparedstatement.executeQuery();
			boolean existe = rs.next();
			if (existe) {
				salida = salida + "<tr>";
				salida = salida + "<td>" + rs.getString("CIF") + "</td>";
				salida = salida + "<td>" + rs.getString("EMPRESA") + "</td>";
				salida = salida + "<td>" + rs.getString("EMAIL") + "</td>";
				salida = salida + "<td>" + rs.getString("TELEFONO") + "</td>";
				salida = salida + "</tr>";
				salida = salida + "</table>";
				this.mensaje = "Hemos obtenido los datos de la empresa";
				return salida;
			} else {
				return "No existe la empresa buscada";
			}

		} catch (SQLException e) {
			this.mensaje = "No se ha podido cerrar la BD\n" + e.getMessage();
			return this.mensaje;
		}
	}

	public String unaValoracion(String nombre) {
		String salida = "<table>";
		try {
			String Query = "SELECT * FROM VALORACION WHERE NOMBRE = ?";
			PreparedStatement preparedstatement = con.prepareStatement(Query);
			preparedstatement.setString(1, nombre);
			ResultSet rs = preparedstatement.executeQuery();
			boolean existe = rs.next();
			if (existe) {
				salida = salida + "<tr>";
				salida = salida + "<td>" + rs.getInt("ID") + "</td>";
				salida = salida + "<td>" + rs.getString("CIF") + "</td>";
				salida = salida + "<td>" + rs.getString("DNI") + "</td>";
				salida = salida + "<td>" + rs.getInt("PUNTUACION") + "</td>";
				salida = salida + "<td>" + rs.getString("COMENTARIO") + "</td>";
				salida = salida + "</tr>";
				salida = salida + "</table>";
				this.mensaje = "Hemos obtenido la tabla de las valoraciones";
				return salida;
			} else {
				return "No existe la valoracion buscada";
			}

		} catch (SQLException e) {
			this.mensaje = "No se ha podido cerrar la BD\n" + e.getMessage();
			return this.mensaje;
		}
	}

	// AÑADIR UN ELEMENTO

	public void anadirCortador(String dni, String nombre, String email, String telefono, String contrasena, int precio) {

		try {
			Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = sentencia.executeQuery("SELECT * FROM CORTADOR");

			rs.moveToInsertRow();
			rs.updateString("DNI", dni);
			rs.updateString("NOMBRE", nombre);
			rs.updateString("EMAIL", email);
			rs.updateString("TELEFONO", telefono);
			rs.updateString("CONTRASEÑA", contrasena);
			rs.updateInt("PRECIO", precio);
			rs.insertRow();

		} catch (SQLException e) {
			System.out.println("Error al añadir al nuevo cortador");
			System.out.println(e.getMessage());
		}
	}

	public void anadirEmpresa(String cif, String nombre, String email, String telefono, String contrasena) {

		try {
			Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = sentencia.executeQuery("SELECT * FROM EMPRESA");

			rs.moveToInsertRow();
			rs.updateString("CIF", cif);
			rs.updateString("EMPRESA", nombre);
			rs.updateString("EMAIL", email);
			rs.updateString("CONTRASEÑA", contrasena);
			rs.updateString("TELEFONO", telefono);
			rs.insertRow();

		} catch (SQLException e) {
			System.out.println("Error al añadir la nueva empresa");
			System.out.println(e.getMessage());
		}
	}

	public void anadirValoracion(String cif, String dni, int puntuacion, String comentario) {

		try {
			Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = sentencia.executeQuery("SELECT * FROM VALORACION");

			rs.moveToInsertRow();
			rs.updateString("ID", null);
			rs.updateString("CIF", cif);
			rs.updateString("NIF", dni);
			rs.updateInt("PUNTUACION", puntuacion);
			rs.updateString("COMENTARIO", comentario);
			rs.insertRow();

		} catch (SQLException e) {
			System.out.println("Error al añadir la nueva empresa");
			System.out.println(e.getMessage());
		}
	}

	// ELIMINAR UN ELEMENTO

	public void eliminarCortador(String nif, String contrasena) {

		try {
			String Query = "SELECT * FROM CORTADOR WHERE NIF = ? AND CONTRASEÑA = ?";
			PreparedStatement preparedstatement = con.prepareStatement(Query);
			preparedstatement.setString(1, nif);
			preparedstatement.setString(2, contrasena);
			ResultSet rs = preparedstatement.executeQuery();
			boolean existe = rs.next();
			if (existe) {
				rs.deleteRow();
			} else {
				System.out.println("El cortador no existe");
			}

		} catch (SQLException e) {
			System.out.println("Error al eliminar al cortador");
			System.out.println(e.getMessage());
		}
	}

	public void eliminarEmpresa(String cif, String contrasena) {

		try {
			String Query = "SELECT * FROM EMPRESA WHERE CIF = ? AND CONTRASEÑA = ?";
			PreparedStatement preparedstatement = con.prepareStatement(Query);
			preparedstatement.setString(1, cif);
			preparedstatement.setString(2, contrasena);
			ResultSet rs = preparedstatement.executeQuery();
			boolean existe = rs.next();
			if (existe) {
				rs.deleteRow();
			} else {
				System.out.println("La empresa no no existe");
			}
		} catch (SQLException e) {
			System.out.println("Error al eliminar la empresa");
			System.out.println(e.getMessage());
		}
	}

	public void eliminarValoracion(String cif, String dni) {

		try {
			String Query = "SELECT * FROM VALORACION WHERE CIF = ? AND DNI = ?";
			PreparedStatement preparedstatement = con.prepareStatement(Query);
			preparedstatement.setString(1, cif);
			preparedstatement.setString(2, dni);
			ResultSet rs = preparedstatement.executeQuery();
			boolean existe = rs.next();
			if (existe) {
				rs.deleteRow();
			} else {
				System.out.println("La empresa no no existe");
			}
		} catch (SQLException e) {
			System.out.println("Error al eliminar la valoración");
			System.out.println(e.getMessage());
		}
	}

	// CERRAR LA CONEXIÓN

	public void cerrarBD() {
		try {
			con.close();
			mensaje = "Se ha cerrado la conexión con la BD";
		} catch (SQLException e) {
			mensaje = "No se ha podido cerrar la BD\n" + e.getMessage();
			System.out.println(mensaje);
			return;
		}
		System.out.println(mensaje);
	}

}
