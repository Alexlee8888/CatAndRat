import javax.swing.ComboBoxModel;
import javax.swing.JComboBox.KeySelectionManager;
import javax.swing.event.MouseInputListener;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * processes keystrokes and mouse clicks
 */
public class InputHandler implements KeyListener, MouseInputListener {
    private final int NUM_KEYS = 256;
    private boolean[] keysPressed = new boolean[NUM_KEYS];
    private boolean[] keysLastPressed = new boolean[NUM_KEYS];
    private Location mouseClicked = null;
    private Location mouseReleased = null;


    /**
     * updates keys last pressed to current keys pressed
     */
    public void update() {
        for(int i = 0; i < NUM_KEYS; i++) {
            keysLastPressed[i] = keysPressed[i];
        }

    }

    /**
     * checks if a key is pressed
     * @param keyCode code for keystroke
     * @return true or false if the key is pressed
     */
    public boolean isKeyPressed(int keyCode) {
        return keysPressed[keyCode];
    }

    /**
     * checks if a key is not pressed
     * @param keyCode code for keystroke
     * @return true or false if the key is not pressed
     */
    public boolean isKeyUp(int keyCode) {
        return !keysPressed[keyCode] && keysLastPressed[keyCode];
    }

    // ------=================+=================------ \\

    /**
     * gets Location e of the recent mouseclick, or null if there wasn't one
     * @return Location of mouseclick
     */
    public Location getMouseClick() {
        return mouseClicked;
    }

    /**
     * returns location of mouse release, needs a value to know when to reset cat
     * @return location of mouse release
     */
    public Location getMouseRelease(){
        return mouseReleased;
    }

    /**
     * resets the mouseClicked point to null
     */
    public void resetClickPoint(){
        mouseClicked = null;
    }

    /**
     * resets mouseReleased point to null
     */
    public void resetReleasePoint(){
        mouseReleased = null;
    }

    @Override
    public void keyTyped(KeyEvent keyCode){

    }

    /**
     * sets mouseClicked location to where the mouse was clicked
     */
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getX() + ", " + e.getY());
        mouseClicked = new Location(e.getX(), e.getY());
    }

    /**
     * sets mouseReleased location to where the mouse was released
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released");
        mouseReleased = new Location(e.getX(), e.getY());
    }

    // ------=================+=================------ \\

    @Override
    public void mouseClicked(MouseEvent e) {

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

    /**
     * sets keysPressed array with associated keycode to true
     */
    @Override
    public void keyPressed(KeyEvent e) {
        keysPressed[e.getKeyCode()] = true;

    }

    /**
     * sets the keysPressed array with associated keycode to false
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keysPressed[e.getKeyCode()] = false;
    }

}
