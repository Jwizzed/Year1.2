from Admin import Admin
from Student import Student
from AdminRecordManagement import AdminRecordManagement
from Authentication import Authentication
from StudentRecordManagement import StudentRecordManagement


class FacadeController:
    def __init__(self):
        self.authentication = Authentication()
        self.verify_role = self.verifying_role()
        self.role = ""
        self.name = ""
        self.idNumber = 0
        self.contactNumber = ""


    def start_program(self):
        if self.verify_role == "Admin":
            self.admin_function()
        else:
            print("There is noting you can do in this assignment bye")
            exit()

    def menu(self, role: str):
        print("MENU")
        print(f"1: Add {role}")
        print(f"2: Delete {role}")
        print(f"3: Update {role}")
        print(f"4: Search {role}")
        print(f"5: Display {role}")
        print(f"8: Switch to Manage Student/Manage Admin: Current is {role}")
        print(f"9: Exit program")
        return int(input("Enter your selection : "))

    def ask_information(self):
        self.name = input("Enter your name: ")
        self.idNumber = int(input("Enter your ID Number: "))
        self.contactNumber = input("Enter your contact number: ")

    def admin_function(self):
        print("Welcome to the admin menu")
        admin_option = self.menu("Admin")
        while True:
            try:
                if admin_option == 1:
                    self.ask_information()
                    self.add_admin(self.name, self.idNumber, self.contactNumber)
                    print("admin added")

                elif admin_option == 2:
                    id = int(input("Enter your ID Number: "))
                    self.delete_admin(id)
                    print("admin deleted")

                elif admin_option == 3:
                    self.ask_information()
                    self.update_admin(self.name, self.idNumber, self.contactNumber)
                    print("admin updated")

                elif admin_option == 4:
                    self.ask_information()
                    self.find_admin(self.name, self.idNumber, self.contactNumber)

                elif admin_option == 5:
                    sort_by = int(
                        input("Enter the field you want to sort by: \n"
                              "1. Name\n"
                              "2. ID Number\n"
                              "3. Contact Number\n"))
                    for people in AdminRecordManagement().display(sort_by):
                        print(people)


                elif admin_option == 8:
                    self.student_function()

                elif admin_option == 9:
                    exit()
                admin_option = self.menu("Admin")
            except ValueError as e:
                print(f"{e}")
                admin_option = self.menu("Admin")

    def student_function(self):
        print("Welcome to the student menu")
        student_option = self.menu("Student")
        while True:
            try:
                if student_option == 1:
                    self.ask_information()
                    self.add_student(self.name, self.idNumber,self.contactNumber)
                    print("student added")

                elif student_option == 2:
                    id = int(input("Enter your ID Number: "))
                    self.delete_student(id)
                    print("student deleted")

                elif student_option == 3:
                    self.ask_information()
                    self.update_student(self.name,
                                                        self.idNumber,
                                                        self.contactNumber)
                    print("student updated")

                elif student_option == 4:
                    self.ask_information()
                    self.find_student(self.name, self.idNumber,
                                                      self.contactNumber)

                elif student_option == 5:
                    sort_by = int(input("Enter the field you want to sort by: \n"
                                    "1. Name\n"
                                    "2. ID Number\n"
                                    "3. Contact Number\n"))
                    for people in StudentRecordManagement().display(sort_by):
                        print(people)

                elif student_option == 8:
                    self.admin_function()

                elif student_option == 9:
                    exit()
                student_option = self.menu("Student")
            except ValueError as e:
                print(f"{e}")
                student_option = self.menu("Student")


    def verifying_role(self):
        try:
            role = self.choose_role()
            self.ask_information()
            if "R" in role:
                self.authentication.register(self.name, self.idNumber, self.contactNumber,role)
                print("Register Successful")
                return "Admin"
            else:
                verify = self.authentication.login(self.name, self.idNumber, self.contactNumber,role)
                if verify and role == "LA":
                    print("Login Successful")
                    return "Admin"
                elif verify and role == "LS":
                    print("Login Successful")
                    return "Student"
        except ValueError as e:
            self.verifying_role()


    def add_admin(self, name, idNumber, contactNumber):
        admin = Admin(name, idNumber, contactNumber)
        admin_record_management = AdminRecordManagement()
        admin_record_management.add(admin)

    def delete_admin(self, idNumber):
        admin_record_management = AdminRecordManagement()
        admin_record_management.delete(idNumber)

    def update_admin(self, name, idNumber, contactNumber):
        admin = Admin(name, idNumber, contactNumber)
        admin_record_management = AdminRecordManagement()
        admin_record_management.update(admin.name, admin.idNumber, admin.contactNumber)

    def find_admin(self, name, idNumber, contactNumber):
        admin = Admin(name, idNumber, contactNumber)
        admin_record_management = AdminRecordManagement()
        admin_record_management.findRecord(admin.name, admin.idNumber, admin.contactNumber)


    def add_student(self, name, idNumber, contactNumber):
        student = Student(name, idNumber, contactNumber)
        student_record_management = StudentRecordManagement()
        student_record_management.add(student)

    def delete_student(self, idNumber):
        student_record_management = StudentRecordManagement()
        student_record_management.delete(idNumber)

    def update_student(self, name, idNumber, contactNumber):
        student = Student(name, idNumber, contactNumber)
        student_record_management = StudentRecordManagement()
        student_record_management.update(student.name, student.idNumber, student.contactNumber)

    def find_student(self, name, idNumber, contactNumber):
        student = Student(name, idNumber, contactNumber)
        student_record_management = StudentRecordManagement()
        student_record_management.findRecord(student.name, student.idNumber, student.contactNumber)

    def choose_role(self):
        choice = input("Here are the roles\n"
                       "RA: Register as Admin\n"
                       "LA: Login as Admin\n"
                       "RS: Register as a Student\n"
                       "LS: Login as a Student\n"
                       "E: Exit\n"
                       "Choose your roles: ").upper()
        if choice == "E":
            exit()
        if choice in ["RA", "LA", "RS", "LS"]:
            return choice
        else:
            print("Invalid choice")
            return self.choose_role()
