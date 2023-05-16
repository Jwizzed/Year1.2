import math
import re


class Person:
    def __init__(self, name, idNumber, contactNumber):
        self.name = name
        self.idNumber = idNumber
        self.contactNumber = contactNumber

    @property
    def name(self):
        return self.__name

    @name.setter
    def name(self, name):
        self.__name = name

    @property
    def idNumber(self):
        return self.__idNumber

    @idNumber.setter
    def idNumber(self, idNumber):

        new_num = idNumber
        while new_num > 10:
            new_num /= 10

        if int(math.log10(idNumber)) == 7 and (new_num % 10 != 0):
            self.__idNumber = idNumber
        else:
            raise ValueError("Invalid ID number\n")

    @property
    def contactNumber(self):
        return self.__contactNumber

    @contactNumber.setter
    def contactNumber(self, contactNumber):
        contactNumber = contactNumber.replace("[^0-9]", "")
        pattern = re.compile("^02\d{7}|0\d{9}", re.IGNORECASE)
        matcher = pattern.match(contactNumber)
        if matcher:
            self.__contactNumber = contactNumber
        else:
            raise ValueError("Invalid contact number\n")

    def __str__(self):
        return "Records{" + "name=" + self.name + ", idNumber=" + str(self.idNumber) + ", contactNumber=" + self.contactNumber + '}'