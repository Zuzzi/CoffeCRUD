package it.io.coffecrud.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.io.coffecrud.model.CoffeDAO;
import it.io.coffecrud.model.SupplierDAO;



public class ViewSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("last_action", request.getParameter("last_action"));
		//request.setAttribute("error", request.getParameter("error"));
		request.setAttribute("list", SupplierDAO.getAllSuppliers());
		request.getRequestDispatcher("/viewSupplier.jsp").forward(request, response);
	}



}
