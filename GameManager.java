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
    // only for testing
    private Rat rat;
    private Cat cat;

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
        rat = new Rat(100, 500, 0, inputHandler);
        cat = new Cat(inputHandler);
    }

    public void tick() {
        // check for click
        if (inputHandler.getMouseClick() != null){
            cat.update(inputHandler.getMouseClick());
            inputHandler.resetClickPoint();
        }
        // check for release
        if (inputHandler.getMouseRelease() != null){
            cat.reset();
            inputHandler.resetReleasePoint();
        }

        // update everything
        rat.update();
        // player1.update();
        // player2.update();
        // calculate everything
    }

    public void render(Graphics g) {
        rat.draw(g);
        cat.draw(g);
        // player1.draw(g);
        // player2.draw(g);
        // render cat
        // render rat
    }
}
