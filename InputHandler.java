import javax.swing.ComboBoxModel;
import javax.swing.JComboBox.KeySelectionManager;
import javax.swing.event.MouseInputListener;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class InputHandler implements KeyListener, MouseInputListener, MouseMotionListener {
    private final int NUM_KEYS = 256;
    private boolean[] keysPressed = new boolean[NUM_KEYS];
    private boolean[] keysLastPressed = new boolean[NUM_KEYS];
    private Location mouseClicked;



    public void update() {
        for(int i = 0; i < NUM_KEYS; i++) {
            keysLastPressed[i] = keysPressed[i];
        }

    }

    public Location getMouseClick() {
        return mouseClicked;
    }

    public boolean isKeyPressed(int keyCode) {
        return keysPressed[keyCode];
    }

    public boolean isKeyUp(int keyCode) {
        return !keysPressed[keyCode] && keysLastPressed[keyCode];
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + ", " + e.getY());
        mouseClicked = new Location(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getX() + ", " + e.getY());
        mouseClicked = new Location(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keysPressed[e.getKeyCode()] = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysPressed[e.getKeyCode()] = false;
    }

}
