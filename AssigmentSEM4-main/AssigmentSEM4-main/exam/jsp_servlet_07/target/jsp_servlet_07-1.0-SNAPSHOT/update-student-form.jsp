<!DOCTYPE html>
<html>

<head>
	<title>Update Student</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CodeLean Academy</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Student</h3>
		
		<form action="StudentControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="studentId" value="${THE_STUDENT.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Employee Code:</label></td>
						<td><input type="text" name="employeeCode"
								   value="${THE_EMPLOYEE.employeeCode}" /></td>
					</tr>

					<tr>
						<td><label>Employee Name:</label></td>
						<td><input type="text" name="lastName" 
								   value="${THE_EMPLOYEE.employeeName}" /></td>
					</tr>

					<tr>
						<td><label>Birthday:</label></td>
						<td><input type="text" name="lastName"
								   value="${THE_EMPLOYEE.birthday}" /></td>
					</tr>

					<tr>
						<td><label>Phone Number:</label></td>
						<td><input type="text" name="lastName"
								   value="${THE_EMPLOYEE.phoneNumber}" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" 
								   value="${THE_EMPLOYEE.email}" /></td>
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
			<a href="StudentControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











