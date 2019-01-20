package coffe_crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cofName=request.getParameter("cofName");  
		String supId=request.getParameter("supId");  
		String price=request.getParameter("price");  
		String sales=request.getParameter("sales");
		String total=request.getParameter("total");
		
		
		

	

		Coffe coffe=new Coffe();  
		coffe.setCofName(cofName);  
		coffe.setSupId(Integer.parseInt(supId));  
		coffe.setPrice(Float.parseFloat(price));  
		coffe.setSales(Integer.parseInt(sales));
		coffe.setTotal(Integer.parseInt(total));

		CoffeDAO.update(coffe);  
		
		response.sendRedirect("ViewServlet");
		
		

		
		
	}

}
