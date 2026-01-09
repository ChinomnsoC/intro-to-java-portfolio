public class Dog extends Pets {
    public Dog(String name, String breed) {
        // TODO Student Code
        super(name, breed);

    }

    // TODO Student Code -- override makeNoise()
    @Override
    public String makeNoise() {
        return "bark";
    }

    // This function should take in a number, multiply it by seven, and then return
    // the appropriate string depending on if the number is even or odd
    public String playFetch(int num) {
        int result = num * 7;

        if ((result % 2) == 0) {
            return "returned the ball";
        } else {
            return "won't give it back";
        }

    }

    public static void main(String[] args) {
        Dog Fido = new Dog("Fido", "mixed");
        System.out.println(Fido.playFetch(3)); // this should return "won't give it back"

    }
}