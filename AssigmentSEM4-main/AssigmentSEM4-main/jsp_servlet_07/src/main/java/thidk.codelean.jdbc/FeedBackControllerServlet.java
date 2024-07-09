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

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/FeedBackControllerServlet")
public class FeedBackControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private FeedBackDbUtil feedBackDbUtil;

    @Resource(name = "jdbc/student_manager")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        // create our student db util ... and pass in the conn pool / datasource
        try {
            feedBackDbUtil = new FeedBackDbUtil(dataSource);
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
                    addFeedBack(request, response);
                    break;
                case "LOAD":
                    loadFeedBack(request, response);
                    break;
                case "UPDATE":
                    updateFeedBack(request, response);
                    break;
                case "DELETE":
                    deleteFeedBack(request, response);
                    break;
                default:
                    listFeedBacks(request, response);
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    private void deleteFeedBack(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // read student id from form data
        String theFeedbackId = request.getParameter("feedbackId");

        // delete student from database
        feedBackDbUtil.deleteFeedBack(theFeedbackId);

        // send them back to "list students" page
        listFeedBacks(request, response);
    }

    private void updateFeedBack(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read student info from form data
        int id = Integer.parseInt(request.getParameter("feedBackId"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        // create a new student object
        FeedBack theFeedback = new FeedBack(id, name, email, subject, message);

        // perform update on database
        feedBackDbUtil.updateFeedBack(theFeedback);

        // send them back to the "list students" page
        listFeedBacks(request, response);

    }

    private void loadFeedBack(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read student id from form data
        String theFeedBackId = request.getParameter("feedBackId");

        // get student from database (db util)
        FeedBack theFeedBack = feedBackDbUtil.getFeedBack(theFeedBackId);

        // place student in the request attribute
        request.setAttribute("THE_FEEDBACK", theFeedBack);

        // send to jsp page: update-student-form.jsp
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/update-feedback-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addFeedBack(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // read student info from form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        // create a new student object
        FeedBack theFeedBack = new FeedBack(name, email, subject, message);

        // add the student to the database
        feedBackDbUtil.addFeedBack(theFeedBack);

        // send back to main page (the student list)
        listFeedBacks(request, response);
    }

    private void listFeedBacks(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // get students from db util
        List<FeedBack> feedBacks = feedBackDbUtil.getFeedBacks();

        // add students to the request
        request.setAttribute("FEEDBACK_LIST", feedBacks);

        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(request, response);
    }

}













