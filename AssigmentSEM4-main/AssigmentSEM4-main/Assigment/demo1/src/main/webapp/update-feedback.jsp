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
    <h3>Update FeedBack</h3>

    <form action="FeedBackControllerServlet" method="GET">

        <input type="hidden" name="command" value="UPDATE" />

        <input type="hidden" name="feedBackId" value="${THE_FEEDBACK.id}" />

        <table>
            <tbody>
            <tr>
                <td><label>Name:</label></td>
                <td><input type="text" name="name"
                           value="${THE_FEEDBACK.name}" /></td>
            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td><input type="text" name="email"
                           value="${THE_FEEDBACK.email}" /></td>
            </tr>

            <tr>
                <td><label>Subject:</label></td>
                <td><input type="text" name="subject"
                           value="${THE_FEEDBACK.subject}" /></td>
            </tr>

            <tr>
                <td><label>Message:</label></td>
                <td><input type="text" name="message"
                           value="${THE_FEEDBACK.message}" /></td>
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
        <a href="FeedBackControllerServlet">Back to List</a>
    </p>
</div>
</body>

</html>











