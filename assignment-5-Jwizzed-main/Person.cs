namespace ConsoleApplication1;

public class Person
{
    private string name;
    private int idNumber;
    private string contactNumber;

    public Person()
    {
    }

    public Person(String name, int idNumber, String contactNumber)
    {
        setName(name);
        setIdNumber(idNumber);
        setContactNumber(contactNumber);
    }

    public string getName()
    {
        return name;
    }

    public void setName(string name)
    {
        this.name = name;
    }

    public int getIdNumber()
    {
        return idNumber;
    }

    public void setIdNumber(int idNumber)
    {
        int new_num = idNumber;
        while (new_num > 10)
        {
            new_num /= 10;
        }

        if ((int)Math.Log10(idNumber) == 7 && (new_num % 10 != 0))
        {
            this.idNumber = idNumber;
        }
        else
        {
            throw new Exception(("Invalid ID number"));
        }
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        contactNumber = contactNumber.Replace("-","").Replace("(","").Replace(")","");
        if(contactNumber.StartsWith("02") && (contactNumber.Length == 9)){
            this.contactNumber = contactNumber;
        }else if(contactNumber.StartsWith("0") && (contactNumber.Length == 10)){
            this.contactNumber = contactNumber;
        }else{
            throw new Exception(("Invalid contact number"));
        }
    }

    public String toString(){
        return "Records{" + "name=" + name + ", idNumber=" + idNumber + ", contactNumber=" + contactNumber + '}';
    }
}