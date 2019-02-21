function checkInsert() {
	var cofName = document.forms["insertForm"]["cofName"].value;
	var test = true;
	if (cofName == "") {
		alert("Please insert coffee name!");
		test = false;
	} else if (cofName.indexOf(' ') >= 0) {
		("Please don't use whitespaces in coffe name!");
		test = false;
	}

	var supId = document.forms["insertForm"]["supId"].value;
	if (supId == "") {
		alert("Please insert supplier id!");
		test = false;
	} else if (supId.indexOf(' ') >= 0) {
		alert("Please don't use whitespaces in supplier id!");
		test = false;
	}
	else if (isNaN(supId)) {
		alert("Supplier id must be a number!");
		test = false;
	}
	
	
	

	var price = document.forms["insertForm"]["price"].value;
	if (price == "") {
		alert("Please insert price!");
		test = false;
	} else if (price.indexOf(' ') >= 0) {
		alert("Please don't use whitespaces in price!");
		test = false;
	} else if (isNaN(price)) {
		alert("Price must be a number!");
		test = false;
	}

	
	
	var sales = document.forms["insertForm"]["sales"].value;
	if (sales == "") {
		alert("Please insert sales!");
		test = false;
	}
	else if (sales.indexOf(' ') >= 0) {
		alert("Please don't use whitespaces in price!");
		test = false;
	}
	else if (isNaN(sales)) {
		alert("Sales id must be a number!");
		test = false;
	}
	
	
	
	var total = document.forms["insertForm"]["total"].value;
	if (total == "") {
		alert("Please insert total!");
		test = false;
	}
	else if (total.indexOf(' ') >= 0) {
		alert("Please don't use whitespaces in total!");
		test = false;
	}
	else if (isNaN(total)) {
		alert("Total must be a number!");
		test = false;
	}
	return test;

}

function checkUpdate() {
	var cofName = document.forms["updateForm"]["cofName"].value;
	var test = true;
	
	if (cofName == "") {
		alert("Please insert coffee name!");
		test = false;
	}

	else if (cofName.indexOf(' ') >= 0) {
		alert("Please don't use whitespaces in coffe name!");
		test = false;
	}
	
	
	
	var supId = document.forms["updateForm"]["supId"].value;
	if (supId == "") {
		alert("Please insert supplier id!");
		test = false;
	}

	else if (supId.indexOf(' ') >= 0) {
		alert("Please don't use whitespaces in supplier id!");
		test = false;
	}
	else if (isNaN(supId)) {
		alert("Supplier id must be a number!");
		test = false;
	}
	
	
	

	var price = document.forms["updateForm"]["price"].value;
	if (price == "") {
		alert("Please insert price!");
		test = false;
	}

	else if (price.indexOf(' ') >= 0) {
		alert("Please don't use whitespaces in price!");
		test = false;
	}
	else if (isNaN(price)) {
		alert("Price must be a number!");
		test = false;
	}

	
	
	var sales = document.forms["updateForm"]["sales"].value;
	if (sales == "") {
		alert("Please insert sales!");
		test = false;
	}
	
	else if (sales.indexOf(' ') >= 0) {
		alert("Please don't use whitespaces in price!");
		test = false;
	}
	else if (isNaN(sales)) {
		alert("Sales id must be a number!");
		test = false;
	}
	
	
	
	var total = document.forms["updateForm"]["total"].value;
	if (total == "") {
		alert("Please insert total!");
		test = false;
	}

	else if (total.indexOf(' ') >= 0) {
		alert("Please don't use whitespaces in total!");
		test = false;
	}
	else if (isNaN(total)) {
		alert("Total must be a number!");
		test = false;
	}
	
	

	return test;

}