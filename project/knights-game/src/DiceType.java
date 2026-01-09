import java.util.Random;

public enum DiceType {
	D4(4), D6(6), D8(8), D10(10), D12(12), D20(20);

	// Private fields
    private final int SIZE;
    private static final Random random_machine = new Random();
    
    // Private constructor
    private DiceType(int size) {
        this.SIZE = size;
    }
    
    // Public method
    public int Roll() {
        return random_machine.nextInt(this.SIZE) + 1;  // Random number from 1 to SIZE
    }
    
    // // Optional: getter for SIZE
    // public int getSize() {
    //     return this.SIZE;
    // }
}