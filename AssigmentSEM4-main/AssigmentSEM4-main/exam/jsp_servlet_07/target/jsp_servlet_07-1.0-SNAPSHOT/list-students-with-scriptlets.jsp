<%@ page import="java.util.*,thidk.codelean.jdbc.*" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Tracker App</title>
		<link type="text/css" rel="stylesheet" href="css/style.css">
	</head>
	<%
		// get the students from the request object (sent by servlet)
		List<Employee> theEmployees = (List<Employee>) request.getAttribute("STUDENT_LIST");
	%>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CodeLean Academy</h2>
			</div>
		</div>
		<div id="container">
			<div id="content">
				<table>
					<tr>
						<th>Employee Code</th>
						<th>Employee Name</th>
						<th>Birthday</th>
						<th>Phone Number</th>
						<th>Email</th>
					</tr>
					<% for (Employee tempEmployee : theEmployees) { %>
						<tr>
							<td>${tempEmployee.employeeCode}</td>
							<td>${tempEmployee.employeeName}</td>
							<td>${tempEmployee.birthday}</td>
							<td>${tempEmployee.phoneNumber}</td>
							<td>${tempEmployee.email}</td>
						</tr>
					<% } %>
				</table>
			</div>
		</div>
	</body>
</html>








