package it.io.coffecrud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.io.coffecrud.model.CoffeDAO;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		request.setAttribute("last_action", request.getParameter("last_action"));
		request.setAttribute("error", request.getParameter("error"));
		request.setAttribute("list", CoffeDAO.getAllCoffees());
		request.getRequestDispatcher("/view.jsp").forward(request, response);

	}

}
