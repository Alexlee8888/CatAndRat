import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CatAndRatGame extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    private static int backgroundWidth = 240 * 25 / 6;
    private static int backgroundHeight = 204 * 25 / 6;
    private static int canvasWidth = backgroundWidth;
    private static int canvasHeight = backgroundHeight + 22;


    private static Image BACKGROUND = Toolkit.getDefaultToolkit().getImage("background.png");
    private static Image BACKGROUND2 = Toolkit.getDefaultToolkit().getImage("background2.png");
    public static final Dimension windowDimension = new Dimension(canvasWidth, canvasHeight);


    private final double UPDATE_CAP = 1.0 / 60.0;
    private InputHandler inputHandler;
    private GameManager gameManager;
    private boolean isRunning = false;
    private Thread thread;
    private boolean isPlayButtonClicked = false;
    private boolean isGameOver = false;
    private boolean gameStarted = false;
    private boolean isAtHomeScreen = true;
    private Window window;
    private Frame frame;

    public CatAndRatGame() {

        window = new Window(windowDimension, this, "Cat and Mouse Game");
        inputHandler = new InputHandler();
        this.addKeyListener(inputHandler);
        this.addMouseListener(inputHandler);
        gameManager = new GameManager(inputHandler, true);


        start();
    }

    public void startMultiplayerGame() {

    }

    public void start() {

        thread = new Thread(this);
        thread.run();
    }

    public void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        isRunning = true;
        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;
        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        while (isRunning) {
            render = false;
            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;


            while (unprocessedTime >= UPDATE_CAP) {
                unprocessedTime -= UPDATE_CAP;
                render = true;
                requestFocus();
                gameManager.tick();
                inputHandler.update();
                if (frameTime >= 1.0) {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    //System.out.println("FPS: " + fps);
                }


            }
            if (render) {
                frames++;
                render();
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.clearRect(0, 0, canvasWidth, canvasHeight);
        gameManager.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        CatAndRatGame game = new CatAndRatGame();
        game.repaint();
    }

}
