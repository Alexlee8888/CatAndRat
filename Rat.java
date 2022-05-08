import java.util.ArrayList;
import org.w3c.dom.events.MouseEvent;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Rat extends THINGYCHANGE {

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
    private int x;
    private int y;
    private double angle;
    private InputHandler inputHandler;
    private static int width = 50;
    private static int height = 50;
    private static Image ratImage = Toolkit.getDefaultToolkit().getImage("rat.png");

    // public Rat(int x, int y, int width, int height, int dx, int dy, InputHandler inputHandler) {
    //     setBounds(x, y, width, height);
    //     this.dx = dx;
    //     this.dy = dy;
    //     this.inputHandler = inputHandler;
    // }
    
    public Rat(int x, int y, int dx, int dy, double angle, InputHandler inputHandler) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.angle = angle;
        this.inputHandler = inputHandler;
    }

    public void update() {
        x += dx;
        y += dy;
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
        Graphics2D g2d = (Graphics2D) g;
        // draw rect

        AffineTransform identity = new AffineTransform();

        g2d.setTransform(identity);
        g2d.rotate(Math.toRadians(angle), x, y);
        g.drawImage(ratImage, x - (width/2), y - (height/2), width, height, null);
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
