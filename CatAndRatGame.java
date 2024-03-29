import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * multiplayer
 * two scores displayed at all times: Player 1 and Player 2
 * You can only get points if you are cat -- +1 for each time you click rat
 * 2 rounds: one round for player 1 to be cat (player 2 to be rat), another
 * round
 * for player 2 to be cat (player 1 to be rat).
 * 
 * 
 * 
 * Cat and Rat game runs a game loop which is able to render cat's mouse clicks
 * and rats movements every few milliseconds. It also updates the position of
 * cat
 * and rat every frame
 * 
 */
public class CatAndRatGame extends Canvas implements Runnable {
    private InputHandler inputHandler;
    private GameManager gameManager;
    private boolean isRunning = false;
    private Thread thread;
    private Window window;
    private static final int backgroundWidth = 240 * 25 / 6;
    private static final int backgroundHeight = 204 * 25 / 6;
    public static final int canvasWidth = backgroundWidth; // width of canvas
    public static final int canvasHeight = backgroundHeight + 22; // height of canvas
    private static final Image endFrame = Toolkit.getDefaultToolkit().getImage("end_menu_background.png");
    private static final Image bg = Toolkit.getDefaultToolkit().getImage("carpet bg.jpeg");
    private static final long serialVersionUID = 1L;
    private static final Dimension windowDimension = new Dimension(canvasWidth, canvasHeight);
    private static final double UPDATE_CAP = 1.0 / 60.0;

    private static CatAndRatGame instance;

    public static CatAndRatGame getInstance() {
        return instance;
    }
    
    /**
     * constructs new cat and rat game
     * creates a window, input handler, and makes a game manager
     * starts the game
     */
    public CatAndRatGame() {
        if (instance != null) {
            throw new RuntimeException("Already initialized");
        }
        
        instance = this;

        window = new Window(windowDimension, this, "Cat and Mouse Game");
        inputHandler = new InputHandler();
        this.addKeyListener(inputHandler);
        this.addMouseListener(inputHandler);
        gameManager = new GameManager(inputHandler);
        start();
    }

    /**
     * starts the game
     */
    public void start() {
        thread = new Thread(this);
        thread.run();
    }

    /**
     * ends the game
     */
    public void stop() { 
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * runs the window, ticks 60 times per second
     * also re-renders the window every tick with updated game state
     * keeps track of frames per second
     */
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

        gameManager.timer();
        gameManager.getTimer().start();
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

        //end game
        // stop();
        // render();
    }

    /**
     * renders an updated game state
     * also draws the home screen and endscreen
     */
    public void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        drawHomeScreen(g);
        if(gameManager.gameOver) {
            drawEndScreen(g);
        }
        else {
            gameManager.render(g);
        }
        g.dispose();
        bs.show();
    }

    /**
     * draws the home screen
     * @param g graphics
     */
    public void drawHomeScreen(Graphics g) {
        g.drawImage(bg, 0, 0, null);
    }

    /**
     * draws the end screen
     * @param g graphics
     */
    public void drawEndScreen(Graphics g) {
        g.drawImage(endFrame, 0, 0, backgroundWidth, backgroundHeight, this);
        g.setFont(new Font("TimesRoman", Font.BOLD, 50));
        g.setColor(Color.BLACK);

        String winString = gameManager.winString();
        int winLength = (int)g.getFontMetrics().getStringBounds(winString, g).getWidth();
        g.drawString(winString, canvasWidth/2 - winLength/2, 300);

        String scoreString = gameManager.returnScore();
        int scoreLength = (int)g.getFontMetrics().getStringBounds(scoreString, g).getWidth();
        g.drawString(scoreString, canvasWidth/2 - scoreLength/2, 400);

        String playerString = "Player 1 : Player 2";
        int playerLength = (int)g.getFontMetrics().getStringBounds(playerString, g).getWidth();
        g.drawString(playerString, canvasWidth/2 - playerLength/2, 500);
    }

    /**
     * creates the cat and rat game
     * @param args for main class
     */
    public static void main(String[] args) {
        CatAndRatGame game = new CatAndRatGame();
        game.repaint();
    }
}
