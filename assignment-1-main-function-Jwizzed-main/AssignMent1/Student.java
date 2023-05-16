package Assignment2;

public class Student {
    private String name;
    private int idNumber;
    private String contactNumber;
    public Student(){

    }
    public Student(String name, int idNumber, String contactNumber){
        setName(name);
        setIdNumber(idNumber);
        setContactNumber(contactNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        int new_num = idNumber;
        while (new_num>10){
            new_num/=10;
        }
        if ((int)Math.log10(idNumber) == 7 && (new_num % 10 != 0)){ //find the length of idnumber.
            this.idNumber = idNumber;
        }else{
            throw new IllegalArgumentException("Invalid ID number");
        }
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) { //replace all possible non-numeric
        contactNumber = contactNumber.replace("-","").replace("(","").replace(")","");
        if(contactNumber.startsWith("02") && (contactNumber.length() == 9)){
            this.contactNumber = contactNumber;
        }else if(contactNumber.startsWith("0") && (contactNumber.length() == 10)){
            this.contactNumber = contactNumber;
        }else{
            throw new IllegalArgumentException("Invalid contact number");
        }
    }

    public String toString(){
        return "Records{" + "name=" + name + ", idNumber=" + idNumber + ", contactNumber=" + contactNumber + '}';
    }
}
