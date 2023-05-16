from PeopleRecordManagement import PeopleRecordManagement
from StudentXMLRecorder import StudentXMLRecorder


class StudentRecordManagement(PeopleRecordManagement):
    def __init__(self):
        super().__init__()
        self.peopleXMLRecorder = StudentXMLRecorder()
        self.peopleList = self.peopleXMLRecorder.loadStudentData()
