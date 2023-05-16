using System.Globalization;

namespace ConsoleApplication1;

public class FacadeController
{
   private Authentication authentication;
   private string verify_role;
   private string role;
   private string name;
   private int idNumber;
   private string contactNumber;
   private AdminRecordManagement adminRecordManagement;
   private StudentRecordManagement studentRecordManagement;
   private static FacadeController instance;

   public FacadeController()
   {
      authentication = new Authentication();
      verify_role = verifying_role();
      role = "";
      name = "";
      idNumber = 0;
      contactNumber = "";
      adminRecordManagement = authentication.getAdminRecordManagement();
      studentRecordManagement = authentication.getStudentRecordManagement();
      instance = null;
   }
   public static FacadeController getInstance()
   {
      if (instance == null)
      {
         instance = new FacadeController();
      }
      return instance;
   }

   public void start_program()
   {
      if (verify_role == "Admin")
      {
         admin_function();
      }
      else
      {
         na_function();
      }
   }

   public int menu(string role)
   {
      Console.WriteLine("MENU");
      Console.WriteLine($"1: Add {role}");
      Console.WriteLine($"2: Delete {role}");
      Console.WriteLine($"3: Update {role}");
      Console.WriteLine($"4: Search {role}");
      Console.WriteLine($"5: Display {role}");
      Console.WriteLine($"8: Switch to Manage Student/Manage Admin: Current is {role}");
      Console.WriteLine($"9: Exit program");
      Console.Write("Enter your selection : ");
      return int.Parse(Console.ReadLine());

   }
   
   public void ask_information()
   {
      Console.Write("Enter name: ");
      name = Console.ReadLine();
      Console.Write("Enter ID number: ");
      idNumber = int.Parse(Console.ReadLine());
      Console.Write("Enter contact number: ");
      contactNumber = Console.ReadLine();
   }

   public void admin_function()
   {
      Console.WriteLine("Welcome to the admin menu");
      int admin_option = menu("Admin");
      while (true)
      {
         try
         {
            switch (admin_option)
            {
               case 1:
                  ask_information();
                  add_admin(name, idNumber, contactNumber);
                  Console.WriteLine("Admin added successfully");
                  break;
               case 2:
                  Console.WriteLine("Enter the ID number of the admin you want to delete: ");
                  int id = int.Parse(Console.ReadLine());
                  delete_admin(id);
                  Console.WriteLine("Admin deleted successfully");
                  break;
               case 3:
                  ask_information();
                  update_admin(name, idNumber, contactNumber);
                  Console.WriteLine("Admin updated successfully");
                  break;
               case 4:
                  ask_information();
                  find_admin(name, idNumber, contactNumber);
                  break;
               case 5:
                  Console.WriteLine("Enter the field you want to display by: ");
                  Console.WriteLine("1. Name");
                  Console.WriteLine("2. ID number");
                  Console.WriteLine("3. Contact number");
                  int sort_by = int.Parse(Console.ReadLine());
                  foreach (Person people in adminRecordManagement.display(sort_by))
                  {
                     Console.WriteLine(people.toString());
                  }
                  break;
               case 8:
                  student_function();
                  break;
               case 9: 
                  Environment.Exit(0);
                  break;
               default:
                  Console.WriteLine("Invalid option");
                  break;
            }
            admin_option = menu("Admin");
         }
         catch (Exception e)
         {
            Console.WriteLine(e);
            admin_option = menu("Admin");
         }
      }
   }
   
   public int student_menu()
   {
      Console.WriteLine("MENU");
      Console.WriteLine("1: Search Student");
      Console.WriteLine("2: Display Student");
      Console.WriteLine("9: Exit program");
      Console.Write("Enter your selection : ");
      return int.Parse(Console.ReadLine());
   }

