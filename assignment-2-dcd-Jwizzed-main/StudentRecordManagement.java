package Assignment2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentRecordManagement {
    private LinkedList<Student> studentList;
    StudentXMLRecorder studentXMLRecorder;

    public LinkedList<Student> getStudentList() {
        return studentList;
    }
    public StudentRecordManagement(){
        studentXMLRecorder = new StudentXMLRecorder();
        studentList = new LinkedList<>(Arrays.asList(studentXMLRecorder.loadStudentData()));
    }
    public void add(Student record){
        if (!find(record.getIdNumber()) && (record.getIdNumber() != 0)){
            studentList.add(record);
            studentXMLRecorder.saveStudentData(studentList.toArray(new Student[0]));
        }
        else {
            // Print statement
            throw new IllegalArgumentException("Record already exists in the Record list or Invalid ID number");
        }
    }
    public boolean find(int idNumber){
        for (Student people : studentList){ //for loop to find the match number
            if (people.getIdNumber() == (idNumber)){
                return true;
            }
        }return false;
    }

    public void delete(int recldNumber){
        for (Student people : studentList){//for loop to find the recldNumber
            if (people.getIdNumber() == (recldNumber)){
                studentList.remove(people);
                System.out.println("Record Deleted Successfully");
                try {
                    studentXMLRecorder.saveStudentData(studentList.toArray(new Student[0]));
                }catch (Exception ignored){
                }
            }
        }
    }
    public Student findRecord(int idNumber){
        Student choose = new Student();
        for (Student people : studentList){//for loop to find the idNumber
            if (people.getIdNumber() == (idNumber)){
                choose = people;
            }
        }return choose;
    }
    public void update(int id, Scanner input) {
        if (find(id)) {
            Student rec = findRecord(id);

            // Display message only
            System.out.print("What is the new Student id Number ? ");
            int idNumber = input.nextInt();

            // Display message only
            System.out.print("What is the new Student contact Number ");
            String contactNumber = input.next();

            // Display message only
            System.out.print("What is the new Student Name ? ");
            String name = input.next();

            try{
                Student test_rec = new Student();

                test_rec.setIdNumber(idNumber);
                test_rec.setName(name);
                test_rec.setContactNumber(contactNumber);

                studentList.remove(rec);
                rec.setIdNumber(idNumber);
                rec.setName(name);
                rec.setContactNumber(contactNumber);
                studentList.add(rec);
                studentXMLRecorder.saveStudentData(studentList.toArray(new Student[0]));
                System.out.println("Record Updated Successfully");

            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            // Print statement
            System.out.println("Record Not Found in the Student list");
        }
    }

    public void display(){
        if (studentList.isEmpty()) {
            System.out.println("The list has no records\n");
        }
        for (Student record : studentList) {
            System.out.println(record.toString());
        }
    }
}
