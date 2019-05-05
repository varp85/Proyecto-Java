package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Distribucion")
public class Distribucion extends HttpServlet {
	private static final long serialVersionUID = 1L;

  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String accion = request.getParameter("accion");//Por si se entra directamente
		if (accion==null) {
			response.sendRedirect("Controlador");
		} 
		else {
			RequestDispatcher rd=null;
			switch (accion) {
				case "cortadores": 
					rd = request.getRequestDispatcher("/cortadores.jsp");
					break;
				case "restauradores":
					rd = request.getRequestDispatcher("/restauradores.jsp");
					break;
				case "buscar":
					rd = request.getRequestDispatcher("/buscar.jsp");
					break;
				
			}
			
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
