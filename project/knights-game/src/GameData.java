import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GameData extends Object {
    protected final List<Knight> activeKnights;
    protected final List<Fortune> fortunes;
    protected final List<Knight> knights;
    private static final int MAX_ACTIVE = 4;
    protected final List<MOB> monsters;
    private static final Random random = new Random();

    public GameData() {
        this.activeKnights = new ArrayList<>();
        this.fortunes = new ArrayList<>();
        this.knights = new ArrayList<>();
        this.monsters = new ArrayList<>();
    }

    protected Knight findKnight(String nameOrId, List<Knight> list) {
        try {
            int id = Integer.parseInt(nameOrId);
            for (Knight knight : list) {
                if (knight.getId() == id) {
                    return knight;
                }
            }
        } catch (NumberFormatException e) {
        }
        for (Knight knight : list) {
            if (knight.getName().equalsIgnoreCase(nameOrId)) {
                return knight;
            }
        }
        return null;
    }

    public Knight getActive(String nameOrId) {
        return findKnight(nameOrId, activeKnights);
    }
    
    public List<Knight> getActiveKnights() {
        return this.activeKnights;
    }

    public List<Knight> getKnights() {
        return this.knights;
    }

    public Knight getKnight(String nameOrId) {
        return findKnight(nameOrId, knights);
    }

    /*
     * Adds a knight to the activeKnights list, as long as there are no more than 4
     * knights in the list.
     * Parameters: kt - knight to add
     * Returns: true if the addition was successful, false if the knight wasn't
     * added due to too many knights already being in the list
     */
    public boolean setActive(Knight kt) {
        if (activeKnights.size() < MAX_ACTIVE) {
            activeKnights.add(kt);
            return true;
        }
        return false;
    }

    /**
     * Removes a knight from the activeKnights list and resets the damage on the
     * knight!
     * Parameters:- knight to remove
     **/
    public void removeActive(Knight kt) {
        if (activeKnights.contains(kt)) {
            activeKnights.remove(kt);
            kt.resetDamage();
        }
    }

    /**
     * Gets a random fortune from fortunes
     * Since fortunes.size() gives you the total fortunes, and random.nextInt(N)
     * gives you a random number between 0-(N-1), combine them!
     * Returns: a Fortune from the fortunes list
     **/
    public Fortune getRandomFortune() {
        int fortuneSize = fortunes.size();
        return fortunes.get(random.nextInt(fortuneSize));
    }

    /**
     * Gets a random monster from monsters assuming the max number of monsters is
     * less than or equal to activeKnights.size().
     * Returns: a list of MOBs no greater than activeKnights.size()
     **/
    public List<MOB> getRandomMonsters() {
        int activeKnightsSize = activeKnights.size();
        List<MOB> randomMonsters = new ArrayList<>();

        for (int i = 0; i < activeKnightsSize; i++) {
            int randomIndex = random.nextInt(monsters.size());
            randomMonsters.add(monsters.get(randomIndex));
        }

        return randomMonsters;

    }

    /**
     * Builds a list of random monsters of size number.
     * Note, that monsters should be copied into the return List, so they can be
     * modified individually.
     * 
     * @param number - the number of monsters to randomly grab and copy
     * @return a list of MOB/monsters (copies)
     */
    public List<MOB> getRandomMonsters(int number) {
        List<MOB> randomMonsters = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            int randomMonsterIndex = random.nextInt(monsters.size());
            MOB originalMonster = monsters.get(randomMonsterIndex);
            randomMonsters.add(originalMonster.copy());
        }

        return randomMonsters;
    }

    

    /**
     * Required for the implementing class to be able to save the file
     * 
     * @param filename - name of file to save
     */
    public abstract void save(String filename);

    public static void main(String[] args) {

        GameData gameData = new GameData() {
            @Override
            public void save(String filename) {
                System.out.println("Calling Save with: " + filename);
            }
        };

        Knight gameDataTestKnight = new Knight(2, "King Kong", 400, 20, 2, DiceType.D6, 0);
        Knight gameDataTestKnightSecond = new Knight(2, "Snow white", 200, 10, 5, DiceType.D10, 0);
        gameData.knights.add(gameDataTestKnight);
        gameData.knights.add(gameDataTestKnightSecond);

        Knight theKnight = gameData.getKnight("King Kong");
        System.out.println("Found knight: " + theKnight.getName());

        for (Knight knight : gameData.getKnights()) {
            System.out.println(knight);
        }

    }

}
