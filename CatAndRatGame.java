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

    public void setIsPlayClicked(boolean bool) {
        isPlayButtonClicked = bool;
        isGameOver = false;
        isAtHomeScreen = false;
    }

    public void setIsGameOver(boolean bool) {
        isGameOver = bool;
        isPlayButtonClicked = false;
        isAtHomeScreen = false;
    }

    public void setIsAtHomeScreen(boolean bool) {
        isAtHomeScreen = bool;
        isPlayButtonClicked = false;
        isGameOver = false;
    }

    public CatAndRatGame() {

        window = new Window(windowDimension, this, "Cat and Mouse Game");

        inputHandler = new InputHandler();
        this.addKeyListener(inputHandler);
        this.addMouseListener(inputHandler);
        gameManager = new GameManager(inputHandler, true);


        start();
    }

    public void startMultiplayerGame() {
        // winner = null;
        // if (objectHandler != null) {
        //     camera = new Camera(0, 0, windowDimension, objectHandler);
        // }
        // if (gameStarted) {
        //     return;
        // }
        // Scanner sc = null;
        // try {
        //     sc = new Scanner(new File("WallPlacements"));
        // } catch (FileNotFoundException e) {
        // }

        // for (int i = 0; i < (34 * 40); i++) {
        //     int currInt = sc.nextInt();
        //     if (currInt == 0) {
        //         continue;
        //     }
        //     WallObject wallObject = new WallObject(((i % 40) * 25), (i / 40) * 25, objectHandler);
        //     objectHandler.addObject(wallObject);
        //     if (currInt == 1) {
        //         objectHandler.addHittableObject(wallObject);
        //     }
        // }

        // TankObject player1 = new TankObject(100, 700, TankType.PLAYER_ONE_TANK_TYPE, objectHandler, this);
        // TankObject player2 = new TankObject(800, 150, TankType.PLAYER_TWO_TANK_TYPE, objectHandler, this);

        // objectHandler.addObject(player1);
        // objectHandler.addHittableObject(player1);
        // objectHandler.addObject(player2);
        // objectHandler.addHittableObject(player2);
        // objectHandler.setTankIndexes();
        // gameStarted = true;
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
                    System.out.println("FPS: " + fps);
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
        g.setColor(Color.CYAN);
        g.drawRect(0, 0, backgroundWidth, backgroundHeight);

//        AffineTransform identity = new AffineTransform();
//        g2d.setTransform(identity);

//         if (camera != null) {
// //            g2d.translate(-camera.getX(), -camera.getY());

//         }
//         g.drawImage(BACKGROUND, 0, 0, backgroundWidth, backgroundHeight, null);
//         g.drawImage(BACKGROUND2, backgroundWidth, 0, backgroundWidth, backgroundHeight, null);

//         if (isAtHomeScreen) {
//             objectHandler.getButtons().removeAll(objectHandler.getButtons());
//             paintHomeScreen(g);
//         } else if (isPlayButtonClicked) {
//             for (int i = 0; i < objectHandler.getButtons().size(); i++) {
//                 GameButton button = (GameButton) objectHandler.getButtons().get(i);
//                 button.setIsClickable(false);
//             }
//             startMultiplayerGame();
//         } else if (isGameOver) {


//             objectHandler.getButtons().removeAll(objectHandler.getButtons());
//             gameStarted = false;
//             paintEndScreen(g);
//         }


//         if (objectHandler.getGameObjects().size() != 0) {
//             drawHearts(g, objectHandler.getGameObjects().get(Handler.PLAYER_ONE));
//             drawHearts(g, objectHandler.getGameObjects().get(Handler.PLAYER_TWO));
//         }
        gameManager.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        CatAndRatGame game = new CatAndRatGame();
        game.repaint();
    }

}
