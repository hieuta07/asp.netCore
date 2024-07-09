<!DOCTYPE html>
<html>

<head>
	<title>Add Student</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Employee ABC</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Student</h3>
		
		<form action="EmployeeControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Employee Code:</label></td>
						<td><input type="text" name="employeeCode" /></td>
					</tr>

					<tr>
						<td><label>Employee Name:</label></td>
						<td><input type="text" name="employeeName" /></td>
					</tr>

					<tr>
						<td><label>Birthday:</label></td>
						<td><input type="date" name="birthday" /></td>
					</tr>

					<tr>
						<td><label>Phone Number:</label></td>
						<td><input type="text" name="phoneNumber" /></td>
					</tr>


					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="EmployeeControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











