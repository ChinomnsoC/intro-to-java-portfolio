import java.util.List;

public interface GameView {
    boolean checkContinue();
    String displayMainMenu();
    void endGame();
    void knightNotFound();
    void listKnights(List<Knight> knights);
    void printBattleText(List<MOB> monsters, List<Knight> knights);
    void printBattleText(MOB monster);
    void printDefeated();
    void printFortunes(List<Knight> activeKnights);
    void printHelp();
    void setActiveFailed();
    void showKnight(Knight knight);
    void splashScreen();


}
