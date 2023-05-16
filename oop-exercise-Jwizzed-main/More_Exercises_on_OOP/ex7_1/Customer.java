package More_Exercises_on_OOP.ex7_1;

public class Customer {
    private String name;
    private boolean member;
    private String memberType;

    public Customer(String name){
        this.name = name;
        this.member = false;
    }
    public String getName() {
        return name;
    }
    public boolean isMember(){
        return this.member;
    }
    public void setMember(boolean member){
        this.member = member;
    }
    public String getMemberType(){
        return this.memberType;
    }
    public void setMemberType(String type){
        this.memberType = type;
    }
    public String toString(){
        return "";
    }
}
