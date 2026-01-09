public class Fortune implements Attributes {
    // private fields
    private String name;
    private int hpBonus;
    private int armor;
    private int hitModifier;
    private DiceType dtype;



    public Fortune (String name,  int hpBonus, int armor, int hitModifier) {
        this.name = name;
        this.hpBonus = hpBonus;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.dtype = null;
    }

    public Fortune(String name, int hpBonus, int armor, int hitModifier,  DiceType dtype) {
        this.name = name;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.hpBonus = hpBonus;
        this.dtype = dtype;
    }

    @Override
    public int getArmor(){
        return this.armor;
    }

    @Override
    public DiceType getDamageDie(){
        return this.dtype;
    }

    @Override
    public int getHitModifier() {
        return this.hitModifier;
    }

    @Override
    public int getMaxHP() {
        return this.hpBonus;
    }

    // Additional public methods
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        String card = "+======================+\n";
        card += String.format("|%-22s|%n", getName());
        card += String.format("|HP Bonus: %12s|%n", "+" + getMaxHP());
        card += String.format("|AC Bonus: %12s|%n", "+" + getArmor());
        card += String.format("|Hit Bonus: %11s|%n", "+" + getHitModifier());
        card += String.format("|Damage Adj: %10s|%n", getDamageDie() != null ? getDamageDie() : "-");
        card += "+======================+";

        return card;
    }

    public static void main(String[] args) {
    System.out.println("=== Testing Fortune Class ===\n");

    Fortune ftn = new Fortune("Merlin Luck", 10, 5, 2, DiceType.D12);
    System.out.println("TESTING Armor in fortune " + ftn.getArmor());

    // Test 1: Constructor with 4 parameters (no DiceType)
    System.out.println("--- Test 1: Constructor without DiceType ---");
    Fortune fortune1 = new Fortune("Amulet of Protection", 10, 3, 50);
    System.out.println("Created: " + fortune1.getName());
    System.out.println("Armor: " + fortune1.getArmor());
    System.out.println("Hit Modifier: " + fortune1.getHitModifier());
    System.out.println("Max HP: " + fortune1.getMaxHP());
    System.out.println("Damage Die: " + fortune1.getDamageDie());
    System.out.println("toString(): " + fortune1.toString());
    System.out.println();
    
    // Test 2: Constructor with 5 parameters (with DiceType)
    System.out.println("--- Test 2: Constructor with DiceType ---");
    Fortune fortune2 = new Fortune("Sword of Destiny", 5, 5, 30, DiceType.D12);
    System.out.println("Created: " + fortune2.getName());
    System.out.println("Armor: " + fortune2.getArmor());
    System.out.println("Hit Modifier: " + fortune2.getHitModifier());
    System.out.println("Max HP: " + fortune2.getMaxHP());
    System.out.println("Damage Die: " + fortune2.getDamageDie());
    System.out.println("toString(): " + fortune2.toString());
    System.out.println();
    
    
    // Test 3: Testing with zero/negative values
    System.out.println("--- Test 3: Edge cases (zero/negative values) ---");
    Fortune fortune5 = new Fortune("Cursed Item", 0, -2, 10, DiceType.D4);
    System.out.println("Armor (0): " + fortune5.getArmor());
    System.out.println("Hit Modifier (-2): " + fortune5.getHitModifier());
    System.out.println();

    
    // Test 4: Testing toString() format
    System.out.println("--- Test 4: toString() Output ---");
    System.out.println(fortune1);
    System.out.println(fortune2);
    System.out.println();
    
    // Test 5: Testing polymorphism (Fortune as Attributes)
    System.out.println("--- Test 5: Polymorphism (Attributes interface) ---");
    Attributes attr = new Fortune("Polymorphic Fortune", 12, 4, 60, DiceType.D10);
    System.out.println("Armor: " + attr.getArmor());
    System.out.println("Hit Modifier: " + attr.getHitModifier());
    System.out.println("Max HP: " + attr.getMaxHP());
    System.out.println("Damage Die: " + attr.getDamageDie());
    System.out.println();
    
    System.out.println("=== All Tests Complete ===");
}
}
