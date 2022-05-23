import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * A class cat that uses a mouse listener to listen to when the player/cat
 * clicks on the screen.
 * It draws itself where the latest click was
 */
public class Cat {
    private double x;
    private double y;
    private static Image catImage = Toolkit.getDefaultToolkit().getImage("paw.png");
    private static int width = 250;
    private static int height = 250;

    /**
     * constructor for cat
     * starts off screen at (99999,99999)
     */
    public Cat() {
        x = 99999;
        y = 99999;
    }

    /**
     * updates x coord and y coord
     * 
     * @param e location
     */
    public void update(Location e) {
        x = e.getX();
        y = e.getY();
    }

    /**
     * resets it so it is not seen after mouse is clicked
     */
    public void reset() {
        x = 9999;
        y = 9999;
    }

    /**
     * draws the paw at x and y coordinates
     * 
     * @param g graphics
     */
    public void draw(Graphics g) {
        g.drawImage(catImage, (int) (x - (width / 2)), (int) (y - (height / 2)), width, height, null);
    }
}
