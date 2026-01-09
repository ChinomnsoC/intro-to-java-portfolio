// MOB

// #int : armor
// #int : damage
// #DiceType : damageDie
// #int : hitModifier
// #int : maxHP
// -String : name

// +MOB(String, int, int, int, DiceType)

public class MOB extends Object implements Attributes{
    protected int armor;
    protected int damage;
    protected DiceType damageDie;
    protected int hitModifier;
    protected int maxHP;
    private String name;

    public MOB(String name, int hp, int armor, int hitModifier, DiceType damageDie) {
        this.name = name;
        this.maxHP = hp;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.damageDie = damageDie;

    }

    public void addDamage(int damageNumber) {
        damage += damageNumber;
    }

    public MOB copy() {
        return new MOB(this.name, this.maxHP, this.armor, this.hitModifier, this.damageDie);
    }

    public int getArmor() {
        return this.armor;
    }

    public int getDamage() {
        return this.damage;
    }

    public DiceType getDamageDie() {
        return this.damageDie;
    }

    public int getHitModifier() {
        return this.hitModifier;
    }

    public int getHP() {
        return this.maxHP - this.damage;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "+============================+\n" +
                String.format("| %-27s|%n", getName()) +
                "|                            |\n" +
                String.format("|         Health: %-10d |%n", getHP()) +
                String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                "|                            |\n" +
                "+============================+";
    }

    public void resetDamage() {
        this.damage = 0;
    }

    public static void main(String[] args) {

    }

}
