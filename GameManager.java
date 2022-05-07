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
    // private Rat rat;

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
        // rat = new Rat(10, 10, 10, 10, 0, 0, inputHandler);
    }

    public void tick() {
        // update everything
        player1.update();
        player2.update();
        // calculate everything
    }

    public void render(Graphics g) {
        player1.draw(g);
        player2.draw(g);
        // render cat
        // render rat
    }
}
