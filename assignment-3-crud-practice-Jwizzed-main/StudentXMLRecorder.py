from xml.dom import minidom
from xml.dom.minidom import Node
from xml.etree import ElementTree
from xml.etree.ElementTree import Element, SubElement
from typing import List
from Student import Student


class StudentXMLRecorder:
    def __init__(self):
        self.file = "student.xml"
        self.doc = minidom.parse(self.file)
        self.nodeList = self.doc.getElementsByTagName("student")

    def loadStudentData(self) -> List[Student]:
        student_list = []
        for node in self.nodeList:
            if node.nodeType == Node.ELEMENT_NODE:
                name = node.getElementsByTagName("name")[0].firstChild.data
                idNumber = int(node.getElementsByTagName("idNumber")[0].firstChild.data)
                contactNumber = node.getElementsByTagName("contactNumber")[0].firstChild.data
                try:
                    student = Student(name, idNumber, contactNumber)
                    student_list.append(student)
                except ValueError as e:
                    print(e)
        return student_list

    def saveStudentData(self, students: List[Student]):
        root = Element('students')
        for student in students:
            student_elem = Element('student')
            name = SubElement(student_elem, 'name')
            name.text = student.name
            id_number = SubElement(student_elem, 'idNumber')
            id_number.text = str(student.idNumber)
            contact_number = SubElement(student_elem, 'contactNumber')
            contact_number.text = student.contactNumber
            root.append(student_elem)

        xmlstr = minidom.parseString(ElementTree.tostring(root)).toprettyxml(indent="    ")
        with open(self.file, "w") as f:
            f.write(xmlstr)

    def deletePerson(self):
        root = self.doc.documentElement
        for node in root.getElementsByTagName("student"):
            root.removeChild(node)
        xmlstr = self.doc.toprettyxml(indent="    ")
        with open(self.file, "w") as f:
            f.write(xmlstr)
