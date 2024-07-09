<%@ page import="java.util.*,thidk.codelean.jdbc.*" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Tracker App</title>
		<link type="text/css" rel="stylesheet" href="css/style.css">
	</head>
	<%
		// get the students from the request object (sent by servlet)
		List<FeedBack> theFeedBacks = (List<FeedBack>) request.getAttribute("STUDENT_LIST");
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
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
					<% for (FeedBack tempFeedBack : theFeedBacks) { %>
						<tr>
							<td> <%= tempFeedBack.getName() %> </td>
							<td> <%= tempFeedBack.getEmail() %> </td>
							<td> <%= tempFeedBack.getSubject() %> </td>
							<td> <%= tempFeedBack.getMessage() %> </td>
						</tr>
					<% } %>
				</table>
			</div>
		</div>
	</body>
</html>








