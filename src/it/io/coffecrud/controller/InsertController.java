package it.io.coffecrud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.io.coffecrud.model.Coffe;
import it.io.coffecrud.model.CoffeDAO;
import it.io.coffecrud.util.ValidationUtil;

@WebServlet("/InsertController")
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

			Coffe e = new Coffe();
			e.setCofName(cofName);
			e.setSupId(supId);
			e.setPrice(price);
			e.setSales(sales);
			e.setTotal(total);

			CoffeDAO.save(e);

			//request.setAttribute("last_action", "insert");

			response.sendRedirect(request.getContextPath() + "/ViewServlet?last_action=INSERT");
			// request.getRequestDispatcher("/ViewServlet").forward(request, response);

		} else {

			// errore

			//request.setAttribute("error", "true");

			response.sendRedirect(request.getContextPath() + "/ViewServlet?error=true");
			// request.getRequestDispatcher("/ViewServlet").forward(request, response);

		}

	}

}
