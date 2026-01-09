public class Knight extends MOB {
    private Fortune activeFortune;

    protected final int id;
    protected int xp;

    public Knight(int id, String name, int hp, int armor, int hitModifier, DiceType damageDie, int xp) {
        super(name, hp, armor, hitModifier, damageDie);
        this.id = id;
        this.xp = xp;
        this.activeFortune = null;
    }

    public void addXP(int xp) {
        this.xp += xp;
    }

    public Fortune getActiveFortune() {
        return this.activeFortune;
    }

    @Override
    public int getArmor() {
        if (getActiveFortune() == null) {
            return super.getArmor();
        }
        return super.getArmor() + activeFortune.getArmor();
    }

    @Override
    public DiceType getDamageDie() {
        if (getActiveFortune() != null && activeFortune.getDamageDie() != null) {
            return activeFortune.getDamageDie();
        }
        return super.getDamageDie();
    }

    @Override
    public int getHitModifier() {
        if (getActiveFortune() != null) {
            return super.getHitModifier() + activeFortune.getHitModifier();
        }
        return super.getHitModifier();
    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public int getMaxHP() {
        if (getActiveFortune() == null) {
            return super.getMaxHP();
        }
        return super.getMaxHP() + activeFortune.getMaxHP();
    }

    public int getXP() {
        return this.xp;
    }

    public void setActiveFortune(Fortune activeFortune) {
        this.activeFortune = activeFortune;
    }

    public String toCSV() {
        return getName() + "," + super.getMaxHP() + "," + super.getArmor() + "," +
                super.getHitModifier() + "," + super.getDamageDie() + "," + xp;
    }

    @Override
    public String toString() {
        return "+============================+\n" +
                String.format("| %-27s|%n", getName()) +
                String.format("| id: %-23d|%n", getId()) +
                "|                            |\n" +
                String.format("| Health: %-6d  XP: %-7d|%n", getHP(), getXP()) +
                String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                "|                            |\n" +
                "+============================+";
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Knight Class ===\n");

        Knight theKnight = new Knight(30, "Mufasa", 10, 5, 2, DiceType.D12, 0);
        System.out.println("TESTING Armor in Knight " + theKnight.getArmor());
        System.out.println("Active Fortune: " + theKnight.getActiveFortune());

        Knight fortuneKnight = new Knight(2, "Marcus", 80, 10, 3, DiceType.D8, 50);
        Fortune sword = new Fortune("Excalibur", 5, 2, 20, DiceType.D10);

        fortuneKnight.setActiveFortune(sword);
        System.out.println("Armor: " + fortuneKnight.getArmor());
        System.out.println("Max HP: " + fortuneKnight.getMaxHP());
    }

}
