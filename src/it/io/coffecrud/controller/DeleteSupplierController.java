package it.io.coffecrud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.io.coffecrud.model.SupplierDAO;


public class DeleteSupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		SupplierDAO.delete(id);
		
		
		
//		request.setAttribute("last_action","delete");
		
		response.sendRedirect(request.getContextPath() + "/ViewSupplierServlet?last_action=DELETE");
		//request.getRequestDispatcher("/ViewServlet").forward(request, response);

	}

}
