package thidk.codelean.jdbc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/EmployeeControllerServlet")
public class EmployeeControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EmployeeDBUtil employeeDBUtil;

    @Resource(name = "jdbc/student_manager")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        // create our student db util ... and pass in the conn pool / datasource
        try {
            employeeDBUtil = new EmployeeDBUtil(dataSource);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");
            // if the command is missing, then default to listing students
            if(theCommand == null)
                theCommand = "list";
            // route to the appropriate method
            switch (theCommand) {
                case "ADD":
                    addEmployee(request, response);
                    break;
                case "LOAD":
                    loadEmployee(request, response);
                    break;
                case "UPDATE":
                    updateEmployee(request, response);
                    break;
                case "DELETE":
                    deleteEmployee(request, response);
                    break;
                default:
                    listEmployees(request, response);
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // read student id from form data
        String theEmployeeId = request.getParameter("employeeId");

        // delete student from database
        employeeDBUtil.deleteEmployee(theEmployeeId);

        // send them back to "list students" page
        listEmployees(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read student info from form data
        int id = Integer.parseInt(request.getParameter("employeeId"));
        String employeeCode = request.getParameter("employeeCode");
        String employeeName = request.getParameter("employeeName");
        String birthday = request.getParameter("birthday");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");

        // create a new student object
        Employee theEmployee = new Employee(id, employeeCode, employeeName, birthday, phoneNumber, email);

        // perform update on database
        employeeDBUtil.updateEmployee(theEmployee);

        // send them back to the "list students" page
        listEmployees(request, response);

    }

    private void loadEmployee(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read student id from form data
        String theEmployeeId = request.getParameter("employeeId");

        // get student from database (db util)
        Employee theEmployee = employeeDBUtil.getEmployee(theEmployeeId);

        // place student in the request attribute
        request.setAttribute("THE_EMPLOYEE", theEmployee);

        // send to jsp page: update-student-form.jsp
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/update-student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // read student info from form data
        String employeeCode = request.getParameter("employeeCode");
        String employeeName = request.getParameter("employeeName");
        String birthday = request.getParameter("birthday");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");

        // create a new student object
        Employee theEmployee = new Employee(employeeCode, employeeName, birthday, phoneNumber, email);

        // add the student to the database
        employeeDBUtil.addEmployee(theEmployee);

        // send back to main page (the student list)
        listEmployees(request, response);
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // get students from db util
        List<Employee> employees = employeeDBUtil.getEmployees();

        // add students to the request
        request.setAttribute("STUDENT_LIST", employees);

        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(request, response);
    }
}
