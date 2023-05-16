namespace ConsoleApplication1;

public class Authentication
{
    private Admin admin;
    private Student student;
    private AdminRecordManagement admin_record_management;
    private StudentRecordManagement student_record_management;
    public AdminRecordManagement getAdminRecordManagement()
    {
        return admin_record_management;
    }
    public StudentRecordManagement getStudentRecordManagement()
    {
        return student_record_management;
    }
    public Authentication()
    {
    }
    public void register(string name, int idNumber, string contactNumber, string role)
    {
        switch (role)
        {
            case "RA":
                admin = new Admin(name, idNumber, contactNumber);
                admin_record_management = new AdminRecordManagement();
                admin_record_management.add(admin);
                break;
            case "RS":
                student = new Student(name, idNumber, contactNumber);
                student_record_management = new StudentRecordManagement();
                student_record_management.add(student);
                break;
            default:
                throw new Exception("User not found");
        }
    } 
    public Boolean login(string name, int idNumber, string contactNumber, string role)
    {
        switch (role)
        {
            case "LA":
                admin = new Admin(name, idNumber, contactNumber);
                admin_record_management = new AdminRecordManagement();
                   if (admin_record_management.find(idNumber))
                   {
                       return true;
                   }
                   else 
                   {
                        throw new Exception("Login Failed");
                   }
            case "LS":
                student = new Student(name, idNumber, contactNumber);
                student_record_management = new StudentRecordManagement();
                   if (student_record_management.find(idNumber))
                   {
                       return true;
                   }
                   else 
                   {
                        throw new Exception("Login Failed");
                   }
            case "NA":
                return true;
            default:
                return false;
        }
    }
}