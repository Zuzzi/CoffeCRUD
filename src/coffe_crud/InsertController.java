package coffe_crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertController")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		 String cofName=request.getParameter("cofName");  
	     int supId=Integer.parseInt(request.getParameter("supId"));  
	     float price=Float.parseFloat(request.getParameter("price"));  
	     int sales=Integer.parseInt(request.getParameter("sales"));
	     int total = Integer.parseInt(request.getParameter("total"));
	          
	     Coffe e=new Coffe();  
	     e.setCofName(cofName);  
	     e.setSupId(supId);  
	     e.setPrice(price);  
	     e.setSales(sales);
	     e.setTotal(total);
	          
	     CoffeDAO.save(e);
	     
	     response.sendRedirect("ViewServlet");
		
		
		
		
	}

}
