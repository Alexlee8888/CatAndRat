import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;

public class Window {
    private static JFrame frame;
    public Window(Dimension dimension, CatAndRatGame game, String title) {
        frame = new JFrame(title);
        frame.setPreferredSize(dimension);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
