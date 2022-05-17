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
    // private Rat rat;
    // private Cat cat;

    GameManager(InputHandler inputHandler, boolean isMultiplayer) {
        this.inputHandler = inputHandler;
        this.isMultiplayer = isMultiplayer;
        player1 = new Person(true, inputHandler); //player 1 is cat, player 2 is rat
        if(isMultiplayer) {
            player2 = new Person(false, inputHandler);
        }
        else {
            player2 = new Computer(); //computer automatically moves rat
        }
    }

    public void tick() {
        // check for click
        if (inputHandler.getMouseClick() != null){
            if(player1.isCat()) {
                player1.getCat().update(inputHandler.getMouseClick());
            } else {
                player2.getCat().update(inputHandler.getMouseClick());
            }

            // check if rat is clicked on
            // if (rat.isClicked()){
            //     swapRoles();
            // }
            // else{
            //     loseLife();
            // }

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
                    player2.loseLife();
                } else {
                    player1.loseLife();
                }
                System.out.println("player 1 lives: " + player1.getLives() + " player 2 lives: " + player2.getLives());
            }

            if(player1.getLives() <= 0 || player2.getLives() <= 0) {
                swapRoles();
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
<<<<<<< HEAD
0.

.00..00000020023000    private boolean ratClicked(Location e){
        //arr of 4 corners of bounds
        Location a0r0r[] = rat.getBounds();
0
        
0    }

}0
=======

    public void swapRoles() {
        System.out.println("swapped");
        player1.swapRoles();
        player2.swapRoles();
        System.out.println("player 1 lives: " + player1.getLives() + " player 2 lives: " + player2.getLives());
    }
}
>>>>>>> eb2ff7e84c6d38712d8e31fe6029a445933ef500
