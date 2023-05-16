from Admin import Admin
from AdminRecordManagement import AdminRecordManagement
from Student import Student
from StudentRecordManagement import StudentRecordManagement


class Authentication:
    def __init__(self):
        pass

    def register(self, name, idNumber, contactNumber, role):

        if role == "RA":
            admin = Admin(name, idNumber, contactNumber)
            admin_record_management = AdminRecordManagement()
            admin_record_management.add(admin)

        elif role == "RS":
            student = Student(name, idNumber, contactNumber)
            student_record_management = StudentRecordManagement()
            student_record_management.add(student)
        else:
            raise ValueError("User not found\n")

    def login(self, name, idNumber, contactNumber, role):

        if role == "LA":
            admin = Admin(name, idNumber, contactNumber)
            admin_record_management = AdminRecordManagement()
            found = admin_record_management.findRecord(admin.name, admin.idNumber,admin.contactNumber)
            if found:
                return True
            else:
                raise ValueError("User not found\n")

        if role == "LS":
            student = Student(name, idNumber, contactNumber)
            student_record_management = StudentRecordManagement()
            found = student_record_management.findRecord(student.name,student.idNumber,student.contactNumber)
            if found:
                return True
            else:
                raise ValueError("User not found\n")

        if role == "NA":
           return True

        return False


