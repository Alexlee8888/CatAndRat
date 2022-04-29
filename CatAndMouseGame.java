import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;

public class CatAndMouseGame extends Canvas implements Runnable
{
    private static int backgroundWidth = 240 * 25 / 6;
    private static int backgroundHeight = 204 * 25 / 6;
    private static int canvasWidth = backgroundWidth;
    private static int canvasHeight = backgroundHeight + 22;
    private static final DimensionUIResource windowDimension = new DimensionUIResource(canvasWidth, canvasHeight);
    private static final String title = "Cat and Mouse";
    private InputHandler inputHandler;
    private GameManager gameManager;

    public CatAndMouseGame() {
        Window window = new Window(windowDimension, this, title);
        inputHandler = new InputHandler();
        this.addKeyListener(inputHandler);
        this.addMouseListener(inputHandler);
        gameManager = new GameManager(inputHandler);
        // start();
    }

    public static void main(String[] args)
    {
        CatAndMouseGame gameManager = new CatAndMouseGame();
        gameManager.repaint();
    }

    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        
    }
}
