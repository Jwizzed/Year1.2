from xml.dom import minidom
from xml.dom.minidom import Node
from xml.etree import ElementTree
from xml.etree.ElementTree import Element, SubElement
from typing import List
from Admin import Admin


class AdminXMLRecorder:
    def __init__(self):
        self.file = "admin.xml"
        self.doc = minidom.parse(self.file)
        self.nodeList = self.doc.getElementsByTagName("admin")

    def loadAdminData(self) -> List[Admin]:
        admin_list = []
        for node in self.nodeList:
            if node.nodeType == Node.ELEMENT_NODE:
                name = node.getElementsByTagName("name")[0].firstChild.data
                idNumber = int(
                    node.getElementsByTagName("idNumber")[0].firstChild.data)
                contactNumber = node.getElementsByTagName("contactNumber")[
                    0].firstChild.data
                try:
                    admin = Admin(name, idNumber, contactNumber)
                    admin_list.append(admin)
                except ValueError as e:
                    print(e)
        return admin_list

    def saveAdminData(self, admins: List[Admin]):
        root = Element('admins')
        for admin in admins:
            admin_elem = Element('admin')
            name = SubElement(admin_elem, 'name')
            name.text = admin.name
            id_number = SubElement(admin_elem, 'idNumber')
            id_number.text = str(admin.idNumber)
            contact_number = SubElement(admin_elem, 'contactNumber')
            contact_number.text = admin.contactNumber
            root.append(admin_elem)

        xmlstr = minidom.parseString(ElementTree.tostring(root)).toprettyxml(indent="    ")
        with open(self.file, "w") as f:
            f.write(xmlstr)

    def deletePerson(self):
        root = self.doc.documentElement
        for node in root.getElementsByTagName("admin"):
            root.removeChild(node)
        xmlstr = self.doc.toprettyxml(indent="    ")
        with open(self.file, "w") as f:
            f.write(xmlstr)