   public void student_function()
   {
      Console.WriteLine("Welcome to the student menu");
      int student_option = menu("Student");
      while (true)
      {
         try
         {
            switch (student_option)
            {
               case 1:
                  ask_information();
                  add_student(name, idNumber, contactNumber);
                  Console.WriteLine("Student added successfully");
                  break;
               case 2:
                  Console.WriteLine("Enter the ID number of the admin you want to delete: ");
                  int id = int.Parse(Console.ReadLine());
                  delete_student(id);
                  Console.WriteLine("Student deleted successfully");
                  break;
               case 3:
                  ask_information();
                  update_student(name, idNumber, contactNumber);
                  Console.WriteLine("Student updated successfully");
                  break;
               case 4:
                  ask_information();
                  find_student(name, idNumber, contactNumber);
                  break;
               case 5:
                  Console.WriteLine("Enter the field you want to display by: ");
                  Console.WriteLine("1. Name");
                  Console.WriteLine("2. ID number");
                  Console.WriteLine("3. Contact number");
                  int sort_by = int.Parse(Console.ReadLine());
                  foreach (Person people in studentRecordManagement.display(sort_by))
                  {
                     Console.WriteLine(people);
                  }
                  break;
               case 8:
                  admin_function();
                  break;
               case 9: 
                  Environment.Exit(0);
                  break;
               default:
                  Console.WriteLine("Invalid option");
                  break;
            }
            student_option = menu("Student");
         }
         catch (Exception e)
         {
            Console.WriteLine(e);
            student_option = menu("Student");
         }
      }
   }
   public void na_function()
   {
      Console.WriteLine("Welcome to the student menu");
      int student_option = student_menu();
      while (true)
      {
         try
         {
            switch (student_option)
            {
               case 1:
                  ask_information();
                  find_student(name, idNumber, contactNumber);
                  break;
               case 2:
                  Console.WriteLine("Enter the field you want to display by: ");
                  Console.WriteLine("1. Name");
                  Console.WriteLine("2. ID number");
                  Console.WriteLine("3. Contact number");
                  int sort_by = int.Parse(Console.ReadLine());
                  foreach (Person people in studentRecordManagement.display(sort_by))
                  {
                     Console.WriteLine(people);
                  }
                  break;
               case 9: 
                  Environment.Exit(0);
                  break;
               default:
                  Console.WriteLine("Invalid option");
                  break;
            }
   
            student_option = student_menu();
         }
         catch (Exception e)
         {
            Console.WriteLine(e);
            student_option = student_menu();
         }
      }
   }

   public string verifying_role()
   {
      try
      {
         role = choose_role();
         if (role == "NA")
         {
            return "Student";
         }

         ask_information();
         if (role.Contains("R"))
         {
            authentication.register(name, idNumber, contactNumber, role);
            Console.WriteLine("Registration successful");
            return "Admin";
         }
         else if (role.Contains("L"))
         {
            Boolean verify = authentication.login(name, idNumber, contactNumber, role);
            if (verify && role == "LA")
            {
               Console.WriteLine("Login successful");
               return "Admin";
            }
            else if (verify && role == "LS")
            {
               Console.WriteLine("Login successful");
               return "Student";
            }
            else
            {
               Console.WriteLine("Login failed");
               return "Student";
            }
         }
      }
      catch (Exception e)
      {
         return verifying_role();
      }
      return "Student";
   }

   public void add_admin(string name, int idNumber, string contactNumber)
   {
     Admin admin = new Admin(name , idNumber, contactNumber);
     adminRecordManagement.add(admin);
   }

   public void delete_admin(int idNumber)
   {
      adminRecordManagement.delete(idNumber);
   }
   
   public void update_admin(string name, int idNumber, string contactNumber)
   {
      Admin admin = new Admin(name , idNumber, contactNumber);
      adminRecordManagement.update(name, idNumber, contactNumber);
   }
   public void find_admin(string name, int idNumber, string contactNumber)
   {
      Admin admin = new Admin(name , idNumber, contactNumber);
      adminRecordManagement.findRecord(name, idNumber, contactNumber);
   }
   public void add_student(string name, int idNumber, string contactNumber)
   {
      Student student = new Student(name , idNumber, contactNumber);
      studentRecordManagement.add(student);
   }
   public void delete_student(int idNumber)
   {
      studentRecordManagement.delete(idNumber);
   }
   public void update_student(string name, int idNumber, string contactNumber)
   {
      Student student = new Student(name , idNumber, contactNumber);
      studentRecordManagement.update(name, idNumber, contactNumber);
   }
   public void find_student(string name, int idNumber, string contactNumber)
   {
      Student student = new Student(name , idNumber, contactNumber);
      studentRecordManagement.findRecord(name, idNumber, contactNumber);
   }

   public string choose_role()
   {
      Console.WriteLine("Here are the roles");
      Console.WriteLine("RA: Register as Admin");
      Console.WriteLine("LA: Login as Admin");
      Console.WriteLine("RS: Register as a Student");
      Console.WriteLine("LS: Login as a Student");
      Console.WriteLine("NA: Non login user");
      Console.WriteLine("E: Exit");
      Console.Write("Choose your roles: ");
      string choice = Console.ReadLine().ToUpper();
      if (choice == "E")
      {
         Environment.Exit(0);
      }
      if (new List<string> { "RA", "LA", "RS", "LS", "NA" }.Contains(choice))
      {
         return choice;
      }
      else
      {
         Console.WriteLine("Invalid choice");
         return choose_role();
      }
   }
}