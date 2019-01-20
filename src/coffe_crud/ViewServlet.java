package coffe_crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> default_values;


	
	
	
	public void init(ServletConfig config) throws ServletException {
		
		this.default_values = new ArrayList<String>();
		this.default_values.add(0, "");
		this.default_values.add(1, "");
		this.default_values.add(2, "");
		this.default_values.add(3, "");
		this.default_values.add(4, "");

	}
	
	
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<head><title>Coffe CRUD</title></head>");
		
		
		/* The following if-statement handles the edit button on the coffe table.
		 * If the user wants to edit one coffe, the page is refreshed with 'update' parameter equals to 'true',
		 * the 'default_values' list is setted with the features of the coffe which has to be edited.
		 * Thanks to this statement, the update <form> will have text input fields with default values of the 'default_values' list
		 * 
		 */
		
		
		String update = request.getParameter("update");
		if (update != null) {
			
			String cofName = request.getParameter("cofName");
			Coffe coffeToUpdate = CoffeDAO.getCoffeByName(cofName);
			this.default_values.set(0, coffeToUpdate.getCofName());
			this.default_values.set(1, Integer.toString(coffeToUpdate.getSupId()));
			this.default_values.set(2, Float.toString(coffeToUpdate.getPrice()));
			this.default_values.set(3, Integer.toString(coffeToUpdate.getSales()));
			this.default_values.set(4, Integer.toString(coffeToUpdate.getTotal()));

		}
		
		out.println("<center><h3> Coffee CRUD </h3></center>");



		ArrayList<Coffe> list=CoffeDAO.getAllCoffes();
		out.print("<table border='1' width='100%'");  
		out.print("<tr><th>Coffee Name</th><th>Supplier ID</th><th>Price</th><th>Sales</th>"
				+ "<th>Total</th><th>Edit</th><th>Delete</th></tr>");




		for(int i = 0; i<list.size(); i++){  
			out.print("<tr><td>"+list.get(i).getCofName()+"</td><td>"+list.get(i).getSupId()+"</td><td>"+list.get(i).getPrice()+"</td>  "
					+ "<td>"+list.get(i).getSales()+"</td><td>"+list.get(i).getTotal()+"</td><td><a href='ViewServlet?cofName="+list.get(i).getCofName()+"&update=true'>edit</a></td>  "
					+ "<td><a href='DeleteController?cofName="+list.get(i).getCofName()+"'>delete</a></td></tr>");  
		}  
		out.print("</table>");  

		out.print("</br></br><form action='InsertController' method = 'post'> "
				+ "Coffee to <strong>INSERT</strong> | name: <input type = 'text' name = 'cofName'/>"
				+ " supplier ID: <input type = 'text' name = 'supId'/>"
				+ " price: <input type = 'text' name = 'price'/>"
				+ " sales: <input type = 'text' name = 'sales'/>"
				+ " total: <input type = 'text' name = 'total'/>");
		out.print("<input type = 'submit' value = 'Insert'/>");
		
		out.print("</form>");
		
		out.print("</br></br><form action='UpdateController' method = 'post'> "
				+ "Coffee to <strong>EDIT</strong> | name: <input  type = 'text' readonly name = 'cofName' value = '" + this.default_values.get(0) + "'/>"
				+ " supplier ID: <input type = 'text' name = 'supId'  value = '" + this.default_values.get(1) + "'    />"
				+ " price: <input type = 'text' name = 'price'  value = '" + this.default_values.get(2) + "'   />"
				+ " sales: <input type = 'text' name = 'sales'  value = '" + this.default_values.get(3) + "'       />"
				+ " total: <input type = 'text' name = 'total'   value = '" + this.default_values.get(4) + "'         />");
		out.print("<input type = 'submit' value = 'Edit'/>");
		
		
		out.print("</form>");
		
		
		
		
		out.println("</br></br></br><em>Coffee names are not editable because they are primary keys</em>");
		
		




		out.close();  



		
		
		
	}
	
	
	
	

	
	

}
