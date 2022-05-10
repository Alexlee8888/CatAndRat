import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class Rat extends THINGYCHANGE {

    private double x;
    private double y;
    private double angle;

    private double v;

    private InputHandler inputHandler;
    private static int division = 9;
    private static int width = 815 / division;
    private static int height = 1062 / division;
    private static Image ratImage = Toolkit.getDefaultToolkit().getImage("rat.png");
    private static int DEGREES_TURNED = 4;
    private static int RAT_SPEED = 9;
    private static int MOVE_FORWARD = 1;
    private static int MOVE_BACKWARD = -1;


    public Rat(double x, double y, double angle, InputHandler inputHandler) {
        this.x = x;
        this.y = y;

        this.angle = angle;
        this.inputHandler = inputHandler;
    }

    public void update() {
        if (inputHandler.isKeyPressed(KeyEvent.VK_D) || inputHandler.isKeyPressed(KeyEvent.VK_RIGHT)) {
            angle += DEGREES_TURNED;
        } else if (inputHandler.isKeyPressed(KeyEvent.VK_A) || inputHandler.isKeyPressed(KeyEvent.VK_LEFT)) {
            angle -= DEGREES_TURNED;
        }
        if (inputHandler.isKeyPressed(KeyEvent.VK_W) || inputHandler.isKeyPressed(KeyEvent.VK_UP)) {
            moveRat(MOVE_FORWARD);
        } else if (inputHandler.isKeyPressed(KeyEvent.VK_S) || inputHandler.isKeyPressed(KeyEvent.VK_DOWN)) {
            moveRat(MOVE_BACKWARD);
        }

        double deltaX = v * Math.cos(Math.toRadians(angle));
        double deltaY = v * Math.sin(Math.toRadians(angle));
        x += deltaX;
        y += deltaY;

        v *= 0.95;

    }

    public void moveRat(int forwardBackward) {
        v += forwardBackward;
        v = Math.min(v, RAT_SPEED);
        v = Math.max(v, -RAT_SPEED);
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        Graphics2D g2d = (Graphics2D) g;
        // draw rect

        AffineTransform identity = new AffineTransform();

        g2d.setTransform(identity);
        g2d.rotate(Math.toRadians(angle), x, y);
        g.drawImage(ratImage, (int) (x - (width / 2)), (int) (y - (height / 2)), width, height, null);
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}
