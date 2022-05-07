public class GameManager {
    private InputHandler inputHandler;
    private boolean isMultiplayer;
    private Player player1;
    private Player player2;

    GameManager(InputHandler inputHandler, boolean isMultiplayer) {
        this.inputHandler = inputHandler;
        this.isMultiplayer = isMultiplayer;
        player1 = new Person(inputHandler);
        if(isMultiplayer) {
            player2 = new Person(inputHandler);
        }
        else {
            player2 = new Computer();
        }
        
    }
}
