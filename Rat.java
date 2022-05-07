import java.util.ArrayList;
import org.w3c.dom.events.MouseEvent;
import javax.swing.*;

import java.awt.Rectangle;
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

    public Rat(int x, int y, int width, int height, int dx, int dy) {
        setBounds(x, y, width, height);
        this.dx = dx;
        this.dy = dy;
    }

    public void update() {
        this.x += dx;
        this.y += dy;
    }

    public void draw(Graphics g) {
        g.fillRect(this.x, this.y, this.width, this.height);
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
