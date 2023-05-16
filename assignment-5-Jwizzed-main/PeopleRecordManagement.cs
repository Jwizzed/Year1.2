namespace ConsoleApplication1;

public class PeopleRecordManagement
{
    private LinkedList<Person> peopleList;

    public LinkedList<Person> getPeopleList()
    {
        return peopleList;
    }

    public PeopleRecordManagement()
    {
        peopleList = new LinkedList<Person>();
    }

    public void add(Person record)
    {
        if (!find(record.getIdNumber()) && (record.getIdNumber() != 0))
        {
            peopleList.AddLast(record);
        }
        else
        { 
            throw new Exception("Record already exists in the Record list or Invalid ID number");
        }
    }
    
    public bool find(int idNumber){
        foreach (Person people in peopleList){ //for loop to find the match number
            if (people.getIdNumber() == (idNumber)){
                return true;
            }
        }return false;
    }
    
    public void delete(int recldNumber){
        foreach (Person people in peopleList){//for loop to find the recldNumber
            if (people.getIdNumber() == (recldNumber)){
                peopleList.Remove(people);
                break;
            }
        } 
    }
    public Person findRecord(string name, int idNumber, string contactNumber){
        Person choose = new Person();
        foreach (Person people in peopleList){//for loop to find the idNumber
            if (people.getIdNumber() == (idNumber)){
                choose = people;
            }
        }return choose;
    }
    
    public void update(string name, int idNumber, string contactNumber) {
        if (find(idNumber)) {
            Person rec = findRecord(name, idNumber, contactNumber);
            
            Console.WriteLine("What is the new Student Name ? ");
            name = Console.ReadLine();
            
            Console.WriteLine("What is the new Student id Number ? ");
            idNumber = Convert.ToInt32(Console.ReadLine());

            // Display message only
            Console.WriteLine("What is the new Student contact Number ");
            contactNumber = Console.ReadLine();

            try{
                Person test_rec = new Person();

                test_rec.setIdNumber(idNumber);
                test_rec.setName(name);
                test_rec.setContactNumber(contactNumber);

                peopleList.Remove(rec);
                rec.setIdNumber(idNumber);
                rec.setName(name);
                rec.setContactNumber(contactNumber);
                peopleList.AddLast(rec);

                Console.WriteLine("Record Updated Successfully");

            }catch (Exception e) {
                Console.WriteLine(e.Message);
            }
        }
        else {
            // Print statement
            Console.WriteLine("Record Not Found in the Student list");
        }
    }

    public LinkedList<Person> display(int sortBy)
    {
        LinkedList<Person> display_list = peopleList;
        if (!display_list.Any())
        {
            return new LinkedList<Person>();
        }
        if (sortBy == 1)
        {
            display_list = new LinkedList<Person>(display_list.OrderBy(x => x.getName()).ToList());
        }
        else if (sortBy == 2)
        {
            display_list = new LinkedList<Person>(display_list.OrderBy(x => x.getIdNumber()).ToList());
        }
        else if (sortBy == 3)
        {
            display_list = new LinkedList<Person>(display_list.OrderBy(x => x.getContactNumber()).ToList());
        }

        return display_list;
    }
    
}