package feedback.assigment;

public class FeedBack {
    private int id;
    private String email;
    private String subject;
    private String message;

    public FeedBack(String email, String subject, String message) {
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public FeedBack(int id, String email, String subject, String message) {
        this.id = id;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "Student [id=" + id + ", email=" + email + ", subject=" + subject + ", message=" + message + "]";
    }

}
