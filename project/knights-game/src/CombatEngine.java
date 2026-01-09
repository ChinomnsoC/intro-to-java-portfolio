import java.util.ArrayList;
import java.util.List;
// import java.util.Random;
import java.util.Random;

public class CombatEngine extends Object {
    private final GameData data;
    private final Random rnd = new Random();
    private final GameView view;

    public CombatEngine(GameData data, GameView view) {
        this.data = data;
        this.view = view;
    }

    public void initialize() {
        List<Knight> allGameDataActiveKnights = data.getActiveKnights();

        for (Knight knight : allGameDataActiveKnights) {
            knight.setActiveFortune(data.getRandomFortune());
        }
        this.view.printFortunes(allGameDataActiveKnights);
    }

    public void clear() {
        List<Knight> allGameDataKnights = data.getKnights();

        for (Knight knight : allGameDataKnights) {
            knight.setActiveFortune(null);
        }
    }

    private int doBattle(List<? extends MOB> attackers, List<? extends MOB> defenders) {
        int victories = 0;
        List<MOB> defeated = new ArrayList<>();

        for (MOB attacker : attackers) {
            if (defenders.isEmpty())
                break;

            // Pick random defender
            int targetIndex = rnd.nextInt(defenders.size());
            MOB defender = defenders.get(targetIndex);

            // Calculate hit: D20 + hitModifier > armor
            int attackRoll = DiceType.D20.Roll() + attacker.getHitModifier();

            if (attackRoll > defender.getArmor()) {
                // Successful hit - roll damage
                int damage = attacker.getDamageDie().Roll();
                defender.addDamage(damage);

                // Check if defender is defeated
                if (defender.getHP() <= 0) {
                    view.printBattleText(defender);
                    defeated.add(defender);
                    victories++;

                    // If defender is a monster, award XP to all active knights
                    if (!attackers.isEmpty() && attackers.get(0) instanceof Knight) {
                        // Attacker was monster, defender was knight - no XP
                    } else {
                        // Attacker was knight, defender was monster - award XP
                        for (Knight k : data.getActiveKnights()) {
                            k.addXP(1);
                        }
                    }
                }
            }
        }

        for (MOB dead : defeated) {
            defenders.remove(dead);

            if (dead instanceof Knight) {
                data.removeActive((Knight) dead);
            }
        }

        return victories;
    }

    public void runCombat() {
        List<Knight> activeKnights = data.getActiveKnights();
        if (activeKnights.isEmpty()) {
            return;
        }

        List<MOB> monsters = data.getRandomMonsters();
        view.printBattleText(monsters, activeKnights);

        while (!activeKnights.isEmpty() && !monsters.isEmpty()) {

            doBattle(activeKnights, monsters);

            if (monsters.isEmpty()) {
                if (view.checkContinue()) {
                    monsters = data.getRandomMonsters();
                    view.printBattleText(monsters, activeKnights);
                } else {
                    return;
                }
            }

            if (!monsters.isEmpty()) {
                doBattle(monsters, activeKnights);
            }
        }

        // Check if all knights were defeated
        if (activeKnights.isEmpty()) {
            view.printDefeated();
        }
    }

    public static void main(String[] args) {
        CSVGameData gameData = new CSVGameData("gamedata.csv", "knights.csv");
        ConsoleView view = new ConsoleView();

        CombatEngine engine = new CombatEngine(gameData, view);

        gameData.setActive(gameData.getKnight("1"));
        gameData.setActive(gameData.getKnight("2"));

        engine.initialize();
        engine.runCombat();
        engine.clear();
    }
}
