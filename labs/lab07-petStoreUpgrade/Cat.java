public class Cat extends Pets {
    private String badName;

    public Cat(String name, String breed) {
        // TODO Student Code
        super(name, breed);
        this.badName = "";

    }

    public Cat(String name, String breed, String badName) {
        // TODO Student Code
        super(name, breed);
        this.badName = badName;

    }

    // TODO Student Code -- Write an override for makeNoise() and for getName()
    @Override
    public String getName() {
        String overridden;
        overridden = name + " aka " + this.badName;
        return overridden;
    }

    public String getName(String badName) {
        String overridden;
        overridden = name + " aka " + badName;
        return overridden;
    }


    public void setNewName(String badName) {
        this.badName = badName;
    }

    @Override
    public String makeNoise() {
        return "meow";
    }

    public static void main(String[] args) {
        Cat Gyorik = new Cat("Gyorik", "russian blue");
        System.out.println(Gyorik.makeNoise());

        Cat Gyoriks = new Cat("Gyoriks", "russian blue", "Wretched Man");
        System.out.println(Gyoriks.getName()); // this should now return "Gyoriks aka Wretched Man"
    }
}