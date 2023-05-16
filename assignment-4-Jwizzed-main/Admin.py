from Person import Person


class Admin(Person):
    def __init__(self, name, idNumber, contactNumber):
        super().__init__(name, idNumber, contactNumber)