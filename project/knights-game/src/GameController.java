public class GameController extends Object {

    private final GameData data;
    private final CombatEngine engine;
    private final GameView view;

    public GameController(GameData data, GameView view, CombatEngine engine) {
        this.data = data;
        this.view = view;
        this.engine = engine;
    }

    public void start() {
        this.view.splashScreen();
        boolean gameIsRunning = true;

        do {
            String command = this.view.displayMainMenu();
            gameIsRunning = processCommand(command);
        } while (gameIsRunning);
        this.view.endGame();
    }

    protected boolean processCommand(String command) {
        String[] commandsList = { "exit", "bye", "ls", "list all", "list active", "show", "set active", "remove",
                "save",
                "explore", "adventure", "quest" };
        String action = command.toLowerCase().trim();

        int matchedCommand = -1;

        for (int i = 0; i < commandsList.length; i++) {
            if (action.contains(commandsList[i]) || action.startsWith(commandsList[i])) {
                matchedCommand = i;
                break;
            }
        }

        switch (matchedCommand) {
            case 0:
            case 1:
                return false;
            case 2:
            case 3:
                view.listKnights(data.getKnights());
                break;
            case 4:
                view.listKnights(data.getActiveKnights());
                break;
            case 5:
                if (command.length() > 5) {
                    String nameOrId = command.substring(5).trim();
                    if (!nameOrId.isEmpty()) {
                        Knight knight = data.getKnight(nameOrId);
                        if (knight != null) {
                            view.showKnight(knight);
                        } else {
                            view.knightNotFound();
                        }
                    } else {
                        view.knightNotFound();
                    }

                } else {
                    view.knightNotFound();
                }

                break;
            case 6:
                if (command.length() > 11) {
                    String nameOrIdSetActive = command.substring(11).trim();

                    if (!nameOrIdSetActive.isEmpty()) {
                        Knight knightSetActive = data.getKnight(nameOrIdSetActive);
                        if (knightSetActive != null) {
                            boolean success = data.setActive(knightSetActive);
                            if (!success) {
                                view.setActiveFailed();
                            }
                        } else {
                            view.knightNotFound();
                        }
                    } else {
                        view.knightNotFound();
                    }
                } else {
                    view.knightNotFound();
                }
                break;
            case 7:
                if (command.length() > 7) {
                    String nameOrIdRemoveActive = command.substring(7).trim();
                    if (!nameOrIdRemoveActive.isEmpty()) {
                        Knight knightRemoveActive = data.getActive(nameOrIdRemoveActive);
                        if (knightRemoveActive != null) {
                            data.removeActive(knightRemoveActive);
                        } else {
                            view.knightNotFound();
                        }
                    }
                } else {
                    view.knightNotFound();
                }
                break;
            case 8:
                String filename = "saveData.csv";

                if (command.length() > 5) {
                    String providedFilename = command.substring(5).trim();
                    if (!providedFilename.isEmpty()) {
                        filename = providedFilename;
                    }
                }

                data.save(filename);
                break;
            case 9:
            case 10:
            case 11:
                engine.initialize();
                engine.runCombat();
                engine.clear();

            default:
                view.printHelp();
        }

        return true;
    }

    public static void main(String[] args) {
        CSVGameData gameData = new CSVGameData("gamedata.csv", "knights.csv");
        ConsoleView view = new ConsoleView();
        CombatEngine engine = new CombatEngine(gameData, view);
        
        GameController controller = new GameController(gameData, view, engine);

        controller.start();
    }
}
