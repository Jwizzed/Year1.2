from PeopleRecordManagement import PeopleRecordManagement
from AdminXMLRecorder import AdminXMLRecorder
from Admin import Admin


class AdminRecordManagement(PeopleRecordManagement):
    def __init__(self):
        super().__init__()
        self.peopleXMLRecorder = AdminXMLRecorder()
        self.peopleList = self.peopleXMLRecorder.loadAdminData()

    def add(self, record):
        if (not self.find(record.idNumber)) and (record.idNumber != 0):
            self.peopleList.append(record)
            self.peopleXMLRecorder.saveAdminData(self.peopleList)
        else:
            raise ValueError("Record already exists in the Record list or Invalid ID number")

    def delete(self, recldNumber: int):
        for people in self.peopleList:
            if people.idNumber == recldNumber:
                self.peopleList.remove(people)
                try:
                    self.peopleXMLRecorder.saveAdminData(self.peopleList)
                except Exception:
                    continue


    def update(self, name:str, idNumber: int, contactNumber: str):
        if self.find(idNumber):
            rec = self.findRecord(name, idNumber, contactNumber)
            name = input("Enter the new name: ")
            idNumber = int(input("Enter the new ID number: "))
            contactNumber = input("Enter the new contact number: ")
            try:
                test_rec = Admin(name, idNumber, contactNumber)
                self.peopleList.remove(rec)
                rec = Admin(name, idNumber, contactNumber)
                self.peopleList.append(rec)
                self.peopleXMLRecorder.saveAdminData(self.peopleList)
            except ValueError as e:
                return e

        else:
            raise "Record Not Found in the Student list"
