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

    // private int dx;
    // private int dy;
    private double x;
    private double y;
    private double angle;
    private InputHandler inputHandler;
    private static int width = 100;
    private static int height = 100;
    private static Image ratImage = Toolkit.getDefaultToolkit().getImage("rat.png");
    private static int DEGREES_TURNED = 4;
    private static int RAT_SPEED = 5;
    private static int MOVE_FORWARD = 1;
    private static int MOVE_BACKWARD = -1;
    // public Rat(int x, int y, int width, int height, int dx, int dy, InputHandler inputHandler) {
    //     setBounds(x, y, width, height);
    //     this.dx = dx;
    //     this.dy = dy;
    //     this.inputHandler = inputHandler;
    // }
    
    public Rat(double x, double y, double angle, InputHandler inputHandler) {
        this.x = x;
        this.y = y;
        // this.dx = dx;
        // this.dy = dy;
        this.angle = angle;
        this.inputHandler = inputHandler;
    }

    public void update() {
        // x += dx;
        // y += dy;
        if(inputHandler.isKeyPressed(KeyEvent.VK_D) || inputHandler.isKeyPressed(KeyEvent.VK_RIGHT)) {
            angle += DEGREES_TURNED;
        }
        else if(inputHandler.isKeyPressed(KeyEvent.VK_A) || inputHandler.isKeyPressed(KeyEvent.VK_LEFT)) {
            angle -= DEGREES_TURNED;
        }
        if(inputHandler.isKeyPressed(KeyEvent.VK_W) || inputHandler.isKeyPressed(KeyEvent.VK_UP)) {
            moveRat(MOVE_FORWARD);
        }
        else if(inputHandler.isKeyPressed(KeyEvent.VK_S) || inputHandler.isKeyPressed(KeyEvent.VK_DOWN)) {
            moveRat(MOVE_BACKWARD);
        }

        // if(inputHandler.isKeyUp(KeyEvent.VK_D) || inputHandler.isKeyUp(KeyEvent.VK_RIGHT)||inputHandler.isKeyUp(KeyEvent.VK_A) || inputHandler.isKeyUp(KeyEvent.VK_LEFT)) {
        //     setDx(0);
        // }
        // if(inputHandler.isKeyUp(KeyEvent.VK_W) || inputHandler.isKeyUp(KeyEvent.VK_UP) || inputHandler.isKeyUp(KeyEvent.VK_S) || inputHandler.isKeyUp(KeyEvent.VK_DOWN)) {
        //     setDy(0);
        // }
        
    }

    public void moveRat(int forwardBackward) {
        double deltaX = forwardBackward * (RAT_SPEED*Math.cos(Math.toRadians(angle)));
        double deltaY = forwardBackward * (RAT_SPEED*Math.sin(Math.toRadians(angle)));
        x += deltaX;
        y += deltaY;
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        Graphics2D g2d = (Graphics2D) g;
        // draw rect

        AffineTransform identity = new AffineTransform();

        g2d.setTransform(identity);
        g2d.rotate(Math.toRadians(angle), x, y);
        g.drawImage(ratImage, (int) (x - (width/2)), (int) (y - (height/2)), width, height, null);
    }

    // public void setDx(int dx) {
    //     this.dx = dx;
    // }

    // public void setDy(int dy) {
    //     this.dy = dy;
    // }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}
