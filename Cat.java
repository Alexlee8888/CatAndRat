import java.util.ArrayList;
import org.w3c.dom.events.MouseEvent;
import javax.swing.*;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
public class Cat extends THINGYCHANGE{
    private Image catImage = Toolkit.getDefaultToolkit().getImage("paw.png");

    private int x;
    private int y;
    private double angle;

    public Cat(int x, int y) {
        angle = 0;
        this.x = x;
        this.y = y;
    }

    public void setAngle(double a){
        this.angle = a;
    }
    
    public void setX(int a){
        this.x = a;
    }

    public void setY(int a){
        this.y = a;
    }

    public void draw(Graphics g) {
        Graphics2D gg = (Graphics2D)g;
        g.fillRect(this.x, this.y, this.width, this.height);
        gg.rotate(angle);
    }
    /*
    cat.setX(e.getX());
        cat.setY(e.getY());
        
        double dx = e.getX() - cat.getLocation().getX();
        double dy = e.getY() - cat.getLocation().getY();
        cat.setAngle(Math.atan2(dy, dx));
    */
}
