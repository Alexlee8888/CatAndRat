import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.TreeMap;

public class GameManager {
    private InputHandler inputHandler;
    private Player player1;
    private Player player2;
    private TreeMap<Integer, ArrayList<String>> leaderboard;
    // only for testing
    // private Rat rat;
    // private Cat cat;

    GameManager(InputHandler inputHandler) {
        leaderboard = new TreeMap<>();
        this.inputHandler = inputHandler;
        player1 = new Person(true, inputHandler); //player 1 is cat, player 2 is rat
        player2 = new Person(false, inputHandler); //player 1 is cat, player 2 is rat
    }

    public void tick() {
        // check for click
        if (inputHandler.getMouseClick() != null){
            if(player1.isCat()) {
                player1.getCat().update(inputHandler.getMouseClick());
            } else {
                player2.getCat().update(inputHandler.getMouseClick());
            }

            

            Location [] hitbox;
            if(player1.isCat()) {
                hitbox = player2.getRat().getHitbox();
            } else {
                hitbox = player1.getRat().getHitbox();
            }

            Location click = inputHandler.getMouseClick();
            if(click.getX() >= hitbox[0].getX() && click.getX() <= hitbox[1].getX() && click.getY() >= hitbox[0].getY() && click.getY() <= hitbox[1].getY()) {
                System.out.println("clicked");
                if(player1.isCat()) {
                    player1.addScore();
                } else {
                    player2.addScore();
                }
                System.out.println("player 1 lives: " + player1.getScore() + " player 2 lives: " + player2.getScore());
            }

            inputHandler.resetClickPoint();
        }

        // check for release
        if (inputHandler.getMouseRelease() != null){
            if(player1.isCat()) {
                player1.getCat().reset();
            } else {
                player2.getCat().reset();
            }
            inputHandler.resetReleasePoint();
        }

        // update everything
        if(player1.isCat()) {
            player2.getRat().update();
        } else {
            player1.getRat().update();
        }
    }

    public void render(Graphics g) {
        if(player1.isCat()) {
            player1.getCat().draw(g);
            player2.getRat().draw(g);
        } else {
            player1.getRat().draw(g);
            player2.getCat().draw(g);
        }

        // render cat
        // render rat
    }

    public void swapRoles() {
        System.out.println("swapped");
        player1.swapRoles();
        player2.swapRoles();
        System.out.println("player 1 lives: " + player1.getScore() + " player 2 lives: " + player2.getScore());
    }
}
