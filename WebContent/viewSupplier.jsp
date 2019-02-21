<%@ page import="java.util.List"%>
<%@ page import="it.io.coffecrud.entity.Supplier"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%!@SuppressWarnings("unchecked")%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Coffe CRUD</title>

<!--  <script src="validation1.js"></script>  -->

</head>
<body>


	<table border='1' style="width: 100%;">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Country</th>
			<th>Delete</th>
		</tr>




		<%

			List<Supplier> list = (List<Supplier>) request.getAttribute("list");

			for (int i = 0; i < list.size(); i++) {
				out.print("<tr><td>" + list.get(i).getId() + "</td><td>" + list.get(i).getName() + "</td><td>"
						+ list.get(i).getCountry() + "</td><td><a href='DeleteSupplierController?id="
						+ list.get(i).getId() + "'>delete</a></td></tr>");
			}
		%>




	</table>

	<br>
	<br>
	<form action='InsertSupplierController' method='post' name="insertForm"
		onsubmit="return checkInsert()">
		Supplier to <strong>INSERT</strong> | id: <input type='text'
			name='id' maxlength="15" /> name: <input type='text'
			name='name' maxlength="15" /> country: <input type='text'
			name='country' maxlength="15" /> <input type='submit' value='Insert' />

	</form>

	<br>
	<br>
	<form action='UpdateSupplierController' method='post' name="updateForm"
		onsubmit="return checkUpdate()">
		Supplier to <strong>EDIT</strong> | id: <input type='text'
			name='id' maxlength="15" /> name: <input type='text'
			name='name' maxlength="15" /> country: <input type='text'
			name='country' maxlength="15" /> <input type='submit' value='Edit'
			maxlength="15" />


	</form>




	<br>
	<br>
	<br>
	<em>Supplier ids are not editable because they are primary keys</em>
	<br>


	<%
		if (request.getAttribute("last_action") != null) {
	%>

	<p>
		L'ultima azione effettuata è stata:
		<%=request.getAttribute("last_action")%></p>



	<%
		}
	%>



	<%
		if (request.getAttribute("error") != null) {
	%>

	<p>
		ERRORE nella validazione del campo di input!! :'(
		<%=request.getAttribute("error")%>
	</p>



	<%
		}
	%>
	
	
	
	
<br><br><br>


<a href = "ViewServlet"><h3>GO TO Coffee table </h3></a>	



</body>
</html>