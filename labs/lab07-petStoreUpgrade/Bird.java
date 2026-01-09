public class Bird extends Pets {
    public Bird(String name, String breed) {
        super(name, breed);
    }

    // TODO put your override for makeNoise here
    @Override
    public String makeNoise() {
        return "chirp";
    }

    // TODO put your overload for makeNoise here

    public String makeNoise(Integer num) {
        String noise;
        if (num % 4 == 0) {
            noise = "squawk";
        } else if (num % 3 == 0) {
            noise = "tweet";
        } else if (num % 2 == 0) {
            noise = "chirp";
        }

        else {
            noise = "caw caw";
        }

        return noise;
    }

    // this method returns "[name] ate some seeds", where [name] is the Class
    // variable name
    public String eatSeeds() {
        return getName() + "ate some seeds";
    }

    // TODO put your overloads for eatSeeds() here
    // 1. eatSeeds(boolean) will take in a boolean value. If the boolean is true, return  "[name] ate some seeds". If the boolean is false, return  "[name] did not eat any seeds".
    // 2. eatSeeds(int num) will take in an int value. It will return "[name] ate [num] seeds".

    public String eatSeeds(boolean val) {
        if (val) {
            return getName() + " ate some seeds";
        }
        else {
            return getName() + " did not eat any seeds";
        }
    }

    public String eatSeeds(Integer num) {
        return getName() + " ate " + num + " seeds";
    }

    public static void main(String[] args) {
        Bird Feathers = new Bird("Feathers", "parrot");
        System.out.println(Feathers.makeNoise(16));
        System.out.println(Feathers.makeNoise()); // this should return "chirp"


        System.out.println(Feathers.eatSeeds(false)); //this should return "Feathers did not eat any seeds"
        System.out.println(Feathers.eatSeeds(17)); //this should return "Feathers ate 17 seeds"
    }
}