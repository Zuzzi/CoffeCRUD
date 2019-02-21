package it.io.coffecrud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.io.coffecrud.entity.Coffees;
import it.io.coffecrud.entity.Supplier;
import it.io.coffecrud.model.CoffeDAO;
import it.io.coffecrud.model.SupplierDAO;
import it.io.coffecrud.util.ValidationUtil;


public class UpdateSupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idTemp = request.getParameter("id");
		String nameTemp = request.getParameter("name");
		String countryTemp = request.getParameter("country");


		if (ValidationUtil.checkStringField(nameTemp) && ValidationUtil.checkNumberField(idTemp)
				&& ValidationUtil.checkStringField(countryTemp)) {

			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String country = request.getParameter("country");


			Supplier s = new Supplier();
			s.setId(id);
			s.setName(name);
			s.setCountry(country);

			int rows_updated = SupplierDAO.update(s);

			if (rows_updated > 0) {

				// request.setAttribute("last_action","update");
				response.sendRedirect(request.getContextPath() + "/ViewSupplierServlet?last_action=UPDATE");
			}

			else {

				// request.setAttribute("last_action","update_FAILED!");
				response.sendRedirect(request.getContextPath() + "/ViewSupplierServlet?error=ErroreQueryDB");

			}
			
			
			

		}
		
		else {
			
			
			
			if(!ValidationUtil.checkStringField(nameTemp))
				response.sendRedirect(request.getContextPath() + "/ViewSupplierServlet?error=ErroreAggiornamentoNome");
			else if(!ValidationUtil.checkNumberField(idTemp))
				response.sendRedirect(request.getContextPath() + "/ViewSupplierServlet?error=ErroreAggiornamentoID");
			else if(!ValidationUtil.checkStringField(countryTemp))
				response.sendRedirect(request.getContextPath() + "/ViewSupplierServlet?error=ErroreAggiornamentoCountry");

			
			// request.setAttribute("last_action","update_FAILED!");
			// request.getRequestDispatcher("/ViewServlet").forward(request, response);
			
			
		}



		

	}

}