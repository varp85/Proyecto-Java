package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import datos.LogicaBDCortadores;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controlador() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Control de entrada

		RequestDispatcher rd;
		HttpSession sesion = request.getSession(true);

		if (sesion.isNew()) {
			rd = request.getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
		}

		// Recogida de datos cortadores

		String nombreC = request.getParameter("nombreC");
		String dni = request.getParameter("dni");
		String emailC = request.getParameter("emailC");
		String telefonoC = request.getParameter("telefonoC");
		String contraC = request.getParameter("contraC");
		int precioC = Integer.parseInt(request.getParameter("precioC"));

		LogicaBDCortadores anadirC = new LogicaBDCortadores();
		anadirC.anadirCortador(dni, nombreC, emailC, telefonoC, contraC, precioC);
		
		response.sendRedirect("verified.jsp");  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Control de entrada

		RequestDispatcher rd;
		HttpSession sesion = request.getSession(true);

		if (sesion.isNew()) {
			rd = request.getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
		}

		// Recogida datos restauradores

		String nombre = request.getParameter("nombre");
		String cif = request.getParameter("cif");
		String email = request.getParameter("email");
		String contra = request.getParameter("contra");
		String telefono = request.getParameter("telefono");

		LogicaBDCortadores anadirE = new LogicaBDCortadores();
		anadirE.anadirEmpresa(cif, nombre, email, telefono, contra);
		
		response.sendRedirect("verified.jsp");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// LA BD SE ABRIRÁ UNA SOLA VEZ.

		ServletContext contextoAplicacion = this.getServletContext(); // Atributo disponible para todos los servlet y
																		// JSP
		LogicaBDCortadores lbd = new LogicaBDCortadores();
		contextoAplicacion.setAttribute("LDB", lbd);
	}
}
