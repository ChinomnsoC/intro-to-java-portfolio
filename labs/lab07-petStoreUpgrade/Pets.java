public class Pets {
    String name;
    String breed;
    public Pets(String name, String breed){
        this.name = name;
        this.breed = breed;
    }
    public String getName(){
        return name;
    }
    public String getBreed(){
        return breed;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setBreed(String breed){
        this.breed = breed;
    }
    public String makeNoise(){
        return "[animal noise]";
    }
    
    public static void main(String[] args){
        
    }
}