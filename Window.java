import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;

public class Window {
    private static JFrame frame;
    public Window(DimensionUIResource dimension, CatAndMouseGame gameManager, String title) {
        frame = new JFrame(title);
        frame.setPreferredSize(dimension);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
