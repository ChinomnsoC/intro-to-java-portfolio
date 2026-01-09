import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSVGameData extends GameData {

    public CSVGameData(String gamedata, String saveData) {
        super();
        loadGameData(gamedata);
        loadSaveData(saveData);
    }

    void loadGameData(String gamedata) {
        Scanner gameFileScanner = readFile(gamedata);

        if (gameFileScanner == null) {
            return;
        }

        while (gameFileScanner.hasNextLine()) {
            String line = gameFileScanner.nextLine();
            Scanner lineParse = new Scanner(line);
            try {
                parseGameDataLine(lineParse);
            } catch (Exception e) {
                System.err.println("Error parsing game data line: " + e.getMessage());
            }

        }

        gameFileScanner.close();

    }

    void loadSaveData(String saveData) {
        int counter = 0;
        Scanner file = readFile(saveData);
        if (file == null)
            return;
        while (file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(",");
            try {
                Knight kt = new Knight(
                        ++counter,
                        line.next().trim(),
                        line.nextInt(),
                        line.nextInt(),
                        line.nextInt(),
                        DiceType.valueOf(line.next()),
                        line.nextInt());
                knights.add(kt);
            } catch (Exception e) {
                System.err.println("Error parsing knight on line " + counter + ": " + e.getMessage());
            }

            line.close();
        }
        file.close();
    }

    private Scanner readFile(String fileName) {
        try {
            return new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println(fileName + " was not found. This is the error message: " + e.getMessage());
            return null;
        }
    }

    private void parseGameDataLine(Scanner lineParse) {
        lineParse.useDelimiter(",");

        String type = lineParse.next().trim();

        try {
            if (type.equalsIgnoreCase("Fortune")) {
                String name = lineParse.next().trim();
                int hpBonus = lineParse.nextInt();
                int armor = lineParse.nextInt();
                int hitModifier = lineParse.nextInt();
                String diceValue = lineParse.next().trim();

                Fortune newFortuneObject;
                if (!diceValue.equals("-")) {
                    try {
                        DiceType damageDie = DiceType.valueOf(diceValue);
                        newFortuneObject = new Fortune(name, hpBonus, armor, hitModifier, damageDie);
                    } catch (IllegalArgumentException e) {
                        System.err.println("DiceType Not Recognized: " + diceValue);
                        return;
                    }
                } else {
                    newFortuneObject = new Fortune(name, hpBonus, armor, hitModifier);
                }

                fortunes.add(newFortuneObject);
            } else if (type.equalsIgnoreCase("MOB")) {
                String name = lineParse.next().trim();
                int hp = lineParse.nextInt();
                int armor = lineParse.nextInt();
                int hitModifier = lineParse.nextInt();

                try {
                    DiceType damageDie = DiceType.valueOf(lineParse.next().trim());
                    MOB newMobObject = new MOB(name, hp, armor, hitModifier, damageDie);
                    monsters.add(newMobObject);
                } catch (IllegalArgumentException e) {
                    System.err.println("DiceType Not Recognized: " + lineParse.next().trim());
                    return;
                }
            }
        } catch (Exception e) {
            System.err.println("Error parsing line: " + e.getMessage());

        }
        lineParse.close();
    }

    @Override
    public void save(String filename) {
        try {
            PrintWriter fileWriter = new PrintWriter(new File(filename));

            for (Knight knight : knights) {
                fileWriter.println(knight.toCSV());
            }

            fileWriter.close();

        } catch (FileNotFoundException e) {
            System.err.println("Encountered error while saving file: " + filename);
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Testing loadGameData ===\n");

        CSVGameData gameData = new CSVGameData("gamedata.csv", "knights.csv");

        System.out.println("Fortunes loaded: " + gameData.fortunes.size());
        for (Fortune fortune : gameData.fortunes) {
            System.out.println(fortune);
        }

        System.out.println("\nMonsters loaded: " + gameData.monsters.size());
        for (MOB monster : gameData.monsters) {
            System.out.println(monster);
        }
    }

}
