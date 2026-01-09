public class Hamster extends Pets {
    public Hamster(String name, String breed) {
        // TODO Student Code
        super(name, breed);
    }

    // TODO Student Code --override makeNoise()
    @Override
    public String makeNoise() {
        return "squeak";
    }

    // This method should take in an array of strings. If any of the strings is
    // "tired", return false. Otherwise, return true.
    public boolean wheelRun(String[] run) {
        // TODO Student Code

        for (int i = 0; i <= run.length - 1; i++) {
            System.out.println(run[i]);
            if (run[i] == "tired") {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] run = { "sleepy", "happy", "excited", "angry", "tired", "hungry" };
        Hamster Chewy = new Hamster("Chewy", "dwarf");
        System.out.println(Chewy.wheelRun(run)); // this should return true

    }
}