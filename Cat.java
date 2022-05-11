import java.util.ArrayList;
import org.w3c.dom.events.MouseEvent;
import javax.swing.*;

import java.awt.geom.AffineTransform;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class Cat extends THINGYCHANGE{
    private static Image catImage = Toolkit.getDefaultToolkit().getImage("paw.png");

    private double x;
    private double y;
    private InputHandler inputHandler;
    private double angle;
    private static int width = 250;
    private static int height = 250;
 
    public Cat(InputHandler input) {
        inputHandler = input;
        angle = 0;
        x = 500;
        y = 500;
    }

    public void update(Location e){
        x = e.getX();       
        y = e.getY();
    }

    public void reset(){
        x = 500;
        y = 500;
        angle = 0;
    }

    public void draw(Graphics g) {
        // Graphics2D g2 = (Graphics2D)g;
        // AffineTransform identity = new AffineTransform();

        //g2.setTransform(identity);
        //g2.rotate(Math.toRadians(angle), x, y);
        g.drawImage(catImage, (int) (x - (width/2)), (int) (y - (height/2)), width, height, null);
    }
}
