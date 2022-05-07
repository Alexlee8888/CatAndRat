import java.util.ArrayList;
import org.w3c.dom.events.MouseEvent;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Rat extends Rectangle {

    // private Location position;
    // private double orientation; // degree
    // private Image ratImage = Toolkit.getDefaultToolkit().getImage("rat.png");

    // public Rat() {
    //     position = new Location(100, 100);
    //     orientation = 90;
    // }

    // public void render(Graphics g) {
    //     g.drawImage(ratImage, position.getX(), position.getY(), 50, 50, null);
    // }

    // public void move(Direction dir) {
    //     position = position.getAdjacentLocation(dir);
    // }

    // public boolean isClicked(MouseEvent e) {
    //     return true;
    // }

    private int dx;
    private int dy;
    private InputHandler inputHandler;

    public Rat(int x, int y, int width, int height, int dx, int dy, InputHandler inputHandler) {
        setBounds(x, y, width, height);
        this.dx = dx;
        this.dy = dy;
        this.inputHandler = inputHandler;
    }

    public void update() {
        this.x += dx;
        this.y += dy;
        if(inputHandler.isKeyPressed(KeyEvent.VK_D) || inputHandler.isKeyPressed(KeyEvent.VK_RIGHT)) {
            setDx(3);
        }
        else if(inputHandler.isKeyPressed(KeyEvent.VK_A) || inputHandler.isKeyPressed(KeyEvent.VK_LEFT)) {
            setDx(-3);
        }
        if(inputHandler.isKeyPressed(KeyEvent.VK_W) || inputHandler.isKeyPressed(KeyEvent.VK_UP)) {
            setDy(-3);
        }
        else if(inputHandler.isKeyPressed(KeyEvent.VK_S) || inputHandler.isKeyPressed(KeyEvent.VK_DOWN)) {
            setDy(3);
        }

        if(inputHandler.isKeyUp(KeyEvent.VK_D) || inputHandler.isKeyUp(KeyEvent.VK_RIGHT)||inputHandler.isKeyUp(KeyEvent.VK_A) || inputHandler.isKeyUp(KeyEvent.VK_LEFT)) {
            setDx(0);
        }
        if(inputHandler.isKeyUp(KeyEvent.VK_W) || inputHandler.isKeyUp(KeyEvent.VK_UP) || inputHandler.isKeyUp(KeyEvent.VK_S) || inputHandler.isKeyUp(KeyEvent.VK_DOWN)) {
            setDy(0);
        }
        
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
