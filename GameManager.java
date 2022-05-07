import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.image.BufferStrategy;

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

    public void tick() {
        // update everything
        // calculate everything
    }

    public void render(Graphics g) {
        // render cat
        // render rat
    }
}
