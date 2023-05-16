package Assignment2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class StudentXMLRecorder {
    public File file;
    public DocumentBuilderFactory dbf;
    public DocumentBuilder db;
    public Document doc;
    public NodeList nodeList;

    public StudentXMLRecorder() {
        try {
            file = new File("src/Assignment2/data.xml");
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = db.parse(file);
            doc.getDocumentElement().normalize();
            nodeList = doc.getElementsByTagName("student");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student[] loadStudentData() {
        try {
            Student[] student = new Student[nodeList.getLength()];
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    try {
                        student[itr] = new Student();
                        student[itr].setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                        student[itr].setIdNumber(Integer.parseInt(eElement.getElementsByTagName("idNumber").item(0).getTextContent()));
                        student[itr].setContactNumber(eElement.getElementsByTagName("contactNumber").item(0).getTextContent());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveStudentData(Student[] students) {
        //This method will save the student data to the XML file.
        try {
            deletePerson();
            for (int itr = 0; itr < students.length; itr++) {
                Element student = doc.createElement("student");
                Element name = doc.createElement("name");
                Element idNumber = doc.createElement("idNumber");
                Element contactNumber = doc.createElement("contactNumber");

                name.appendChild(doc.createTextNode(students[itr].getName()));
                student.appendChild(name);
                idNumber.appendChild(doc.createTextNode(String.valueOf(students[itr].getIdNumber())));
                student.appendChild(idNumber);
                contactNumber.appendChild(doc.createTextNode(students[itr].getContactNumber()));
                student.appendChild(contactNumber);
                doc.getDocumentElement().appendChild(student);
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("src/Assignment2/data.xml"));
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                transformer.transform(domSource, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePerson() {
        try {
            doc = db.parse("src/Assignment2/data.xml");
            for(int i = 0; i < nodeList.getLength(); i++) {
                Node nodeToDelete = doc.getElementsByTagName("student").item(0);
                nodeToDelete.getParentNode().removeChild(nodeToDelete);
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("src/Assignment2/data.xml"));
                transformer.transform(source, result);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
