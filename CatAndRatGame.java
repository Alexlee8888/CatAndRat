import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class CatAndRatGame extends Canvas implements Runnable {
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

    public CatAndRatGame() {
        Window window = new Window(windowDimension, this, title);
        inputHandler = new InputHandler();
        this.addKeyListener(inputHandler);
        this.addMouseListener(inputHandler);
        gameManager = new GameManager(inputHandler);
        render();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        rat.render(g);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

    public void paintHomeScreen(Graphics g) {
        // Image startMenu = Toolkit.getDefaultToolkit().getImage("start_menu_background.png");
        // Image title = Toolkit.getDefaultToolkit().getImage("title.png");
        // g.drawImage(startMenu, 0, 0, backgroundWidth, backgroundHeight, null);
        // g.drawImage(title, 250, 170, 872 * 4 / 7, 411 * 4 / 7, null);
        
        // GameButton singleButton = new GameButton(backgroundWidth / 2, backgroundHeight / 2 + 30, g, "singleplayer_button.png", this);
        // objectHandler.addButton(singleButton);
        // singleButton.setIsClickable(true);
        // GameButton multiButton = new GameButton(backgroundWidth / 2, backgroundHeight / 2 + 130, g, "multiplayer_button.png", this);
        // objectHandler.addButton(multiButton);
        // multiButton.setIsClickable(true);
        // GameButton cancelButton = new GameButton(backgroundWidth / 2, backgroundHeight / 2 + 230, g, "cancel_button.png", this);
        // objectHandler.addButton(cancelButton);
        // cancelButton.setIsClickable(true);
    }

    public static void main(String[] args) {
        CatAndRatGame gameManager = new CatAndRatGame();
        gameManager.repaint();
    }

}
