import javax.swing.Timer;
import javax.swing.JPanel;

import java.awt.Graphics;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox.KeySelectionManager;
import javax.swing.event.MouseInputListener;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Screen extends JPanel implements ActionListener, KeyListener, MouseInputListener, MouseMotionListener{

    Timer t = new Timer (10, this);
    Rat rat = new Rat(10, 10, 10, 10, 0, 0);
    Cat cat = new Cat(10, 10, 10, 10);

    public Screen() {
        setFocusable(true);
        addKeyListener(this);

        t.start();
    }

    public void actionPerformed(ActionEvent e) {
        rat.update();
        repaint();
    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        rat.draw(g);
        cat.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + ", " + e.getY());

        cat.setX(e.getX());
        cat.setY(e.getY());
        
        double dx = e.getX() - cat.getLocation().getX();
        double dy = e.getY() - cat.getLocation().getY();
        cat.setAngle(Math.atan2(dy, dx));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getX() + ", " + e.getY());
        
        cat.setX(e.getX());
        cat.setY(e.getY());
        
        double dx = e.getX() - cat.getLocation().getX();
        double dy = e.getY() - cat.getLocation().getY();
        cat.setAngle(Math.atan2(dy, dx));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        double dx = e.getX() - cat.getLocation().getX();
        double dy = e.getY() - cat.getLocation().getY();
        cat.setAngle(Math.atan2(dx, dy));
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_D:
                rat.setDx(1);
                break;

            case KeyEvent.VK_S:
                rat.setDy(1);
                break;
            
            case KeyEvent.VK_A:
                rat.setDx(-1);
                break;
            
            case KeyEvent.VK_W:
                rat.setDy(-1);
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_D:
                rat.setDx(0);
                break;

            case KeyEvent.VK_S:
                rat.setDy(0);
                break;
            
            case KeyEvent.VK_A:
                rat.setDx(0);
                break;
            
            case KeyEvent.VK_W:
                rat.setDy(0);
                break;
        }
    }
}
