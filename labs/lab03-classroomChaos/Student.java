public class Student {
    String name;
    int ID;
    public Student(String name, int ID){
        this.name = name;
        this.ID = ID;
    }
    public void setName(String name){ this.name = name; }
    public String getName(){ return name; }
    public void setID(int ID){ this.ID = ID; }
    public int getID(){ return ID; }
}