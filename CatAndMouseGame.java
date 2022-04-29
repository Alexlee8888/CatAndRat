import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.image.BufferStrategy;

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

    // Test
    private Rat rat = new Rat();

    public CatAndMouseGame() {
        Window window = new Window(windowDimension, this, title);
        inputHandler = new InputHandler();
        this.addKeyListener(inputHandler);
        this.addMouseListener(inputHandler);
        gameManager = new GameManager(inputHandler);
        render();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g  = bs.getDrawGraphics();
        rat.render(g);
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
