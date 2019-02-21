<%@ page import="java.util.List"%>
<%@ page import="it.io.coffecrud.entity.Coffees"%>



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
			<th>COF_NAME</th>
			<th>SUP_ID</th>
			<th>PRICE</th>
			<th>SALES</th>
			<th>TOTAL</th>
			<th>DELETE</th>
		</tr>




		<%

			List<Coffees> list = (List<Coffees>) request.getAttribute("list");

			for (int i = 0; i < list.size(); i++) {
				out.print("<tr><td>" + list.get(i).getCofName() + "</td><td>" + list.get(i).getSupId() + "</td><td>"
						+ list.get(i).getPrice() + "</td><td>"
						+ list.get(i).getSales() + "</td><td>"
						+ list.get(i).getTotal() + "</td><td><a href='DeleteController?cofName="
						+ list.get(i).getCofName() + "'>delete</a></td></tr>");
			}
		%>




	</table>

	<br>
	<br>
	<form action='InsertController' method='post' name="insertForm"
		onsubmit="return checkInsert()">
		Coffe to <strong>INSERT</strong> | name: <input type='text'
			name='cofName' maxlength="15" />sup id: <input type='text'
			name='supId' maxlength="15" /> price: <input type='text'
			name='price' maxlength="15" /> sales: <input type='text'
			name='sales' maxlength="15" />total: <input type='text'
			name='total' maxlength="15" /> <input type='submit' value='Insert' />

	</form>

	<br>
	<br>
	<form action='UpdateController' method='post' name="updateForm"
		onsubmit="return checkUpdate()">
		Coffe to <strong>EDIT</strong> | name: <input type='text'
			name='cofName' maxlength="15" /> sup id: <input type='text'
			name='supId' maxlength="15" /> price: <input type='text'
			name='price' maxlength="15" /> sales: <input type='text'
			name='sales' maxlength="15" />total: <input type='text'
			name='total' maxlength="15" /><input type='submit' value='Edit'
			maxlength="15" />


	</form>




	<br>
	<br>
	<br>
	<em>Coffe ids are not editable because they are primary keys</em>
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


<a href = "ViewSupplierServlet"><h3>GO TO supplier table </h3></a>	



</body>
</html>