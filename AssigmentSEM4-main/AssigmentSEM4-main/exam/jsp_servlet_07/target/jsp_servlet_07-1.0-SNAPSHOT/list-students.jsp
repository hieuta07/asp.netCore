<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Student Tracker App</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<%-- <link type="text/css" rel="stylesheet" href="css/list.css"> --%>
</head>
<body>
<div id="wrapper">
	<header id="header">
		<h1>CodeLean Academy</h1>
	</header>
</div>

<div id="container">
	<div id="content">
		<!-- Add Student button -->
		<input type="button" value="Add Student" onclick="window.location.href='add-student-form.jsp'; return false;" class="add-student-button" />

		<table>
			<tr>
				<th>Employee Code</th>
				<th>Employee Name</th>
				<th>Birthday</th>
				<th>Phone Number</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tempEmployee" items="${STUDENT_LIST}">
				<!-- Set up a link for each student -->
				<c:url var="tempLink" value="EmployeeControllerServlet">
					<c:param name="command" value="LOAD"/>
					<c:param name="employeeId" value="${tempEmployee.id}"/>
				</c:url>
				<!-- Set up a link to delete a student -->
				<c:url var="deleteLink" value="EmployeeControllerServlet">
					<c:param name="command" value="DELETE"/>
					<c:param name="employeeId" value="${tempEmployee.id}"/>
				</c:url>
				<tr>
					<td>${tempEmployee.employeeCode}</td>
					<td>${tempEmployee.employeeName}</td>
					<td>${tempEmployee.birthday}</td>
					<td>${tempEmployee.phoneNumber}</td>
					<td>${tempEmployee.email}</td>
					<td>
						<a href="${tempLink}" class="update-link">Update</a> |
						<a href="${deleteLink}" class="delete-link" onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>
