from StudentXMLRecorder import StudentXMLRecorder
from Person import Person
from Student import Student


class PeopleRecordManagement:
    def __init__(self):
        self.peopleXMLRecorder = StudentXMLRecorder()
        self.peopleList = self.peopleXMLRecorder.loadStudentData()

    def add(self, record):
        if (not self.find(record.idNumber)) and (record.idNumber != 0):
            self.peopleList.append(record)
            self.peopleXMLRecorder.saveStudentData(self.peopleList)
        else:
            raise ValueError("Record already exists in the Record list or Invalid ID number")


    def find(self, idNumber: int):
        for people in self.peopleList:
            if people.idNumber == idNumber:
                return True
        return False

    def delete(self, recldNumber: int):
        for people in self.peopleList:
            if people.idNumber == recldNumber:
                self.peopleList.remove(people)
                print("Record Deleted Successfully")
                try:
                    self.peopleXMLRecorder.saveStudentData(self.peopleList)
                except Exception:
                    continue

    def findRecord(self, name:str, idNumber:int, contactNumber:str):
        choose = None
        for people in self.peopleList:
            if people.idNumber == idNumber and people.name == name and people.contactNumber == contactNumber:
                choose = people
        if choose is None:
            raise ValueError("Record not found")
        return choose

    def update(self, name:str, idNumber: int, contactNumber: str):
        if self.find(idNumber):
            rec = self.findRecord(name, idNumber, contactNumber)
            name = input("What is the new Student Name? ")
            idNumber = int(input("What is the new Student id Number? "))
            contactNumber = input("What is the new Student contact Number? ")


            try:
                test_rec = Person(name, idNumber, contactNumber)
                self.peopleList.remove(rec)
                rec = Student(name, idNumber, contactNumber)
                self.peopleList.append(rec)
                self.peopleXMLRecorder.saveStudentData(self.peopleList)
                print("Record Updated Successfully")

            except ValueError as e:
                print(e)

        else:
            print("Record Not Found in the Student list")

    def display(self, sort_by: int):
        display_list = self.peopleList
        if not self.peopleList:
            return ["No records found"]
        if sort_by == 1:
            display_list.sort(key=lambda x: x.name)
        elif sort_by == 2:
            display_list.sort(key=lambda x: x.idNumber)
        elif sort_by == 3:
            display_list.sort(key=lambda x: x.contactNumber)
        return display_list
