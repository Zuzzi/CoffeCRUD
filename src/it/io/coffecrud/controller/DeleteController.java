package it.io.coffecrud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.io.coffecrud.model.CoffeDAO;

public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cofName = request.getParameter("cofName");
		CoffeDAO.delete(cofName);
		
		
		
//		request.setAttribute("last_action","delete");
		
		response.sendRedirect(request.getContextPath() + "/ViewServlet?last_action=DELETE");
		//request.getRequestDispatcher("/ViewServlet").forward(request, response);

	}

}
