from PeopleRecordManagement import PeopleRecordManagement
from AdminXMLRecorder import AdminXMLRecorder


class AdminRecordManagement(PeopleRecordManagement):
    def __init__(self):
        super().__init__()
        self.peopleXMLRecorder = AdminXMLRecorder()
        self.peopleList = self.peopleXMLRecorder.loadAdminData()
