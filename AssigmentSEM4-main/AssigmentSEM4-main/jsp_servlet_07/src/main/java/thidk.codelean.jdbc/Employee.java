package thidk.codelean.jdbc;

public class Employee {
    private int id;
    private String employeeCode;
    private String employeeName;
    private String birthday;
    private String phoneNumber;
    private String email;

    public Employee(int id, String employeeCode, String employeeName, String birthday, String phoneNumber, String email) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Employee(String employeeCode, String employeeName, String birthday, String phoneNumber, String email) {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmployeeCode() {
        return employeeCode;
    }
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;

    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", employeeCode=" + employeeCode + ", employeeName=" + employeeName
                + ", birthday=" + birthday + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
    }
}
