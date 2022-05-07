import javax.swing.JFrame;
import java.awt.GridLayout;

public class Frame extends JFrame {
    
    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);

        render();
    }

    public void render() {
        setLayout(new GridLayout(1, 1, 0, 0));
        Screen screen = new Screen();
        add(screen);
        setVisible(true);
    }

    public static void main(String [] args) {
        Frame frame = new Frame();
    }
}
