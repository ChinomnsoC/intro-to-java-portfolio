import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleView extends Object implements GameView {
    private final Scanner in;

    public ConsoleView() {
        this.in = new Scanner(System.in);
    }

    @Override
    public void splashScreen() {
        System.out.println("Round Table Games: Knights of Legend");
        System.out.println("loading...");
    }

    @Override
    public void endGame() {
        System.out.println("Thanks for playing!!!");
    }

    @Override
    public String displayMainMenu() {
        System.out.print("What would you like to do? ");
        return in.nextLine();
    }

    @Override
    public void printHelp() {

        System.out.println("Unsure what to do, here are some options:");
        System.out.println("    ls or list all  - listing the knights");
        System.out.println("    list active  - list the active knights knights only");
        System.out.println("    show name or id - show the knight details card");
        System.out.println("    set active name or id - set knight as active (note: only 4 knights can be active)");
        System.out.println("    remove active name or id - remove a knight from active status (heals knight)");
        System.out.println("    explore or adventure or quest - find random monsters to fight");
        System.out.println("    save filename - save the game to the file name (default: saveData.csv)");
        System.out.println("    exit or goodbye - to leave the game");
        System.out.println();
        System.out.println(
                "Game rules: You can have four active knights. As long as they are active, they won't heal, but they can gain XP by going on adventures.");
        System.out.println(
                "When you make a knight inactive, they will heal. How many monsters can you defeat before, you have to heal?");
    }

    @Override
    public void listKnights(List<Knight> knights) {

        if (knights == null || knights.isEmpty()) {
            System.out.println("No knights to list");
        } else {
            for (Knight knight : knights) {
                System.out.println(knight.getId() + ": " + knight.getName());
            }
        }
    }

    @Override
    public void knightNotFound() {
        System.out.print("Knight not found!");
    }

    @Override
    public void showKnight(Knight knight) {
        System.out.println(knight);
    }

    @Override
    public void setActiveFailed() {
        System.out.println("Unable to set active knight. Only four can be active at a time.");
    }

    @Override
    public void printBattleText(List<MOB> monsters, List<Knight> activeKnights) {
        System.out.println("Our heroes come across the following monsters. Prepare for battle!");
        System.out.println("Knights                     Foes");

        int sizeOfLongerList = Math.max(monsters.size(), activeKnights.size());

        for (int i = 0; i < sizeOfLongerList; i++) {
            String nameOfKnight = "";
            String nameOfMonster = "";

            if (i < monsters.size()) {
                nameOfMonster = monsters.get(i).getName();
            }
            if (i < activeKnights.size()) {
                nameOfKnight = activeKnights.get(i).getName();
            }

            System.out.printf("%-27s %s%n", nameOfKnight, nameOfMonster);
        }
        System.out.println();
    }

    @Override
    public void printBattleText(MOB dead) {
        String nameOfDeadMonster = dead.getName();
        System.out.println(nameOfDeadMonster + " was defeated!");
    }

    @Override
    public void printFortunes(List<Knight> activeKnights) {

        if (activeKnights == null || activeKnights.isEmpty()) {
            System.out.println("No active knights to list");
        } else {
            System.out.println("For this quest, our knights drew the following fortunes!");
            for (Knight activeKnight : activeKnights) {
                System.out.println(activeKnight.getName() + " drew");
                System.out.println(activeKnight.getActiveFortune());
            }
        }

    }

    @Override
    public boolean checkContinue() {
        System.out.print("Would you like to continue on your quest (y/n)? ");
        String response = in.nextLine();

        if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }

    @Override
    public void printDefeated() {
        System.out.println("All active knights have been defeated!");
    }

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();

        List<Knight> knights = new ArrayList<>();
        knights.add(new Knight(1, "Guinevere", 400, 15, 5, DiceType.D4, 0));
        knights.add(new Knight(2, "Arthur", 90, 12, 4, DiceType.D10, 50));
        knights.add(new Knight(3, "Lancelot", 345, 10, 3, DiceType.D6, 25));

        List<MOB> monsters = new ArrayList<>();
        monsters.add(new MOB("Umber Hulk", 55, 13, 1, DiceType.D6));
        monsters.add(new MOB("Frost Giant", 70, 15, 2, DiceType.D8));
        MOB deadMob = new MOB("Icy Giant", 990, 25, 1, DiceType.D8);
        monsters.add(deadMob);

        List<Knight> activeKnights = new ArrayList<>();

        Knight KnightGuinevere = new Knight(1, "Guinevere", 400, 15, 5, DiceType.D4, 0);
        Knight KnightLancelot = new Knight(3, "Lancelot", 345, 10, 3, DiceType.D6, 25);
        
        Fortune fortune1 = new Fortune("Excalibur", 20, 5, 3, DiceType.D12);
        Fortune fortune2 = new Fortune("Valor", 10, 0, 0);

        KnightGuinevere.setActiveFortune(fortune2);
        KnightLancelot.setActiveFortune(fortune1);

        activeKnights.add(KnightLancelot);
        activeKnights.add(KnightGuinevere);

        view.printBattleText(monsters, knights);
        view.printBattleText(deadMob);
        view.printFortunes(activeKnights);
    }
}
