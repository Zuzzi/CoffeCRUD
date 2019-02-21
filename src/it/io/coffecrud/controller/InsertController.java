package it.io.coffecrud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.io.coffecrud.entity.Coffees;
import it.io.coffecrud.model.CoffeDAO;
import it.io.coffecrud.util.ValidationUtil;


public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cofNameTemp = request.getParameter("cofName");
		String supIdTemp = request.getParameter("supId");
		String priceTemp = request.getParameter("price");
		String salesTemp = request.getParameter("sales");
		String totalTemp = request.getParameter("total");

		if (ValidationUtil.checkStringField(cofNameTemp) && ValidationUtil.checkNumberField(supIdTemp)
				&& ValidationUtil.checkNumberField(priceTemp) && ValidationUtil.checkNumberField(salesTemp)
				&& ValidationUtil.checkNumberField(totalTemp)) {

			String cofName = request.getParameter("cofName");
			int supId = Integer.parseInt(request.getParameter("supId"));
			float price = Float.parseFloat(request.getParameter("price"));
			int sales = Integer.parseInt(request.getParameter("sales"));
			int total = Integer.parseInt(request.getParameter("total"));

			Coffees e = new Coffees();
			e.setCofName(cofName);
			e.setSupId(supId);
			e.setPrice(price);
			e.setSales(sales);
			e.setTotal(total);

			int status = CoffeDAO.save(e);
			
			
			if (status > 0) {
				
				//request.setAttribute("last_action", "insert");
				response.sendRedirect(request.getContextPath() + "/ViewServlet?last_action=INSERT");
				// request.getRequestDispatcher("/ViewServlet").forward(request, response);
			}
			else
				response.sendRedirect(request.getContextPath() + "/ViewServlet?error=ErroreQueryDB");



		} else {
			
			
			if(!ValidationUtil.checkStringField(cofNameTemp))
				response.sendRedirect(request.getContextPath() + "/ViewServlet?error=ErroreInserimentoNome");
			else if(!ValidationUtil.checkNumberField(supIdTemp))
				response.sendRedirect(request.getContextPath() + "/ViewServlet?error=ErroreInserimentoIDsupplier");
			else if(!ValidationUtil.checkNumberField(priceTemp))
				response.sendRedirect(request.getContextPath() + "/ViewServlet?error=ErroreInserimentoPrice");
			else if(!ValidationUtil.checkNumberField(salesTemp))
				response.sendRedirect(request.getContextPath() + "/ViewServlet?error=ErroreInserimentoSales");
			else if(!ValidationUtil.checkNumberField(totalTemp))
				response.sendRedirect(request.getContextPath() + "/ViewServlet?error=ErroreInserimentoTotal");
			
			

			// errore

			//request.setAttribute("error", "true");
			// request.getRequestDispatcher("/ViewServlet").forward(request, response);

		}

	}

}
