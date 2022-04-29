import java.util.ArrayList;
import org.w3c.dom.events.MouseEvent;
import javax.swing.*;
import java.awt.*;

public class Rat {

    private Location position;
    private double orientation; //degree
    private Image ratImage = Toolkit.getDefaultToolkit().getImage("rat.png");

    public Rat() {
        position = new Location(100, 100);
        orientation = 90;
    }

    public void render(Graphics g) {
        g.drawImage(ratImage, position.getX(), position.getY(), 50, 50, null);
    }

    public void move() {

    }

    public boolean isClicked(MouseEvent e) {
        return true;
    }


}
