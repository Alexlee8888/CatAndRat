import java.util.ArrayList;
import org.w3c.dom.events.MouseEvent;
import javax.swing.*;
import java.awt.*;
public class Cat {
    private Location position;
    private double orientation; // degree
    private Image catImage = Toolkit.getDefaultToolkit().getImage("paw.png");
    private InputHandler input = new InputHandler();

    public Cat() {
        position = new Location(100, 100);
        orientation = 90;
    }

    public void render(Graphics g) {
        g.drawImage(catImage, position.getX(), position.getY(), 50, 50, null);
    }

    public void move() {
        position = input.mouseMoved(MouseEvent e);
    }

    public boolean isClicked(MouseEvent e) {
        return true;
    }
}
