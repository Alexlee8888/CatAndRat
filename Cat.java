import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.geom.AffineTransform;
/**
 * A class cat that uses a mouse listener to listen to when the player/cat
 * clicks on the screen.
 * It draws itself where the latest click was
 */
public class Cat {
    private double x;
    private double y;
    private static Image catImage = Toolkit.getDefaultToolkit().getImage("catpaw.png");
    private static Image catPouncing = Toolkit.getDefaultToolkit().getImage("cat pouncing.png");
    private static int width = 250;
    private static int height = 250;
    private InputHandler input;

    /**
     * constructor for cat
     * starts off screen at (9999,9999)
     */
    public Cat(InputHandler i) {
        input = i;
        x = 9999;
        y = 9999;
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
        Point p = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(p, CatAndRatGame.getInstance());

        if (x == 9999){
            g.drawImage(catImage, (int)p.getX() - width / 4, (int)p.getY() - height / 4 , width/2, height/2, null);
        }

        g.drawImage(catImage, (int) (x - (width / 2)), (int) (y - (height / 2)), width, height, null);

        Graphics2D g2d = (Graphics2D) g;

        AffineTransform at = new AffineTransform();
        at.translate(500, 745);
        at.rotate(Math.atan((p.getY() - 745) / (p.getX() - 500)) + (p.getX() < 500 ? Math.toRadians(180) : 0)) ;
        at.scale(0.3, 0.3);
        if (p.getX() < 500) {
            at.scale(1, -1);
        }

        // center
        at.translate(-catPouncing.getWidth(CatAndRatGame.getInstance()) / 2, -catPouncing.getHeight(CatAndRatGame.getInstance()) / 2);

        g2d.drawImage(catPouncing, at, null);
    }
}
