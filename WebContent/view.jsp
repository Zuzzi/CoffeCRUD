<%@ page import="java.util.List"%>
<%@ page import="it.io.coffecrud.model.Coffe"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%! @SuppressWarnings("unchecked") %>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Coffe CRUD</title>

<!--  <script src="validation1.js"></script>  -->

</head>
<body>


	<table border='1' style="width:100%;">
		<tr>
			<th>Coffee Name</th>
			<th>Supplier ID</th>
			<th>Price</th>
			<th>Sales</th>
			<th>Total</th>
			<th>Delete</th>
		</tr>




		<%
			List<Coffe> list = (List<Coffe>) request.getAttribute("list");

			for (int i = 0; i < list.size(); i++) {
				out.print("<tr><td>" + list.get(i).getCofName() + "</td><td>" + list.get(i).getSupId() + "</td><td>"
						+ list.get(i).getPrice() + "</td>  " + "<td>" + list.get(i).getSales() + "</td><td>"
						+ list.get(i).getTotal() + "</td>" + "<td><a href='DeleteController?cofName="
						+ list.get(i).getCofName() + "'>delete</a></td></tr>");
			}
		%>




	</table>

	<br>
	<br>
	<form action='InsertController' method='post' name="insertForm" onsubmit="return checkInsert()">
		Coffee to <strong>INSERT</strong> | name: <input type='text'
			name='cofName' /> supplier ID: <input type='text' name='supId' />
		price: <input type='text' name='price' /> sales: <input type='text'
			name='sales' /> total: <input type='text' name='total' /> <input
			type='submit' value='Insert' />

	</form>

	<br>
	<br>
	<form action='UpdateController' method='post' name="updateForm" onsubmit="return checkUpdate()" >
		Coffee to <strong>EDIT</strong> | name: <input type='text'
			name='cofName' /> supplier ID: <input type='text' name='supId' />
		price: <input type='text' name='price' /> sales: <input type='text'
			name='sales' /> total: <input type='text' name='total' /> <input
			type='submit' value='Edit' />


	</form>




	<br>
	<br>
	<br>
	<em>Coffee names are not editable because they are primary keys</em>
	<br>
	
	
	<%
	if(request.getAttribute("last_action") != null) { %>
		
		<p>L'ultima azione effettuata è stata: <%= request.getAttribute("last_action") %></p>
	
	
	
	<%
	}
	%>
	
	
	
	<%
	if(request.getAttribute("error") != null) { %>
		
		<p>ERRORE nella validazione del campo di input!!  :'(</p>
	
	
	
	<%
	}
	%>



</body>
</html>