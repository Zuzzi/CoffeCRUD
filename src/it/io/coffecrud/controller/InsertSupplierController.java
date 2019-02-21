package it.io.coffecrud.controller;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.io.coffecrud.entity.Supplier;

import it.io.coffecrud.model.SupplierDAO;
import it.io.coffecrud.util.ValidationUtil;

public class InsertSupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idTemp = request.getParameter("id");
		String nameTemp = request.getParameter("name");
		String countryTemp = request.getParameter("country");

		if (ValidationUtil.checkNumberField(idTemp) && ValidationUtil.checkStringField(nameTemp)
				&& ValidationUtil.checkStringField(countryTemp)) {

			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String country = request.getParameter("country");

			Supplier s = new Supplier();
			s.setId(id);
			s.setName(name);
			s.setCountry(country);

			int status = SupplierDAO.save(s);

			if (status > 0) {
			   //request.setAttribute("last_action", "insert");
				response.sendRedirect(request.getContextPath() + "/ViewSupplierServlet?last_action=INSERT");
				// request.getRequestDispatcher("/ViewServlet").forward(request, response);
			} else
				response.sendRedirect(request.getContextPath() + "/ViewSupplierServlet?error=ErroreQueryDB");

		} else {

			if (!ValidationUtil.checkNumberField(idTemp))
				response.sendRedirect(request.getContextPath() + "/ViewSupplierServlet?error=ErroreInserimentoID");
			else if (!ValidationUtil.checkStringField(nameTemp))
				response.sendRedirect(
						request.getContextPath() + "/ViewSupplierServlet?error=ErroreInserimentoNomeSupplier");
			else if (!ValidationUtil.checkStringField(countryTemp))
				response.sendRedirect(request.getContextPath() + "/ViewSupplierServlet?error=ErroreInserimentoCountry");

			// errore

			// request.setAttribute("error", "true");
			// request.getRequestDispatcher("/ViewServlet").forward(request, response);

		}

	}

}
